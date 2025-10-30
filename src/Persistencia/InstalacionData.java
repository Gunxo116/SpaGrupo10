package Persistencia;

import Modelo.ConexionDB;
import Modelo.Instalacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InstalacionData{

    public static ArrayList<Instalacion> obtenerActivas(){
        ArrayList<Instalacion> instalaciones = new ArrayList<>();
        String sql = "SELECT * FROM instalacion WHERE estado = 1";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);

                while( rs.next() ){
                    Instalacion instalacion = new Instalacion();
                    instalacion.setIdInstalacion(rs.getInt("id"));
                    instalacion.setNombre(rs.getString("nombre"));
                    instalacion.setDetalleUso(rs.getString("detalleUso"));
                    instalacion.setPrecio30m(rs.getDouble("precio30m"));
                    instalacion.setEstado(rs.getBoolean("estado"));
                    instalaciones.add(instalacion);
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al obtener instalaciones: " + e.getMessage());
        } finally{
            try{
                if( rs != null ){
                    rs.close();
                }
                if( stmt != null ){
                    stmt.close();
                }
            } catch( SQLException e ){
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return instalaciones;
    }

    public static ArrayList<Instalacion> obtenerTodas(){
        ArrayList<Instalacion> instalaciones = new ArrayList<>();
        String sql = "SELECT * FROM instalacion";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);

                while( rs.next() ){
                    Instalacion instalacion = new Instalacion();
                    instalacion.setIdInstalacion(rs.getInt("id"));
                    instalacion.setNombre(rs.getString("nombre"));
                    instalacion.setDetalleUso(rs.getString("detalleUso"));
                    instalacion.setPrecio30m(rs.getDouble("precio30m"));
                    instalacion.setEstado(rs.getBoolean("estado"));
                    instalaciones.add(instalacion);
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al obtener instalaciones: " + e.getMessage());
        } finally{
            try{
                if( rs != null ){
                    rs.close();
                }
                if( stmt != null ){
                    stmt.close();
                }
            } catch( SQLException e ){
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return instalaciones;
    }

    public static boolean existeNombre(String nombre, int idExcluir){
        String sql = "SELECT COUNT(*) as total FROM instalacion WHERE nombre = ? AND id != ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, nombre);
                pstmt.setInt(2, idExcluir);
                rs = pstmt.executeQuery();

                if( rs.next() ){
                    return rs.getInt("total") > 0;
                }
            }
        } catch( SQLException e ){
            System.err.println("Error verificando nombre: " + e.getMessage());
        } finally{
            try{
                if( rs != null ){
                    rs.close();
                }
                if( pstmt != null ){
                    pstmt.close();
                }
            } catch( SQLException e ){
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return false;
    }

    public static ArrayList<Instalacion> buscarPor(String criterio, String texto){
        ArrayList<Instalacion> instalaciones = new ArrayList<>();
        String sql = "SELECT * FROM instalacion WHERE ";

        switch( criterio ){
            case "ID":
                sql += "id = ?";
                break;
            case "Nombre":
                sql += "nombre LIKE ?";
                break;
            case "Estado":
                sql += "estado = ?";
                break;
            default:
                return obtenerActivas();
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);

                if( criterio.equals("ID") ){
                    pstmt.setInt(1, Integer.parseInt(texto));
                } else if( criterio.equals("Nombre") ){
                    pstmt.setString(1, "%" + texto + "%");
                } else if( criterio.equals("Estado") ){
                    boolean estado = texto.equalsIgnoreCase("Activo")
                      || texto.equalsIgnoreCase("true")
                      || texto.equals("1");
                    pstmt.setBoolean(1, estado);
                }

                rs = pstmt.executeQuery();

                while( rs.next() ){
                    Instalacion inst = new Instalacion();
                    inst.setIdInstalacion(rs.getInt("id"));
                    inst.setNombre(rs.getString("nombre"));
                    inst.setDetalleUso(rs.getString("detalleUso"));
                    inst.setPrecio30m(rs.getDouble("precio30m"));
                    inst.setEstado(rs.getBoolean("estado"));
                    instalaciones.add(inst);
                }
            }
        } catch( SQLException | NumberFormatException e ){
            System.err.println("Error en busqueda: " + e.getMessage());
        } finally{
            try{
                if( rs != null ){
                    rs.close();
                }
                if( pstmt != null ){
                    pstmt.close();
                }
            } catch( SQLException e ){
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return instalaciones;
    }

    public static Instalacion guardar(Instalacion instalacion){
        String sql = "INSERT INTO instalacion (nombre, detalleUso, precio30m, estado) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, instalacion.getNombre());
                pstmt.setString(2, instalacion.getDetalleUso());
                pstmt.setDouble(3, instalacion.getPrecio30m());
                pstmt.setBoolean(4, instalacion.isEstado());

                int filas = pstmt.executeUpdate();
                if( filas > 0 ){
                    rs = pstmt.getGeneratedKeys();
                    if( rs.next() ){
                        instalacion.setIdInstalacion(rs.getInt(1));
                        System.out.println("Instalacion guardada con ID: " + instalacion.getIdInstalacion());
                    }
                }
            }
        } catch( SQLException e ){
            System.err.println("Error guardando instalacion: " + e.getMessage());
            instalacion = null;
        } finally{
            try{
                if( rs != null ){
                    rs.close();
                }
                if( pstmt != null ){
                    pstmt.close();
                }
            } catch( SQLException e ){
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return instalacion;
    }

    public static boolean actualizar(Instalacion instalacion){
        String sql = "UPDATE instalacion SET nombre = ?, detalleUso = ?, precio30m = ?, estado = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, instalacion.getNombre());
                pstmt.setString(2, instalacion.getDetalleUso());
                pstmt.setDouble(3, instalacion.getPrecio30m());
                pstmt.setBoolean(4, instalacion.isEstado());
                pstmt.setInt(5, instalacion.getIdInstalacion());

                int filas = pstmt.executeUpdate();
                if( filas > 0 ){
                    System.out.println("Instalacion actualizada ID: " + instalacion.getIdInstalacion());
                    return true;
                } else{
                    System.out.println("No se encontro instalacion con ID: " + instalacion.getIdInstalacion());
                    return false;
                }
            }
        } catch( SQLException e ){
            System.err.println("Error actualizando: " + e.getMessage());
            return false;
        } finally{
            try{
                if( pstmt != null ){
                    pstmt.close();
                }
            } catch( SQLException e ){
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return false;
    }

    public static boolean eliminar(int id){
        String sql = "DELETE FROM instalacion WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                int filas = pstmt.executeUpdate();

                if( filas > 0 ){
                    System.out.println("Instalacion eliminada ID: " + id);
                    return true;
                } else{
                    System.out.println("No se encontro instalacion con ID: " + id);
                    return false;
                }
            }
        } catch( SQLException e ){
            System.err.println("Error eliminando: " + e.getMessage());
            return false;
        } finally{
            try{
                if( pstmt != null ){
                    pstmt.close();
                }
            } catch( SQLException e ){
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return false;
    }

    public static Instalacion buscarPorId(int id){
        Instalacion instalacion = null;
        String sql = "SELECT * FROM instalacion WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                rs = pstmt.executeQuery();

                if( rs.next() ){
                    instalacion = new Instalacion();
                    instalacion.setIdInstalacion(rs.getInt("id"));
                    instalacion.setNombre(rs.getString("nombre"));
                    instalacion.setDetalleUso(rs.getString("detalleUso"));
                    instalacion.setPrecio30m(rs.getDouble("precio30m"));
                    instalacion.setEstado(rs.getBoolean("estado"));
                }
            }
        } catch( SQLException e ){
            System.err.println("Error buscando por ID: " + e.getMessage());
        } finally{
            try{
                if( rs != null ){
                    rs.close();
                }
                if( pstmt != null ){
                    pstmt.close();
                }
            } catch( SQLException e ){
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return instalacion;
    }

    @Override
    public String toString(){
        return "Instalacion: ";
    }

}

/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
 */

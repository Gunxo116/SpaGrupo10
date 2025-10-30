package Persistencia;

import Modelo.ConexionDB;
import Modelo.Tratamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TratamientoData{

    public static ArrayList<Tratamiento> obtenerActivos(){
        ArrayList<Tratamiento> tratamientos = new ArrayList<>();
        String sql = "SELECT * FROM tratamiento WHERE estado = 1";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);

                while( rs.next() ){
                    Tratamiento tratamiento = new Tratamiento();
                    tratamiento.setIdTratamiento(rs.getInt("id"));
                    tratamiento.setNombre(rs.getString("nombre"));
                    tratamiento.setTipo(rs.getString("tipo"));
                    tratamiento.setDetalle(rs.getString("detalle"));
                    tratamiento.setProductos(rs.getString("productos"));
                    tratamiento.setDuracion(rs.getInt("duracion"));
                    tratamiento.setCosto(rs.getDouble("costo"));
                    tratamiento.setEstado(rs.getBoolean("estado"));
                    tratamientos.add(tratamiento);
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al obtener tratamientos: " + e.getMessage());
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
        return tratamientos;
    }

    public static ArrayList<Tratamiento> obtenerTodos(){
        ArrayList<Tratamiento> tratamientos = new ArrayList<>();
        String sql = "SELECT * FROM tratamiento";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);

                while( rs.next() ){
                    Tratamiento tratamiento = new Tratamiento();
                    tratamiento.setIdTratamiento(rs.getInt("id"));
                    tratamiento.setNombre(rs.getString("nombre"));
                    tratamiento.setTipo(rs.getString("tipo"));
                    tratamiento.setDetalle(rs.getString("detalle"));
                    tratamiento.setProductos(rs.getString("productos"));
                    tratamiento.setDuracion(rs.getInt("duracion"));
                    tratamiento.setCosto(rs.getDouble("costo"));
                    tratamiento.setEstado(rs.getBoolean("estado"));
                    tratamientos.add(tratamiento);
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al obtener tratamientos: " + e.getMessage());
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
        return tratamientos;
    }

    public static boolean existeNombre(String nombre, int idExcluir){
        String sql = "SELECT COUNT(*) as total FROM tratamiento WHERE nombre = ? AND id != ?";
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

    public static ArrayList<Tratamiento> buscarPor(String criterio, String texto){
        ArrayList<Tratamiento> tratamientos = new ArrayList<>();
        String sql = "SELECT * FROM tratamiento WHERE ";

        switch( criterio ){
            case "ID":
                sql += "id = ?";
                break;
            case "Nombre":
                sql += "nombre LIKE ?";
                break;
            case "Tipo":
                sql += "tipo = ?";
                break;
            case "Estado":
                sql += "estado = ?";
                break;
            default:
                return obtenerActivos();
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
                } else if( criterio.equals("Tipo") ){
                    pstmt.setString(1, texto);
                } else if( criterio.equals("Estado") ){
                    boolean estado = texto.equalsIgnoreCase("Activo")
                      || texto.equalsIgnoreCase("true")
                      || texto.equals("1");
                    pstmt.setBoolean(1, estado);
                }

                rs = pstmt.executeQuery();

                while( rs.next() ){
                    Tratamiento t = new Tratamiento();
                    t.setIdTratamiento(rs.getInt("id"));
                    t.setNombre(rs.getString("nombre"));
                    t.setTipo(rs.getString("tipo"));
                    t.setDetalle(rs.getString("detalle"));
                    t.setProductos(rs.getString("productos"));
                    t.setDuracion(rs.getInt("duracion"));
                    t.setCosto(rs.getDouble("costo"));
                    t.setEstado(rs.getBoolean("estado"));
                    tratamientos.add(t);
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
        return tratamientos;
    }

    public static Tratamiento guardar(Tratamiento tratamiento){
        String sql = "INSERT INTO tratamiento (nombre, tipo, detalle, productos, duracion, costo, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, tratamiento.getNombre());
                pstmt.setString(2, tratamiento.getTipo());
                pstmt.setString(3, tratamiento.getDetalle());
                pstmt.setString(4, tratamiento.getProductos());
                pstmt.setInt(5, tratamiento.getDuracion());
                pstmt.setDouble(6, tratamiento.getCosto());
                pstmt.setBoolean(7, tratamiento.getEstado());

                int filas = pstmt.executeUpdate();
                if( filas > 0 ){
                    rs = pstmt.getGeneratedKeys();
                    if( rs.next() ){
                        tratamiento.setIdTratamiento(rs.getInt(1));
                        System.out.println("Tratamiento guardado con ID: " + tratamiento.getIdTratamiento());
                    }
                }
            }
        } catch( SQLException e ){
            System.err.println("Error guardando tratamiento: " + e.getMessage());
            tratamiento = null;
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
        return tratamiento;
    }

    public static boolean actualizar(Tratamiento tratamiento){
        String sql = "UPDATE tratamiento SET nombre = ?, tipo = ?, detalle = ?, productos = ?, duracion = ?, costo = ?, estado = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, tratamiento.getNombre());
                pstmt.setString(2, tratamiento.getTipo());
                pstmt.setString(3, tratamiento.getDetalle());
                pstmt.setString(4, tratamiento.getProductos());
                pstmt.setInt(5, tratamiento.getDuracion());
                pstmt.setDouble(6, tratamiento.getCosto());
                pstmt.setBoolean(7, tratamiento.getEstado());
                pstmt.setInt(8, tratamiento.getIdTratamiento());

                int filas = pstmt.executeUpdate();
                if( filas > 0 ){
                    System.out.println("Tratamiento actualizado ID: " + tratamiento.getIdTratamiento());
                    return true;
                } else{
                    System.out.println("No se encontro tratamiento con ID: " + tratamiento.getIdTratamiento());
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
        String sql = "DELETE FROM tratamiento WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                int filas = pstmt.executeUpdate();

                if( filas > 0 ){
                    System.out.println("Tratamiento eliminado ID: " + id);
                    return true;
                } else{
                    System.out.println("No se encontro tratamiento con ID: " + id);
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

    public static Tratamiento buscarPorId(int id){
        Tratamiento tratamiento = null;
        String sql = "SELECT * FROM tratamiento WHERE id = ?";
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
                    tratamiento = new Tratamiento();
                    tratamiento.setIdTratamiento(rs.getInt("id"));
                    tratamiento.setNombre(rs.getString("nombre"));
                    tratamiento.setTipo(rs.getString("tipo"));
                    tratamiento.setDetalle(rs.getString("detalle"));
                    tratamiento.setProductos(rs.getString("productos"));
                    tratamiento.setDuracion(rs.getInt("duracion"));
                    tratamiento.setCosto(rs.getDouble("costo"));
                    tratamiento.setEstado(rs.getBoolean("estado"));
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
        return tratamiento;
    }

    public static ArrayList<Tratamiento> listarPorTipo(String tipo){
        return buscarPor("Tipo", tipo);
    }

}


/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
*/

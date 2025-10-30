package Persistencia;

import Modelo.ConexionDB;
import Modelo.Masajista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MasajistaData{

    public static ArrayList<Masajista> obtenerActivos(){
        ArrayList<Masajista> masajistas = new ArrayList<>();
        String sql = "SELECT * FROM masajista WHERE estado = 1";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                while( rs.next() ){
                    Masajista masajista = new Masajista();
                    masajista.setId(rs.getInt("id"));
                    masajista.setNombreCompleto(rs.getString("nombreCompleto"));
                    masajista.setTelefono(rs.getString("telefono"));
                    masajista.setEspecialidad(rs.getString("especialidad"));
                    masajista.setEstado(rs.getBoolean("estado"));
                    masajistas.add(masajista);
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al obtener masajistas: " + e.getMessage());
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
        return masajistas;
    }

    public static ArrayList<Masajista> obtenerTodos(){
        ArrayList<Masajista> masajistas = new ArrayList<>();
        String sql = "SELECT * FROM masajista";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                while( rs.next() ){
                    Masajista masajista = new Masajista();
                    masajista.setId(rs.getInt("id"));
                    masajista.setNombreCompleto(rs.getString("nombreCompleto"));
                    masajista.setTelefono(rs.getString("telefono"));
                    masajista.setEspecialidad(rs.getString("especialidad"));
                    masajista.setEstado(rs.getBoolean("estado"));
                    masajistas.add(masajista);
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al obtener masajistas: " + e.getMessage());
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
        return masajistas;
    }

    public static Masajista buscarPorId(int id){
        String sql = "SELECT * FROM masajista WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Masajista masajista = null;
        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                rs = pstmt.executeQuery();
                if( rs.next() ){
                    masajista = new Masajista();
                    masajista.setId(rs.getInt("id"));
                    masajista.setNombreCompleto(rs.getString("nombreCompleto"));
                    masajista.setTelefono(rs.getString("telefono"));
                    masajista.setEspecialidad(rs.getString("especialidad"));
                    masajista.setEstado(rs.getBoolean("estado"));
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al buscar masajista por ID: " + e.getMessage());
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
        return masajista;
    }

    public static boolean existeId(int id){
        String sql = "SELECT COUNT(*) FROM masajista WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean existe = false;
        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                rs = pstmt.executeQuery();
                if( rs.next() ){
                    existe = rs.getInt(1) > 0;
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al verificar ID: " + e.getMessage());
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
        return existe;
    }

    public static Masajista guardar(Masajista masajista){
        String sql = "INSERT INTO masajista (nombreCompleto, telefono, especialidad, estado) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean guardado = false;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, masajista.getNombreCompleto());
                pstmt.setString(2, masajista.getTelefono());
                pstmt.setString(3, masajista.getEspecialidad());
                pstmt.setBoolean(4, masajista.getEstado());

                int filasAfectadas = pstmt.executeUpdate();

                if( filasAfectadas > 0 ){
                    rs = pstmt.getGeneratedKeys();
                    if( rs.next() ){
                        masajista.setId(rs.getInt(1));
                        guardado = true;
                    }
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al guardar masajista: " + e.getMessage());
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

        return masajista;
    }

    public static boolean actualizar(Masajista masajista){
        String sql = "UPDATE masajista SET nombreCompleto = ?, telefono = ?, especialidad = ?, estado = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean actualizado = false;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, masajista.getNombreCompleto());
                pstmt.setString(2, masajista.getTelefono());
                pstmt.setString(3, masajista.getEspecialidad());
                pstmt.setBoolean(4, masajista.getEstado());
                pstmt.setInt(5, masajista.getId());

                int filasAfectadas = pstmt.executeUpdate();
                actualizado = filasAfectadas > 0;
            }
        } catch( SQLException e ){
            System.err.println("Error al actualizar masajista: " + e.getMessage());
        } finally{
            try{
                if( pstmt != null ){
                    pstmt.close();
                }
            } catch( SQLException e ){
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }

        return actualizado;
    }

    public static boolean borrar(int id){
        String sql = "DELETE FROM masajista WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean eliminado = false;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);

                int filasAfectadas = pstmt.executeUpdate();
                eliminado = filasAfectadas > 0;
            }
        } catch( SQLException e ){
            System.err.println("Error al borrar masajista: " + e.getMessage());
        } finally{
            try{
                if( pstmt != null ){
                    pstmt.close();
                }
            } catch( SQLException e ){
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }

        return eliminado;
    }

    public static ArrayList<Masajista> buscarPor(String criterio, String texto){
        ArrayList<Masajista> masajistas = new ArrayList<>();
        String sql = "SELECT * FROM masajista WHERE ";

        switch( criterio ){
            case "ID":
                sql += "id = ?";
                break;
            case "Nombre":
                sql += "nombreCompleto LIKE ?";
                break;
            case "Telefono":
                sql += "telefono = ?";
                break;
            case "Especialidad":
                sql += "especialidad LIKE ?";
                break;
            case "Estado":
                sql += "estado = ?";
                break;
            default:
                return masajistas;
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
                } else if( criterio.equals("Nombre") || criterio.equals("Especialidad") ){
                    pstmt.setString(1, "%" + texto + "%");
                } else{
                    pstmt.setString(1, texto);
                }

                rs = pstmt.executeQuery();

                while( rs.next() ){
                    Masajista masajista = new Masajista();
                    masajista.setId(rs.getInt("id"));
                    masajista.setNombreCompleto(rs.getString("nombreCompleto"));
                    masajista.setTelefono(rs.getString("telefono"));
                    masajista.setEspecialidad(rs.getString("especialidad"));
                    masajista.setEstado(rs.getBoolean("estado"));
                    masajistas.add(masajista);
                }
            }
        } catch( SQLException | NumberFormatException e ){
            System.err.println("Error al buscar masajistas: " + e.getMessage());
            e.printStackTrace();
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

        return masajistas;
    }
}

/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
 */

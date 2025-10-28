package Persistencia;

import Modelo.Cliente;
import Modelo.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteData{

    public static ArrayList<Cliente> obtenerTodos(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                while( rs.next() ){
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("id"));
                    cliente.setDni(rs.getString("dni"));
                    cliente.setNombreCompleto(rs.getString("nombreCompleto"));
                    cliente.setTelefono(rs.getString("telefono"));
                    cliente.setEdad(rs.getInt("edad"));
                    cliente.setAfecciones(rs.getString("afecciones"));
                    cliente.setEstado(rs.getBoolean("estado"));
                    clientes.add(cliente);
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al obtener clientes: " + e.getMessage());
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
        return clientes;
    }

    public static boolean existeDni(String dni){
        String sql = "SELECT COUNT(*) FROM cliente WHERE dni = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean existe = false;
        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, dni);
                rs = pstmt.executeQuery();
                if( rs.next() ){
                    existe = rs.getInt(1) > 0;
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al verificar DNI: " + e.getMessage());
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

    public static Cliente guardar(Cliente cliente){
        String sql = "INSERT INTO cliente (dni, nombreCompleto, telefono, edad, afecciones, estado) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean guardado = false;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, cliente.getDni());
                pstmt.setString(2, cliente.getNombreCompleto());
                pstmt.setString(3, cliente.getTelefono());
                pstmt.setInt(4, cliente.getEdad());
                pstmt.setString(5, cliente.getAfecciones());
                pstmt.setBoolean(6, cliente.getEstado());

                int filasAfectadas = pstmt.executeUpdate();

                if( filasAfectadas > 0 ){
                    rs = pstmt.getGeneratedKeys();
                    if( rs.next() ){
                        cliente.setIdCliente(rs.getInt(1));
                        guardado = true;
                    }
                }
            }
        } catch( SQLException e ){
            System.err.println("Error al guardar cliente: " + e.getMessage());
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

        return cliente;
    }

    public static boolean actualizar(Cliente cliente){
        String sql = "UPDATE cliente SET dni = ?, nombreCompleto = ?, telefono = ?, edad = ?, afecciones = ?, estado = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean actualizado = false;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, cliente.getDni());
                pstmt.setString(2, cliente.getNombreCompleto());
                pstmt.setString(3, cliente.getTelefono());
                pstmt.setInt(4, cliente.getEdad());
                pstmt.setString(5, cliente.getAfecciones());
                pstmt.setBoolean(6, cliente.getEstado());
                pstmt.setInt(7, cliente.getIdCliente());

                int filasAfectadas = pstmt.executeUpdate();
                actualizado = filasAfectadas > 0;
            }
        } catch( SQLException e ){
            System.err.println("Error al actualizar cliente: " + e.getMessage());
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

    public static boolean borrar(int idCliente){
        String sql = "DELETE FROM cliente WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean eliminado = false;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, idCliente);

                int filasAfectadas = pstmt.executeUpdate();
                eliminado = filasAfectadas > 0;
            }
        } catch( SQLException e ){
            System.err.println("Error al borrar cliente: " + e.getMessage());
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

    public static ArrayList<Cliente> buscarPor(String criterio, String texto){
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE ";

        switch( criterio ){
            case "ID":
                sql += "id = ?";
                break;
            case "DNI":
                sql += "dni = ?";
                break;
            case "Nombre":
                sql += "nombreCompleto LIKE ?";
                break;
            case "Telefono":
                sql += "telefono = ?";
                break;
            case "Edad":
                sql += "edad = ?";
                break;
            default:
                return clientes;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = ConexionDB.getConexion();
            if( conn != null ){
                pstmt = conn.prepareStatement(sql);

                if( criterio.equals("ID") || criterio.equals("Edad") ){
                    pstmt.setInt(1, Integer.parseInt(texto));
                } else if( criterio.equals("Nombre") ){
                    pstmt.setString(1, "%" + texto + "%");
                } else{
                    pstmt.setString(1, texto);
                }

                rs = pstmt.executeQuery();

                while( rs.next() ){
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("id"));
                    cliente.setDni(rs.getString("dni"));
                    cliente.setNombreCompleto(rs.getString("nombreCompleto"));
                    cliente.setTelefono(rs.getString("telefono"));
                    cliente.setEdad(rs.getInt("edad"));
                    cliente.setAfecciones(rs.getString("afecciones"));
                    cliente.setEstado(rs.getBoolean("estado"));
                    clientes.add(cliente);
                }
            }
        } catch( SQLException | NumberFormatException e ){
            System.err.println("Error al buscar clientes: " + e.getMessage());
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

        return clientes;
    }
}

/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
*/
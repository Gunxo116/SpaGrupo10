package Persistencia;

import Modelo.ConexionDB;
import Modelo.DiaDeSpa;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DiaDeSpaData {
    
    public static ArrayList<DiaDeSpa> obtenerTodos() {
        ArrayList<DiaDeSpa> diasDeSpa = new ArrayList<>();
        String sql = "SELECT * FROM dia_de_spa";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                
                while (rs.next()) {
                    DiaDeSpa dia = new DiaDeSpa();
                    dia.setId(rs.getInt("id"));
                    dia.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
                    dia.setPreferencias(rs.getString("preferencias"));
                    dia.setIdCliente(rs.getInt("idCliente"));
                    dia.setMonto(rs.getDouble("monto"));
                    dia.setEstado(rs.getString("estado"));
                    diasDeSpa.add(dia);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener días de spa: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return diasDeSpa;
    }
    
    public static DiaDeSpa buscarPorId(int id) {
        DiaDeSpa dia = null;
        String sql = "SELECT * FROM dia_de_spa WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    dia = new DiaDeSpa();
                    dia.setId(rs.getInt("id"));
                    dia.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
                    dia.setPreferencias(rs.getString("preferencias"));
                    dia.setIdCliente(rs.getInt("idCliente"));
                    dia.setMonto(rs.getDouble("monto"));
                    dia.setEstado(rs.getString("estado"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error buscando día de spa por ID: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return dia;
    }
    
    public static ArrayList<DiaDeSpa> obtenerPorCliente(int idCliente) {
        ArrayList<DiaDeSpa> diasDeSpa = new ArrayList<>();
        String sql = "SELECT * FROM dia_de_spa WHERE idCliente = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, idCliente);
                rs = pstmt.executeQuery();
                
                while (rs.next()) {
                    DiaDeSpa dia = new DiaDeSpa();
                    dia.setId(rs.getInt("id"));
                    dia.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
                    dia.setPreferencias(rs.getString("preferencias"));
                    dia.setIdCliente(rs.getInt("idCliente"));
                    dia.setMonto(rs.getDouble("monto"));
                    dia.setEstado(rs.getString("estado"));
                    diasDeSpa.add(dia);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener días de spa por cliente: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return diasDeSpa;
    }
    
    public static DiaDeSpa guardar(DiaDeSpa dia) {
        String sql = "INSERT INTO dia_de_spa (fechaHora, preferencias, idCliente, monto, estado) " +
                     "VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setTimestamp(1, Timestamp.valueOf(dia.getFechaHora()));
                pstmt.setString(2, dia.getPreferencias());
                pstmt.setInt(3, dia.getIdCliente());
                pstmt.setDouble(4, dia.getMonto());
                pstmt.setString(5, dia.getEstado());
                
                int filas = pstmt.executeUpdate();
                if (filas > 0) {
                    rs = pstmt.getGeneratedKeys();
                    if (rs.next()) {
                        dia.setId(rs.getInt(1));
                        System.out.println("Día de spa guardado con ID: " + dia.getId());
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error guardando día de spa: " + e.getMessage());
            dia = null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return dia;
    }
    
    public static boolean actualizar(DiaDeSpa dia) {
        String sql = "UPDATE dia_de_spa SET fechaHora = ?, preferencias = ?, idCliente = ?, " +
                     "monto = ?, estado = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setTimestamp(1, Timestamp.valueOf(dia.getFechaHora()));
                pstmt.setString(2, dia.getPreferencias());
                pstmt.setInt(3, dia.getIdCliente());
                pstmt.setDouble(4, dia.getMonto());
                pstmt.setString(5, dia.getEstado());
                pstmt.setInt(6, dia.getId());
                
                int filas = pstmt.executeUpdate();
                if (filas > 0) {
                    System.out.println("Día de spa actualizado ID: " + dia.getId());
                    return true;
                } else {
                    System.out.println("No se encontró día de spa con ID: " + dia.getId());
                    return false;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error actualizando día de spa: " + e.getMessage());
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return false;
    }
    
    public static boolean eliminar(int id) {
        String sql = "DELETE FROM dia_de_spa WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                int filas = pstmt.executeUpdate();
                
                if (filas > 0) {
                    System.out.println("Día de spa eliminado ID: " + id);
                    return true;
                } else {
                    System.out.println("No se encontró día de spa con ID: " + id);
                    return false;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error eliminando día de spa: " + e.getMessage());
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return false;
    }
    
    public static ArrayList<DiaDeSpa> buscarPor(String criterio, String texto) {
        ArrayList<DiaDeSpa> diasDeSpa = new ArrayList<>();
        String sql = "SELECT * FROM dia_de_spa WHERE ";
        
        switch (criterio) {
            case "ID":
                sql += "id = ?";
                break;
            case "Cliente":
                sql += "idCliente = ?";
                break;
            case "Estado":
                sql += "estado LIKE ?";
                break;
            case "Fecha":
                sql += "DATE(fechaHora) = ?";
                break;
            default:
                return obtenerTodos();
        }
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                
                if (criterio.equals("ID") || criterio.equals("Cliente")) {
                    pstmt.setInt(1, Integer.parseInt(texto));
                } else if (criterio.equals("Estado")) {
                    pstmt.setString(1, "%" + texto + "%");
                } else if (criterio.equals("Fecha")) {
                    pstmt.setString(1, texto);
                }
                
                rs = pstmt.executeQuery();
                
                while (rs.next()) {
                    DiaDeSpa dia = new DiaDeSpa();
                    dia.setId(rs.getInt("id"));
                    dia.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
                    dia.setPreferencias(rs.getString("preferencias"));
                    dia.setIdCliente(rs.getInt("idCliente"));
                    dia.setMonto(rs.getDouble("monto"));
                    dia.setEstado(rs.getString("estado"));
                    diasDeSpa.add(dia);
                }
            }
        } catch (SQLException | NumberFormatException e) {
            System.err.println("Error en búsqueda: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return diasDeSpa;
    }
    
    public static boolean actualizarMonto(int idDiaSpa, double nuevoMonto) {
        String sql = "UPDATE dia_de_spa SET monto = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setDouble(1, nuevoMonto);
                pstmt.setInt(2, idDiaSpa);
                
                int filas = pstmt.executeUpdate();
                if (filas > 0) {
                    System.out.println("Monto actualizado para día de spa ID: " + idDiaSpa);
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error actualizando monto: " + e.getMessage());
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return false;
    }
}

/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
*/
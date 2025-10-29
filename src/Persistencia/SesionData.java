package Persistencia;

import Modelo.ConexionDB;
import Modelo.Sesion;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SesionData {
    
    public static ArrayList<Sesion> obtenerTodas() {
        ArrayList<Sesion> sesiones = new ArrayList<>();
        String sql = "SELECT * FROM sesion";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                
                while (rs.next()) {
                    Sesion sesion = new Sesion();
                    sesion.setId(rs.getInt("id"));
                    sesion.setFechaHoraInicio(rs.getTimestamp("fechaHoraInicio").toLocalDateTime());
                    sesion.setFechaHoraFin(rs.getTimestamp("fechaHoraFin").toLocalDateTime());
                    
                    // idTratamiento puede ser NULL
                    int idTrat = rs.getInt("idTratamiento");
                    sesion.setIdTratamiento(rs.wasNull() ? null : idTrat);
                    
                    // idMasajista puede ser NULL
                    int idMasa = rs.getInt("idMasajista");
                    sesion.setIdMasajista(rs.wasNull() ? null : idMasa);
                    
                    sesion.setIdDiaSpa(rs.getInt("idDiaSpa"));
                    sesion.setIdInstalacion(rs.getInt("idInstalacion"));
                    sesion.setEstado(rs.getString("estado"));
                    sesiones.add(sesion);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener sesiones: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return sesiones;
    }
    
    public static ArrayList<Sesion> obtenerPorDiaSpa(int idDiaSpa) {
        ArrayList<Sesion> sesiones = new ArrayList<>();
        String sql = "SELECT * FROM sesion WHERE idDiaSpa = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, idDiaSpa);
                rs = pstmt.executeQuery();
                
                while (rs.next()) {
                    Sesion sesion = new Sesion();
                    sesion.setId(rs.getInt("id"));
                    sesion.setFechaHoraInicio(rs.getTimestamp("fechaHoraInicio").toLocalDateTime());
                    sesion.setFechaHoraFin(rs.getTimestamp("fechaHoraFin").toLocalDateTime());
                    
                    int idTrat = rs.getInt("idTratamiento");
                    sesion.setIdTratamiento(rs.wasNull() ? null : idTrat);
                    
                    int idMasa = rs.getInt("idMasajista");
                    sesion.setIdMasajista(rs.wasNull() ? null : idMasa);
                    
                    sesion.setIdDiaSpa(rs.getInt("idDiaSpa"));
                    sesion.setIdInstalacion(rs.getInt("idInstalacion"));
                    sesion.setEstado(rs.getString("estado"));
                    sesiones.add(sesion);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener sesiones por día spa: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return sesiones;
    }
    
    public static Sesion buscarPorId(int id) {
        Sesion sesion = null;
        String sql = "SELECT * FROM sesion WHERE id = ?";
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
                    sesion = new Sesion();
                    sesion.setId(rs.getInt("id"));
                    sesion.setFechaHoraInicio(rs.getTimestamp("fechaHoraInicio").toLocalDateTime());
                    sesion.setFechaHoraFin(rs.getTimestamp("fechaHoraFin").toLocalDateTime());
                    
                    int idTrat = rs.getInt("idTratamiento");
                    sesion.setIdTratamiento(rs.wasNull() ? null : idTrat);
                    
                    int idMasa = rs.getInt("idMasajista");
                    sesion.setIdMasajista(rs.wasNull() ? null : idMasa);
                    
                    sesion.setIdDiaSpa(rs.getInt("idDiaSpa"));
                    sesion.setIdInstalacion(rs.getInt("idInstalacion"));
                    sesion.setEstado(rs.getString("estado"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error buscando sesión por ID: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return sesion;
    }
    
    public static Sesion guardar(Sesion sesion) {
        String sql = "INSERT INTO sesion (fechaHoraInicio, fechaHoraFin, idTratamiento, idMasajista, idDiaSpa, idInstalacion, estado) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setTimestamp(1, Timestamp.valueOf(sesion.getFechaHoraInicio()));
                pstmt.setTimestamp(2, Timestamp.valueOf(sesion.getFechaHoraFin()));
                
                // Permitir NULL en tratamiento y masajista
                if (sesion.getIdTratamiento() != null) {
                    pstmt.setInt(3, sesion.getIdTratamiento());
                } else {
                    pstmt.setNull(3, Types.INTEGER);
                }
                
                if (sesion.getIdMasajista() != null) {
                    pstmt.setInt(4, sesion.getIdMasajista());
                } else {
                    pstmt.setNull(4, Types.INTEGER);
                }
                
                pstmt.setInt(5, sesion.getIdDiaSpa());
                pstmt.setInt(6, sesion.getIdInstalacion());
                pstmt.setString(7, sesion.getEstado());
                
                int filas = pstmt.executeUpdate();
                if (filas > 0) {
                    rs = pstmt.getGeneratedKeys();
                    if (rs.next()) {
                        sesion.setId(rs.getInt(1));
                        System.out.println("Sesión guardada con ID: " + sesion.getId());
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error guardando sesión: " + e.getMessage());
            sesion = null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return sesion;
    }
    
    public static boolean actualizar(Sesion sesion) {
        String sql = "UPDATE sesion SET fechaHoraInicio = ?, fechaHoraFin = ?, idTratamiento = ?, " +
                     "idMasajista = ?, idDiaSpa = ?, idInstalacion = ?, estado = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setTimestamp(1, Timestamp.valueOf(sesion.getFechaHoraInicio()));
                pstmt.setTimestamp(2, Timestamp.valueOf(sesion.getFechaHoraFin()));
                
                if (sesion.getIdTratamiento() != null) {
                    pstmt.setInt(3, sesion.getIdTratamiento());
                } else {
                    pstmt.setNull(3, Types.INTEGER);
                }
                
                if (sesion.getIdMasajista() != null) {
                    pstmt.setInt(4, sesion.getIdMasajista());
                } else {
                    pstmt.setNull(4, Types.INTEGER);
                }
                
                pstmt.setInt(5, sesion.getIdDiaSpa());
                pstmt.setInt(6, sesion.getIdInstalacion());
                pstmt.setString(7, sesion.getEstado());
                pstmt.setInt(8, sesion.getId());
                
                int filas = pstmt.executeUpdate();
                if (filas > 0) {
                    System.out.println("Sesión actualizada ID: " + sesion.getId());
                    return true;
                } else {
                    System.out.println("No se encontró sesión con ID: " + sesion.getId());
                    return false;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error actualizando sesión: " + e.getMessage());
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
        String sql = "DELETE FROM sesion WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                int filas = pstmt.executeUpdate();
                
                if (filas > 0) {
                    System.out.println("Sesión eliminada ID: " + id);
                    return true;
                } else {
                    System.out.println("No se encontró sesión con ID: " + id);
                    return false;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error eliminando sesión: " + e.getMessage());
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
    
    public static ArrayList<Sesion> buscarPor(String criterio, String texto) {
        ArrayList<Sesion> sesiones = new ArrayList<>();
        String sql = "SELECT * FROM sesion WHERE ";
        
        switch (criterio) {
            case "ID":
                sql += "id = ?";
                break;
            case "Estado":
                sql += "estado LIKE ?";
                break;
            case "DiaSpa":
                sql += "idDiaSpa = ?";
                break;
            default:
                return obtenerTodas();
        }
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                
                if (criterio.equals("ID") || criterio.equals("DiaSpa")) {
                    pstmt.setInt(1, Integer.parseInt(texto));
                } else {
                    pstmt.setString(1, "%" + texto + "%");
                }
                
                rs = pstmt.executeQuery();
                
                while (rs.next()) {
                    Sesion sesion = new Sesion();
                    sesion.setId(rs.getInt("id"));
                    sesion.setFechaHoraInicio(rs.getTimestamp("fechaHoraInicio").toLocalDateTime());
                    sesion.setFechaHoraFin(rs.getTimestamp("fechaHoraFin").toLocalDateTime());
                    
                    int idTrat = rs.getInt("idTratamiento");
                    sesion.setIdTratamiento(rs.wasNull() ? null : idTrat);
                    
                    int idMasa = rs.getInt("idMasajista");
                    sesion.setIdMasajista(rs.wasNull() ? null : idMasa);
                    
                    sesion.setIdDiaSpa(rs.getInt("idDiaSpa"));
                    sesion.setIdInstalacion(rs.getInt("idInstalacion"));
                    sesion.setEstado(rs.getString("estado"));
                    sesiones.add(sesion);
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
        return sesiones;
    }
}

/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
*/
package Persistencia;

import Modelo.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EstadisticasData {
    
    public static int obtenerTotalClientesActivos() {
        String sql = "SELECT COUNT(*) as total FROM cliente WHERE estado = 1";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    return rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error obteniendo clientes activos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return 0;
    }
    
    public static int obtenerTotalMasajistasDisponibles() {
        String sql = "SELECT COUNT(*) as total FROM masajista WHERE estado = 1";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    return rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error obteniendo masajistas disponibles: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return 0;
    }
    
    public static int obtenerSesionesDelDia() {
        String sql = "SELECT COUNT(*) as total FROM sesion " +
                     "WHERE DATE(fechaHoraInicio) = CURDATE() " +
                     "AND estado != 'cancelada'";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    return rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error obteniendo sesiones del día: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return 0;
    }

    public static int obtenerDiasDeSpasPendientes() {
        String sql = "SELECT COUNT(*) as total FROM dia_de_spa " +
                     "WHERE estado IN ('pendiente', 'confirmado')";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    return rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error obteniendo días de spa pendientes: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return 0;
    }
    
    public static int obtenerTotalInstalacionesActivas() {
        String sql = "SELECT COUNT(*) as total FROM instalacion WHERE estado = 1";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    return rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error obteniendo instalaciones activas: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return 0;
    }
    
    public static int obtenerTotalTratamientosActivos() {
        String sql = "SELECT COUNT(*) as total FROM tratamiento WHERE estado = 1";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();

                if (rs.next()) {
                    return rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error obteniendo tratamientos activos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return 0;
    }
    
    
    public static double obtenerIngresosDelMes() {
        String sql = "SELECT COALESCE(SUM(monto), 0) as total FROM dia_de_spa " +
                     "WHERE MONTH(fechaHora) = MONTH(CURDATE()) " +
                     "AND YEAR(fechaHora) = YEAR(CURDATE()) " +
                     "AND estado = 'completado'";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    return rs.getDouble("total");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error obteniendo ingresos del mes: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return 0.0;
    }
    
}
/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
*/
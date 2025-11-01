package Persistencia;

import Modelo.ConexionDB;
import Modelo.Tratamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReportesData {

    // ===================== TRATAMIENTOS =====================
    
    /*Obtiene tipos únicos de tratamientos*/
    public static ArrayList<String> obtenerTiposTratamiento() {
        ArrayList<String> tipos = new ArrayList<>();
        String sql = "SELECT DISTINCT tipo FROM tratamiento WHERE tipo IS NOT NULL ORDER BY tipo";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    tipos.add(rs.getString("tipo"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener tipos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return tipos;
    }

    /*Obtiene estados posibles*/
    public static ArrayList<String> obtenerEstados() {
        ArrayList<String> estados = new ArrayList<>();
        estados.add("Activo");
        estados.add("Inactivo");
        return estados;
    }

    /*Filtra tratamientos por tipo y estado*/
    public static ArrayList<Tratamiento> filtrarTratamientos(String tipo, String estado) {
        ArrayList<Tratamiento> tratamientos = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM tratamiento WHERE 1=1");
        
        boolean filtrarTipo = !tipo.equals("Todos");
        boolean filtrarEstado = !estado.equals("Todos");
        
        if (filtrarTipo) {
            sql.append(" AND tipo = ?");
        }
        if (filtrarEstado) {
            sql.append(" AND estado = ?");
        }
        
        sql.append(" ORDER BY nombre");
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql.toString());
                
                int paramIndex = 1;
                if (filtrarTipo) {
                    pstmt.setString(paramIndex++, tipo);
                }
                if (filtrarEstado) {
                    boolean estadoBool = estado.equals("Activo");
                    pstmt.setBoolean(paramIndex++, estadoBool);
                }
                
                rs = pstmt.executeQuery();

                while (rs.next()) {
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
        } catch (SQLException e) {
            System.err.println("Error al filtrar tratamientos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return tratamientos;
    }

    /*Obtiene los tratamientos más solicitados (por cantidad de sesiones)*/
    public static ArrayList<Object[]> obtenerTratamientosMasSolicitados(String fechaDesde, String fechaHasta) {
        ArrayList<Object[]> ranking = new ArrayList<>();
        String sql = "SELECT t.id, t.nombre, t.tipo, COUNT(s.id) as cantidad, SUM(t.costo) as ingresos " +
                     "FROM tratamiento t " +
                     "INNER JOIN sesion s ON t.id = s.idTratamiento " +
                     "WHERE s.fechaHoraInicio BETWEEN ? AND ? " +
                     "GROUP BY t.id, t.nombre, t.tipo " +
                     "ORDER BY cantidad DESC " +
                     "LIMIT 10";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, fechaDesde);
                pstmt.setString(2, fechaHasta);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Object[] fila = {
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getInt("cantidad"),
                        rs.getDouble("ingresos")
                    };
                    ranking.add(fila);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener tratamientos más solicitados: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return ranking;
    }

    // ===================== INSTALACIONES =====================
    
    /*Obtiene instalaciones disponibles en una franja horaria*/
    public static ArrayList<Object[]> obtenerInstalacionesDisponibles(String fecha, String horaInicio, String horaFin) {
        ArrayList<Object[]> instalaciones = new ArrayList<>();
        String sql = "SELECT i.id, i.nombre, i.detalleUso, i.precio30m " +
                     "FROM instalacion i " +
                     "WHERE i.estado = 1 " +
                     "AND i.id NOT IN ( " +
                     "    SELECT s.idInstalacion " +
                     "    FROM sesion s " +
                     "    WHERE DATE(s.fechaHoraInicio) = ? " +
                     "    AND ( " +
                     "        (TIME(s.fechaHoraInicio) < ? AND TIME(s.fechaHoraFin) > ?) " +
                     "        OR (TIME(s.fechaHoraInicio) >= ? AND TIME(s.fechaHoraInicio) < ?) " +
                     "    ) " +
                     ") " +
                     "ORDER BY i.nombre";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, fecha);
                pstmt.setString(2, horaFin);
                pstmt.setString(3, horaInicio);
                pstmt.setString(4, horaInicio);
                pstmt.setString(5, horaFin);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Object[] fila = {
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("detalleUso"),
                        rs.getDouble("precio30m")
                    };
                    instalaciones.add(fila);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener instalaciones disponibles: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return instalaciones;
    }

    /* Ranking de instalaciones más solicitadas*/
    public static ArrayList<Object[]> obtenerRankingInstalaciones(String fechaDesde, String fechaHasta) {
        ArrayList<Object[]> ranking = new ArrayList<>();
        String sql = "SELECT i.id, i.nombre, COUNT(s.id) as cantidad, SUM(i.precio30m) as ingresos " +
                     "FROM instalacion i " +
                     "INNER JOIN sesion s ON i.id = s.idInstalacion " +
                     "WHERE s.fechaHoraInicio BETWEEN ? AND ? " +
                     "GROUP BY i.id, i.nombre " +
                     "ORDER BY cantidad DESC " +
                     "LIMIT 10";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, fechaDesde);
                pstmt.setString(2, fechaHasta);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Object[] fila = {
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("cantidad"),
                        rs.getDouble("ingresos")
                    };
                    ranking.add(fila);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener ranking instalaciones: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return ranking;
    }

    // ===================== MASAJISTAS =====================
    
    /*Obtiene tipos de especialidad únicos*/
    public static ArrayList<String> obtenerEspecialidades() {
        ArrayList<String> especialidades = new ArrayList<>();
        String sql = "SELECT DISTINCT especialidad FROM masajista WHERE especialidad IS NOT NULL ORDER BY especialidad";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    especialidades.add(rs.getString("especialidad"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener especialidades: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return especialidades;
    }

    /*Obtiene masajistas disponibles en una franja horaria*/
    public static ArrayList<Object[]> obtenerMasajistasDisponibles(String fecha, String horaInicio, String horaFin) {
        ArrayList<Object[]> masajistas = new ArrayList<>();
        String sql = "SELECT m.id, m.nombreCompleto, m.telefono, m.especialidad " +
                     "FROM masajista m " +
                     "WHERE m.estado = 1 " +
                     "AND m.id NOT IN ( " +
                     "    SELECT s.idMasajista " +
                     "    FROM sesion s " +
                     "    WHERE DATE(s.fechaHoraInicio) = ? " +
                     "    AND ( " +
                     "        (TIME(s.fechaHoraInicio) < ? AND TIME(s.fechaHoraFin) > ?) " +
                     "        OR (TIME(s.fechaHoraInicio) >= ? AND TIME(s.fechaHoraInicio) < ?) " +
                     "    ) " +
                     ") " +
                     "ORDER BY m.nombreCompleto";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, fecha);
                pstmt.setString(2, horaFin);
                pstmt.setString(3, horaInicio);
                pstmt.setString(4, horaInicio);
                pstmt.setString(5, horaFin);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Object[] fila = {
                        rs.getInt("id"),
                        rs.getString("nombreCompleto"),
                        rs.getString("telefono"),
                        rs.getString("especialidad")
                    };
                    masajistas.add(fila);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener masajistas disponibles: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return masajistas;
    }

    /* Obtiene masajistas por especialidad */
    public static ArrayList<Object[]> obtenerMasajistasPorEspecialidad(String especialidad) {
        ArrayList<Object[]> masajistas = new ArrayList<>();
        String sql = "SELECT m.id, m.nombreCompleto, m.telefono, " +
                     "(SELECT COUNT(*) FROM sesion WHERE idMasajista = m.id) as sesiones_totales " +
                     "FROM masajista m " +
                     "WHERE m.especialidad = ? AND m.estado = 1 " +
                     "ORDER BY sesiones_totales DESC";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.getConexion();
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, especialidad);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Object[] fila = {
                        rs.getInt("id"),
                        rs.getString("nombreCompleto"),
                        rs.getString("telefono"),
                        rs.getInt("sesiones_totales")
                    };
                    masajistas.add(fila);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener masajistas por especialidad: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando recursos: " + e.getMessage());
            }
        }
        return masajistas;
    }
}
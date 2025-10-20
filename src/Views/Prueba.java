package Views;

import Modelo.ConexionDB;
import java.sql.Connection;

public class Prueba {
    
    public static void main(String[] args) {
        
        System.out.println("=== SPA ENTRE DEDOS - Sistema de Gestion ===");
        
        mostrarIntegrantes();
        
        System.out.println("=== Prueba de Conexion a Base de Datos ===");
        Connection conn = ConexionDB.getConexion();
        System.out.println(" ");
        if (conn != null) {
            System.out.println("Conexion: " + (ConexionDB.isConectado() ? "EXITOSA" : "FALLIDA"));
            
        } else {
            System.err.println("No se pudo conectar a la base de datos");
        }
    }
    
    private static void mostrarIntegrantes() {
        System.out.println("Integrantes del Grupo 10:");
        System.out.println("- Barbeito Yamil");
        System.out.println("- Redon Estaban");
        System.out.println("- Atahualpa Blanco");
    }
        
}

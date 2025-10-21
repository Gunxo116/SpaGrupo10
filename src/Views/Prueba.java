package Views;

import Modelo.ConexionDB;
import Modelo.Instalacion;
import Persistencia.InstalacionData;
import java.sql.Connection;

public class Prueba{

    public static void main(String[] args){

        System.out.println("=== SPA ENTRE DEDOS - Sistema de Gestion ===");

        mostrarIntegrantes();

        System.out.println("=== Prueba de Conexion a Base de Datos ===");
        Connection conn = ConexionDB.getConexion();
        System.out.println(" ");
        if( conn != null ){
            System.out.println("Conexion: " + (ConexionDB.isConectado() ? "EXITOSA" : "FALLIDA"));

        } else{
            System.err.println("No se pudo conectar a la base de datos");
        }

        // Alta-baja-modificación de la entidad Instalacion
        System.out.println("===============================");
        Instalacion salaMasaje1 = InstalacionData.guardar(new Instalacion("Sala de masaje 1", "Camilla para masajes", 45000, true));
        System.out.println("Nueva instalación Creada");
        System.out.println(salaMasaje1);
        System.out.println("===============================");
        salaMasaje1.setDetalleUso("Sala con varias camillas para masaje");
        salaMasaje1.setEstado(false);
        InstalacionData.actualizar(salaMasaje1);
        System.out.println("Sala de masaje actualizada");
        System.out.println(salaMasaje1);
        System.out.println("===============================");
        InstalacionData.eliminar(salaMasaje1.getIdInstalacion());
        System.out.println("Instalación borrada");
        System.out.println("===============================");
    }

    private static void mostrarIntegrantes(){
        System.out.println("Integrantes del Grupo 10:");
        System.out.println("- Barbeito Yamil");
        System.out.println("- Redon Estaban");
        System.out.println("- Atahualpa Blanco");
    }

}

package Modelo;

public class Instalacion {
    
    private int idInstalacion;
    private String nombre;
    private String detalleUso;
    private double precio30m;
    private boolean estado;


    
    // CONTRUCTORES // 
    public Instalacion() {
    }
    // SIN ID //
    public Instalacion(String nombre, String detalleUso, double precio30m, boolean estado) {
        this.nombre = nombre;
        this.detalleUso = detalleUso;
        this.precio30m = precio30m;
        this.estado = estado;
    }
    // CON ID //
    public Instalacion(int idInstalacion, String nombre, String detalleUso, double precio30m, boolean estado) {
        this.idInstalacion = idInstalacion;
        this.nombre = nombre;
        this.detalleUso = detalleUso;
        this.precio30m = precio30m;
        this.estado = estado;
    }

    // GET - SET //
    public int getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(int idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalleUso() {
        return detalleUso;
    }

    public void setDetalleUso(String detalleUso) {
        this.detalleUso = detalleUso;
    }

    public double getPrecio30m() {
        return precio30m;
    }

    public void setPrecio30m(double precio30m) {
        this.precio30m = precio30m;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Instalacion{" +
                "idInstalacion=" + idInstalacion +
                ", nombre='" + nombre + '\'' +
                ", detalleUso='" + detalleUso + '\'' +
                ", precio30m=" + precio30m +
                ", estado=" + (estado ? "Activa" : "Inactiva") +
                '}';
    }
    
}

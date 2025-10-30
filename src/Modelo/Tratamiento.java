package Modelo;

public class Tratamiento {
    
    private int id;
    private String nombre;
    private String tipo;
    private String detalle;
    private String productos;
    private int duracion;
    private double costo;
    private boolean estado;
    

    // CONTRUCTORES
    public Tratamiento() {}
    public Tratamiento(String nombre, String tipo, String detalle, String productos, int duracion, double costo, boolean estado) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.detalle = detalle;
            this.productos = productos;
            this.duracion = duracion;
            this.costo = costo;
            this.estado = estado;
    }
    public Tratamiento(int idTratamiento, String nombre, String tipo, String detalle, String productos, int duracion, double costo, boolean estado) {
        this.id = idTratamiento;
        this.nombre = nombre;
        this.tipo = tipo;
        this.detalle = detalle;
        this.productos = productos;
        this.duracion = duracion;
        this.costo = costo;
        this.estado = estado;
    }
    
    // GET - SET //
    public int getIdTratamiento() {
        return id;
    }
    public void setIdTratamiento(int idTratamiento) {
        this.id = idTratamiento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDetalle() {
        return detalle;
    }
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    public String getProductos() {
        return productos;
    }
    public void setProductos(String productos) {
        this.productos = productos;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    public boolean getEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    // OVER
    
    @Override
    public String toString() {
        return nombre + " - " + duracion + "min - $" + String.format("%.2f", costo);
    }
    
    
}


/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
*/
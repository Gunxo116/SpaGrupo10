package Modelo;

import java.time.LocalDateTime;

public class DiaDeSpa {
    
    private int id;
    private LocalDateTime fechaHora;
    private String preferencias;
    private int idCliente;
    private double monto;
    private String estado;
    
    // CONSTRUCTORES
    public DiaDeSpa() {}
    
    public DiaDeSpa(LocalDateTime fechaHora, String preferencias, int idCliente, 
                    double monto, String estado) {
        this.fechaHora = fechaHora;
        this.preferencias = preferencias;
        this.idCliente = idCliente;
        this.monto = monto;
        this.estado = estado;
    }
    
    public DiaDeSpa(int id, LocalDateTime fechaHora, String preferencias, 
                    int idCliente, double monto, String estado) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.preferencias = preferencias;
        this.idCliente = idCliente;
        this.monto = monto;
        this.estado = estado;
    }
    
    // GETTERS Y SETTERS
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    public String getPreferencias() {
        return preferencias;
    }
    
    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }
    
    public int getIdCliente() {
        return idCliente;
    }
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public double getMonto() {
        return monto;
    }
    
    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "DiaDeSpa{" +
                "id=" + id +
                ", fechaHora=" + fechaHora +
                ", preferencias='" + preferencias + '\'' +
                ", idCliente=" + idCliente +
                ", monto=" + monto +
                ", estado='" + estado + '\'' +
                '}';
    }
}

/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
*/
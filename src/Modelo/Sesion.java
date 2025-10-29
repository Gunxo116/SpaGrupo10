package Modelo;

import java.time.LocalDateTime;

public class Sesion {
    
    private int id;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private Integer idTratamiento;  // Puede ser null (opcional)
    private Integer idMasajista;     // Puede ser null (opcional)
    private int idDiaSpa;
    private int idInstalacion;
    private String estado;
    
    // CONSTRUCTORES
    public Sesion() {}
    
    public Sesion(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Integer idTratamiento, 
                  Integer idMasajista, int idDiaSpa, int idInstalacion, String estado) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.idTratamiento = idTratamiento;
        this.idMasajista = idMasajista;
        this.idDiaSpa = idDiaSpa;
        this.idInstalacion = idInstalacion;
        this.estado = estado;
    }
    
    public Sesion(int id, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, 
                  Integer idTratamiento, Integer idMasajista, int idDiaSpa, 
                  int idInstalacion, String estado) {
        this.id = id;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.idTratamiento = idTratamiento;
        this.idMasajista = idMasajista;
        this.idDiaSpa = idDiaSpa;
        this.idInstalacion = idInstalacion;
        this.estado = estado;
    }
    
    // GETTERS Y SETTERS
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }
    
    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }
    
    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }
    
    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }
    
    public Integer getIdTratamiento() {
        return idTratamiento;
    }
    
    public void setIdTratamiento(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }
    
    public Integer getIdMasajista() {
        return idMasajista;
    }
    
    public void setIdMasajista(Integer idMasajista) {
        this.idMasajista = idMasajista;
    }
    
    public int getIdDiaSpa() {
        return idDiaSpa;
    }
    
    public void setIdDiaSpa(int idDiaSpa) {
        this.idDiaSpa = idDiaSpa;
    }
    
    public int getIdInstalacion() {
        return idInstalacion;
    }
    
    public void setIdInstalacion(int idInstalacion) {
        this.idInstalacion = idInstalacion;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Sesion{" +
                "id=" + id +
                ", fechaHoraInicio=" + fechaHoraInicio +
                ", fechaHoraFin=" + fechaHoraFin +
                ", idTratamiento=" + idTratamiento +
                ", idMasajista=" + idMasajista +
                ", idDiaSpa=" + idDiaSpa +
                ", idInstalacion=" + idInstalacion +
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
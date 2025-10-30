package Modelo;

public class Masajista{

    private int id;
    private String nombreCompleto;
    private String telefono;
    private String especialidad;
    private boolean estado;

    public Masajista(){
    }

    public Masajista(String nombreApellido, String telefono, String especialidad, boolean estado){
        this.nombreCompleto = nombreApellido;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public Masajista(int matricula, String nombreApellido, String telefono, String especialidad, boolean estado){
        this.id = matricula;
        this.nombreCompleto = nombreApellido;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombreCompleto(){
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto){
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public String getEspecialidad(){
        return especialidad;
    }

    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }

    public boolean getEstado(){
        return estado;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }
    
    
    @Override
    public String toString() {
        return nombreCompleto + " - Mat: " + id + " (" + especialidad + ")";
    }
    
}

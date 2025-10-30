package Modelo;

public class Cliente{

    private int id;
    private String dni;
    private String nombreCompleto;
    private String telefono;
    private int edad;
    private String afecciones;
    private boolean estado;

    public Cliente(){
    }

    public Cliente(String dni, String nombreCompleto, String telefono, int edad, String afecciones, boolean estado){
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.edad = edad;
        this.afecciones = afecciones;
        this.estado = estado;
    }

    public Cliente(int idCliente, String dni, String nombreCompleto, String telefono, int edad, String afecciones, boolean estado){
        this.id = idCliente;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.edad = edad;
        this.afecciones = afecciones;
        this.estado = estado;
    }

    public int getIdCliente(){
        return id;
    }

    public void setIdCliente(int idCliente){
        this.id = idCliente;
    }

    public String getDni(){
        return dni;
    }

    public void setDni(String dni){
        this.dni = dni;
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

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public String getAfecciones(){
        return afecciones;
    }

    public void setAfecciones(String afecciones){
        this.afecciones = afecciones;
    }

    public boolean getEstado(){
        return estado;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    @Override
    public String toString(){
        return id + " - " + nombreCompleto;
    }
}

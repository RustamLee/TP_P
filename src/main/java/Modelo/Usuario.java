package Modelo;

abstract class Usuario {
    protected String nombre;
    protected String apellido;
    protected String DNI;

    public Usuario(String nombre, String apellido, String DNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
    }

}

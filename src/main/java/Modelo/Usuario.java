package Modelo;

import Enumeraciones.RoleUsuario;
import Gestion.GestionAcceso;
import Interfaces.ICifradorContrasena;

import java.util.Base64;

public abstract class Usuario implements ICifradorContrasena {
    protected String nombre;
    protected String apellido;
    protected String DNI;
    protected RoleUsuario role;
    protected String email;
    private String login;
    protected String contrasenaCifrada;

    // Constructor
    public Usuario(String nombre, String apellido, String DNI, RoleUsuario role, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.role = role;
        this.email = email;
        this.login = email;
        this.contrasenaCifrada = cifrarContrasena(DNI);
    }

    // getters y setters
    public String getDNI() {
        return DNI;
    }
    public String getEmail() {
        return email;
    }
    public static void setGestionUsuario(GestionAcceso gestionAcceso) {
    }
    public String getContrasenaCifrada() {
        return contrasenaCifrada;
    }

    // el metodo para cifrar contrasena
    @Override
    public String cifrarContrasena(String contrasena) {
        return Base64.getEncoder().encodeToString(contrasena.getBytes());
    }

    // el metodo abstracto para cambiar la contrasena
    public abstract void cambiarContrasena(String contrasena);
}

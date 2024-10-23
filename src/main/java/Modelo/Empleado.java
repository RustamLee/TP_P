package Modelo;

import Enumeraciones.RoleUsuario;
import Interfaces.IAccionesUsuarios;

public class Empleado extends Usuario implements IAccionesUsuarios {
    public String telefono;

    // Constructor
public Empleado(String nombre, String apellido, String DNI,RoleUsuario role, String email, String telefono) {
    super(nombre, apellido, DNI, role, email);
    if (role != RoleUsuario.ADMINISTRADOR && role != RoleUsuario.RECEPCIONISTA) {
        throw new IllegalArgumentException("Role solo puede ser ADMINISTRADOR or RECEPCIONISTA");
    }
    this.email = email;
    this.telefono = telefono;
}

    public String getDNI() {
        return DNI;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public void cambiarContrasena(String contrasena) {
        this.contrasenaCifrada = cifrarContrasena(contrasena);
    }

    public void mostrarDatos() {
        System.out.println("Nombre:" + nombre+ " Apellido:" + apellido+ " DNI:" + DNI+" Email:" + email+" Teléfono:" + telefono);
    }


    @Override
    public void login() {

    }
    @Override
    public void logout() {

    }
}

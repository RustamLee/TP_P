package Model;

import Interfaces.IAccionesUsuario;

public class Empleado extends Usuario implements IAccionesUsuario {
    public String email;//
    public String telefono;

    public Empleado(String nombre, String apellido, String DNI, String email, String telefono) {
        super(nombre, apellido, DNI);
        this.email = email;
        this.telefono = telefono;
    }

    public String getDNI() {
        return DNI;
    }
    public String getEmail() {
        return email;
    }

    public void mostrarDatos() {
        System.out.println("Nombre:" + nombre+ " Apellido:" + apellido+ " DNI:" + DNI+" Email:" + email+" Teléfono:" + telefono);
    }

    @Override
    public void login() {
        System.out.println("Para entrar al sistema reserva es necesario");

    }
    @Override
    public void logout() {
        System.out.println("Logout de Cliente");
    }
}

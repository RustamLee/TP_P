package Gestion;

import Interfaces.IAccionesUsuarios;
import Interfaces.ICifradorContrasena;
import Modelo.Usuario;

import java.util.Base64;
import java.util.HashMap;

public class GestionAcceso implements ICifradorContrasena, IAccionesUsuarios {

    private HashMap<String, String> loginContrasenaCollection;

    // Constructor
    public GestionAcceso() {
        this.loginContrasenaCollection = new HashMap<>();
    }

//    // el metodo para almacenar login y contrasena en la coleccion
//    public void guardarLoginContrasena(Usuario usuario) {
//        loginContrasenaCollection.put(usuario.getEmail(),usuario.getContrasenaCifrada());
//    }

    // getter y setter
    public void setLoginContrasenaCollection(HashMap<String, String> loginContrasenaCollection) {
        this.loginContrasenaCollection = loginContrasenaCollection;
    }
    public HashMap<String, String> getLoginContrasenaCollection() {
        return loginContrasenaCollection;
    }


//    // el metodo para verificar login y contrasena
//    public boolean verificarLoginContrasena (String email, String contrasena){
//        String contrasenaActual = loginContrasenaCollection.get(email);
//        if (contrasenaActual == null) {
//            return false;
//        }
//        if(isPrimeraVez(email,contrasena)){
//            return true;
//        } else if (contrasenaActual.equals(cifrarContrasena(contrasena))) {
//            return llamarCambiarContrasena(email,contrasena);
//        } else {
//            return false;
//        }
//    }

    public boolean llamarCambiarContrasena(String email, String dni) {
        String contrasenaActual = loginContrasenaCollection.get(email);
        System.out.println("Su contraseña es igual a su DNI, por favor cambie su contraseña.");
        System.out.println("Ingrese su nueva contraseña:");
        String nuevaContrasena = System.console().readLine();
        System.out.println("Confirme su nueva contraseña:");
        String contrasenaConfirmada = System.console().readLine();

        if (!nuevaContrasena.equals(contrasenaActual) && nuevaContrasena.equals(contrasenaConfirmada)) {
            loginContrasenaCollection.put(email, cifrarContrasena(nuevaContrasena));
            System.out.println("Contraseña cambiada!");
            return true;
        } else {
            System.out.println("Las contraseñas no coinciden o la nueva contraseña no puede ser igual a la anterior o al DNI.");
            return false;
        }
    }

    @Override
    public String cifrarContrasena(String contrasena) {
        return Base64.getEncoder().encodeToString(contrasena.getBytes());
    }

    @Override
    public void login() {
        System.out.println("Para iniciar sesión, ingrese su email:");
    }

    @Override
    public void logout() {
        System.out.println("Logout");
    }

    public void mostrarDatosDeAcceso() {
        for (String email : loginContrasenaCollection.keySet()) {
            System.out.println("Email: " + email + " Contraseña: " + loginContrasenaCollection.get(email));
        }
    }
}

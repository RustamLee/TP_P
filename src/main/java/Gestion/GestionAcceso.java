package Gestion;

import Interfaces.ICifradorContrasena;
import Modelo.Usuario;

import java.util.Base64;
import java.util.HashMap;

public class GestionAcceso implements ICifradorContrasena {

    private HashMap<String, String> loginContrasenaCollection;

    // Constructor
    public GestionAcceso() {
        this.loginContrasenaCollection = new HashMap<>();
    }

    // el metodo para almacenar login y contrasena en la coleccion
    public void guardarLoginContrasena(Usuario usuario) {
        loginContrasenaCollection.put(usuario.getEmail(),usuario.getContrasenaCifrada());
    }

    // getter y setter
    public void setLoginContrasenaCollection(HashMap<String, String> loginContrasenaCollection) {
        this.loginContrasenaCollection = loginContrasenaCollection;
    }
    public HashMap<String, String> getLoginContrasenaCollection() {
        return loginContrasenaCollection;
    }

    // el metodo para verificar si el login y contrasena son correctos
    public boolean verificarLoginContrasena (String email, String contrasena) {
        String contrasenaCifrada = loginContrasenaCollection.get(email);
        if (contrasenaCifrada == null) {
            return false;
        } else {
            String contrasenaCifradaIngresada = cifrarContrasena(contrasena);
            return contrasenaCifrada.equals(contrasenaCifradaIngresada);
        }
    }

    @Override
    public String cifrarContrasena(String contrasena) {
        return Base64.getEncoder().encodeToString(contrasena.getBytes());
    }

    public void mostrarDatosDeAcceso() {
        for (String email : loginContrasenaCollection.keySet()) {
            System.out.println("Email: " + email + " Contraseña: " + loginContrasenaCollection.get(email));
        }
    }

}

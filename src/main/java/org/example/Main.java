package org.example;

import Gestion.GestionArchivo;
import Gestion.GestionHotel;
import Gestion.GestionAcceso;
import Modelo.Usuario;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        // Cargar datos desde el archivo JSON
        // создаем объекты классов GestionAcceso, GestionArchivo, GestionHotel
        GestionAcceso gestionAcceso = new GestionAcceso();
        GestionHotel gestionHotel = new GestionHotel(gestionAcceso);
        GestionArchivo gestionArchivo = new GestionArchivo(gestionHotel, gestionAcceso);

        // Cargar empleados desde el archivo JSON a colección
        gestionArchivo.cargarDatos();

        // Cargar login y contrasena desde el archivo JSON a colección
        gestionArchivo.cargarLoginContrasena();

        // Creamos un nuevo empleado
        try {
            gestionHotel.crearEmpleado();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // print todos los empleados de la colección
        gestionHotel.mostrarEmpleados();

        // print todos los datos de acceso
        gestionAcceso.mostrarDatosDeAcceso();

        // cargamos los datos de los colecciones (empleados y loginContrasenas) a los archivos JSON
        gestionArchivo.guardarDatos();
        gestionArchivo.guardarLoginContrasenaEnArchivo();
    }
}
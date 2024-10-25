package org.example;

import Gestion.GestionArchivo;
import Gestion.GestionEmpleado;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        GestionArchivo gestionArchivo = new GestionArchivo();
        GestionEmpleado gestionEmpleado = gestionArchivo.getGestionEmpleado();

        // cargar empleados desde archivo JSON
        gestionArchivo.cargarEmpleadosDesdeArchivo();
        gestionArchivo.cargarLoginContrasenaDesdeArchivo();

        gestionEmpleado.cargarEmpleadoAColeccion();
        System.out.println("Empleados cargados: ");
        gestionEmpleado.mostrarEmpleados();
        System.out.println("Login y contrasenas: ");
        gestionEmpleado.mostrarLoginContrasenas();

        // guardar empleados y login y contrasenas en archivos JSON
        gestionArchivo.guardarEmpleados();
        gestionArchivo.guardarLoginContrasena();
        gestionArchivo.guardarLoginContrasena();

    }
}
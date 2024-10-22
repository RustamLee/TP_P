package org.example;

import Gestion.GestionArchivo;
import Gestion.GestionHotel;
import Modelo.Empleado;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        // Cargar datos desde el archivo JSON

        GestionHotel gestionHotel = new GestionHotel();
        GestionArchivo gestionArchivo = new GestionArchivo(gestionHotel);
        gestionArchivo.cargarDatos();

        // para menu: crear empleado
        //gestionHotel.addEmpleadoToCollection(gestionHotel.crearEmpleado());

        gestionHotel.mostrarEmpleados();

        // Guardar datos en el archivo JSON
        gestionArchivo.guardarDatos();

    }
}
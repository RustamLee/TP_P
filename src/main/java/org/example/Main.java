package org.example;

import Gestion.GestionHotel;
import Modelo.Empleado;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        Empleado empleado = new Empleado("Anna", "Gascon", "12345", "Calle Falsa 123", "123456789");
        Empleado empleado2 = new Empleado("Juan", "Lancome", "54321", "Calle Falsa 123", "123456789");
        Empleado empleado3 = new Empleado("Maria", "Garcia", "33333", "Calle Falsa 123", "123456789");



        GestionHotel gestionHotel = new GestionHotel();
//        try {
//            gestionHotel.addEmpleadoToFile(empleado);
//            gestionHotel.addEmpleadoToFile(empleado2);
//            gestionHotel.addEmpleadoToFile(empleado3);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        gestionHotel.mostrarEmpleados();
        Empleado test = new Empleado("Maria", "Garcia", "77777", "Calle Falsa 123", "11111111111");
        try {
            gestionHotel.addEmpleadoToFile(test);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
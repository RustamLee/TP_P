package Gestion;

import Excepciones.EmpleadoYaExistenteException;
import Modelo.Empleado;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class GestionHotel {

    private HashMap<String, Empleado> empleados;

    // Constructor
    public GestionHotel() {
        empleados = new HashMap<>();
    }

    // Methodo para agregar un empleado a la colección empleados
    public void addEmpleadoToCollection(Empleado empleado) throws EmpleadoYaExistenteException {
        if (empleados.containsKey(empleado.getDNI())) {
            throw new EmpleadoYaExistenteException("El empleado ya existe");
        }
        empleados.put(empleado.getDNI(), empleado);
    }
    // metodo para eliminar un empleado de la colección empleados
    public void eliminarEmpleado(String DNI) {
        empleados.remove(DNI);
    }

    // getter y setter para empleados (collections)
    public HashMap<String, Empleado> getEmpleados() {
        return empleados;
    }
    public void setEmpleados(HashMap<String, Empleado> empleados) {
        this.empleados = empleados;
    }

    public void mostrarEmpleados() {
        for (Empleado empleado : empleados.values()) {
            empleado.mostrarDatos();
        }
    }

    // un metodo que lee datos del usuario en la consola y devuelve un objeto Empleado

    public Empleado crearEmpleado(){
        System.out.println("Ingrese el nombre del empleado: ");
        String nombre = System.console().readLine();
        System.out.println("Ingrese el apellido del empleado: ");
        String apellido = System.console().readLine();
        System.out.println("Ingrese el DNI del empleado: ");
        String DNI = System.console().readLine();
        System.out.println("Ingrese el email del empleado: ");
        String email = System.console().readLine();
        System.out.println("Ingrese el telefono del empleado: ");
        String telefono = System.console().readLine();
        return new Empleado(nombre, apellido, DNI, telefono, email);
    }

}

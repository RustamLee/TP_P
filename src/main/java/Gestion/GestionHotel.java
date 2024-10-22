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
    private String  FILE_PATH = "empleados.json";
    private Gson gson;

    // Constructor
    public GestionHotel() {
        empleados = new HashMap<>();
        gson = new Gson();
    }

    // antes de guardar los empleados en el archivo JSON hay que revisar si ya existe un empleado con el mismo DNI
    // -> por eso leemos el archivo JSON y guardamos los empleados en el HashMap
    // -> si ya existe un empleado con el mismo DNI lanzamos una excepción
    // -> si no existe el empleado lo guardamos en el HashMap y luego guardamos el HashMap en el archivo JSON
    public void addEmpleadoToFile(Empleado empleado) throws EmpleadoYaExistenteException, IOException {
        // Load existing employees from file
        leerEmpleadosFromFile();

        // Check if the employee already exists
        if (empleados.containsKey(empleado.getDNI())) {
            throw new EmpleadoYaExistenteException("Empleado con DNI " + empleado.getDNI() + " ya existe.");
        }

        // Add the new employee to the collection
        empleados.put(empleado.getDNI(), empleado);

        // Save the updated collection to the file
        saveEmpleadosToFileAux();
    }

    // Methodo para guardar los empleados en el archivo JSON
    public void saveEmpleadosToFileAux() throws IOException {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(empleados, writer);
        }
    }

    // Methodo para cargar los empleados desde el archivo JSON a la colección empleados
    public void leerEmpleadosFromFile() throws IOException {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<HashMap<String, Empleado>>() {}.getType();
            empleados = gson.fromJson(reader, type);
        } catch (IOException e) {
            // si no se puede leer el archivo, se crea un nuevo HashMap
            empleados = new HashMap<>();
        }
    }

    public void mostrarEmpleados() {
        for (Empleado empleado : empleados.values()) {
            empleado.mostrarDatos();
        }
    }


}

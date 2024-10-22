package Gestion;
import Modelo.Empleado;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class GestionArchivo {

    private GestionHotel gestionHotel;
    private String FILE_PATH = "empleados.json";
    private Gson gson;

    public GestionArchivo(GestionHotel gestionHotel) {
        this.gestionHotel = gestionHotel;
        gson = new Gson();
    }

    // carga los empleados desde el archivo JSON al HashMap
    // aca hay que anadir caargas otros archivos (clientes, habitaciones, etc.)
    public void cargarDatos() throws IOException {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<HashMap<String, Empleado>>() {}.getType();
            HashMap<String, Empleado> empleadosFromFile = gson.fromJson(reader, type);
            if (empleadosFromFile != null) {
                gestionHotel.getEmpleados().putAll(empleadosFromFile);
            }
        }
    }

        //// Guardando datos en un archivo cuando finaliza el programa
        public void guardarDatos() {
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try (FileWriter writer = new FileWriter(FILE_PATH)) {
                    gson.toJson(gestionHotel.getEmpleados(), writer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));
        }

}

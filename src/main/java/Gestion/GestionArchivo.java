package Gestion;

import Modelo.Empleado;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class GestionArchivo {

    // EMPLEADOS
    private GestionHotel gestionHotel;
    private GestionAcceso gestionAcceso;
    private String EMPLEADOS_PATH = "empleados.json";
    private String USUARIOS_PATH = "loginContrasena.json";
    private Gson gson;

    // Constructor
    public GestionArchivo(GestionHotel gestionHotel, GestionAcceso gestionAcceso) {
        this.gestionHotel = gestionHotel;
        this.gestionAcceso = gestionAcceso;
        gson = new Gson();
    }


    // EMPLEADOS

    // carga los empleados desde el archivo JSON al HashMap
    // aca hay que anadir caargas otros archivos (clientes, habitaciones, etc.)
    public void cargarDatos() throws IOException {
        checkEmpleadosFileExists();
        try (FileReader reader = new FileReader(EMPLEADOS_PATH)) {
            Type type = new TypeToken<HashMap<String, Empleado>>() {
            }.getType();
            HashMap<String, Empleado> empleadosFromFile = gson.fromJson(reader, type);
            if (empleadosFromFile != null) {
                gestionHotel.getEmpleados().putAll(empleadosFromFile);
            }
        }
    }

    // Cargar login y contrasena desde el archivo JSON al HashMap
    private void checkLoginContrasenaFileExists() throws IOException {
        File file = new File(USUARIOS_PATH);
        if (!file.exists()) {
            file.createNewFile();
            try (FileWriter writer = new FileWriter(file)) {
                gson.toJson(new HashMap<String, String>(), writer);
            }
        }
    }

    private void checkEmpleadosFileExists() throws IOException {
        File file = new File(EMPLEADOS_PATH);
        if (!file.exists()) {
            file.createNewFile();
            try (FileWriter writer = new FileWriter(file)) {
                gson.toJson(new HashMap<String, Empleado>(), writer);
            }
        }
    }

    public void cargarLoginContrasena() throws IOException {
        checkLoginContrasenaFileExists();
        try (FileReader reader = new FileReader(USUARIOS_PATH)) {
            Type type = new TypeToken<HashMap<String, String>>() {
            }.getType();
            HashMap<String, String> loginContrasenaFromFile = gson.fromJson(reader, type);
            if (loginContrasenaFromFile != null) {
                gestionAcceso.setLoginContrasenaCollection(loginContrasenaFromFile);
            }
        }
    }

    //// Guardando Empleados en un archivo cuando finaliza el programa
    public void guardarDatos() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter(EMPLEADOS_PATH)) {
                gson.toJson(gestionHotel.getEmpleados(), writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    // Guardar login y contrasena en archivo cuando finaliza el programa
    public void guardarLoginContrasenaEnArchivo() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter(USUARIOS_PATH)) {
                gson.toJson(gestionAcceso.getLoginContrasenaCollection(), writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
}

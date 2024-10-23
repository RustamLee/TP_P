package Gestion;

import Enumeraciones.RoleUsuario;
import Excepciones.EmpleadoYaExistenteException;
import Modelo.Empleado;
import java.util.HashMap;

public class GestionHotel {

    private HashMap<String, Empleado> empleados;
    private GestionArchivo gestionArchivo;
    private GestionAcceso gestionAcceso;

    // Constructor
    public GestionHotel(GestionAcceso gestionAcceso) {
        this.gestionAcceso = gestionAcceso;
        this.gestionArchivo = new GestionArchivo(this, gestionAcceso);
        this.empleados = new HashMap<>();
    }

    // el metodo para crear nuevoEmpleado
    public void crearEmpleado () {
        Empleado empleado = obtenerDatosEmpleado();
        try{
            addEmpleadoToCollection(empleado);
            gestionAcceso.guardarLoginContrasena(empleado);
        } catch (EmpleadoYaExistenteException e) {
            System.out.println(e.getMessage());
        }
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
    public Empleado obtenerDatosEmpleado(){
        System.out.println("Ingrese el nombre del empleado: ");
        String nombre = System.console().readLine();
        System.out.println("Ingrese el apellido del empleado: ");
        String apellido = System.console().readLine();
        System.out.println("Ingrese el DNI del empleado: ");
        String DNI = System.console().readLine();
        System.out.println("Ingrese el role del empleado ADMINISTRADOR or RECEPCIONISTA: ");
        RoleUsuario role = RoleUsuario.valueOf(System.console().readLine());
        System.out.println("Ingrese el email del empleado: ");
        String email = System.console().readLine();
        System.out.println("Ingrese el telefono del empleado: ");
        String telefono = System.console().readLine();
        return new Empleado(nombre, apellido, DNI, role,email,telefono);
    }

}

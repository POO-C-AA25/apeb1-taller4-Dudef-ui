/***
 * Un conductor de autobús escolar necesita un sistema sencillo que le permita verificar si los estudiantes tienen permitido subir al autobús, 
 * según su ruta y si están autorizados para ese día. El programa debe permitir registrar temporalmente una lista de estudiantes con su nombre, grado, 
 * y si tienen permiso vigente. Luego, debe simular el ingreso de estudiantes, indicando si pueden subir o no, 
 * y mostrando al final un resumen del total de estudiantes aceptados y rechazados.
 * Los requerimientos generales en resumen son los siguientes:
 * 
 * Registrar estudiantes con los datos requeridos.
 * Simular el ingreso y verificar condiciones dadas.
 * Mostrar un resumen con totales de aceptados y rechazados.
 * @author David Gonzalez/Dudef-ui
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Problema3_EjecutorBuses {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Variables para solitictar la informacion al usuario
        String nombre = "", ruta = "", grado = "";
        boolean permisoVigente;
        int numeroEstudiantes;

        //Creacion de la lista dinamica que va a contener a los objetos de clase Estudiante[]; 
        ArrayList<Estudiantes> estudiantes1 = new ArrayList<>();

        //Creacion de un objeto del tipo estudiante para poder trabajar con los metodos de esta clase
        Estudiantes estudiante1 = new Estudiantes();

        //Creacion del objeto tipo Autobus para poder manejar los metodos
        Autobus autobus1 = new Autobus("Ruta 1", true);

        //Se solicita al usuario de cuantos estudiantes hay y la informacion de los mismos
        System.out.print("Ingrese el número de estudiantes: ");
        numeroEstudiantes = Integer.parseInt(teclado.nextLine());

        for (int i = 0; i < numeroEstudiantes; i++) {
            System.out.println("\nEstudiante #" + (i + 1));
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();

            System.out.print("Grado: ");
            grado = teclado.nextLine();

            System.out.print("Ruta: ");
            ruta = teclado.nextLine();

            System.out.print("¿Tiene permiso vigente? (true/false): ");
            permisoVigente = Boolean.parseBoolean(teclado.nextLine());

            estudiante1.registroEstudiantes(estudiantes1, nombre, grado, ruta, permisoVigente);
        }

        //Se invoca el metodo para simular el ingreso de los estudiantes con ayuda del objeto del tipo Autobus
        autobus1.simularIngresoEstudiantes(estudiantes1);
        autobus1.mostrarResumen();
        //Se imprimen los datos recaudados en el toString
        System.out.print(autobus1.toString());
    }
}

class Autobus {

    public String ruta;
    public boolean autorizacion;
    public int estudiantesAdmitidos;
    public int estudiantesRechazados;

    //Constructores  
    public Autobus() {
    }

    public Autobus(String ruta, boolean autorizacion) {
        this.ruta = ruta;
        this.autorizacion = autorizacion;
    }

    //Metodo para simular el ingreso de los estudiantes
    public void simularIngresoEstudiantes(ArrayList<Estudiantes> estudiantes) {
        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.permisoVigente == true && (estudiante.ruta.equalsIgnoreCase(this.ruta))) {
                this.estudiantesAdmitidos++;
            } else {
                this.estudiantesRechazados++;
            }
        }
    }

    //Se imprime la cantidad de estudiantes aceptados y rechazados
    public void mostrarResumen() {
        System.out.println("--------------RESUMEN--------------");
        System.out.println("Estudiantes aceptados: " + this.estudiantesAdmitidos);
        System.out.println("Estudiantes rechazados: " + this.estudiantesRechazados);
    }

    //Metodo toString para mostrar la informacion del bus
    @Override
    public String toString() {
        return "\nAutobus{"
                + "\nRuta: " + ruta
                + "\nAutorizacion: " + autorizacion
                + "\nEstudiantes admitidos:" + estudiantesAdmitidos
                + "\nEstudiantes rechazados:" + estudiantesRechazados
                + "\n}\n";
    }

}

//Segunda clase para definir los estudiantes
class Estudiantes {
    //En esta clase unicamente se van a registrar los datos de los estudiantes 

    public String nombre;
    public String grado;
    public String ruta;
    public boolean permisoVigente;

    //Constructores
    public Estudiantes() {

    }

    public Estudiantes(String nombre, String grado, String ruta, boolean permisoVigente) {
        this.nombre = nombre;
        this.grado = grado;
        this.ruta = ruta;
        this.permisoVigente = permisoVigente;
    }

    //Metodo para el registro de los estudiantes en una lista dinamica
    public void registroEstudiantes(ArrayList<Estudiantes> estudiantes, String nombre, String grado, String ruta, boolean permisoVigente) {
        estudiantes.add(new Estudiantes(nombre, grado, ruta, permisoVigente));
    }
}

/***
 * Ingrese el número de estudiantes: 2
 * 
 * Estudiante #1
 * Nombre: Pedro
 * Grado: Segundo
 * Ruta: ruta 1
 * ¿Tiene permiso vigente? (true/false): true
 * Estudiante #2
 * Nombre: Daniel
 * Grado: Tercero 
 * Ruta: ruta 2
 * ¿Tiene permiso vigente? (true/false): true
 * 
 * Estudiantes aceptados: 1
 * Estudiantes rechazados: 1
 * 
 * Autobus{
 * Ruta: Ruta 1
 * Autorizacion: true
 * Estudiantes admitidos:1
 * Estudiantes rechazados:1
 * }
 * BUILD SUCCESSFUL (total time: 36 seconds)
 */
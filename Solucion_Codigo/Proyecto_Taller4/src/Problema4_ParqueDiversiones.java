/***
 * Un parque de diversiones necesita controlar la entrada de visitantes según su edad y altura. 
 * Solo pueden ingresar a ciertos juegos los visitantes que cumplen con las restricciones mínimas. 
 * El programa debe registrar a los visitantes e indicar a cuáles juegos pueden acceder. 
 * Al final, debe mostrar cuántos visitantes cumplieron con todos los requisitos. 
 * 
 * Por tanto, los requerimientos generales son los siguientes:
 * 
 * Registrar al visitante con los datos de entreda necesarios.
 * Determinar si el visitante puede acceder al juegos de su elección.
 * Al final del día, se debe mostrar el resumen de cuántos cumplen con todas las condiciones.
 * 
 * @author David Gonzalez/ Dudef-ui
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Problema4_ParqueDiversiones {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //Definion de las varibles para regitrar los visitantes
        int edad = 0, numeroVisitantes = 0;
        double altura = 0.0;
        String juegoPreferencial = "";

        //Definicion de la lista dinamica para registrar los visitantes y la lista de juegos disponibles
        ArrayList<Visitante> grupoVisitantes = new ArrayList<>();

        //Definicion de los objetos para utilizar los metodos de cada clase      
        Visitante visitanteTemp = new Visitante();

        Parque juego1 = new Parque("Juego 1", 15, 1.60);

        //Solicitud de los datos
        System.out.print("Dime cuantos visitantes van a ingresar: ");
        numeroVisitantes = teclado.nextInt();
        teclado.nextLine();
        for (int i = 0; i < numeroVisitantes; i++) {
            System.out.println("---------------------Visitante" +(i+1)+"---------------------");
            System.out.print("Dime el juego al que quiere ingresar el visitante: ");
            juegoPreferencial = teclado.nextLine();
            System.out.print("Dime la estatura del visitante: ");
            altura = teclado.nextDouble();
            System.out.print("Dime la edad del visitante: ");
            edad = teclado.nextInt();
            teclado.nextLine();
            //Registro de los visitantes
            visitanteTemp.registrarVisitantes(grupoVisitantes, juegoPreferencial, edad, altura);
        }
        //Invocacion de los metodos
        juego1.determinarAcceso(grupoVisitantes);
        System.out.print("\nResumen del dia:\n" + juego1.toString());

    }

}
//Creacion de la clase visitante

class Visitante {

    public int edad;
    public double altura;
    public String juegoPreferencial;

    //Definicion de los constructores de la clase visitante
    public Visitante() {
    }

    public Visitante(String juegoPreferencial, int edad, double altura) {
        this.edad = edad;
        this.altura = altura;
        this.juegoPreferencial = juegoPreferencial;
    }

    //Metodo para registrar los visitantes
    public void registrarVisitantes(ArrayList<Visitante> grupovisitantes, String juegoPreferencial, int edad, double altura) {
        grupovisitantes.add(new Visitante(juegoPreferencial, edad, altura));
    }

}
//Creacion de la clase parque

class Parque {

    //En esta clase los objetos creados van a ser los juegos mecanicos del parque
    public int cumplieronRequisitos;
    public String nombre;
    public int edadRequerida;
    public double alturaRequerida;

    //Definicion de los constructores de la clase parque
    public Parque() {
    }

    public Parque(String nombre, int edadRequerida, double alturaRequerida) {
        this.nombre = nombre;
        this.edadRequerida = edadRequerida;
        this.alturaRequerida = alturaRequerida;
    }

    //Metodo para verificar a que juegos pueden entrar los visitantes
    public void determinarAcceso(ArrayList<Visitante> grupoVisitantes) {
        for (Visitante grupoVisitante : grupoVisitantes) {
            if (grupoVisitante.edad >= this.edadRequerida && grupoVisitante.altura >= this.alturaRequerida) {
                this.cumplieronRequisitos++;
                System.out.print("El jugador puede acceder a todos los juegos");
            } else if (grupoVisitante.edad >= this.edadRequerida || grupoVisitante.altura >= this.alturaRequerida) {
                if (grupoVisitante.juegoPreferencial.equalsIgnoreCase(this.nombre)) {
                    System.out.println("El visitante puede subir a su juego de preferencia ");
                }
                System.out.print("El visitante puede acceder a los siguientes juegos: ");
                System.out.println("\t" + this.nombre);
            }
        }
    }

    @Override
    public String toString() {
        return "\nJuego mecanico{"
                + "\nCumplieron con todos los requisitos: " + cumplieronRequisitos
                + "\nNombre: " + nombre
                + "\nEdad requerida: " + edadRequerida
                + "\nAltura requerida: " + alturaRequerida 
                + "\n}\n";
    }
}
/***
 * run:
 * Dime cuantos visitantes van a ingresar: 2
---------------------Visitante1---------------------
Dime el juego al que quiere ingresar el visitante: juego 1
Dime la estatura del visitante: 1,70
Dime la edad del visitante: 18
---------------------Visitante2---------------------
Dime el juego al que quiere ingresar el visitante: juego 1
Dime la estatura del visitante: 1,50
Dime la edad del visitante: 12
* El jugador puede acceder a todos los juegos
* 
* Resumen del dia:
* 
* Juego mecanico{
* Cumplieron con todos los requisitos: 1
* Nombre: Juego 1
* Edad requerida: 15
* Altura requerida: 1.6}
* 
* BUILD SUCCESSFUL (total time: 30 seconds)
 */
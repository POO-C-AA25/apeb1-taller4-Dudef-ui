/***
 * Desarrolla un programa que permita gestionar una lista de empleados de una empresa y su nómina de pagos. El programa debe permitir al usuario realizar las siguientes acciones:
 * 
 * Agregar un empleado: El usuario debe ingresar el nombre, el salario y la edad del empleado. 
 * El programa debe crear un objeto de la clase "Empleado" con esta información y agregarlo a la lista de empleados.
 *
 * Mostrar información de los empleados: El programa debe mostrar en pantalla la información de todos los empleados registrados, incluyendo su nombre, salario y edad.
 * 
 * Calcular aumento de salario: El programa debe solicitar al usuario ingresar un porcentaje de aumento salarial. 
 * Luego, para cada empleado cuyo salario sea menor al salario promedio de todos los empleados, 
 * se debe aplicar el aumento correspondiente y mostrar en pantalla el nuevo salario.
 * @author David Gonzalez/Dudef-ui
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Problema2_EjecutorNomina {
//Metodo main

    public static void main(String[] args) {
        //Se declaran las variables en caso de querer agregar un empleado
        Scanner teclado = new Scanner(System.in);
        //Variables a utilizar 
        int eleccion = 0, edad = 0, salir = 0;
        double salario = 0.0, aumento = 0;
        String nombre;
        //Declaracion de una lista dinamica 
        ArrayList<Empleados> dinamicaEmpleados = new ArrayList<>();

        //Declaracion de una lista para trabajar con elementos estaticos 
        Empleados empleadoObj = new Empleados();
        
        //Bucle para la eleccion del menu y las acciones del mismo
        do {
            //Impresion del menu de acciones
            System.out.print("""
                                                        Menú 
                         _______________________________________________________________
                         
                                        Ingresa 1 para agregar un empleado          
                         _______________________________________________________________
                         
                            Ingresa 2 para visualizar la informacion de los empleados
                         _______________________________________________________________
                             
                              Ingresa 3 si quieres solicitar un aumento de salario
                         _______________________________________________________________             
                             
                                      Ingresa 4 si quieres salir del programa 
                         _______________________________________________________________
                           
                             """);
            
            System.out.println("");
            eleccion = teclado.nextInt();

            //Elegir que metodo se va a utilizar
            switch (eleccion) {
                case 1:
                    System.out.print("\nIngresa los datos del nuevo empleado");
                    teclado.nextLine();
                    System.out.print("\nDime el nombre del empleado: ");
                    nombre = teclado.nextLine();
                    System.out.print("\nDime la edad del empleado: ");
                    edad = teclado.nextInt();
                    System.out.print("\nDime el salario del empleado: ");
                    salario = teclado.nextDouble();
                    teclado.nextLine();
                    
                    //Se agrega los datos a la array list dinamica utilizando el objeto como puente
                    empleadoObj.agregarEmpleado(dinamicaEmpleados, nombre, edad, salario);
                    break;
                case 2:
                    //Se invoca el metodo usando el objeto puente
                    System.out.println("");
                    empleadoObj.mostrarInformacion(dinamicaEmpleados);
                    break;
                case 3:
                    System.out.print("Dime el porcentaje de aumento: ");
                    aumento = teclado.nextInt();
                    
                    empleadoObj.calcularAumento(dinamicaEmpleados, aumento);
                    break;
                default:
                    System.out.print("Saliendo del sistema");
            }

        } while (eleccion != 4);
    }
        //Clase empleados
    static class Empleados {

        //Definicion de los atributos
        public String nombres;
        public int edad;
        public double salario;
        public double aumentoSalario;

        //Constructores
        public Empleados() {
        }

        public Empleados(String nombres, int edad, double salario) {
            this.nombres = nombres;
            this.edad = edad;
            this.salario = salario;
        }
        
        //Metodo para agregar empleados
        public void agregarEmpleado(ArrayList<Empleados> empleados, String nombre, int edad, double salario){
            empleados.add(new Empleados(nombre, edad, salario));
        }
        
        //Metodo para visualizar la informacion
        public void mostrarInformacion(ArrayList<Empleados> empleados){
            int i = 0;
            
            for (Empleados empleado : empleados) {
                i++;
                System.out.print("Empleado N" +i+ ": "
                        + "\t\nNombres:" + empleado.nombres 
                        + "\t\nEdad:" + empleado.edad
                        + "\t\nSalario:" + empleado.salario
                        + "\n_____________________________\n");
            }
        }
        
        //Metodo para calcular y aplicar el aumento
        public void calcularAumento(ArrayList<Empleados> empleados, double aumento){
            this.aumentoSalario = ((aumento + 100.0)/100.0);
            for (Empleados empleado : empleados) {
                empleado.salario = empleado.salario * this.aumentoSalario;
            }
        }
    }
}
/***
 * run:
                               Menú
_______________________________________________________________

               Ingresa 1 para agregar un empleado
_______________________________________________________________

   Ingresa 2 para visualizar la informacion de los empleados
_______________________________________________________________

     Ingresa 3 si quieres solicitar un aumento de salario
_______________________________________________________________

             Ingresa 4 si quieres salir del programa
_______________________________________________________________


1

Ingresa los datos del nuevo empleado
Dime el nombre del empleado: Josue Daniel 

Dime la edad del empleado: 23

Dime el salario del empleado: 2000
                               Menú
_______________________________________________________________

               Ingresa 1 para agregar un empleado
_______________________________________________________________

   Ingresa 2 para visualizar la informacion de los empleados
_______________________________________________________________

     Ingresa 3 si quieres solicitar un aumento de salario
_______________________________________________________________

             Ingresa 4 si quieres salir del programa
_______________________________________________________________


1

Ingresa los datos del nuevo empleado
Dime el nombre del empleado: Juan Alvarez 

Dime la edad del empleado: 30

Dime el salario del empleado: 2600
                               Menú
_______________________________________________________________

               Ingresa 1 para agregar un empleado
_______________________________________________________________

   Ingresa 2 para visualizar la informacion de los empleados
_______________________________________________________________

     Ingresa 3 si quieres solicitar un aumento de salario
_______________________________________________________________

             Ingresa 4 si quieres salir del programa
_______________________________________________________________


3
Dime el porcentaje de aumento: 10
                               Menú
_______________________________________________________________

               Ingresa 1 para agregar un empleado
_______________________________________________________________

   Ingresa 2 para visualizar la informacion de los empleados
_______________________________________________________________

     Ingresa 3 si quieres solicitar un aumento de salario
_______________________________________________________________

             Ingresa 4 si quieres salir del programa
_______________________________________________________________


2

Empleado N1: 	
Nombres:Josue Daniel 	
Edad:23	
Salario:2200.0
_____________________________
Empleado N2: 	
Nombres:Juan Alvarez 	
Edad:30	
Salario:2860.0000000000005
_____________________________
 */
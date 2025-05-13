import java.util.ArrayList;
import java.util.Scanner;
public class Problema5_gym {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        //Lista dinamica para guardar los datos de los clientes
        ArrayList<Cliente> grupoClientes = new ArrayList<>();
        
        //Definicion de variables
        String nombre = " ", tipoEjercicio = " ";
        double tiempoRutina = 0.0;
        boolean cumplimiento;
        int cantidadClientes = 0;
        
        //Objetos temporales para trabajar los atributos
        Cliente clienteTemp = new Cliente();
        
        //Creacion del objeto del tipo Gimnasio
        Gimnasio gimnasio1 = new Gimnasio("Total Flex");
        
        System.out.println("Dime la cantidad de clientes: ");
        cantidadClientes = teclado.nextInt();
        teclado.nextLine();
        for (int i = 0; i < cantidadClientes; i++) {
            System.out.print("---------------------Cliente" +(i+1)+"---------------------");
            System.out.print("\nDime el nombre del cliente: ");
            nombre = teclado.nextLine();
            System.out.print("Dime el tipo de ejercicio: ");
            tipoEjercicio = teclado.nextLine();
            System.out.print("Dime el tiempo de rutina del cliente: ");
            tiempoRutina = teclado.nextDouble();
            System.out.print("Dime si el cliente completo su rutina(true/false): ");
            cumplimiento = teclado.nextBoolean();
            teclado.nextLine();
            
            clienteTemp.registroCliente(grupoClientes, nombre, tipoEjercicio, tiempoRutina, cumplimiento);      
        }
        
        //Uso del los metodos
        gimnasio1.estadisticaBasica(grupoClientes);
        System.out.println(gimnasio1.toString());
        
        
    }
}
class Cliente{
    public String nombre;
    public String tipoEjercicio;
    public double tiempoRutina;
    public boolean cumplimiento;
    
    //Definicion de los constructores
    public Cliente() {
    }

    public Cliente(String nombre, String tipoEjercicio, double tiempoRutina, boolean cumplimiento) {
        this.nombre = nombre;
        this.tipoEjercicio = tipoEjercicio;
        this.tiempoRutina = tiempoRutina;
        this.cumplimiento = cumplimiento;
    }
    
    public void registroCliente(ArrayList<Cliente> cliente, String nombre, String tipoEjercicio, double tiempoRutina, boolean cumplimiento){
        cliente.add(new Cliente(nombre, tipoEjercicio, tiempoRutina, cumplimiento));
    }
    
    
}
class Gimnasio{
    public String nombreGym;
    public int rutinaCompleta;
    public int rutinaIncompleta;
    public int totalMin;
    
//Constructores
    public Gimnasio() {
    }

    public Gimnasio(String nombreGym) {
        this.nombreGym = nombreGym;
    }
    
    public void estadisticaBasica(ArrayList<Cliente> cliente){
        for (Cliente cliente1 : cliente) {
            if(cliente1.cumplimiento == true){
                this.rutinaCompleta++;
            }else{
                this.rutinaIncompleta++;
            }
            this.totalMin += cliente1.tiempoRutina;
        }
    }

    @Override
    public String toString() {
        return "\nGimnasio{" 
                + "\nNombre gimnasio: " + nombreGym 
                + "\nPersonas que completaron la rutina: " + rutinaCompleta 
                + "\nPersonas que no completaron la rutina: " + rutinaIncompleta 
                + "\nTotal de los minutos de rutina: " + totalMin 
                + "\n}\n";
    }
}
/***
 * run:
Dime la cantidad de clientes: 
2
---------------------Cliente1---------------------
Dime el nombre del cliente: Rosa
Dime el tipo de ejercicio: Cardio
Dime el tiempo de rutina del cliente: 60
Dime si el cliente completo su rutina(true/false): true
---------------------Cliente2---------------------
Dime el nombre del cliente: Pedro
Dime el tipo de ejercicio: Hipertrofia 
Dime el tiempo de rutina del cliente: 180
Dime si el cliente completo su rutina(true/false): false

Gimnasio{
Nombre gimnasio: Total Flex
Personas que completaron la rutina: 1
Personas que no completaron la rutina: 1
Total de los minutos de rutina240
}

BUILD SUCCESSFUL (total time: 35 seconds)

 */
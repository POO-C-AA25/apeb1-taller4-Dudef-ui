import java.util.Scanner;
/***
 * Desarrolla un programa que automatice la venta de X producto. 
 * El programa debe permitir al usuario ingresar el precio de un producto y determinar el descuento aplicable según las siguientes reglas:
 * Si el precio del producto es mayor o igual a $1000, y el número de productos al menos 10, se aplica un descuento del 10%.
 * Si el precio del producto es menor a $1000, se aplica un descuento del 5%, independientemente del número de productos.
 * 
 * @author David Gonzalez / Dudef-ui
 */
public class Problema1_EjecutorProducto {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //Variables para insercion de datos
        int cantidad;
        double precio;
        
        //Solicitud de los datos en el metodo main
        System.out.print("Dime la cantidad de producto que deseas: ");
        cantidad = teclado.nextInt();
        System.out.print("Dime el precio por producto: ");
        precio = teclado.nextInt();
        
        //Generacion y impresion de los datos del primer objeto
        Producto  producto1 = new Producto(cantidad, precio);
            producto1.calcularDescuento(precio, cantidad);
            producto1.calcularPrecioFinal();
            System.out.print(producto1.toString());
        
        //Generacion y impresion de los datos del segundo objeto
        Producto producto2 = new Producto(10, 10.0);
            producto2.calcularDescuento(precio, cantidad);
            producto2.calcularPrecioFinal();
            System.out.print(producto2.toString());
    }
}

class Producto {
    //Declaraciond de los atributos
    public int cantidadProducto;
    public double precioProducto;
    public double descuento;
    public double montoDescuento;
    public double precioFinal;

    public Producto() {
    }

    public Producto(int cantidadProducto, double precioProducto) {
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
    }

    public double calcularDescuento(double precioProducto, int cantidadProducto) {
        if (this.precioProducto >= 1000 && this.cantidadProducto >= 10) {
            this.descuento = 10;
        } else if (this.precioProducto < 1000) {
            this.descuento = 5;
        }
        this.montoDescuento = (this.cantidadProducto * this.precioProducto) * (this.descuento / 100);
        return this.descuento;
    }

    public double calcularPrecioFinal() {
        this.precioFinal = (this.cantidadProducto * this.precioProducto) - this.montoDescuento;
        return this.precioFinal;
    }
    
    @Override
    public String toString() {
        return "\nProducto{" 
                + "\nCantidad del producto: " + cantidadProducto 
                + "\nPrecio del producto: " + precioProducto 
                + "\nDescuento aplicado: " + descuento +" %" 
                + "\nDescuento:" + montoDescuento 
                + "\nPrecio final: " + precioFinal + "}\n";
    }
}
/**
 * run:
 * Dime la cantidad de producto que deseas: 10
 * Dime el precio por producto: 1000
 * Producto{
 * Cantidad del producto: 10
 * Precio del producto: 1000.0
 * Descuento aplicado: 10.0 %
 * Descuento:1000.0
 * Precio final: 9000.0}
 * 
 * Producto{
 * Cantidad del producto: 10
 * Precio del producto: 10.0
 * Descuento aplicado: 5.0 %
 * Descuento:5.0
 * Precio final: 95.0}
 * BUILD SUCCESSFUL (total time: 13 seconds)
 */
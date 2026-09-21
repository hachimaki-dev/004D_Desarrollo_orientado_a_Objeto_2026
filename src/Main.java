/*
* En verdad nose que me esperaba :/
* Teoricamente aca utilisamos el paradigma de Programacion Orientada a Objecto (POO)
* Para lograr una estructura organizada y mantenible, en teoria.
* 
* Que diferencias hay entre Java y Python? 
* Java definitivamente requiere mucho mas pensamiento a la larga ya que
* Errores en planificacion realmente complican todo a diferencia de Python
* Donde puedes mas o menos salirte con la tuya, pero aca no (Y yo soy)
* TERRIBLE planificando, algo para trabajar.
* Tambien Java y POO en general es mucho menos intuitivo comparado a Python y
* Programacion linear, pero en todo caso con un poco de cabeza definitivamente
* Podria entenderlo y hacer algo asi funcionar.
* (Spoiler esto no funciona y con suerte logre hacer un esqueleto )
*/

import java.util.Scanner;

    
public class Main {
    
    public static void mostrarMenu(){
        System.out.println("=== TIENDA DE VIDEOJUEGOS ===");
        System.out.println("1. Registrar Producto");
        System.out.println("2. Listar Inventario");
        System.out.println("3. Buscar Producto por Nombre");
        System.out.println("4. Vender Producto");
        System.out.println("5. Resumen de Inventario");
        System.out.println("6. Salir");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean menuActivado;

        int seleccion = sc.nextInt();
        while (menuActivado = true){
            mostrarMenu();
            switch (seleccion) {
                case 1:
                    
                    registrarProducto(sc);
                    break;
                case 2:

                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    menuActivado = false;
                    break;
            
                default:
                    break;
            }
        }
    }
    public static void registrarProducto(Scanner sc){
        System.out.println("--- Tipo de Producto ---");
        System.out.println("1. Fisico");
        System.out.println("2. Digital");

        String seleccion = sc.nextLine();
        
        switch (seleccion) {
            case "1":
                String nombre = sc.nextLine();
                int precio_base = sc.nextInt();
                int stock = sc.nextInt();
                Producto nuevoProductoFisico = new ProductoFisico(nombre, precio_base, stock);
                break;
            case "2":
                Producto nuevoProductoDigital = new ProductoDigital();
                break;
        
            default:
                break;
        }
    }
}
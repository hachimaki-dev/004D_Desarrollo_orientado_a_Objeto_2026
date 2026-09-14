import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {

    static ArrayList<ProductoFisico> coleccion_juegos_fisicos = new ArrayList<>();

    static ArrayList<ProductoDigital> coleccion_juegos_digitales = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        boolean mostrar_menu = true;

        while (mostrar_menu) {
            System.out.println("1. Registrar producto");
            System.out.println("2. Listar inventario");
            System.out.println("3. Buscar producto por nombre");
            System.out.println("4. Vender producto");
            System.out.println("5. Resumen del inventario");
            System.out.println("6. Salir");
            System.out.println("7. casos de prueba");

            System.out.println("Ingrese su opción: ");

            String opcion_menu = sc.nextLine();

            switch (opcion_menu) {
                case "1":
                    registrarProducto();
                    break;
                case "2":
                    listarInventario();
                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":
                    insertarDatosPrueba();

                    break;

                default:
                    break;
            }

        }
    }

    static public void registrarProducto() {
        boolean mostrar_menu = true;

        while (mostrar_menu) {
            System.out.println("1. Registrar producto Físico");
            System.out.println("2. Registrar producto digital");
            System.out.println("3. Volver al menu");

            System.out.println("Elija su opción: ");

            String opcion_registro_juego = sc.nextLine();

            switch (opcion_registro_juego) {
                case "1":
                    registrarProductoFisico();
                    break;
                case "2":
                    registrarProductoDigital();
                    break;
                case "3":
                    mostrar_menu = false;
                    break;

                default:
                    break;
            }

        }
    }

    static public void registrarProductoFisico(){

        System.out.println("Ingrese nombre del juego");
        String nombre = sc.nextLine();

        System.out.println("Ingrese precio base del juego");
        int precioBase = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese stock del juego");
        int stock = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese costo de envio del juego");
        int costo_envio = Integer.parseInt(sc.nextLine());

        ProductoFisico juego = new ProductoFisico(nombre, precioBase, stock, costo_envio);

        coleccion_juegos_fisicos.add(juego);
    }

    static public void registrarProductoDigital(){

        System.out.println("Ingrese nombre del juego");
        String nombre = sc.nextLine();

        System.out.println("Ingrese precio base del juego");
        int precioBase = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese stock del juego");
        int stock = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese costo de envio del juego");
        int descuento = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese la plataforma del juego");
        String plataforma = sc.nextLine();

        ProductoDigital juego = new ProductoDigital(nombre, precioBase, stock, descuento, plataforma);

        coleccion_juegos_digitales.add(juego);
    }


    static public void listarInventario(){
        System.err.println("inventario de juego fisico");
        for (ProductoFisico juegofisico : coleccion_juegos_fisicos) {
            juegofisico.mostrarInfo();
            System.out.println(juegofisico);
        }

        System.err.println("inventario de juego digitales");
        for (ProductoDigital productoDigital : coleccion_juegos_digitales) {
            productoDigital.mostrarInfo();
            System.out.println(productoDigital);
        }
    }

    static void insertarDatosPrueba(){
        coleccion_juegos_fisicos.add(new ProductoFisico("pokemon Escudo", 45000 , 10, 2500));
    }
}

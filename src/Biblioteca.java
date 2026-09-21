// El paradigma de programacion a utilizar es POO (Programacion orientada a objetos), esta hace que cada objeto tega un archivo "independiente".

import java.util.Scanner;
import java.util.ArrayList;

public class Biblioteca {

    static ArrayList<Materiales> Coleccion_materiales = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        mostrarMenu();
    }

    static void mostrarMenu(){
        System.out.println("=== BIBLIOTECA MUNICIPAL ===");

        boolean menu_activo = true;

        while (menu_activo) {
            System.out.println("1.- Registrar material");
            System.out.println("2.- Listar catalogo");
            System.out.println("3.- Buscar material por titulo");
            System.out.println("4.- Prestar material");
            System.out.println("5.- Resumen del catalogo");
            System.out.println("6.- Salir");

            System.out.println("Seleccione una opcion: ");

            String opcion_usuario = scanner.nextLine();

            switch (opcion_usuario) {
                case "1":
                    registrarMaterial();    

                    break;
                case "2":
                    listarCatalogo();

                    break;

                case "3":

                    break;

                case "4":

                    break;

                case "5":

                    break;
                
                case "6":
                    menu_activo = false;

                    break;
            
                default:
                    break;
            }
        }
    }

    static void registrarMaterial(){
        boolean mostrar_menu = true;

        while (mostrar_menu) {
            System.out.println("Seleccione el tipo de material a registrar: ");
            System.out.println("1.- Libro");
            System.out.println("2.- Revista");
            System.out.println("3.- Salir");

            String tipoMaterial = scanner.nextLine();

            switch (tipoMaterial) {
                case "1":
                    registrarLibro();
                    mostrar_menu = false;
                    break;

                case "2":
                    registrarRevista();
                    mostrar_menu = false;
                    break;

                case "3":
                    mostrar_menu = false;
                    
                default:
                    break;
            }
        }
    }

    static void registrarLibro(){
        System.out.println("Ingresa el nombre del libro: ");
        String titulo = scanner.nextLine();

        System.out.println("Ingrese el autor");
        String autor = scanner.nextLine();

        try {
            System.out.println("Ingrese la cantidad disponible: ");
            int cantidadDisponible = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese el numero de paginas: ");
            int numeroPaginas = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("Error, ingresa numeros enteros positivos");
        }

        Coleccion_materiales.add(new Materiales(titulo, autor, cantidadDisponible, numeroPaginas));
    }

    static void registrarRevista(){
        System.out.println("Ingresa el nombre de la revista: ");
        String titulo = scanner.nextLine();

        System.out.println("Ingrese el autor");
        String autor = scanner.nextLine();

        System.out.println("Ingrese el es de publicacion: ");
        String mesPublicacion = scanner.nextLine();

        try {
            System.out.println("Ingrese la cantidad disponible: ");
            int cantidadDisponible = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("Error, ingresa numeros enteros positivos");
        }

        Coleccion_materiales.add(new Materiales(titulo, autor, mesPublicacion, cantidadDisponible));
    }

    static void listarCatalogo(){
        for (Materiales materiales : Coleccion_materiales) {
            System.out.println(materiales);
        }
    }
}

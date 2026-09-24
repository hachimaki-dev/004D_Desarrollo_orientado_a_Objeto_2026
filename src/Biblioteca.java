// El paradigma de programacion a utilizar es POO (Programacion orientada a objetos)
// Una de las principales diferencias entre python y java es que, java es un lenguaje más estricto, además de ser keySensivility

import java.util.Scanner;
import java.util.ArrayList;

public class Biblioteca {

    static ArrayList <Materiales> Coleccion_materiales = new ArrayList<>();
    static ArrayList <Libro> Coleccion_libros = new ArrayList<>();
    static ArrayList <Revista> Coleccion_revistas = new ArrayList<>();

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
                    buscarMaterialPorTitulo();
                    break;

                case "4":
                    prestarMaterial();
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
        String titulo = scanner.nextLine().trim().toLowerCase();

        System.out.println("Ingrese el autor");
        String autor = scanner.nextLine().trim().toLowerCase();

        int cantidadDisponible = 0;
        int numeroPaginas = 0;

        try {
            System.out.println("Ingrese la cantidad disponible: ");
            cantidadDisponible = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese el numero de paginas: ");
            numeroPaginas = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("Error, ingresa numeros enteros positivos");
        }

        Libro nuevo_libro = new Libro(titulo, autor, cantidadDisponible, numeroPaginas);
        
        Coleccion_libros.add(nuevo_libro);
        Coleccion_materiales.add(nuevo_libro);
    }

    static void registrarRevista(){
        System.out.println("Ingresa el nombre de la revista: ");
        String titulo = scanner.nextLine();

        System.out.println("Ingrese el autor");
        String autor = scanner.nextLine();

        System.out.println("Ingrese el mes de publicacion: ");
        String mesPublicacion = scanner.nextLine();

        int cantidadDisponible = 0;

        try {
            System.out.println("Ingrese la cantidad disponible: ");
            cantidadDisponible = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("Error, ingresa numeros enteros positivos");
        }

        Revista nueva_revista = new Revista(titulo, autor, cantidadDisponible, mesPublicacion);
        
        Coleccion_revistas.add(nueva_revista);
        Coleccion_materiales.add(nueva_revista);
    }

    static void listarCatalogo(){
        if (Coleccion_materiales.isEmpty()) {
            System.out.println("No hay nada en el catalogo");
        }
        else {
            System.out.println("=== Catalogo de libros ===");
            
            for (Libro libro : Coleccion_libros) {
                System.out.println(libro.mostrarInfo());
            }

            System.out.println("=== Catalogo de revistas ===");

            for (Revista revista: Coleccion_revistas) {
                System.out.println(revista.mostrarInfo());
            }
        }
    }

    static void buscarMaterialPorTitulo(){
        if (Coleccion_materiales.isEmpty()) {
            System.out.println("No hay nada en el catalogo");
        }
        else {
            String tituloBuscado = scanner.nextLine().trim().toLowerCase();

            if (tituloBuscado.isEmpty()) {
                System.out.println("ERROR, debe ingresar el nombre a buscar");
            }
            else {
                
                }
        }
    }

    static void prestarMaterial(){
        if (Coleccion_materiales.isEmpty()) {
            System.out.println("No hay nada en el catalogo");
        }
        else {
            for (Materiales materiales : Coleccion_materiales) {
                System.out.println(materiales.mostrarInfo());
            }

            String materialVendido = scanner.nextLine().trim().toLowerCase();

        }
    }
}

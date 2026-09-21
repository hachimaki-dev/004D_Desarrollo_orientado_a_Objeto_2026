import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList <Material> coleccion_libros = new ArrayList<>();
    ArrayList <Material> coleccion_revista = new ArrayList<>();

    public static void main(String[] args) {
        
    }
    static void  mostrar_menu(){
        System.out.println("BIBLIOTECA MUNICIPAL");
        boolean mostrar_menu = true;
        while (mostrar_menu) {
            System.out.println("1. Registrar material: ");
            System.out.println("2. Listar catalogo: ");
            System.out.println("3. Buscar material por titulo: ");
            System.out.println("4. Prestar material: ");
            System.out.println("5. Resumen del catalogo: ");
            System.out.println("6. Salir: ");
            System.out.println("7. Encajar datos: ");

            String opcion_menu = sc.nextLine();

            switch (opcion_menu) {
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
                    resumenDelCatalogo();
                    break;
                                
                case "6":
                    mostrar_menu = false;
                    break;

                case "7":
                    encajarDatos();
                    break;
                default:
                    break;
            }
        }
    }

    static void registrarMaterial(){
        System.out.println("Porfavor. Marque la opción de registro: ");
        boolean mostrar_menu = true;
        while (mostrar_menu) {
            System.out.println("1. Libro: ");
            System.out.println("2. Revista: ");
            System.out.println("3. Regresar: ");

            String opcion_menu = sc.nextLine();

            switch (opcion_menu) {
                case "1":
                    registroLibro();
                    break;
                case "2":
                    registroRevista();
                    break;
                case "3":
                    mostrar_menu = false;
                    break;
            
                default:
                    break;
            }
        }

 
    }

    static void registroLibro(){
        System.out.println("Ingrese el titulo: ");

        System.out.println("Autor: ");

        try {
            numPaginas = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ingrese números, no letras");
            // TODO: handle exception
        }


    }

    static void prestarMaterial(){

    }

    static void encajarDatos(){

    }

    public static  void listarCatalogo(){
        System.out.println("Listado de los catalagos: ");

        for (Libro libro_registrado : coleccion_libros) {
            System.out.println(libro_registrado.mostrarInfo());
            System.out.println(Libro.mostrarInfo());
        }

        for (Libro revista_registrado : coleccion_revista) {
            System.out.println(revista_registrado.mostrarInfo());
            System.out.println(Revista.mostrarInfo());
            
        }
    }

    static void buscarMaterialPorTitulo(){
        System.out.println("Ingrese nombre del titulo: ");
        String nombre = sc.nextLine();
        boolean encontrado = false;

        for (libro libro_registrado : coleccion_libros) {
            if (nombre.getTitulo().equals(nombre)) {
              System.out.println("Encontrado: " + Libro.mostrarInfo());  
            }
        }

        for (Revista libro_registrado : coleccion_revista) {
            if (nombre.getTitulo().equals(nombre)) {
              System.out.println("Encontrado: " + Revista.mostrarInfo());  
            }
        }
    }

    static void resumenDelCatalogo(){

    }
}

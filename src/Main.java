import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList material = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        boolean off = true;

        while (off == true) {
            System.out.println("= BIBLIOTECA MUNICIPAL =");
            System.out.println("1. Registrar material");
            System.out.println("2. Listar catalogo");
            System.out.println("3. Buscar material por titulo");
            System.out.println("4. Prestar material");
            System.out.println("5. Resumen del catalogo");
            System.out.println("6. Salir");
            
            System.out.println("Seleccione una opcion: ");
            
            String opcion_usuario = scanner.nextLine();

            switch (opcion_usuario) {
                case "1":
                    registrarMaterial();
                case "2":
                    listarCatalogo();
                case "3":
                    buscarMaterial();
                case "4":
                    prestarMaterial();
                case "5":
                    resumenCatalogo();
                case "6":
                    off = false;
                    System.out.println("Programa Finalizado");
                    break;
                case "7":
                default:
                    break;
            }
        }
    }    

    public static void registrarMaterial(Scanner scanner, ArrayList material){
        System.out.println("- Tipo de material -");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        
        String opcion_usuario = scanner.nextLine();

        switch (opcion_usuario) {
            case "1":
                System.out.println("Ingrese el titulo: ");
                String titulo = scanner.nextLine();

                System.out.println("Ingrese el autor: ");
                String autor = scanner.nextLine();

                System.out.println("Ingrese el cantidad disponible: ");
                String cantidadDisponible = Integer.parseInt(cantidadDisponible);

                System.out.println("Días de prestamo: ");
                String diasPrestamo =  Integer.parseInt(diasPrestamo); 

                System.out.println("Ingrese la cantidad de paginas: ");
                String cantidadPaginas = Integer.parseInt(cantidadPaginas)

                material.add(titulo);
                material.add(autor);
                material.add(cantidadDisponible);
                material.add(diasPrestamo);
                material.add(cantidadPaginas);
                break;
            case "2":
                System.out.println("Ingrese el titulo: ");
                String titulo = scanner.nextLine();

                System.out.println("Ingrese el autor: ");
                String autor = scanner.nextLine();

                System.out.println("Ingrese el cantidad disponible: ");
                String cantidadDisponible = Integer.parseInt(cantidadDisponible);
                
                System.out.println("Días de prestamo: ");
                String diasPrestamo =  Integer.parseInt(diasPrestamo); 

                System.out.println("Ingrese el mes de publicación: ");
                String mesPublicacion = scanner.nextLine();

                material.add(titulo);
                material.add(autor);
                material.add(cantidadDisponible);
                material.add(diasPrestamo);
                material.add(mesPublicacion)
                break;
            default:
                break;
        }

    }

    public static void listarCatalogo(ArrayList material){
        for (int i = 0; i >= material ; i++) {
            System.out.println();
        }
    }

    public static void buscarMaterial(){
        
    }

    public static void prestarMaterial(){

    }
    
    public static void resumenCatalogo(){

    }

    public static void datosDePrueba(ArrayList material){
        material.add();
    }
}

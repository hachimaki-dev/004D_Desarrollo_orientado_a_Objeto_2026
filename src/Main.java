import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList material = new ArrayList<>
        Scanner scanner = new Scanner(System.in);
        
        boolean off = true;

        while (off = true) {
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
                    break;
                case "7":
                default:
                    break;
            }
        }
    }    

    public static void registrarMaterial(){
        System.out.println("- Tipo de material -");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        
        opcion_usuario = new scanner.nextLine;

        switch (opcion_usuario) {
            case "1":
                System.out.println("Ingrese el titulo: ");
                System.out.println("Ingrese el autor: ");
                System.out.println("Ingrese el cantidad disponible: ");
                System.out.println("Días de prestamo: ");
                System.out.println("Ingrese la cantidad de paginas: ");

            case "2":
                System.out.println("Ingrese el titulo");
                System.out.println("Ingrese el autor");
                System.out.println("Ingrese la cantidad disponible");
                System.out.println("Días de prestamo");
                System.out.println("Ingrese el mes de publicación:");

            default:
                break;
        }

    }

    public static void listarCatalogo(){
        for (int i = 0; i < array.length; i++) {
            
        }
    }

    public static void buscarMaterial(){
        
    }

    public static void prestarMaterial(){

    }
    
    public static void resumenCatalogo(){
z
    }
}

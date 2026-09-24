import java.util.ArrayList;
import java.util.Scanner;

public class Main Material {

    static Scanner sc= new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }
    
}
    public static void mostrarMenu(){
        boolean mostrar_menu = true;

    while (mostrar_menu) {
        System.out.println("1.Registrar material");
        System.out.println("2.Listar catalogo");
        System.out.println("3.Buscar material por titulo");
        System.out.println("4.Prestar material");
        System.out.println("5.resumen del catalogo");
        System.out.println("6.salir");

        System.out.println("Ingrese una opcion:");

        String opcion_menu=sc.nextLine();

        switch (opcion_menu) {
            case "1":
                registrarMaterial();
                break;
            case "2":
                ();
                break;
            case "3":
                ();
                break;
            case "4":
                ();
                break;
            case "5":
                ();
                break;
            
            default:
                break;
        }
        }

        public void registrarMaterial(){
            System.out.println("Ingresa el titulo del libro:");
            String titulo=sc.nextLine();
            System.out.println("Ingresa el Autor del libro:");
            String autor=sc.nextLine();
            System.out.println("Ingresa la cantidad disponible:");
            int cantidadDisponible=Integer.parseInt(sc.nextLine());
            System.out.println("Ingresa el numero de paginas disponible:");
            int numPaginas=Integer.parseInt(sc.nextLine());

            Material libro = new Material(titulo,autor,cantidadDisponible,numPaginas,mesPublicacion);
            Material revista = new Material(titulo,autor,cantidadDisponible,numPaginas,mesPublicacion);
        }

        public void buscarMaterial(){
            System.out.println("Ingrese el texto a buscar:");
        }

        public void pestarMaterial(){
            System.out.println("Ingrese numero de material:");
        }


        
        ArrayList<Material> mostrarInfo = new ArrayList<>();

        try{
            Material mat = mostrarInfo.get();
        }catch (NumberFormatException e){
            System.out .println("Error:debe ingresar un numero");
        }
}

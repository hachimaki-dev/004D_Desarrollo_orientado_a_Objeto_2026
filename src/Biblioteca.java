import java.util.Scanner;

public class Biblioteca {
   static  Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Mostrarmenu();
    }

    public static void Mostrarmenu(){
        boolean opcion_menu = true;

        while (opcion_menu) {
            System.out.println("=== BIBLIOTECA MUNICIPAL ===");
            System.out.println("1. registrar material");
            System.out.println("2. listar catalogo");
            System.out.println("3. material por titulo");
            System.out.println("4. prestar material");
            System.out.println("5. resumen del catalogo");
            System.out.println("6.salir ");
            System.out.println("selecciona una opcion");

            String menu = sc.nextLine();

            
            
            
        }
    }
            
        
    }
    


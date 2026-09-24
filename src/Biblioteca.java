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

            switch (menu) {
                case "1":
                    registrarmaterial();
                    
                    
                    break;
            
                default:
                    break;
            }

            

            
            
            
        }

        static public void registrarmaterial(){
            boolean opcion_submenu = true;
            while (opcion_submenu) {
                System.out.println("ingrese el tipo de material");
                System.out.println("1.libro");
                System.out.println("2.revista");
                System.out.println("3.volver al menu");
                
                String submenu = sc.nextLine();


                switch (opcion_submenu) {
                    case "1":
                        registrarLibro();
                        
                        break;
                    case "2":
                        registrarrevista();
                    case "3":
                        opcion_submenu = false;
                        System.out.println("volviendo al menu");
                
                    default:
                        System.out.println("opcion incorrecta vuelva a intentarlo");
                        break;
                }
            }

        }
    }
    static void registrarLibro(){
        
        System.out.println("ingrese el nombre del libro");
        s


    }
            
        
    }
    


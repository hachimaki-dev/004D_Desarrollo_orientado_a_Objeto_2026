import java.util.ArrayList;
import java.util.Scanner;


// En este clase en donde se ba a ejecutar la interbas con sus metodos
public class Main 
{
    // El ArrayList permite guardar sub clases mediante el polimorfismo
    static  ArrayList<Material> catalogo = new ArrayList<>();
    static   Scanner sc = new Scanner(System.in);

    // Aqui estoy declarando que mis metos deven ser static 
    public static void main(String[] args) 
    {
        mostrarMenu();
    }


    static void mostrarMenu()
    {
    
        boolean mostarMenu = true;
        while (mostarMenu) 
        {
        System.out.println("= BIBLIOTECA MUNICIPAL =");
        System.out.println("1. Registrar material");
        System.out.println("2. Listar catalogo");
        System.out.println("3. Buscar mateerial");
        System.out.println("4. Prestar material");
        System.out.println("5. Resuen del catalogo");
        System.out.println("Salir");

        System.out.println("Seleccine una opcion");

        String opcio_menu = sc.nextLine();
         
            switch (opcio_menu) 
            {
                case "1":
                    registroMaterail();
                    break;

                case "2":
                    listarPorCAtalogo();
                    break;

                case "3":
                    break;
                    
                case "4":
                    break; 
                    
                case "5":
                    break;
                    
                case "6":
                    mostarMenu = false;
                    break;    
            
                default:
                    break;
            } 
        }
       

    }

    static void registroMaterail()
    {

        boolean menu = true;
        while (menu) 
        {
        System.out.println("---Tipo de material---");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        System.out.println("bolver");

        String selecion = sc.nextLine();

        switch (selecion) 
         {
            case "1":
                registraLibro();
                break;
             case "2": 
                registraRevista();
                break;

            case "3":
                menu = false;    
        
            default:
                break;
         }
        }
       
        
        
    }

    static void registraLibro()
        {
            System.out.println("Titulo: ");
            System.out.println("Autor: ");
            System.out.println("Cantidad: ");
            System.out.println("Numero de paginas: ");
        }

    static void registraRevista()
        {
            System.out.println("Titulo: ");
            System.out.println("Autor: ");
            System.out.println("Cantidad: ");
            System.out.println("mes de publicacion: ");
        }    

    static  void listarPorCAtalogo()
    {
        System.out.println("---CATALOGO---");
        System.out.println("Selecione una opcion");
    }

}


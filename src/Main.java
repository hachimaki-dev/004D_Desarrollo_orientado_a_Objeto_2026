import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
    //public ArrayList<Material> 
    public  Scanner opcione = new Scanner(System.in);
    public static void main(String[] args) 
    {
        Boolean menu = true;
        while (menu) 
        {
            mostrarMenu();
            System.out.println("Seleccine una opcion");
            switch (opcione) 
            {
                case "1":
                    registroMateril();
                    break;

                case "2":
                    break;

                case "3":
                    break;
                    
                case "4":
                    break; 
                    
                case "5":
                    break;
                    
                case "6":
                    menu = true;
                    break;    
            
                default:
                    break;
            }
            
        }
        
    }
    static void mostrarMenu()
    {
        System.out.println("= BIBLIOTECA MUNICIPAL =");
        System.out.println("1. Registrar material");
        System.out.println("2. Listar catalogo");
        System.out.println("3. Buscar mateerial");
        System.out.println("4. Prestar material");
        System.out.println("5. Resuen del catalogo");
        System.out.println("Salir");

    }

    static void registroMateril()
    {
        System.out.println("---Tipo de material---");
        System.out.println("1. Libro");
        System.out.println("2. revista");

    }

}


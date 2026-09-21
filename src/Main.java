import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Material> Inventario = new ArrayList<>();
    static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        MostrarMenu();
    }
        
     static public void MostrarMenu(){
         boolean MostrarMenu = true;
            
        
    while (MostrarMenu) {

        System.out.println("==== BIBLIOTECA MUNICIPAL ====");
        System.out.println("1. Registrar material");
        System.out.println("2. listar catalogo");
        System.out.println("3. buscar material por revista");
        System.out.println("4. prestar material");
        System.out.println("5. resumen del catalogo");
        System.out.println("6. salir");
        System.out.println("seleccione una opcio:");
        }
        
        String OpcionMemu = consola.nextLine();

        switch (OpcionMemu) {
            case "1":
                MostrarSubMenu();
                break;

            case "2":
                ListarCatalogo();
                break;

            case "3":
                break;

            case "4":
                break;

             case "5":
                break;

             case "6":
                MostrarMenu = false;
                System.out.println("gracias por usar la biblioteca nacional, que tenga buen dia :)");
                break;
            default:
                break;
        }
    }

     static public void MostrarSubMenu(){
        boolean MostrarSubMenu = true;

        while (MostrarSubMenu) {

        System.out.println("1. registra libro");
        System.out.println("2. registrar revista");
        System.out.println("3. salir");

        System.out.println("seleccione una opcio:");
            
        }
        String OpcionSubMenu = consola.nextLine();

        switch (OpcionSubMenu) {
            case "1":
                registraLibro();
                break;

             case "2":
                registraRevista();
                break;

             case "3":
                MostrarSubMenu = false;
                System.out.println("gracias por usar el sistema de registro");
                break;
        
            default:
                break;
        }
    }

    static void registraLibro(){
        System.out.println("ingrese el nombre del titulo: ");
        String Titulo = consola.nextLine();

        System.out.println("ingrese el nombre del autor: ");
        String Autor = consola.nextLine();

        System.out.println("ingrese la cantidad disponible: ");
        int CantidadDisponible = Integer.parseInt(consola.nextLine());

        System.out.println("ingrese el numero de paguinas: ");
        int NumPaginas= Integer.parseInt(consola.nextLine());

        
    }
        

      static void registraRevista(){
        System.out.println("ingrese el nombre del titulo: ");
        String Titulo = consola.nextLine();

        System.out.println("ingrese el nombre del autor: ");
        String Autor = consola.nextLine();

        System.out.println("ingrese la cantidad disponible: ");
        int CantidadDisponible = Integer.parseInt(consola.nextLine());

         System.out.println("ingrese el mes de la publicacion: ");
        String MesPublicacion = consola.nextLine();

    }

    static void ListarCatalogo(){
        System.out.println("****** Lista De Catalogo *******");

        if(Inventario.isEmpty()){
            System.out.println("no se encuentra nada dentro del inventario");
            return;
        }
        for (int i = 0; i < Inventario.size(); i++) {
            Material L = Inventario.get(i);
            System.out.println("[" + (i + 1) + "]"  );
            
        }
    }


    
}

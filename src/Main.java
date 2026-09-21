import java.util.ArrayList;
import java.util.Scanner;

/*Paradigma:  Los paradigmas que ocupe al desarrollar este ejercicio fueron los cuatro pilares del desarrollo horientado a objetos (Polimorfismo, Herencia, Abstraccion y encapsulamiento) como por ejemplo herencia al hacer que las clases hijas hereden los atributos de la clase padre, al resguardar los datos para que no cualquiera pueda modificarlos y demas.*/ 

/*las principales diferencias que noto entre java y python es la identacion, mientras python pide ser extremadamente preciso java le permite al desarrollador una comodidad de expresion a la hora de escribir codigo que python no permite */
/*la otra diferencia principal que noto es que java es mucho mas verboso, mientras python tenia una estructura sencilla e intuitiva java requiere mas precision y dominio para escribir codigo por lo que java se me dificulta un poco mas */
public class Main {

    static Scanner sc = new Scanner(System.in);
    ArrayList<Material>coleccion_Material = new ArrayList<>();

    public static void main(final String[] args) {

       int OpcionDelMenu = mostrarMenu(sc);

        boolean seguir = true;

    while (seguir == true) {

        switch (OpcionDelMenu) {
            
            case 1:

                RegistrarMaterial(sc);
                
                break;
            case 2:
                
                ListarCatalogo();
                break;
            case 3:

                BuscarPorTitulo(sc);
                
                break;
            case 4:

                PrestarMaterial(sc);
                
                break;
            case 5:

                ResumenDelCatalogo();
                
                break;
            case 6:

                System.out.println("Saliendo del sistema...");
                seguir = false;
                break;
        
            default:
                break;
        }
        
    }
    
}

static int mostrarMenu(Scanner sc){
            System.out.println("===== BIBLIOTECA MUNICIPAL =====");
            System.out.println("1. Registrar Material");
            System.out.println("2. Listar catalogo");
            System.out.println("3. Buscar material por titulo");
            System.out.println("4. Prestar material");
            System.out.println("5. Resumen del catalogo");
            System.out.println("6. Salir");

            int OpcionDelMenu = sc.nextInt();

            return OpcionDelMenu;


        }
    

static void RegistrarMaterial (Scanner sc){

    System.out.println("Seleccione el tipo de material   1. Libro | 2.Revista");

    int TipoDeMaterial = sc.nextInt();

    switch (TipoDeMaterial) {
        case 1:

             System.out.println("Ingrese el numero de paginas de su libro");

            int NumeroDePaginas = sc.nextInt();

            System.out.println("Ingrese la cantidad de ejemplares disponible");

            int CantidadDeEjemplares = sc.nextInt();
            
            
            break;

        case 2:

            System.out.println("Ingrese el mes de publicacion de su revista");

            String MesDePublicacion = sc.nextLine();

            System.out.println("Ingrese la cantidad de ejemplares disponible");

            int CantidadDeEjemplare = sc.nextInt();

            
              
            break;
    
        default:
            break;
    }
}

static void ListarCatalogo(){

   System.out.println("Listando catalogo....");
}

static void BuscarPorTitulo(Scanner sc){

    System.out.println("Ingrese el titulo que busca:");

    String TituloPorBuscar = sc.nextLine();

    
}

static void ResumenDelCatalogo(){

    System.out.println("Resumen del catalogo: ");

}

static void PrestarMaterial(Scanner sc){

    System.out.println("Seleccione el material que necesita: ");

    String MaterialPorPrestar = sc.nextLine();

    

}

} 
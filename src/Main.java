import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
   
    public static void main(String[] args) {

//creo las listas donde se almacenaran los matiriales libros y revistaas
        static ArrayList<Material>general_matirial = new ArrayList<>();
        static ArrayList<Libro> Libros_inventario = new ArrayList<>();
        static ArrayList<Revista> Revistas_inventario = new ArrayList<>();



        int opcion = 0;
    static void mostrar_menu(){
        while(opcion = 0){
//creo un sccaner dentro de un while apra que el usuario puedainteractuar con el mismo
            Scanner scn = new Scanner(System.in);

//creo el menu que va a visualisar el usuario
            System.out.println("Biblioteca Municipal");
            System.out.println("1. registrar material");
            System.out.println("2.listar catalogo");
            System.out.println("3.buscar material por titulo");
            System.out.println("4.prestar material");
            System.out.println("5.resumen del catalogo");
            System.out.println("6.salir");
            opcion = scn.nextInt();
//switch sirve para que todas las opciones del menu puedan tener una accion
            switch (opcion) {
                case 1:
                    Registrar_Material();
                    
                
                    break;
                case 2:
                    listar_catalogo();
                    
                
                    break;
                case 3:
                    buscar_material_por_titulo();
                
                    break;
                case 4:
                    prestar_material();

                    break;
                
                case 5:
                    resumen_del_catalogo();
                
                    break;
                case 6:
                    mostrar_menu() = false
                default:
                    break;
            }
        }
    }

//empiezo a crear las funciones para que el usuario pueda interactuar con las opciones del menu    
    static void Registrar_Material(){
        System.out.println("registrar libro");

        System.out.println("titulo del libro");
        String titulo = scn.nexline();

        System.out.println("autor del libro");
        String autor = scn.nexline();

        System.out.println("numero total de paginas");
        int numPaginas = scn.nexline();
        System.out.println("cantidad disponible ");

    }

    static void listar_catalogo(){
        if(invenatrio.isEmpty){
            System.out.println("no hay ningun libro o revista registrado todavia!!!!!");
        }else{
            System.out.println("se a podido registrar el libro o revista con excito");
        }

            for(Libro libro : invenatrio){
                System.out.println(libro.mostrarInfo);
            }

    }
    
    static void buscar_material_por_titulo(){
        System.out.println("ingrese el nombre del libro o revista que quiera buscar");
    }

    static void prestar_material(){
        if(invenatrio.isEmpty){
            System.out.println("no hay nada registrado");
        }else{
            System.out.println("libros y revistas disponibles");
            int contador = 0;
            for(Material material : invenatrio)(
                System.out.println((contador + 1)+ ,material.mostrarInfo());
            )
        }
        while(true) {
            System.out.println("ingrese el indice: ");
            int indice = Integer.parseInt(scn.nexline());

            if(indice <= 0) {
                System.out.println("ingrese un dato valido");
            }else if (inventario.libros.get(indice).getCantidad_disponible() <=0){
                System.out.println("ingrese le material con una cantidad mayor a =");
            }
        }

    }

    static void resumen_del_catalogo(){
        System.out.println("");
    }

    }

}

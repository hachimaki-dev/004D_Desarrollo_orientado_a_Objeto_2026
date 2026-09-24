import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Libro> Almacenamiento_libros = new ArrayList<>();
    static ArrayList<Revista> Almacenamiento_revistas = new ArrayList<>();

    public static void main(String[] args) {
        mostrar_menu();
    }


    static public void mostrar_menu(){
        boolean bandera = true;
        while (bandera){
            try {
                System.out.println("BIBLIOTECA MUNICIPAL");
                System.out.println("1.- Registrar material");
                System.out.println("2.- Listar catalogo");
                System.out.println("3.- Buscar material por titulo");
                System.out.println("4.- Prestar material");
                System.out.println("5.- Resumen del catalogo");
                System.out.println("6.- Salir");
                System.out.println("Seleccione una opcion");

                String opcion_elegida = sc.nextLine();
                switch (opcion_elegida) {
                    case "1":
                        registrarMaterial();
                        break;
                    case "2":
                        listarCatalogo();
                    case "3":
                        buscarMaterialPorTitulo();
                    case "4":
                        prestarMaterial();
                    case "5":
                        resumenDelCatalogo();
                    case "6":
                        bandera = false;
                        break;
                    case "7":
                        cargarDatos();
                        break;
                    default:
                        System.out.println("Esta opcion no existe");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Esta opcion no es valida");
            }
            
        }
        
    }

    static void registrarMaterial(){
        System.err.println("Que material desea registrar");
        System.out.println("1.- Libro");
        System.out.println("2.- Revista");
        String opcion_seleccionada = sc.nextLine();

        switch (opcion_seleccionada) {
            case "1":
                registrarLibro();
                break;
            case "2":
                registrarRevista();
            default:
                System.out.println("No existe la opcion");
                break;
        }
    }

    static void registrarLibro(){
        System.out.println("Titulo: ");
        String Titulo = sc.nextLine();

       

        System.out.println("Autor");
        String Autor = sc.nextLine();

        System.out.println("Cantidad disponible:");
        String disponibles = sc.nextLine();

        System.out.println("Numero de paginas");
        String Paginas = sc.nextLine();

        

        

        


    

        

        
    }

    static void registrarRevista(){
        
        System.out.println("Titulo: ");
        String Titulo = sc.nextLine();

        System.out.println("Autor");
        String Autor = sc.nextLine();

        System.out.println("Cantidad disponible:");
        String cantidadDisponible = sc.nextLine();

        System.out.println("Numero de paginas");
        String mesDePublicacion = sc.nextLine();
        
        

        
    }



    static void listarCatalogo(){
        if(Almacenamiento_libros.size()>0){
            for(Libro Libro_en_el_catalogo : Almacenamiento_libros){
                System.out.println(Libro_en_el_catalogo.mostrarInfo());
            }
        }else{
            System.out.println("No se encuentra ningun Libro registrado");
        }
        
        if (Almacenamiento_revistas.size()>0){
            for(Revista Revista_en_el_catalogo : Almacenamiento_revistas){
                System.out.println(Revista_en_el_catalogo.mostrarInfo());
            }
        }else{
            System.out.println("No se encuentra ninguna revista registrado");
        }
        
            
        

        
    }

    static void buscarMaterialPorTitulo(){
    }

    static void prestarMaterial(){}

    static void resumenDelCatalogo(){}


    static void   cargarDatos(){
        Libro Libro1 = new Libro("El principito", "Pedro", 8, 30);
        Almacenamiento_libros.add(Libro1);
        Libro Libro2 = new Libro("Harry potter", "jk", 2, 120);
        Almacenamiento_libros.add(Libro2);
    }



}

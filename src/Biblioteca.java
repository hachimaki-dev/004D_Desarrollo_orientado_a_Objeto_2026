/* El paradigma utilizado es el de Programacion orientado a objetos en java.
Algunas caracteristicas es que se utiliza a traves de clases(molde, objetos, etc), metodos(acciones) y atributos(caracteristicas).
Se diferencia del paradigma anterior en que este es mucho mas organizado gracias a la division de clases
en este lenguaje de java hay que ser mas especificos sobre cada objeto, incluyendo su tipo y nombre.
Aca es mas facil y efectivo encapsular y proteger datos
el lenguaje es menos intuitivo en comparacion con python



*/
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Libro> coleccion_libros = new ArrayList<>();
    static ArrayList<Revista> coleccion_revistas = new ArrayList<>();
    public static void main(String[] args) {
        menuPrincipal();
    }

    static void menuPrincipal() {
        boolean mostrarMenu = true;
        while(mostrarMenu){
            System.out.println("=== BIBLIOTECA MUNICIPAL ===");
            System.out.println("1. Registrar material");
            System.out.println("2. Listar catalogo");
            System.out.println("3. Buscar material por titulo");
            System.out.println("4. Prestar material");
            System.out.println("5. Resumen del catalogo");
            System.out.println("6. Salir");
            System.out.println("Seleccione una opcion: _");
            
            String opcionMenu = sc.nextLine();

            switch (opcionMenu) {
                case "1":
                    registrarMaterial();
                    break;
                case "2":
                    listarCatalogo();
                    break;
                case "3":
                    buscarMaterial();
                    break;
                case "4":
                    //prestarMaterial();
                    break;
                case "5":
                    //resumenCatalogo();
                    break;
                case "6":
                    System.out.println("Hasta la proxima");
                    mostrarMenu = false;
                    break;
                
                default:
                    System.out.println("Esa opcion no es valida");
                    break;
            }
    }
}

static void registrarMaterial(){
    System.out.println("=== ¿Que material desea registrar? ===");
    System.out.println("1. Libro");
    System.out.println("2. Revista");
    String opcionRegistro = sc.nextLine();

    switch (opcionRegistro) {
        case "1":
            registrarLibro();
            break;
        case "2":
            registrarRevista();

            break;
        default:
            System.out.println("Opcion no valida");
            break;
    }
    
}
static void registrarLibro(){
        System.out.println("Ingrese el titulo");
            String titulo = sc.nextLine();
            System.out.println("Ingrese el autor");
            String autor = sc.nextLine();
            System.out.println("Ingrese la cantidad disponible");
            int cantidadDisponible = Integer.parseInt(sc.nextLine());
            System.out.println("Ingrese el numero de paginas");
            int numPaginas = Integer.parseInt(sc.nextLine());

            coleccion_libros.add(new Libro(numPaginas, titulo, autor, cantidadDisponible));
    }
static void registrarRevista(){
            System.out.println("Ingrese el titulo");
            String titulo = sc.nextLine();
            System.out.println("Ingrese el autor");
            String autor = sc.nextLine();
            System.out.println("Ingrese la cantidad disponible");
            int cantidadDisponible = Integer.parseInt(sc.nextLine());
            System.out.println("Ingrese el mes de publicacion");
            String mesPublicacion = sc.nextLine();

            coleccion_revistas.add(new Revista(mesPublicacion, titulo, autor, cantidadDisponible));
}

static void listarCatalogo() {
    for (Libro libro : coleccion_libros) {
        System.out.println(libro.mostrarInfo());
    }
    for (Revista revista : coleccion_revistas) {
        System.out.println(revista.mostrarInfo());
    }
}

static void buscarMaterial() {
    System.out.println("Que material desea buscar por nombre?");
    String materialBuscado = sc.nextLine();
    for (Libro libro : coleccion_libros) {
        if (libro.getTitulo().contains(materialBuscado)){
        System.out.println(libro.mostrarInfo());}
        else{
            System.out.println("No hay coincidencias");
        }
    }
    for (Revista revista : coleccion_revistas) {
        if (revista.getTitulo().contains(materialBuscado)){
        System.out.println(revista.mostrarInfo());}
        else{
            System.out.println("No hay coincidencias");
        }
    }
    }
}



 /*   static void prestarMaterial() {
    System.out.println("Que material desea prestar? (busque por nombre)");
    String materialBuscado = sc.nextLine();
    for (Libro libro : coleccion_libros) {
        if (libro.getTitulo().contains(materialBuscado)){
        System.out.println(libro.mostrarInfo());
        System.out.println("Cuantos desea prestar?");

    }*/


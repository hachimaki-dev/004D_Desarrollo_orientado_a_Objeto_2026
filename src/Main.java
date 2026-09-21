//usamos el paradigma de programacion orientada a objetos
//1 diferencia seria como se interpreta que en java no puedes compilar o darle play a tu programa sin que este este 100% bien si no dara error, y en python es diferente
//el tipado es distino porque en python los comandos son diferentes a como se usa en java.


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public static ArrayList<Material> libro = new ArrayList<>();

    public static void main(String[] args) {
        boolean menu = true;
        while (menu) {
            System.out.println("= BIBLIOTECA MUNICIPAL =");
            System.out.println("1. Registrar material");
            System.out.println("2. Listar catalogo");
            System.out.println("3. Buscar material por titulo");
            System.out.println("4. Prestar material");
            System.out.println("5. Resumen del catalogo");
            System.out.println("6. Salir");
            System.out.println("Seleccione una opcion: ");

            String opcion_usuario_menu = sc.nextLine();

            switch (opcion_usuario_menu) {
                case "1":
                    registrarMaterial();
                    break;
                case "2":
                    listarCatalogo();
                    break;
                case "3":
                    buscarMaterialPorTitulo();
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    menu = false;
                    break;
                default:
                    System.out.println("Opcion no valida, ingrese una opcion del menu");
                    break;
            }
        }
    }

    public static void registrarMaterial() {
        System.out.println("--- Tipo de material ---");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        System.out.println("Seleccione: ");
        ;

        String opcion_usuario_menu = sc.nextLine();

        switch (opcion_usuario_menu) {
            case "1":
                registrarLibro();
                break;
            case "2":
                registrarRevista();
                break;
            default:
                System.out.println("Opcion no valida, ingrese una opcion del menu");
                break;
        }
    }

    public static void registrarLibro() {
        System.out.println("Ingrese el titulo del libro: ");
        String titulo = sc.nextLine();
        System.out.println("Ingrese el autor del libro: ");
        String autor = sc.nextLine();
        System.out.println("Ingrese la cantidad disponible del libro: ");
        int cantidadDisponible = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese el numero de paginas del libro: ");
        int numpPaginas = Integer.parseInt(sc.nextLine());

        libro.add(new Libro(titulo, autor, cantidadDisponible, numpPaginas));
    }

    public static void registrarRevista() {
        System.out.println("Ingrese el titulo de la Revista: ");
        String titulo = sc.nextLine();
        System.out.println("Ingrese el autor de la Revista: ");
        String autor = sc.nextLine();
        System.out.println("Ingrese la cantidad disponible de la Revista: ");
        int cantidadDisponible = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese el Mes de publicacion: ");
        String mesPublicacion = sc.nextLine();

        libro.add(new Revista(titulo, autor, cantidadDisponible, mesPublicacion));
    }

    public static void listarCatalogo() {
        System.out.println("--- CATALOGO ---");
        for (Material p : libro) {
            System.out.println(p.mostrarInfo());

        }
    }

    public static void buscarMaterialPorTitulo(){
        System.out.println("--- BUSCAR MATERIAL ---");
        System.out.println("Ingrese el material a buscar");
        String texto = sc.nextLine();
        if (libro.contains(texto)) {
            System.out.println("Libro encontrado");
        } else {
            System.out.println("no encontrado");
        }
    }
}
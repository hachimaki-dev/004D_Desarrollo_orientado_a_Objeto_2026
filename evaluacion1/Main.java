import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Material> materiales = new ArrayList<>();
    int contadorRevista = 0;
    int contadorLibro = 0;
    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        boolean menu = true;
        while (menu) {
            System.out.println("=== BIBLIOTECA MUNICIPAL ===");
            System.out.println("1. Registrar material");
            System.out.println("2. Listar catalogo");
            System.out.println("3. Buscar material por titulo");
            System.out.println("4. Prestar material");
            System.out.println("5. Resumen catalogo");
            System.out.println("6. Salir");
            try {
                System.out.print("Seleccione una de estras opciones: ");
                int opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        registrarMaterial();
                        break;
                    case 2:
                        listarCatalogo();
                        break;
                    case 3:
                        buscarMaterialNombre();
                        break;
                    case 4:
                        prestarMaterial();
                        break;
                    case 5:
                        resumenCatalogo();
                        break;
                    case 6:
                        System.out.print("Programa finalizado.");
                        menu = false;
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (Exception e) {
                System.out.println("Error. Debe seleccionar un número válido.");
            }
        }
    }

    public static void registrarMaterial() {
        System.out.println("--- Tipo de material ---");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        try {
            System.out.print("Seleccione: ");
            int tipoMaterial = Integer.parseInt(sc.nextLine());
            switch (tipoMaterial) {
                case 1:
                    crearLibro();
                    break;
                case 2:
                    crearRevista();
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } catch (Exception e) {
            System.out.println("Error. Debe seleccionar un número válido.");
        }
    }

    public static void crearLibro() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Cantidad disponible: ");
        int cantidadDisponible = Integer.parseInt(sc.nextLine());
        System.out.print("Número de páginas: ");
        int numPaginas = Integer.parseInt(sc.nextLine());
        Libro libro = new Libro(titulo, autor, cantidadDisponible, numPaginas);
        System.out.println(libro instanceof Material);
        materiales.add(libro);
        System.out.println("[OK] Libro registrado");
    }

    public static void crearRevista() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Cantidad disponible: ");
        int cantidadDisponible = Integer.parseInt(sc.nextLine());
        System.out.print("Mes de publicación: ");
        String mesPublicacion = sc.nextLine();
        Revista revista = new Revista(titulo, autor, cantidadDisponible, mesPublicacion);
        System.out.println(revista instanceof Material);
        materiales.add(revista);
        System.out.println("[OK] Revista registrada");
    }

    public static void listarCatalogo() {
        if (materiales.isEmpty()) {
            System.out.println("No hay materiales registrados");
        } else {
            for (Material material : materiales) {
                System.out.println(material.mostrarInfo());
            }
        }
    }

    public static void buscarMaterialNombre() {
        System.out.print("Ingrese el título que deseas buscar: ");
        String tituloBuscar = sc.nextLine();
        for (Material material : materiales) {
            if (material.getTitulo().contains(tituloBuscar)) {
                System.out.println("Resultados: ");
                System.out.println(material.mostrarInfo());
            }
        }
    }

    public static void prestarMaterial() {
        System.out.print("Indique el índice del material: ");
        int indicePrestar = Integer.parseInt(sc.nextLine());
        System.out.println(indicePrestar);
    }

    public static void resumenCatalogo() {
        System.out.println("Libros: ");
        System.out.println("Revistas: ");
    }
}

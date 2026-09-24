
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Material> catalogo = new ArrayList<>();

        boolean mostrar_menu = true;

        while (mostrar_menu) {
            System.out.println("=== BIBLIOTECA MUNIPAL ===");
            System.out.println("1. Registrar material");
            System.out.println("2. Lista catalogo");
            System.out.println("3. Buscar material por titulo");
            System.out.println("4. Presentar material");
            System.out.println("5. Resumen del catalogo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            String opcion_menu = sc.nextLine();

            switch (opcion_menu) {
                case "1":
                    registarMaterial(sc, catalogo);
                    break;
                case "2":
                    listaCatalogo(sc, catalogo);
                    break;
                case "3":
                    buscarMaterialPorTitulo(sc, catalogo);
                    break;
                case "4":
                    presentarMaterial(sc, catalogo);
                    break;
                case "5":
                    resumenCatalogo(sc, catalogo);
                    break;
                case "6":
                    System.out.println("Programa finalizado.");
                    mostrar_menu = false;
                    break;
                default:
                    System.out.println("La opcion ingresada no es valida.");
            }

        }

    }

    static void registarMaterial(Scanner sc, ArrayList<Material> catalogo) {
        boolean mostrar_submenu = true;
        while (mostrar_submenu) {
            System.out.println("=== REGISTAR MATERIAL ===");
            System.out.println("1. Libros");
            System.out.println("2. Revistas");
            System.out.println("3. Volver");

            String opcion_submenu = sc.nextLine();

            switch (opcion_submenu) {
                case "1":
                    registrarLibro(sc, catalogo);
                    break;
                case "2":
                    registrarRevista(sc, catalogo);
                    break;
                case "3":
                    mostrar_submenu = false;
                    break;
                default:
                    System.out.println("Opción ingresada no valida.");
            }

        }

    }

    static void registrarLibro(Scanner sc, ArrayList<Material> catalogo) {
        boolean mostrar_submenu = true;
        while (mostrar_submenu) {
            System.out.print("Titulo: ");

            String titulo = sc.nextLine().strip().toLowerCase();

            System.out.print("Autor: ");

            String autor = sc.nextLine().strip().toLowerCase();

            int cantidadDisponible = 0;

            while (true) {
                try {
                    System.out.print("Cantidad Disponible: ");
                    cantidadDisponible = Integer.parseInt(sc.nextLine().strip());

                    if (cantidadDisponible < 1) {
                        System.out.println("Error: El número debe ser un entero positivo");
                    } else {
                        break;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresa un número entero positivo ");
                }
            }

            int numPaginas = 0;

            while (true) {
                try {
                    System.out.print("Numero paginas: ");
                    numPaginas = Integer.parseInt(sc.nextLine().strip());

                    if (numPaginas < 1) {
                        System.out.println("Error: El número debe ser un entero positivo");
                    } else {
                        break;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresa un número entero positivo ");
                }
            }

            Libro nuevoLibro = new Libro(numPaginas, autor, cantidadDisponible, titulo);

            catalogo.add(nuevoLibro);

            System.out.println("Libro ingresada exitosamente.");
            mostrar_submenu = false;
        }
    }

    static void registrarRevista(Scanner sc, ArrayList<Material> catalogo) {
        boolean mostrar_submenu = true;
        while (mostrar_submenu) {
            System.out.print("Titulo: ");

            String titulo = sc.nextLine().strip().toLowerCase();

            System.out.print("Autor: ");

            String autor = sc.nextLine().strip().toLowerCase();

            int cantidadDisponible = 0;

            while (true) {
                try {
                    System.out.print("Cantidad Disponible: ");
                    cantidadDisponible = Integer.parseInt(sc.nextLine().strip());

                    if (cantidadDisponible < 1) {
                        System.out.println("Error: El número debe ser un entero positivo");
                    } else {
                        break;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresa un número entero positivo ");
                }
            }

            String mesPublicacion = sc.nextLine();

            Revista nuevaRevista = new Revista(mesPublicacion, autor, cantidadDisponible, titulo);

            catalogo.add(nuevaRevista);
            System.out.println("Revista ingresada exitosamente.");
            mostrar_submenu = false;
        }
    }

    static void listaCatalogo(Scanner sc, ArrayList<Material> catalogo) {
        if (catalogo.isEmpty()) {
            System.out.println("El catalogo esta vacio");
            return;
        }

        System.out.println("=== CATALOGO ===");
        for (Material material : catalogo) {
            material.mostrarInfo();
            System.out.println("-----------------");
        }

    }

    static void buscarMaterialPorTitulo(Scanner sc, ArrayList<Material> catalogo) {
        if (catalogo.isEmpty()) {
            System.out.println("El catalogo esta vacio");
            return;
        }

        System.out.println("Ingrese el nombre del titulo a buscar: ");
        String buscarTitulo = sc.nextLine();

        if (buscarTitulo.isEmpty()) {
            System.out.println("El campo a buscar no puede estar vacio.");
            return;
        }

        int coincidencias = 0;

        System.out.println("=== BUSCAR POR TITULO ===);");
        for (Material material : catalogo) {
            if (material.getTitulo().strip().toLowerCase().contains(buscarTitulo)) {
                material.mostrarInfo();
                coincidencias++;
            }

        }

        if (coincidencias == 0) {
            System.out.println("No se han encontrado coincidencias con el termino: " + buscarTitulo);
        } else {
            System.out.println("Se ha encontrado " + coincidencias + " Titulo(s) coincidentes");
        }

    }

    static void presentarMaterial(Scanner sc, ArrayList<Material> catalogo) {
        if (catalogo.isEmpty()) {
            System.out.println("El catalogo esta vacio");
            return;
        }
        
        System.out.println("=== CATALOGO ===");
        for (Material material : catalogo) {
            material.mostrarInfo();
            System.out.println("-----------------");
        }
    }

    static void resumenCatalogo(Scanner sc, ArrayList<Material> catalogo) {
        if (catalogo.isEmpty()) {
            System.out.println("No hay catalogo a resumir");
        }

    }

}

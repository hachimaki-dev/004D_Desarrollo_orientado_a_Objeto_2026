/* 
Paradigma:
Diferencias:
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <Material> coleccionBiblioteca = new ArrayList<>();
        boolean menuPrincipal = true;

        while (menuPrincipal) {
            try {
                System.out.println("=== BIBLIOTECA MUNICIPAL ===");
                System.out.println("1. Registrar material");
                System.out.println("2. Listar catálogo");
                System.out.println("3. Buscar material por título");
                System.out.println("4. Prestar material");
                System.out.println("5. Resumen del catálogo");
                System.out.println("6. Salir");

                System.out.print("Seleccione una opción: ");
                String opcionUsuario = sc.nextLine();

                switch (opcionUsuario) {
                    case "1":
                        registrarMaterial(sc, coleccionBiblioteca);
                        break;
                    case "2":
                        listarCatalogo(sc, coleccionBiblioteca);
                        break;
                    case "3":
                        buscarMaterialPorTitulo(sc, coleccionBiblioteca);
                        break;
                    case "4":
                        prestarMaterial(sc, coleccionBiblioteca);
                        break;
                    case "5":
                        resumenCatalogo(coleccionBiblioteca);
                        break;
                    case "6":
                        System.out.println("Programa Finalizado");
                        menuPrincipal = false;
                        break;
                    default:
                        System.out.println("Opción Inválida. Intente nuevamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error de formato. Ingrese un entero.");
            }
            
        }
    }

    /* Métodos Menú Principal */
    
    static void registrarMaterial(Scanner sc, ArrayList <Material> coleccionBiblioteca) {
        boolean menuRegistro = true;

        while(menuRegistro){
            try {
                System.out.println("\n--- Tipo de material ---");
                System.out.println("1. Registrar Libro");
                System.out.println("2. Registrar Revista");
                System.out.println("3. Volver al menú principal");
                
                System.out.print("Seleccione una opción: ");
                String opcionUsuario = sc.nextLine();

                switch (opcionUsuario) {
                    case "1":
                        registrarLibro(sc, coleccionBiblioteca);
                        break;
                    case "2":
                        registrarRevista(sc, coleccionBiblioteca);
                        break;
                    case "3":
                        menuRegistro = false;
                        break;
                    default:
                        System.out.println("Opción Inválida. Intente nuevamente.");
                        break;
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Formato Inválido. Ingrese un entero.");
            }
        }
    }

    static void registrarLibro(Scanner sc, ArrayList <Material> coleccionBiblioteca) {
        String titulo = pedirString(sc, "\nIngrese título del libro: ");
        String autor = pedirString(sc, "Ingrese autor del libro: ");
        int cantidadDisponible = pedirEnteroPositivo(sc, "Ingrese cantidad disponible del libro: ");
        int numPaginas = pedirEnteroPositivo(sc, "Ingrese número de páginas del libro: ");

        Libro libro = new Libro(titulo, autor, cantidadDisponible, numPaginas);
        coleccionBiblioteca.add(libro);
        System.out.println("[OK] Libro Registrado.");
    }

    static void registrarRevista(Scanner sc, ArrayList <Material> coleccionBiblioteca) {
        String titulo = pedirString(sc, "\nIngrese título de la revista: ");
        String autor = pedirString(sc, "Ingrese autor de la revista: ");
        int cantidadDisponible = pedirEnteroPositivo(sc, "Ingrese cantidad disponible de la revista: ");
        String mesPublicacion = pedirString(sc, "Ingrese mes de publicación de la revista: ");

        Revista revista = new Revista(titulo, autor, cantidadDisponible, mesPublicacion);
        coleccionBiblioteca.add(revista);
        System.out.println("[OK] Revista Registrada.");
    }

    static void listarCatalogo(Scanner sc, ArrayList <Material> coleccionBiblioteca) {
        if (coleccionBiblioteca.isEmpty()) {
            System.out.println("\n--- NO HAY MATERIAL REGISTRADO ---");
            return;
        }

        System.out.println("\n----- CATÁLOGO DE LIBROS -----");
        for (int i = 0; i < coleccionBiblioteca.size(); i++) {
            Material material = coleccionBiblioteca.get(i);
            System.out.println("[" + i + "] " + material.mostrarInfo());
            System.out.print("\n");
        }
    }

    static void buscarMaterialPorTitulo(Scanner sc, ArrayList <Material> coleccionBiblioteca) {
        if (coleccionBiblioteca.isEmpty()) {
            System.out.println("\n--- NO HAY MATERIAL REGISTRADO ---");
            return;
        }
        
        String materialBuscado = pedirString(sc, "Ingrese título del material que busca: ");
        for (int i = 0; i < coleccionBiblioteca.size(); i++) {
            Material material = coleccionBiblioteca.get(i);
            if (material.getTitulo().contains(materialBuscado)) {
                System.out.println("[" + i + "] " + material.mostrarInfo());
            }
        }
    }

    static void prestarMaterial(Scanner sc, ArrayList <Material> coleccionBiblioteca) {
        if (coleccionBiblioteca.isEmpty()) {
            System.out.println("\n--- NO HAY MATERIAL REGISTRADO ---");
            return;
        }

        listarCatalogo(sc, coleccionBiblioteca);

        System.out.println("Ingrese el índice del material a prestar: ");
        int indiceMaterial = Integer.parseInt(sc.nextLine());
        if (indiceMaterial > coleccionBiblioteca.size()) {
            System.out.println("Índice fuera de rango. El valor debe estar entre 0 y " + coleccionBiblioteca.size());
        } else {
            Material materialUsuario = coleccionBiblioteca.get(indiceMaterial);
            if (materialUsuario.getCantidadDisponible() > 0) {
                materialUsuario.setCantidadDisponible(materialUsuario.getCantidadDisponible() - 1);
                System.out.println("\n---- RESUMEN DEL PRÉSTAMO ----");
                System.out.println("Título: " + materialUsuario.getTitulo());
                System.out.println("Días de préstamo: " + materialUsuario.calcularDiasPrestamo());
                System.out.println("Ejemplares restantes: " + materialUsuario.getCantidadDisponible());
            } else {
                System.out.println("NO HAY STOCK DISPONIBLE DEL MATERIAL SOLICITADO");
            }
        }
    }

    static void resumenCatalogo(ArrayList <Material> coleccionBiblioteca) {
        int contadorLibro = 0;
        int contadorRevista = 0;
        int totalMateriales = 2;

        for (Material material : coleccionBiblioteca) {
            if (material instanceof Libro) {
                contadorLibro++;
            } else {
                contadorRevista++;
            }
        }

        System.out.println("--- RESUMEN DEL CATÁLOGO ---");
        System.out.println("Total de materiales: " + totalMateriales);
        System.out.println("Libros: " + contadorLibro);
        System.out.println("Revista: " + contadorRevista);
        System.out.println("Total de ejemplares disponibles: " + (contadorLibro + contadorRevista));

    }

    /*Validar datos */

    private static int pedirEnteroPositivo(Scanner sc, String mensaje) {
        int numeroEntero;
        while (true){
            try {
                System.out.print(mensaje);
                numeroEntero = Integer.parseInt(sc.nextLine());
                if (numeroEntero > 0) {
                    return numeroEntero;
                } else {
                    System.out.println("El valor debe ser mayor a cero");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un entero positivo. Intente nuevamente");
            }
        }
    }

    private static String pedirString(Scanner sc, String mensaje) {
        String entradaUsuario;
        while (true) {
            System.out.print(mensaje);
            entradaUsuario = sc.nextLine().trim();
            return entradaUsuario;
        }
    }


}

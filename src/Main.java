/* 
Paradigma:

Para este programa se utiliza el paradigma de la Programación Orientada a Objetos (POO), en el que se declaran clases 
para representar entidades de la vida real, junto a sus caracteristicas (atributos) y comportamientos (métodos).
Los cuatro pilares de la POO son: 
1. Abstracción (ocultar detalles y sólo mostrar lo necesario).
2. Encapsulamiento (protección de datos).
3. Herencia (clases hijas pueden heredar atributos y métodos del padre).
4. Polimorfismo (clases heredadas pueden agregar comportamiento propio a un método heredado).

Diferencias con Python:
1. En Python no es necesario declarar el tipo de dato al definir una función o declarar una variable, en cambio, en Java sí
es necesario incluirlo.
2. En Python se interpreta el código, es decir, se va ejecutando línea a línea. En Java se compila el código, es decir, la 
máquina revisa el paquete en su totalidad antes de permitir su ejecución
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList <Material> coleccionBiblioteca = new ArrayList<>();
        mostrarMenu(coleccionBiblioteca);
    }

    static void mostrarMenu(ArrayList <Material> coleccionBiblioteca){
        boolean menuPrincipal = true;

        while (menuPrincipal) {
            System.out.println("\n===== BIBLIOTECA MUNICIPAL =====");
            System.out.println("1. Registrar material");
            System.out.println("2. Listar catálogo");
            System.out.println("3. Buscar material por título");
            System.out.println("4. Prestar material");
            System.out.println("5. Resumen del catálogo");
            System.out.println("6. Salir");

            System.out.print("\nSeleccione una opción: ");
            String opcionUsuario = sc.nextLine();

            switch (opcionUsuario) {
                case "1":
                    registrarMaterial(coleccionBiblioteca);
                    break;
                case "2":
                    listarCatalogo(coleccionBiblioteca);
                    break;
                case "3":
                    buscarMaterialPorTitulo(coleccionBiblioteca);
                    break;
                case "4":
                    prestarMaterial(coleccionBiblioteca);
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
        }
    }

    /* Métodos Menú Principal */
    
    static void registrarMaterial(ArrayList <Material> coleccionBiblioteca) {
        boolean menuRegistro = true;

        while(menuRegistro){
            System.out.println("\n---- Tipo de Material ----");
            System.out.println("1. Registrar Libro");
            System.out.println("2. Registrar Revista");
            System.out.println("3. Volver al menú principal");
            
            System.out.print("\nSeleccione una opción: ");
            String opcionUsuario = sc.nextLine();

            switch (opcionUsuario) {
                case "1":
                    registrarLibro(coleccionBiblioteca);
                    break;
                case "2":
                    registrarRevista(coleccionBiblioteca);
                    break;
                case "3":
                    menuRegistro = false;
                    break;
                default:
                    System.out.println("Opción Inválida. Intente nuevamente.");
                    break;
            }
        }
    }

    static void registrarLibro(ArrayList <Material> coleccionBiblioteca) {
        String titulo = pedirString("\nIngrese título del libro: ");
        String autor = pedirString("Ingrese autor del libro: ");
        int cantidadDisponible = pedirEnteroPositivo("Ingrese cantidad disponible del libro: ");
        int numPaginas = pedirEnteroPositivo("Ingrese número de páginas del libro: ");

        Libro libro = new Libro(titulo, autor, cantidadDisponible, numPaginas);
        coleccionBiblioteca.add(libro);
        System.out.println("[OK] Libro Registrado.");
    }

    static void registrarRevista(ArrayList <Material> coleccionBiblioteca) {
        String titulo = pedirString("\nIngrese título de la revista: ");
        String autor = pedirString("Ingrese autor de la revista: ");
        int cantidadDisponible = pedirEnteroPositivo("Ingrese cantidad disponible de la revista: ");
        String mesPublicacion = pedirString("Ingrese mes de publicación de la revista: ");

        Revista revista = new Revista(titulo, autor, cantidadDisponible, mesPublicacion);
        coleccionBiblioteca.add(revista);
        System.out.println("[OK] Revista Registrada.");
    }

    static void listarCatalogo(ArrayList <Material> coleccionBiblioteca) {
        if (coleccionBiblioteca.isEmpty()) {
            System.out.println("\n--- NO HAY MATERIAL REGISTRADO ---");
            return;
        }

        System.out.println("\n----- CATÁLOGO DE MATERIALES -----");
        for (int i = 0; i < coleccionBiblioteca.size(); i++) {
            Material material = coleccionBiblioteca.get(i);
            System.out.println("[" + i + "] " + material.mostrarInfo());
            System.out.print("\n");
        }
    }

    static void buscarMaterialPorTitulo(ArrayList <Material> coleccionBiblioteca) {
        if (coleccionBiblioteca.isEmpty()) {
            System.out.println("\n--- NO HAY MATERIAL REGISTRADO ---");
            return;
        }

        boolean encontrado = false;
        
        String materialBuscado = pedirString("Ingrese título del material que busca: ").toLowerCase();
        for (int i = 0; i < coleccionBiblioteca.size(); i++) {
            Material material = coleccionBiblioteca.get(i);
            if (material.getTitulo().toLowerCase().contains(materialBuscado)) {
                System.out.println("\n[" + i + "] " + material.mostrarInfo());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró material registrado con ese título");
        }
    }

    static void prestarMaterial(ArrayList <Material> coleccionBiblioteca) {
        if (coleccionBiblioteca.isEmpty()) {
            System.out.println("\n--- NO HAY MATERIAL REGISTRADO ---");
            return;
        }

        listarCatalogo(coleccionBiblioteca);

        try {
            System.out.println("Ingrese el índice del material a prestar: ");
            int indiceMaterial = Integer.parseInt(sc.nextLine());
            
            if (indiceMaterial < 0 || indiceMaterial >= coleccionBiblioteca.size()) {
                System.out.println("Índice fuera de rango. El valor debe estar entre 0 y " + (coleccionBiblioteca.size() - 1));
                return;
            }
            
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
            
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Formato Inválido. Debe ingresar un entero.");
        }
        
    }

    static void resumenCatalogo(ArrayList <Material> coleccionBiblioteca) {
        int contadorLibro = 0;
        int contadorRevista = 0;
        int totalMateriales = coleccionBiblioteca.size();
        int totalEjemplares = 0;

        for (Material material : coleccionBiblioteca) {
            if (material instanceof Libro) {
                contadorLibro++;
            } else {
                contadorRevista++;
            }
            totalEjemplares += material.getCantidadDisponible();
        }

        System.out.println("--- RESUMEN DEL CATÁLOGO ---");
        System.out.println("Total de materiales: " + totalMateriales);
        System.out.println("Libros: " + contadorLibro);
        System.out.println("Revista: " + contadorRevista);
        System.out.println("Total de ejemplares disponibles: " + totalEjemplares);

    }

    /*Validar datos */

    private static int pedirEnteroPositivo(String mensaje) {
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

    private static String pedirString(String mensaje) {
        String entradaUsuario;
        
        do {
            System.out.print(mensaje);
            entradaUsuario = sc.nextLine().trim();
            if (entradaUsuario.isEmpty()) {
                System.out.println("Este campo no puede estar vacío. Intente nuevamente");
            } 
        } while (entradaUsuario.isEmpty());
        
        return entradaUsuario;
    }
}

/**
 * Clase lanzadora independiente.
 * 
 * NOTA TÉCNICA:
 * Al no heredar directamente de javafx.application.Application en la clase con el main
 * principal, evitamos el error clásico de la JVM:
 * "Error: JavaFX runtime components are missing, and are required to run this application".
 */
public class Main {
    public static void main(String[] args) {
        App.main(args);
    }
}

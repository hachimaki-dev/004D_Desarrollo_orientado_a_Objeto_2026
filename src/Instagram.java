import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Instagram {

    // Configuración de conexión Oracle
    static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    static final String USER = "usuario_desarrollador"; // Sustituye por tu usuario de Oracle
    static final String PASS = "123456";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    // Método sencillo para abrir la conexión a la base de datos
    static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    static void mostrarMenu() {
        boolean mostrar_menu = true;

        while (mostrar_menu) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Crear autor");
            System.out.println("2. Mostrar autor");
            System.out.println("3. Salir");

            System.out.print("Ingrese una opción: ");
            String opcion_menu = sc.nextLine();

            switch (opcion_menu) {
                case "1":
                    crearAutor();
                    break;
                case "2":
                    mostrarAutor();
                    break;
                case "3":
                    mostrar_menu = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    static void crearAutor() {
        System.out.print("Ingrese id del nuevo autor: ");
        int id_autor = Integer.parseInt(sc.nextLine());
        
        System.out.print("Ingrese nombre del nuevo autor: ");
        String nombre_autor = sc.nextLine();

        String sql = "INSERT INTO autores (id, nombre) VALUES (?, ?)";

        try (Connection con = obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id_autor);
            ps.setString(2, nombre_autor);
            ps.executeUpdate();
            
            System.out.println("¡Autor guardado exitosamente en Oracle!");

        } catch (SQLException e) {
            System.out.println("Error al insertar en Oracle: " + e.getMessage());
        }
    }

    static void mostrarAutor() {
        System.out.println("1. Mostrar un autor en concreto");
        System.out.println("2. Mostrar todos los autores");

        String opcion_menu = sc.nextLine();
        switch (opcion_menu) {
            case "1":
                mostrarUnAutor();
                break;
            case "2":
                mostrarTodosLosAutores();
                break;
            default:
                break;
        }
    }

    static void mostrarUnAutor() {
        System.out.print("Ingrese el ID del autor a buscar: ");
        int idBuscado = Integer.parseInt(sc.nextLine());

        String sql = "SELECT id, nombre FROM autores WHERE id = ?";

        try (Connection con = obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idBuscado);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("El id del autor es: " + rs.getInt("id"));
                System.out.println("El nombre del autor es: " + rs.getString("nombre"));
            } else {
                System.out.println("No se encontró ningún autor con el ID " + idBuscado);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar Oracle: " + e.getMessage());
        }
    }

    static void mostrarTodosLosAutores() {
        String sql = "SELECT id, nombre FROM autores";

        try (Connection con = obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println("El id del autor es: " + rs.getInt("id"));
                System.out.println("El nombre del autor es: " + rs.getString("nombre"));
                System.out.println("---------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar Oracle: " + e.getMessage());
        }
    }
}
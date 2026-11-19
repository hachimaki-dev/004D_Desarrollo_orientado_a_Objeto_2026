package com.relarsamsa.Database;

public class ConexionDB {

    // OPCIÓN A: Para Laboratorio Duoc (Conexión por SID usa ':ORCL')
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private static final String USER = "usuario_desarrollador";
    private static final String PASS = "123456";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // Método main temporal solo para comprobar que el puente funciona
    public static void main(String[] args) {
        try (Connection conn = obtenerConexion()) {
            System.out.println("¡CONEXIÓN EXITOSA A ORACLE DATABASE!");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}
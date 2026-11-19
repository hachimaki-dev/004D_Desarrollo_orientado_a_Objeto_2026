package main.java.com.blasphemycmd.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private static final String USER = "usuario_desarrollador";
    private static final String PASS = "123456";

    public static Connection obtenerConnection() throws SQLDataException{
        return DriverManager.getConnection(URL,USER,PASS);
    }

    public static void main(String[] args) {
        try (Connection conn = obtenerConexion()){
            System.out.println("Conexión");
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        
    }
}

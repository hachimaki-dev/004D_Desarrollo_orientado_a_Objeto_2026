package com.javadb_prueba_final.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
     
    private static final String URL = "jdbc:orancle:thin:@localhost:1521:ORCL";

    private static final String USER = "usuario_desarollador";

    private static final String PASS = "123456";


    public static Connection obtenerConexion() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASS);
    } 

    public static void main(String[] args) {
        try(Connection conn = obtenerConexion()) {
            System.out.println("si");


        } catch (SQLException e) {
            System.err.println("Error al conectar " + e.getMessage());
        }
    }

}

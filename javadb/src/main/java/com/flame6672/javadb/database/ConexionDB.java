package com.flame6672.javadb.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";

    private static final String USER = "usuario_desarrollador";
    private static final String PASS = "123456";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

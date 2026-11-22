package com.config.hogarya.ConnectionDB;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionDB 
{
    
    private final String URL = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";

    private final String NAME = "desarrollador_hogarYA";

    private final String PASS = "123456";

    public Connection formarConexion() throws SQLException
    {   
        try 
        {
            Connection con = DriverManager.getConnection(URL, NAME, PASS);
            
            return con;

        } catch (Exception e) 
        {
            System.out.println("No se formo la conexion");
        }
    
        return null;
    }
}

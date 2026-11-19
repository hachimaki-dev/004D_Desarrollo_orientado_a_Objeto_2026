package com.kiosko.data.SQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion 
{
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";

    private static final String NOMBRE = "usuario_desarrollador";

    private static final String PASS = "123456";

    public Connection obtenerConexion()
    {   
        Connection con;

        try 
        {
            con = DriverManager.getConnection(URL, NOMBRE, PASS);
        } 
        catch (Exception e) 
        {
            return null;
        }
        
        return con;
    }

}

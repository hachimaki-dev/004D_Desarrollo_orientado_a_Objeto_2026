package com.kiosko.data.ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion 
{
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";

    private static final String NOMBRE = "kiosko_desarrollador";

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

    public static void main(String[] args) 
    {   

        Conexion cx = new Conexion();

        Connection con = cx.obtenerConexion();

        if (con == null)
        {
            System.out.println("No funciono");
        }
        else 
        {
            System.out.println("YESSSSS");
        }
    }
}

package com.kiosko.data.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kiosko.data.ConexionDB.Conexion;
import com.kiosko.data.Model.producto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class productoDAO 
{
    private Conexion connection = new Conexion();

    public void insertProducto(String nombre, String catalogo, int precio, int stock, ObservableList<producto> ol) throws SQLException
    {

        String sql_statement = "insert into producto(nombre, categoria, precio, stock) values (?, ?, ?, ?)";
        
        PreparedStatement ps;
        
        Connection con = connection.obtenerConexion();

        if (con == null)
        {   
            System.out.println("La conexión no se pudo formar.");

            return;
        }

        try 
        {
            ps = con.prepareStatement(sql_statement);

            ps.setString(1, nombre);
            ps.setString(2, catalogo);
            ps.setInt(3, precio);
            ps.setInt(4, stock);

            ps.execute();
        } 

        catch (Exception ex) 
        {
            return;
        }

        producto p = new producto(getIdActual(), nombre, catalogo, precio, stock);

        ol.add(p);

        con.close();
        ps.close();

    }

    public void deleteProducto(int id, ObservableList<producto> ol, int IDol) throws SQLException
    {
        String sql_statement = "delete from producto where id = ?";

        PreparedStatement ps;

        Connection con = connection.obtenerConexion();

        if (con == null)
        {   
            System.out.println("La conexión no se pudo formar.");

            return;
        }

        ps = con.prepareStatement(sql_statement);

        ps.setInt(1, id);

        ps.execute();

        ol.remove(IDol);
        
        ps.close();
        con.close();
    }

    public void updateProducto(producto prod, ObservableList<producto> ol, int IDol) throws SQLException
    {

        String sql_statement = "update producto p set p.nombre = ?, p.categoria = ?, p.precio = ?, p.stock = ? where id = ?";

        PreparedStatement ps;

        Connection con = connection.obtenerConexion();

        if (con == null)
        {   
            System.out.println("No se pudo crear una conexión");

            return;
        }

        ps = con.prepareStatement(sql_statement);

        ps.setString(1, prod.getNombre());
        ps.setString(2, prod.getCategoria());
        ps.setInt(3, prod.getPrecio());
        ps.setInt(4, prod.getStock());
        ps.setInt(5, prod.getID());

        int filasAfectadas = ps.executeUpdate();

        if (filasAfectadas == 0)
        {
            System.out.println("Filas actualizadas: " + filasAfectadas);
        }
        else
        {
            System.out.println("Filas actualizadas: " + filasAfectadas);
        }

        ol.set(IDol, prod);

        ps.close();
        con.close();
    }

    public ObservableList<producto> mostrarProductos() throws SQLException
    {      

        ObservableList<producto> lista = FXCollections.observableArrayList();

        final String sql_statement = "select p.id as id, p.nombre as nombre, p.categoria as categoria, p.precio as precio, p.stock as stock from producto p order by p.id asc";

        Connection con = connection.obtenerConexion();

        PreparedStatement ps;

        ps = con.prepareStatement(sql_statement);

        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {

            producto p = new producto(rs.getInt("id"), rs.getString("nombre"), rs.getString("categoria"), rs.getInt("precio"), rs.getInt("stock"));

            lista.add(p);
        
        }

        return lista;

    }

    public int getIdActual() throws SQLException
    {
        String sql_statement = "select nvl(max(id), 0) as ID_actual from producto";

        PreparedStatement ps;

        Connection con = connection.obtenerConexion();

        if (con == null)
        {

        }
        ps = con.prepareStatement(sql_statement);

        ResultSet rs = ps.executeQuery();

        rs.next();

        return rs.getInt("ID_actual");

    }

    public static void main(String[] args) throws SQLException 
    {   
        productoDAO pd = new productoDAO();

        System.out.println(pd.getIdActual());
    }
}

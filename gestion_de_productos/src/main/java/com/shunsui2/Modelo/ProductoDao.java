package com.shunsui2.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao {
    // Esta Clase esta Hecha con IA pero previamente se va a explicar cada linea con comentarios propios para enterder bien como funciona el DAO y cada linea que viene en esta clase
    
    private Connection conexion;

    public ProductoDao(Connection conexion) {
        this.conexion = conexion;
    }

    // 1. GUARDAR
    public void guardar(Producto p) throws SQLException {

        String sql = "INSERT INTO productos "
                   + "(nombre, categoria, precio, stock) "
                   + "VALUES (?, ?, ?, ?)";

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, p.getNombre());
        ps.setString(2, p.getCategoria());
        ps.setDouble(3, p.getPrecio());
        ps.setInt(4, p.getStock());

        ps.executeUpdate();
        ps.close();
    }

    // 2. OBTENER TODOS
public List<Producto> obtenerTodos() throws SQLException {

    List<Producto> lista = new ArrayList<>();

    String sql = "SELECT * FROM productos";

    PreparedStatement ps = conexion.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();

    while (rs.next()) {

        Producto p = new Producto(sql, sql, 0, 0);

        p.setter_Id(rs.getInt("id"));
        p.setter_nombre(rs.getString("nombre"));
        p.setter_categoria(rs.getString("categoria"));
        p.setter_precio(0);
        p.setter_stock(rs.getInt("stock"));

        lista.add(p);
    }

    rs.close();
    ps.close();

    return lista;
}

    // 3. ACTUALIZAR
    public void actualizar(Producto p) throws SQLException {

        String sql = "UPDATE productos SET "
                   + "nombre=?, categoria=?, precio=?, stock=? "
                   + "WHERE id=?";

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, p.getNombre());
        ps.setString(2, p.getCategoria());
        ps.setDouble(3, p.getPrecio());
        ps.setInt(4, p.getStock());
        ps.setInt(5, p.getId());

        ps.executeUpdate();
        ps.close();
    }

    // 4. ELIMINAR
    public void eliminar(int id) throws SQLException {

        String sql = "DELETE FROM productos WHERE id=?";

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, id);

        ps.executeUpdate();
        ps.close();
    }
       




}

package com.kiosko.data.View;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kiosko.data.Controller.producoController;
import com.kiosko.data.Model.producto;
import com.kiosko.data.SQL.Conexion;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class viewPrincipal 
{   
    public VBox vista()
    {

        TextField tf_nombre = new TextField();
        tf_nombre.setPromptText("Nombre producto");

        TextField tf_categoria = new TextField();
        tf_categoria.setPromptText("Categoria producto");

        TextField tf_precio = new TextField();
        tf_precio.setPromptText("Precio producto");

        TextField tf_stock = new TextField();
        tf_stock.setPromptText("Stock producto");

        Button btn_registro = new Button();
        btn_registro.setStyle("-fx-background-color:rgb(255, 0, 0)");

        btn_registro.setOnAction(e -> 
            {   

                String sql_statement = "insert into producto(nombre, categoria, precio, stock) values (?, ?, ?, ?)";

                int int_precio;

                int int_stock;
                
                try 
                {
                    int_precio = Integer.parseInt(tf_precio.getText());
                } 
                catch (Exception exc) 
                {
                    return;
                }
                
                try
                {
                    int_stock = Integer.parseInt(tf_stock.getText());
                }
                catch (Exception exce)
                {
                    return;
                }

                PreparedStatement ps;
                
                producoController pc = new producoController();

                Conexion connection = new Conexion();

                Connection con = connection.obtenerConexion();

                if (con == null)
                {   

                    System.out.println("La conexión no se pudo formar.");

                    return;
                }

                producto p = pc.chkProductoValido(tf_nombre.getText(), tf_categoria.getText(), int_precio, int_stock);    

                try 
                {
                    ps = con.prepareStatement(sql_statement);

                    ps.setString(1, p.getNombre());
                    ps.setString(2, p.getCategoria());
                    ps.setInt(3, p.getPrecio());
                    ps.setInt(4, p.getStock());

                    ps.execute();
                } 
                catch (Exception ex) 
                {
                    return;
                }
                

            });

        VBox vb_registro_producto = new VBox(10, btn_registro, tf_nombre, tf_categoria, tf_precio, tf_stock);

        return vb_registro_producto;
    }


}

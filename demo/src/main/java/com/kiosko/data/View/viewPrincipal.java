package com.kiosko.data.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kiosko.data.Controller.producoController;
import com.kiosko.data.DAO.productoDAO;
import com.kiosko.data.Model.producto;
import com.kiosko.data.ConexionDB.Conexion;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.property.SimpleIntegerProperty;

public class viewPrincipal 
{   
    private productoDAO pDAO = new productoDAO();

    private int productoID;

    private int IndexTabla = -1;

    public HBox vista() throws SQLException
    {

        ObservableList<producto> ol = pDAO.mostrarProductos();

        TableView<producto> tb = new TableView<>();

        TableColumn<producto, Integer> tc_id = new TableColumn<>();
        tc_id.setText("ID");
        tc_id.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getID()).asObject());

        TableColumn<producto, String> tc_nombre = new TableColumn<>();
        tc_nombre.setText("Nombre");
        tc_nombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));

        TableColumn<producto, String> tc_categoria = new TableColumn<>();
        tc_categoria.setText("Categoria");
        tc_categoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()));

        TableColumn<producto, Integer> tc_precio = new TableColumn<>();
        tc_precio.setText("Precio");
        tc_precio.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPrecio()).asObject());

        TableColumn<producto, Integer> tc_stock = new TableColumn<>();
        tc_stock.setText("Stock");
        tc_stock.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getStock()).asObject());

        tb.getColumns().setAll(tc_id, tc_nombre, tc_categoria, tc_precio, tc_stock);

        tb.setItems(ol);

        TextField tf_nombre = new TextField();
        tf_nombre.setPromptText("Nombre producto");

        TextField tf_categoria = new TextField();
        tf_categoria.setPromptText("Categoria producto");

        TextField tf_precio = new TextField();
        tf_precio.setPromptText("Precio producto");

        TextField tf_stock = new TextField();
        tf_stock.setPromptText("Stock producto");

        Button btn_registro = new Button("REGISTRAR");
        btn_registro.setStyle("-fx-background-color:rgb(46, 255, 19)");

        Button btn_actualizar = new Button("ACTUALIZAR");
        btn_actualizar.setStyle("-fx-background-color: #2bc8f0");

        Button btn_eliminar = new Button("ELIMINAR");
        btn_eliminar.setStyle("-fx-background-color: #ff0000");

        tb.getSelectionModel().selectedItemProperty().addListener((obs, anterior, nuevo) -> 
        {
            if (nuevo == null)
            {
                return;
            }
            
            tf_nombre.setText(nuevo.getNombre());
            tf_categoria.setText(nuevo.getCategoria());
            tf_precio.setText(Integer.toString(nuevo.getPrecio()));
            tf_stock.setText(Integer.toString(nuevo.getStock()));

            productoID = nuevo.getID();

            IndexTabla = tb.getSelectionModel().getSelectedIndex();

        });

        btn_registro.setOnAction(e -> 
            {   

                producoController pc = new producoController();

                String p_nombre = tf_nombre.getText();

                String p_categoria = tf_categoria.getText();

                int int_precio;

                int int_stock;

                try 
                {
                   int_precio = Integer.parseInt(tf_precio.getText());
                } 
                catch (Exception ex) 
                {
                    return;
                }

                try 
                {
                    int_stock = Integer.parseInt(tf_stock.getText());
                } 
                catch (Exception exc) 
                {
                    return;
                }

                producto p = pc.chkProductoValido(p_nombre, p_categoria, int_precio, int_stock);

                if (p == null)
                {

                    System.out.println("Los datos son invalidos");

                    return;

                }
                try 
                {
                    pDAO.insertProducto(p.getNombre(), p.getCategoria(), p.getPrecio(), p.getStock(), ol);
                } catch (Exception exce) 
                {
                    return;
                }
                

            });
        
        btn_actualizar.setOnAction(e -> 
            {

                if (IndexTabla == -1)
                {
                    return;
                }

                producto p = new producto(0, null, null, 0, 0);

                p.setNombre(tf_nombre.getText());
                p.setCategoria(tf_categoria.getText());
                p.setID(productoID);

                try 
                {
                    p.setPrecio(Integer.parseInt(tf_precio.getText()));
                } 
                catch (Exception excepi) 
                {
                    return;
                }

                try 
                {
                    p.setStock(Integer.parseInt(tf_stock.getText()));
                } 
                catch (Exception except) 
                {
                    return;
                }

                try 
                {
                    pDAO.updateProducto(p, ol, IndexTabla);    

                    System.out.println("Si se ejecuto");

                } catch (SQLException s) 
                {
                    System.out.println("ERROR:" + s.getMessage());
                }
            

            });   

        btn_eliminar.setOnAction(e -> 
            {

                if (IndexTabla == -1)
                {
                    return;
                }

                try 
                {
                    pDAO.deleteProducto(productoID, ol, IndexTabla);    
                } 
                catch (SQLException sql) 
                {
                    System.out.println("ERROR: " + sql.getMessage());
                }
                

            });
        VBox vb_registro_producto = new VBox(10, btn_registro, tf_nombre, tf_categoria, tf_precio, tf_stock, btn_actualizar, btn_eliminar);

        HBox hb_registro_producto = new HBox(10, vb_registro_producto, tb);

        return hb_registro_producto;
    }


}

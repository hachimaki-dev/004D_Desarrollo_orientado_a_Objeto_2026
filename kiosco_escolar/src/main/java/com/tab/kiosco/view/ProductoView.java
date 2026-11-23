package com.tab.kiosco.view;

import com.tab.kiosco.controller.ProductoController;
import com.tab.kiosco.model.Producto;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ProductoView{

    public Scene productoScene(){
        ProductoController productocontroller = new ProductoController();
        
        Label lbl_bienvenida = new Label("Hola, este es un testeo de que la app se ejecute correctamente");
        
        TextField txf_nombre_producto = new TextField();
        txf_nombre_producto.setPromptText("Nombre del producto");
        
        ComboBox<String> cb_categoria = new ComboBox<>();

        cb_categoria.getItems().addAll(
            "Bebestible",
            "Snack"
        );

        TextField txf_precio_producto = new TextField();
        txf_precio_producto.setPromptText("Precio");

        TextField txf_stock_producto = new TextField();
        txf_stock_producto.setPromptText("Stock");

        VBox vbox_formulario = new VBox(10, lbl_bienvenida, txf_nombre_producto, cb_categoria, txf_precio_producto, txf_stock_producto);

        Button btn_guardar = new Button("Guardar");
        Button btn_actualizar = new Button("Actualizar");
        Button btn_eliminar = new Button("Eliminar");
        Button btn_limpiar = new Button("Limpiar");

        TableView<Producto> tview_datos = new TableView<>();

        btn_guardar.setOnAction(e -> {
            String nombre_ingresado = txf_nombre_producto.getText();
            String categoria_ingresada = cb_categoria.getValue();
            String precio_ingresado = txf_precio_producto.getText();
            String stock_ingresado = txf_stock_producto.getText();

            productocontroller.registrarProducto(nombre_ingresado, categoria_ingresada, precio_ingresado, stock_ingresado);
            tview_datos.setItems(FXCollections.observableArrayList(productocontroller.obtenerProductos()));
        });

        btn_limpiar.setOnAction(e -> {
            txf_nombre_producto.clear();
            cb_categoria.setValue(null);
            txf_precio_producto.clear();
            txf_stock_producto.clear();
            tview_datos.getSelectionModel().clearSelection();
        });

        btn_actualizar.setOnAction(e -> {
            Producto seleccionado = tview_datos.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                productocontroller.actualizarProducto(
                    seleccionado.getId(),
                    txf_nombre_producto.getText(),
                    cb_categoria.getValue(),
                    txf_precio_producto.getText(),
                    txf_stock_producto.getText()
                );
                tview_datos.setItems(FXCollections.observableArrayList(productocontroller.obtenerProductos()));
            }
        });

        btn_eliminar.setOnAction(e -> {
            Producto seleccionado = tview_datos.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                productocontroller.eliminarProducto(seleccionado.getId());
            }
            tview_datos.setItems(FXCollections.observableArrayList(productocontroller.obtenerProductos()));
        });


        HBox hbox_botones_funciones = new HBox(5, btn_guardar, btn_actualizar, btn_eliminar, btn_limpiar);

        VBox vbox_formulario_y_funciones = new VBox(5, vbox_formulario, hbox_botones_funciones);

        tview_datos.getSelectionModel().selectedItemProperty().addListener((obs, anterior, actual) -> {
        
        if (actual != null) {
        txf_nombre_producto.setText(actual.getNombre());
        cb_categoria.setValue(actual.getCategoria());
        txf_precio_producto.setText(String.valueOf(actual.getPrecio()));
        txf_stock_producto.setText(String.valueOf(actual.getStock()));
    }
});

        TableColumn <Producto, Integer> col_id = new TableColumn<>("ID");
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn <Producto, String> col_nombre = new TableColumn<>("Nombre");
        col_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn <Producto, String> col_categoria = new TableColumn<>("Categoria");
        col_categoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        TableColumn <Producto, Integer> col_precio = new TableColumn<>("Precio");
        col_precio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn <Producto, Integer> col_stock = new TableColumn<>("Stock");
        col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tview_datos.getColumns().addAll(col_id, col_nombre, col_categoria, col_precio, col_stock);

        HBox hbox_todos_elementos = new HBox(vbox_formulario_y_funciones, tview_datos);

        Scene home_scene = new Scene(hbox_todos_elementos, 720, 480);

        tview_datos.setItems(FXCollections.observableArrayList(productocontroller.obtenerProductos()));
        return home_scene;
    }
}

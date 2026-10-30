package com.hachimakidev.techstore.view;

import com.hachimakidev.techstore.controller.DispositivoController;
import com.hachimakidev.techstore.model.Dispositivo;
import com.hachimakidev.techstore.model.Notebook;
import com.hachimakidev.techstore.model.Smartphone;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CatalogoView {

    private DispositivoController controlador = new DispositivoController();

    public VBox catalogo() {
        Label lbl_titulo = new Label("TechStore — Catálogo de Notebooks y Smartphones");
        lbl_titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // ==========================================
        // TODO 2: Construir el TableView<Dispositivo>
        // ==========================================
        TableView<Dispositivo> tabla = new TableView<>();
        
        // Creamos las columnas pidiendo las propiedades de la clase Dispositivo
        TableColumn<Dispositivo, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Dispositivo, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        TableColumn<Dispositivo, String> colMarca = new TableColumn<>("Marca");
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

        TableColumn<Dispositivo, String> colModelo = new TableColumn<>("Modelo");
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        TableColumn<Dispositivo, Integer> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<Dispositivo, String> colEspecificacion = new TableColumn<>("Especificación");
        colEspecificacion.setCellValueFactory(new PropertyValueFactory<>("especificacion")); // O el método getter que tengas para los detalles

        TableColumn<Dispositivo, Boolean> colDisponible = new TableColumn<>("Disponible");
        colDisponible.setCellValueFactory(new PropertyValueFactory<>("disponible"));

        // Añadimos las columnas a la tabla
        tabla.getColumns().addAll(colId, colTipo, colMarca, colModelo, colPrecio, colEspecificacion, colDisponible);

        // Cargamos los datos del controlador convirtiéndolos en ObservableList
        ObservableList<Dispositivo> datosDispositivos = FXCollections.observableArrayList(controlador.obtenerDispositivo());
        tabla.setItems(datosDispositivos);
        tabla.setPrefHeight(250);

        VBox contenedor_tabla = new VBox(10, tabla);
        contenedor_tabla.setPadding(new Insets(20));
        contenedor_tabla.setStyle("-fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-background-color: #f8fafc;");

        // ==========================================
        // TODO 3: Construir el Formulario
        // ==========================================
        ComboBox<String> cbTipo = new ComboBox<>();
        cbTipo.getItems().addAll("notebook", "smartphone");
        cbTipo.setPromptText("Seleccionar tipo");

        TextField txtId = new TextField();
        txtId.setPromptText("ID");
        txtId.setPrefWidth(60);

        TextField txtMarca = new TextField();
        txtMarca.setPromptText("Marca");

        TextField txtModelo = new TextField();
        txtModelo.setPromptText("Modelo");

        TextField txtPrecio = new TextField();
        txtPrecio.setPromptText("Precio");
        txtPrecio.setPrefWidth(80);

        // Campos extra para especificaciones (puedes adaptarlos según tus clases hijas)
        TextField txtExtra1 = new TextField();
        txtExtra1.setPromptText("RAM / Almacenamiento");

        TextField txtExtra2 = new TextField();
        txtExtra2.setPromptText("Procesador / Cámara MP");

        Button btnAgregar = new Button("Agregar Dispositivo");
        
        // Lógica del botón al hacerle clic
        btnAgregar.setOnAction(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String tipo = cbTipo.getValue();
                String marca = txtMarca.getText();
                String modelo = txtModelo.getText();
                int precio = Integer.parseInt(txtPrecio.getText());
                boolean disponible = true; // Por defecto o puedes agregar un CheckBox

                Dispositivo nuevo;
                if ("notebook".equals(tipo)) {
                    int ram = Integer.parseInt(txtExtra1.getText());
                    String proc = txtExtra2.getText();
                    nuevo = new Notebook(id, marca, modelo, precio, disponible, ram, proc);
                } else {
                    int almacenamiento = Integer.parseInt(txtExtra1.getText());
                    int camara = Integer.parseInt(txtExtra2.getText());
                    nuevo = new Smartphone(id, marca, modelo, precio, disponible, almacenamiento, camara);
                }

                // Registramos en el controlador
                controlador.registrarnuevoDispositivo(nuevo);

                // Actualizamos la tabla visualmente
                datosDispositivos.setAll(controlador.obtenerDispositivo());

                // Limpiamos los campos
                txtId.clear();
                txtMarca.clear();
                txtModelo.clear();
                txtPrecio.clear();
                txtExtra1.clear();
                txtExtra2.clear();
                cbTipo.getSelectionModel().clearSelection();

            } catch (Exception ex) {
                System.out.println("Error al ingresar los datos: " + ex.getMessage());
            }
        });

        HBox fila_formulario = new HBox(10, cbTipo, txtId, txtMarca, txtModelo, txtPrecio, txtExtra1, txtExtra2, btnAgregar);
        fila_formulario.setPadding(new Insets(10));

        VBox contenedor_formulario = new VBox(10, new Label("Nuevo Dispositivo"), fila_formulario);
        contenedor_formulario.setPadding(new Insets(16));
        contenedor_formulario.setStyle("-fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-background-color: #ffffff;");

        VBox layout_principal = new VBox(16, lbl_titulo, contenedor_tabla, contenedor_formulario);
        layout_principal.setPadding(new Insets(20));

        return layout_principal;
    }
}


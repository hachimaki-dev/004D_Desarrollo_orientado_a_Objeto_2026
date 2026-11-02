package com.hachimakidev.techstore.view;

import com.hachimakidev.techstore.controller.DispositivoController;
import com.hachimakidev.techstore.model.Dispositivo;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CatalogoView {

    private DispositivoController controller = new DispositivoController();

    public VBox catalogo() {

        Label lbl_titulo = new Label("TechStore — Catálogo de Notebooks y Smartphones");
        lbl_titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // TABLA DE DISPOSITIVOS
        TableView<Dispositivo> tablita = new TableView<>();
        tablita.setPlaceholder(new Label("No hay dispositivos disponibles. Ingrese nuevos."));

        TableColumn<Dispositivo, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setPrefWidth(50);

        TableColumn<Dispositivo, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colTipo.setPrefWidth(90);

        TableColumn<Dispositivo, String> colMarca = new TableColumn<>("Marca");
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colMarca.setPrefWidth(100);

        TableColumn<Dispositivo, String> colModelo = new TableColumn<>("Modelo");
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colModelo.setPrefWidth(100);

        TableColumn<Dispositivo, Integer> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colPrecio.setPrefWidth(90);

        TableColumn<Dispositivo, String> colEspecificacion = new TableColumn<>("Especificación");
        colEspecificacion.setCellValueFactory(new PropertyValueFactory<>("especificacion"));
        colEspecificacion.setPrefWidth(150);

        TableColumn<Dispositivo, Boolean> colDisponible = new TableColumn<>("Disponible");
        colDisponible.setCellValueFactory(new PropertyValueFactory<>("disponible"));
        colDisponible.setPrefWidth(90);

        tablita.getColumns().add(colId);
        tablita.getColumns().add(colTipo);
        tablita.getColumns().add(colMarca);
        tablita.getColumns().add(colModelo);
        tablita.getColumns().add(colPrecio);
        tablita.getColumns().add(colEspecificacion);
        tablita.getColumns().add(colDisponible);
        tablita.setItems(FXCollections.observableArrayList(controller.obtenerDispositivos()));

        // FORMULARIO DE INGRESO
        ComboBox<String> cbTipo = new ComboBox<>(FXCollections.observableArrayList("Notebook", "Smartphone"));
        cbTipo.setValue("Notebook");

        TextField txtMarca = new TextField();
        txtMarca.setPromptText("Marca");

        TextField txtModelo = new TextField();
        txtModelo.setPromptText("Modelo");

        TextField txtPrecio = new TextField();
        txtPrecio.setPromptText("Precio ($)");

        // Campos específicos de Notebook
        TextField txtRam = new TextField();
        txtRam.setPromptText("RAM (GB)");

        TextField txtProcesador = new TextField();
        txtProcesador.setPromptText("Procesador");

        HBox panelNotebook = new HBox(8, new Label("RAM:"), txtRam, new Label("Procesador:"), txtProcesador);

        // Campos específicos de Smartphone
        TextField txtAlmacenamiento = new TextField();
        txtAlmacenamiento.setPromptText("Almacenamiento (GB)");

        TextField txtCamara = new TextField();
        txtCamara.setPromptText("Cámara (MP)");

        HBox panelSmartphone = new HBox(8, new Label("Almacenamiento:"), txtAlmacenamiento, new Label("Cámara:"), txtCamara);

        panelSmartphone.setVisible(false);
        panelSmartphone.setManaged(false);

        // Evento del ComboBox para alternar paneles
        cbTipo.setOnAction(e -> {
            boolean esNotebook = "Notebook".equals(cbTipo.getValue());
            panelNotebook.setVisible(esNotebook);
            panelNotebook.setManaged(esNotebook);
            panelSmartphone.setVisible(!esNotebook);
            panelSmartphone.setManaged(!esNotebook);
        });

        Button btnAgregar = new Button("Agregar Dispositivo");
        
        // Label simple para retroalimentación
        Label lblMensaje = new Label(); 

        // ACCIÓN DEL BOTÓN AGREGAR
        btnAgregar.setOnAction(e -> {
            try {
                String tipo = cbTipo.getValue();
                String marca = txtMarca.getText().trim();
                String modelo = txtModelo.getText().trim();
                int precio = Integer.parseInt(txtPrecio.getText().trim());

                if ("Notebook".equals(tipo)) {
                    int ram = Integer.parseInt(txtRam.getText().trim());
                    String procesador = txtProcesador.getText().trim();
                    controller.agregarNotebook(marca, modelo, precio, true, ram, procesador);

                } else if ("Smartphone".equals(tipo)) {
                    int almacenamiento = Integer.parseInt(txtAlmacenamiento.getText().trim());
                    int camara = Integer.parseInt(txtCamara.getText().trim());
                    controller.agregarSmartphone(marca, modelo, precio, true, almacenamiento, camara);
                }

                // Refrescar tabla
                tablita.setItems(FXCollections.observableArrayList(controller.obtenerDispositivos()));

                // Limpiar cajas de texto
                txtMarca.clear();
                txtModelo.clear();
                txtPrecio.clear();
                txtRam.clear();
                txtProcesador.clear();
                txtAlmacenamiento.clear();
                txtCamara.clear();

                // Mensaje en pantalla
                lblMensaje.setText("¡Dispositivo registrado con éxito!");
                lblMensaje.setStyle("-fx-text-fill: green;");

            } catch (NumberFormatException ex) {
                lblMensaje.setText("Error: Ingrese solo números en Precio, RAM/Almacenamiento o Cámara.");
                lblMensaje.setStyle("-fx-text-fill: red;");
            } catch (Exception ex) {
                lblMensaje.setText("Ocurrió un error al registrar el dispositivo.");
                lblMensaje.setStyle("-fx-text-fill: red;");
            }
        });

        // ESTRUCTURA VISUAL
        HBox formBasico = new HBox(10, new Label("Tipo:"), cbTipo, txtMarca, txtModelo, txtPrecio);
        VBox formEspecificos = new VBox(8, panelNotebook, panelSmartphone);

        VBox formulario = new VBox(10, formBasico, formEspecificos, btnAgregar, lblMensaje);
        formulario.setPadding(new Insets(10));

        VBox layoutPrincipal = new VBox(16, lbl_titulo, tablita, formulario);
        layoutPrincipal.setPadding(new Insets(20));

        return layoutPrincipal;
    }
}
package com.hachimakidev.techstore.view;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import com.hachimakidev.techstore.controller.DispositivoController;
import com.hachimakidev.techstore.model.Dispositivo;
import com.hachimakidev.techstore.model.Notebook;
import com.hachimakidev.techstore.model.Smartphone;

public class CatalogoView {
        private DispositivoController c = new DispositivoController();

    public VBox catalogo() {
        // TODO 1: Instanciar DispositivoController para pedirle la lista de dispositivos y registrar nuevos equipos.

        Label lbl_titulo = new Label("TechStore — Catálogo de Notebooks y Smartphones");
        lbl_titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // TODO 2: Reemplazar este contenedor temporal por un TableView<Dispositivo>
        //   - Crear columnas con PropertyValueFactory para: "id", "tipo", "marca", "modelo", "precio", "especificacion", "disponible"
        //   - Poblar la tabla usando FXCollections.observableArrayList(...) con la lista del controlador
        TableView<Dispositivo> tabla = new TableView<>();

        TableColumn<Dispositivo, Integer> colID = new TableColumn<>("Id");
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Dispositivo, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        TableColumn<Dispositivo, String> colMarca = new TableColumn<>("Marca");
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        TableColumn<Dispositivo, String> colModelo = new TableColumn<>("Modelo");
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        TableColumn<Dispositivo, Integer> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        TableColumn<Dispositivo, String> colEspecificacion = new TableColumn<>("Especificacion");
        colEspecificacion.setCellValueFactory(new PropertyValueFactory<>("especificacion")); 
        TableColumn<Dispositivo, String> colDisponible = new TableColumn<>("disponible");
        colDisponible.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().isDisponible() ? "si" : "no"));

        tabla.getColumns().addAll(colID, colTipo, colMarca, colModelo, colPrecio, colEspecificacion, colDisponible);
        tabla.setItems(FXCollections.observableArrayList(c.obtenerDispositivos()));


        VBox contenedor_tabla = new VBox(10, tabla);
        contenedor_tabla.setPadding(new Insets(20));
        contenedor_tabla.setStyle("-fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-background-color: #f8fafc;");

        ComboBox<String> cmbTipo = new ComboBox<>();
        cmbTipo.getItems().addAll("Notebook", "Smartphone");
        cmbTipo.setValue("Notebook");
        TextField txfMarca = new TextField();
        txfMarca.setPromptText("Marca");
        TextField txfModelo = new TextField();
        txfModelo.setPromptText("Modelo");
        TextField txfPrecio = new TextField();
        txfPrecio.setPromptText("Precio");
        TextField txfDisponible = new TextField();
        txfDisponible.setPromptText("Disponible");

        TextField txfRam = new TextField();
        txfRam.setPromptText("Ram");
        TextField txfProcesador = new TextField();
        txfProcesador.setPromptText("Procesador");


        //Smartphone
        TextField txfAlmacenamiento = new TextField();
        txfAlmacenamiento.setPromptText("Almacenamiento");

        TextField txfCamara = new TextField();
        txfCamara.setPromptText("Cámara (Mp)");

        Button btn_agregar = new Button("Agregar Dispositivo");

        HBox camposNotebook = new HBox(10, txfRam, txfProcesador);
        HBox camposSmartphone = new HBox(10, txfAlmacenamiento, txfCamara);

        camposNotebook.setVisible(true);
        camposNotebook.setManaged(true);

        camposSmartphone.setVisible(false);
        camposSmartphone.setManaged(false);

        cmbTipo.setOnAction(e -> {
            boolean esNotebook = cmbTipo.getValue().equals("Notebook");

            camposNotebook.setVisible(esNotebook);
            camposNotebook.setManaged(esNotebook);

            camposSmartphone.setVisible(!esNotebook);
            camposSmartphone.setManaged(!esNotebook);
        });

        btn_agregar.setOnAction(e -> {
            try {
                String marca = txfMarca.getText();
                String modelo = txfModelo.getText();
                int precio = Integer.parseInt(txfPrecio.getText());
                boolean disponible = Boolean.parseBoolean(txfDisponible.getText());
                


                Dispositivo nuevoDispositivo;
                if (cmbTipo.getValue().equals("Notebook")){
                    int ram = Integer.parseInt(txfRam.getText());
                    String procesador = txfProcesador.getText();

                    nuevoDispositivo = new Notebook(0, marca, modelo, precio, disponible, ram, procesador);
                
            }
            else{
                int almacenamiento = Integer.parseInt(txfAlmacenamiento.getText());
                int camara = Integer.parseInt(txfCamara.getText());

                nuevoDispositivo = new Smartphone(0, marca, modelo, precio, disponible, almacenamiento, camara);
            }
            c.agregarDispositivo(nuevoDispositivo);
            tabla.setItems(FXCollections.observableArrayList(c.obtenerDispositivos()));

            txfMarca.clear();
            txfModelo.clear();
            txfPrecio.clear();
            txfRam.clear();
            txfProcesador.clear();
            txfAlmacenamiento.clear();
            txfCamara.clear();
            
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setTitle("TechStore");
            alerta.setHeaderText(null);
            alerta.setContentText("Dispositivo agregado correctamente.");
            alerta.showAndWait();

        } catch (NumberFormatException ex) {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Datos numéricos inválidos");
            alerta.setContentText("Revisa el precio y los campos numéricos.");
            alerta.showAndWait();
        }
    });

        VBox contenedor_formulario = new VBox(10, new Label("Agregar nuevo dispositivo"), cmbTipo, txfMarca, txfModelo, txfPrecio, camposNotebook, camposSmartphone, btn_agregar);
        contenedor_formulario.setPadding(new Insets(16));
        contenedor_formulario.setStyle("-fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-background-color: #ffffff;");

        VBox layout_principal = new VBox(16, lbl_titulo, contenedor_tabla, contenedor_formulario);
        layout_principal.setPadding(new Insets(20));

        return layout_principal;
    }
}


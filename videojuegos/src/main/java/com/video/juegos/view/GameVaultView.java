package com.video.juegos.view;

import com.video.juegos.controller.InventarioController;
import com.video.juegos.model.JuegoDigital;
import com.video.juegos.model.JuegoFisico;
import com.video.juegos.model.Videojuego;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableCell;
import javafx.scene.image.ImageView;

public class GameVaultView {
    private TableView<Videojuego> tablaVideoJuegos;
    private InventarioController inventarioController;

    public GameVaultView() {
        inventarioController = new InventarioController();
        configurarTabla();
        cargarInventario();
    }

    private void configurarTabla() {

        tablaVideoJuegos = new TableView<>();
        tablaVideoJuegos.setFixedCellSize(180);
        // tablaVideoJuegos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        TableColumn<Videojuego, String> columnaTipo = new TableColumn<>("Tipo");
        columnaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        TableColumn<Videojuego, String> columnaTitulo = new TableColumn<>("Título");
        columnaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));

        TableColumn<Videojuego, String> columnaDetalle = new TableColumn<>("Detalles");

        columnaDetalle.setCellValueFactory(fila -> {
            Videojuego videojuego = fila.getValue();
            String detalle = "";

            if (videojuego instanceof JuegoFisico fisico) {
                detalle = "Stock: " + fisico.getStockTienda()
                        + " · Peso: " + fisico.getPesoGramos() + " g";

            } else if (videojuego instanceof JuegoDigital digital) {
                detalle = "Tamaño: " + digital.getTamanoGB() + " GB"
                        + " · Código: " + digital.getCodigoActivacion();
            }

            return new ReadOnlyStringWrapper(detalle);
        });

        TableColumn<Videojuego, String> columnaPlataforma = new TableColumn<>("Plataforma");
        columnaPlataforma.setCellValueFactory(new PropertyValueFactory<>("plataforma"));

        TableColumn<Videojuego, String> columnaPortada = new TableColumn<>("Portada");
        columnaPortada.setCellValueFactory(new PropertyValueFactory<>("portada"));

        columnaPortada.setCellFactory(columna -> {

            return new TableCell<Videojuego, String>() {

                private final ImageView vistaImagen = new ImageView();

                {
                    vistaImagen.setFitWidth(110);
                    vistaImagen.setFitHeight(160);
                    vistaImagen.setPreserveRatio(true);
                }

                @Override
                protected void updateItem(String rutaImagen, boolean vacio) {
                    super.updateItem(rutaImagen, vacio);

                    if (vacio || rutaImagen == null || rutaImagen.isBlank()) {
                        vistaImagen.setImage(null);
                        setGraphic(null);
                        setText(null);
                    } else {
                        Image imagen = new Image(rutaImagen, true);
                        vistaImagen.setImage(imagen);

                        setGraphic(vistaImagen);
                        setText(null);
                    }
                }
            };
        });

        tablaVideoJuegos.getColumns().add(columnaTipo);
        tablaVideoJuegos.getColumns().add(columnaTitulo);
        tablaVideoJuegos.getColumns().add(columnaDetalle);
        tablaVideoJuegos.getColumns().add(columnaPlataforma);
        tablaVideoJuegos.getColumns().add(columnaPortada);
    }

    private void cargarInventario() {
        ObservableList<Videojuego> videojuegos = FXCollections.observableArrayList(inventarioController.getInventario());
        tablaVideoJuegos.setItems(videojuegos);
    }

    public Scene inventarioScene() {
        VBox contenedorInventario = new VBox(tablaVideoJuegos);
        Scene escenaInventario = new Scene(contenedorInventario, 800, 600);
        return escenaInventario;
    }

    public VBox contenedorGameVault() {
        return new VBox(tablaVideoJuegos);
    }

}

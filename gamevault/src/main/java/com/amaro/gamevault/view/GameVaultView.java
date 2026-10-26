package com.amaro.gamevault.view;


import com.amaro.gamevault.controller.InventarioController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import com.amaro.gamevault.model.Videojuego;

public class GameVaultView {
    private TableView<Videojuego> tablaJuegos;
    private InventarioController inventarioController;

    public GameVaultView() {
        inventarioController = new InventarioController();
        configurarTabla();
        cargarVideojuego();
    }

    private void configurarTabla() {
        tablaJuegos = new TableView<>();
        TableColumn<Videojuego, String> columnaTitulo = new TableColumn<>("Título");
        columnaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        TableColumn<Videojuego, String> columnaPlataforma = new TableColumn<>("Plataforma");
        columnaPlataforma.setCellValueFactory(new PropertyValueFactory<>("plataforma"));
        tablaJuegos.getColumns().add(columnaTitulo);
        tablaJuegos.getColumns().add(columnaPlataforma);
    }

    private void cargarVideojuego() {
        ObservableList<Videojuego> juego = FXCollections.observableArrayList(inventarioController.getVideojuegos());
        tablaJuegos.setItems(juego);
    }

    public Scene VideojuegoScene() {
        VBox contenedor = new VBox(tablaJuegos);
        Scene escena = new Scene(contenedor, 800, 600);
        return escena;
    }
}

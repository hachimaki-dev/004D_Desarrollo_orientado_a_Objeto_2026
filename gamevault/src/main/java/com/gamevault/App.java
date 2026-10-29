package com.gamevault;

import com.gamevault.Controlador.InventarioControlador;
import com.gamevault.Modelo.Usuario;
import com.gamevault.Modelo.UsuarioManager;
import com.gamevault.Modelo.Videojuego;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private UsuarioManager usuarioManager;

    @Override
    public void start(Stage stage) {
        stage.setTitle("GameVault — Gestión de Inventario y Socios Gamer");

        usuarioManager = new UsuarioManager();
        InventarioControlador controlador = new InventarioControlador();

        Label lbl_titulo_principal = new Label("GAMEVAULT — GESTIÓN DE INVENTARIO Y SOCIOS GAMER");
        lbl_titulo_principal_style(lbl_titulo_principal);

        Label lbl_rut = new Label("Ingrese RUT:");
        TextField txt_rut = new TextField();
        txt_rut.setPromptText("Ej: 18.111.222-3");
        Button btn_buscar_socio = new Button("Buscar Socio");

        HBox panel_busqueda = new HBox(10, lbl_rut, txt_rut, btn_buscar_socio);
        panel_busqueda.setPadding(new Insets(5));

        Label lbl_resultado_socio = new Label("RUT: -- | Socio: -- | Nivel: --");
        Label lbl_email_socio = new Label("Email: --");
        
        VBox panel_socio_info = new VBox(3, lbl_resultado_socio, lbl_email_socio);
        panel_socio_info.setPadding(new Insets(5));

        // Evento conectado a tu UsuarioManager
        btn_buscar_socio.setOnAction(e -> {
            String rutBuscado = txt_rut.getText().trim();
            Usuario usuarioEncontrado = usuarioManager.buscarPorRut(rutBuscado);
            
            if (usuarioEncontrado != null) {
                lbl_resultado_socio.setText("RUT: " + usuarioEncontrado.getRut() + 
                                            "  |  Socio: " + usuarioEncontrado.getNombre() + 
                                            "  |  Nivel: " + usuarioEncontrado.getNivelGamer());
                lbl_email_socio.setText("Email: " + usuarioEncontrado.getEmail());
            } else {
                lbl_resultado_socio.setText("Socio no encontrado en el sistema");
                lbl_email_socio.setText("Email: --");
            }
        });

        VBox panel_superior = new VBox(10, panel_busqueda, panel_socio_info);
        panel_superior.setPadding(new Insets(10));
        panel_superior.setStyle("-fx-border-color: #cccccc; -fx-border-width: 0 0 1 0;");

        TableView<Videojuego> tabla_inventario = new TableView<>();
        
        TableColumn<Videojuego, String> col_formato = new TableColumn<>("Formato");
        col_formato.setCellValueFactory(new PropertyValueFactory<>("plataforma"));

        TableColumn<Videojuego, String> col_titulo = new TableColumn<>("Título");
        col_titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));

        TableColumn<Videojuego, Double> col_precio = new TableColumn<>("Precio");
        col_precio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<Videojuego, Integer> col_stock = new TableColumn<>("Detalle (Stock)");
        col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tabla_inventario.getColumns().addAll(col_formato, col_titulo, col_precio, col_stock);

        ObservableList<Videojuego> datos = FXCollections.observableArrayList(controlador.obtenerInventarioCompleto());
        tabla_inventario.setItems(datos);

        Label lbl_titulo_inventario = new Label("Inventario de Videojuegos");
        VBox panel_inferior = new VBox(10, lbl_titulo_inventario, tabla_inventario);
        panel_inferior.setPadding(new Insets(10));

        VBox root = new VBox(10, lbl_titulo_principal, panel_superior, panel_inferior);
        root.setPadding(new Insets(15));

        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }

    private void lbl_titulo_principal_style(Label lbl) {
        lbl.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
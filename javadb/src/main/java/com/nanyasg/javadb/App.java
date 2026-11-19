package com.nanyasg.javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    // =========================================================================
    // PARTE 1: DATOS DE CONEXIÓN A ORACLE CLOUD (Reemplaza a localhost, lo debo modificar al estar en el duoc con docker)
    // =========================================================================
    private final String URL = "jdbc:oracle:thin:@proyectobd1_high?TNS_ADMIN=C:/Wallet_Oracle";
    private final String USER = "usuario_desarrollador";
    private final String PASS = "Desarrollador123"; 
    // =========================================================================
    // PARTE 2: ELEMENTOS VISUALES DE LA VENTANA (Cajas de texto, botones, tabla)
    // =========================================================================
    private TextField txtNombre = new TextField();
    private TextField txtPrecio = new TextField();
    private TextField txtConsola = new TextField();
    private Label lblEstado = new Label("Listo.");
    
    // TableView es la tabla visual; ObservableList es como un ArrayList que avisa a la tabla cuando cambia
    private TableView<Juego> tablaJuegos = new TableView<>();
    private ObservableList<Juego> listaJuegos = FXCollections.observableArrayList();
    private Integer idSeleccionado = null; // Guarda el ID del juego al que le hiciste clic

    // Molde simple para guardar cada fila que viene de Oracle
    public static class Juego {
        int id;
        String nombre;
        double precio;
        String consola;

        public Juego(int id, String nombre, double precio, String consola) {
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
            this.consola = consola;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        txtNombre.setPromptText("Nombre del juego");
        txtPrecio.setPromptText("Precio (ej: 15000)");
        txtConsola.setPromptText("Consola (ej: PS5, Switch, PC)");

        // Crear las 4 columnas de la tabla visual
        TableColumn<Juego, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(d -> new SimpleStringProperty(String.valueOf(d.getValue().id)));

        TableColumn<Juego, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().nombre));

        TableColumn<Juego, String> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(d -> new SimpleStringProperty(String.valueOf(d.getValue().precio)));

        TableColumn<Juego, String> colConsola = new TableColumn<>("Consola");
        colConsola.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().consola));

        tablaJuegos.getColumns().addAll(colId, colNombre, colPrecio, colConsola);
        tablaJuegos.setItems(listaJuegos);

        // Evento: Cuando haces clic en una fila de la tabla, rellena las cajas de texto
        tablaJuegos.getSelectionModel().selectedItemProperty().addListener((obs, anterior, seleccionado) -> {
            if (seleccionado != null) {
                idSeleccionado = seleccionado.id;
                txtNombre.setText(seleccionado.nombre);
                txtPrecio.setText(String.valueOf(seleccionado.precio));
                txtConsola.setText(seleccionado.consola);
                lblEstado.setText("Seleccionado ID: " + idSeleccionado);
            }
        });

        // Crear botones y conectarlos con sus métodos
        Button btnInsertar = new Button("Insertar");
        Button btnActualizar = new Button("Actualizar");
        Button btnEliminar = new Button("Eliminar");
        Button btnLimpiar = new Button("Limpiar");

        btnInsertar.setOnAction(e -> insertarJuego());
        btnActualizar.setOnAction(e -> actualizarJuego());
        btnEliminar.setOnAction(e -> eliminarJuego());
        btnLimpiar.setOnAction(e -> limpiarCampos());

        // Ordenar todo en pantalla (HBox = horizontal, VBox = vertical)
        HBox filaBotones = new HBox(10, btnInsertar, btnActualizar, btnEliminar, btnLimpiar);
        VBox layout = new VBox(10, txtNombre, txtPrecio, txtConsola, filaBotones, lblEstado, tablaJuegos);
        layout.setPadding(new Insets(15));

        // Traer los juegos desde Oracle apenas se abre la ventana
        cargarJuegos();

        primaryStage.setTitle("CRUD Juegos - Sin Patrones");
        primaryStage.setScene(new Scene(layout, 650, 500));
        primaryStage.show();
    }

    // =========================================================================
    // PARTE 3: MÉTODOS QUE HABLAN CON LA BASE DE DATOS (CRUD)
    // =========================================================================

    // Abre el puente con Oracle usando el Wallet
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // READ (Leer): Trae todos los juegos de Oracle y los mete en la tabla visual
    private void cargarJuegos() {
        listaJuegos.clear();
        String sql = "SELECT id, nombre, precio, consola FROM juegos ORDER BY id";

        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                listaJuegos.add(new Juego(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getString("consola")
                ));
            }
        } catch (SQLException e) {
            lblEstado.setText("Error al cargar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // CREATE (Insertar): Guarda un juego nuevo en Oracle
    private void insertarJuego() {
        String sql = "INSERT INTO juegos (nombre, precio, consola) VALUES (?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, txtNombre.getText());
            ps.setDouble(2, Double.parseDouble(txtPrecio.getText()));
            ps.setString(3, txtConsola.getText());
            ps.executeUpdate();

            lblEstado.setText("Juego insertado correctamente.");
            limpiarCampos();
            cargarJuegos(); // Refresca la tabla para ver el nuevo juego
        } catch (Exception e) {
            lblEstado.setText("Error al insertar: " + e.getMessage());
        }
    }

    // UPDATE (Actualizar): Modifica el juego seleccionado usando su ID
    private void actualizarJuego() {
        if (idSeleccionado == null) {
            lblEstado.setText("Haz clic en un juego de la tabla primero.");
            return;
        }
        String sql = "UPDATE juegos SET nombre = ?, precio = ?, consola = ? WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, txtNombre.getText());
            ps.setDouble(2, Double.parseDouble(txtPrecio.getText()));
            ps.setString(3, txtConsola.getText());
            ps.setInt(4, idSeleccionado);
            ps.executeUpdate();

            lblEstado.setText("Juego actualizado.");
            limpiarCampos();
            cargarJuegos();
        } catch (Exception e) {
            lblEstado.setText("Error al actualizar: " + e.getMessage());
        }
    }

    // DELETE (Eliminar): Borra de Oracle el juego seleccionado
    private void eliminarJuego() {
        if (idSeleccionado == null) {
            lblEstado.setText("Haz clic en un juego de la tabla primero.");
            return;
        }
        String sql = "DELETE FROM juegos WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idSeleccionado);
            ps.executeUpdate();

            lblEstado.setText("Juego eliminado.");
            limpiarCampos();
            cargarJuegos();
        } catch (SQLException e) {
            lblEstado.setText("Error al eliminar: " + e.getMessage());
        }
    }

    // Limpia las cajas de texto
    private void limpiarCampos() {
        idSeleccionado = null;
        txtNombre.clear();
        txtPrecio.clear();
        txtConsola.clear();
        tablaJuegos.getSelectionModel().clearSelection();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


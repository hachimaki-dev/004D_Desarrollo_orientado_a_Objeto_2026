import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class Main {

    private final String URL = "jdbc:oracle:thin:@localhost:1521/freepdb1";
    private final String USER = "SYSTEM";
    private final String PASS = "123456";

    private TextField txtNombre = new TextField();
    private TextField txtPrecio = new TextField();
    private TextField txtConsola = new TextField();
    private TableView<Juego> tablaJuegos = new TableView<>();
    private ObservableList<Juego> listaJuegos = FXCollections.observableArrayList();

    private int idSeleccionado = -1;

    public static class Juego {
        private final SimpleIntegerProperty id;
        private final SimpleStringProperty nombre;
        private final SimpleDoubleProperty precio;
        private final SimpleStringProperty consola;

        public Juego(int id, String nombre, double precio, String consola) {
            this.id = new SimpleIntegerProperty(id);
            this.nombre = new SimpleStringProperty(nombre);
            this.precio = new SimpleDoubleProperty(precio);
            this.consola = new SimpleStringProperty(consola);
        }

        public int getId() { return id.get(); }
        public String getNombre() { return nombre.get(); }
        public double getPrecio() { return precio.get(); }
        public String getConsola() { return consola.get(); }
    }

    public static void main(String[] args) {
        Application.launch(App.class, args);
    }

    public static class App extends Application {
        @Override
        public void start(Stage stage) {
            new Main().iniciar(stage);
        }
    }

    @SuppressWarnings("unchecked")
    public void iniciar(Stage stage) {
        txtNombre.setPromptText("Nombre del juego");
        txtPrecio.setPromptText("Precio");
        txtConsola.setPromptText("Consola (ej. PS5, Switch, PC)");

        Button btnInsertar = new Button("Insertar");
        Button btnActualizar = new Button("Actualizar");
        Button btnEliminar = new Button("Eliminar");
        Button btnLimpiar = new Button("Limpiar");

        btnInsertar.setOnAction(e -> insertarJuego());
        btnActualizar.setOnAction(e -> actualizarJuego());
        btnEliminar.setOnAction(e -> eliminarJuego());
        btnLimpiar.setOnAction(e -> limpiarCampos());

        HBox panelCampos = new HBox(10, txtNombre, txtPrecio, txtConsola);
        HBox panelBotones = new HBox(10, btnInsertar, btnActualizar, btnEliminar, btnLimpiar);

        TableColumn<Juego, Number> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()));

        TableColumn<Juego, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNombre()));
        colNombre.setPrefWidth(180);

        TableColumn<Juego, Number> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrecio()));

        TableColumn<Juego, String> colConsola = new TableColumn<>("Consola");
        colConsola.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getConsola()));
        colConsola.setPrefWidth(120);

        tablaJuegos.getColumns().addAll(colId, colNombre, colPrecio, colConsola);
        tablaJuegos.setItems(listaJuegos);

        tablaJuegos.getSelectionModel().selectedItemProperty().addListener((obs, anterior, actual) -> {
            if (actual != null) {
                idSeleccionado = actual.getId();
                txtNombre.setText(actual.getNombre());
                txtPrecio.setText(String.valueOf(actual.getPrecio()));
                txtConsola.setText(actual.getConsola());
            }
        });

        VBox root = new VBox(12, panelCampos, panelBotones, tablaJuegos);
        root.setPadding(new Insets(15));

        cargarJuegos();

        stage.setTitle("CRUD Juegos - Sin Patrón Arquitectónico");
        stage.setScene(new Scene(root, 550, 420));
        stage.show();
    }

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    private void cargarJuegos() {
        listaJuegos.clear();
        String sql = "SELECT id, nombre, precio, consola FROM JUEGOS ORDER BY id";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                listaJuegos.add(new Juego(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getString("consola")
                ));
            }
        } catch (SQLException e) {
            mostrarAlerta("Error de lectura", e.getMessage());
        }
    }

    private void insertarJuego() {
        String sql = "INSERT INTO JUEGOS (nombre, precio, consola) VALUES (?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, txtNombre.getText());
            pstmt.setDouble(2, Double.parseDouble(txtPrecio.getText()));
            pstmt.setString(3, txtConsola.getText());
            pstmt.executeUpdate();

            limpiarCampos();
            cargarJuegos();
        } catch (SQLException | NumberFormatException e) {
            mostrarAlerta("Error al insertar", "Verifica los datos ingresados: " + e.getMessage());
        }
    }

    private void actualizarJuego() {
        if (idSeleccionado == -1) {
            mostrarAlerta("Aviso", "Selecciona un juego de la tabla para actualizar.");
            return;
        }

        String sql = "UPDATE JUEGOS SET nombre = ?, precio = ?, consola = ? WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, txtNombre.getText());
            pstmt.setDouble(2, Double.parseDouble(txtPrecio.getText()));
            pstmt.setString(3, txtConsola.getText());
            pstmt.setInt(4, idSeleccionado);
            pstmt.executeUpdate();

            limpiarCampos();
            cargarJuegos();
        } catch (SQLException | NumberFormatException e) {
            mostrarAlerta("Error al actualizar", e.getMessage());
        }
    }

    private void eliminarJuego() {
        if (idSeleccionado == -1) {
            mostrarAlerta("Aviso", "Selecciona un juego de la tabla para eliminar.");
            return;
        }

        String sql = "DELETE FROM JUEGOS WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idSeleccionado);
            pstmt.executeUpdate();

            limpiarCampos();
            cargarJuegos();
        } catch (SQLException e) {
            mostrarAlerta("Error al eliminar", e.getMessage());
        }
    }

    private void limpiarCampos() {
        idSeleccionado = -1;
        txtNombre.clear();
        txtPrecio.clear();
        txtConsola.clear();
        tablaJuegos.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
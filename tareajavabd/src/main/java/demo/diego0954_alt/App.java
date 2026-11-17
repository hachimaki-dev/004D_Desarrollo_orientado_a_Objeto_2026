package demo.diego0954_alt;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{

        String origuen_conexion = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";
        String usuario_db = "usuario_desarrollador";
        String password_usuario_db = "123456";

    public static class juego{
        private int id;
        private String nombre;
        private double precio;
        private String consola;

        public juego(int id, String nombre, double precio, String consola) {
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
            this.consola = consola;
        }
        public int getId() {return id;}
        public String getNombre() {return nombre;}
        public double getPrecio() {return precio;}
        public String getConsola() {return consola;}       
    }

    public void start(Stage primaryStage) throws
    Exception{


        TextField txt_nombre = new TextField();
        TextField txt_precio = new TextField();
        TextField txt_consola = new TextField();

        Button btn_resgistrar = new Button("registrar");
        Button btn_actualizar = new Button("actualizar");
        Button btn_eliminar = new Button("eliminar");

        TableView<juego> tabla = new TableView<>();

        TableColumn<juego, Integer> col_id = new TableColumn<>("ID");
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<juego, String> col_nombre = new TableColumn<>("Nombre");
        col_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<juego, Double> col_precio = new TableColumn<>("Precio");
        col_precio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<juego, String> col_consola = new TableColumn<>("Consola");
        col_consola.setCellValueFactory(new PropertyValueFactory<>("consola"));

        tabla.getColumns().addAll(col_id, col_nombre, col_precio, col_consola);
        cargarJuegos(tabla);

        txt_nombre.setPromptText("nombre del juego");
        txt_precio.setPromptText("Precio (ej: 59.99)");
        txt_consola.setPromptText("Consola (ej: Switch)");

        // Al hacer click en una fila, sus datos pasan a los campos
        tabla.getSelectionModel().selectedItemProperty().addListener((obs, anterior, seleccionado) -> {
            if (seleccionado != null) {
                txt_nombre.setText(seleccionado.getNombre());
                txt_precio.setText(String.valueOf(seleccionado.getPrecio()));
                txt_consola.setText(seleccionado.getConsola());
            }
        });

        // INSERTAR
        btn_resgistrar.setOnAction(e -> {
            String sql = "INSERT INTO JUEGOS (nombre, precio, consola) VALUES (?, ?, ?)";
            try (Connection conn = DriverManager.getConnection(origuen_conexion, usuario_db, password_usuario_db);
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, txt_nombre.getText());
                ps.setDouble(2, Double.parseDouble(txt_precio.getText()));
                ps.setString(3, txt_consola.getText());
                ps.executeUpdate();

                txt_nombre.clear();
                txt_precio.clear();
                txt_consola.clear();
                cargarJuegos(tabla);
            } catch (Exception ex) {
                System.out.println("error al insertar: " + ex.getMessage());
            }
        });

        // ACTUALIZAR (primero selecciona una fila)
        btn_actualizar.setOnAction(e -> {
            juego seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado == null) {
                System.out.println("Selecciona un juego primero");
                return;
            }
            String sql = "UPDATE JUEGOS SET nombre = ?, precio = ?, consola = ? WHERE id = ?";
            try (Connection conn = DriverManager.getConnection(origuen_conexion, usuario_db, password_usuario_db);
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, txt_nombre.getText());
                ps.setDouble(2, Double.parseDouble(txt_precio.getText()));
                ps.setString(3, txt_consola.getText());
                ps.setInt(4, seleccionado.getId());
                ps.executeUpdate();

                cargarJuegos(tabla);
            } catch (Exception ex) {
                System.out.println("error al actualizar: " + ex.getMessage());
            }
        });

        // ELIMINAR (primero selecciona una fila)
        btn_eliminar.setOnAction(e -> {
            juego seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado == null) {
                System.out.println("Selecciona un juego primero");
                return;
            }
            String sql = "DELETE FROM JUEGOS WHERE id = ?";
            try (Connection conn = DriverManager.getConnection(origuen_conexion, usuario_db, password_usuario_db);
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, seleccionado.getId());
                ps.executeUpdate();

                txt_nombre.clear();
                txt_precio.clear();
                txt_consola.clear();
                cargarJuegos(tabla);
            } catch (Exception ex) {
                System.out.println("error al eliminar: " + ex.getMessage());
            }
        });

        HBox botones = new HBox(10, btn_resgistrar, btn_actualizar, btn_eliminar);
        VBox contenedor = new VBox(10, txt_nombre, txt_precio, txt_consola, botones, tabla);
        primaryStage.setScene(new Scene(contenedor, 720, 500));
        primaryStage.show();
    }
    public void cargarJuegos(TableView<juego> tabla){
        ObservableList<juego> lista = FXCollections.observableArrayList();
        try (Connection conn = DriverManager.getConnection(origuen_conexion, usuario_db, password_usuario_db);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM JUEGOS")) {

            while (rs.next()) {
                lista.add(new juego(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"), rs.getString("consola")));
            }
        } catch (Exception ex) {
            System.out.println("error de carga" + ex.getMessage());
        }
        tabla.setItems(lista);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.crimayorga.javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Con esto se puede hacer la conexion
        String origen_conexion ="jdbc:oracle:thin:@//localhost:1521/FREEPDB1";         
        String usuario_db = "usuario_desarrollador";                                    
        String password_usuario_db = "123456";                                          

        // Estos son los datos que se piden para cada juego
        TextField txf_nombre = new TextField();
        txf_nombre.setPromptText("Nombre del juego");                      
                                                                                
        TextField txf_precio = new TextField();                                 

        txf_precio.setPromptText("Precio");                             
        TextField txf_consola = new TextField();   
        txf_consola.setPromptText("Consola");

        // Botones
        Button btn_registrar = new Button("Registrar");                  
        Button btn_mostrar = new Button("Mostrar juegos");              
        Button btn_actualizar = new Button("Actualizar");              
        Button btn_eliminar = new Button("Eliminar");

        // Tabla visual
        TableView<Juego> tabla = new TableView<>();                     

        TableColumn<Juego, String> col_nombre =                         
                new TableColumn<>("Nombre");                      
        col_nombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre"));

        TableColumn<Juego, Double> col_precio =
                new TableColumn<>("Precio");
        col_precio.setCellValueFactory(
                new PropertyValueFactory<>("precio"));

        TableColumn<Juego, String> col_consola =
                new TableColumn<>("Consola");
        col_consola.setCellValueFactory(
                new PropertyValueFactory<>("consola"));

        tabla.getColumns().addAll(col_nombre, col_precio, col_consola);


        // Con esto se puede registrar un juego en la tabla
        btn_registrar.setOnAction(e -> {
            String sql = "INSERT INTO JUEGOS VALUES (?, ?, ?)";

            try (Connection conexion = DriverManager.getConnection(
                    origen_conexion, usuario_db, password_usuario_db);
                 PreparedStatement ps = conexion.prepareStatement(sql)) {

                ps.setString(1, txf_nombre.getText());
                ps.setDouble(2,
                        Double.parseDouble(txf_precio.getText()));
                ps.setString(3, txf_consola.getText());

                ps.executeUpdate();
                System.out.println("Juego registrado");

            } catch (Exception ex) {
                System.out.println("Error al registrar: "
                        + ex.getMessage());
            }
        });

        // Con esto se puede mostrar la tabla con los juegos
        btn_mostrar.setOnAction(e -> {
            ObservableList<Juego> juegos =
                    FXCollections.observableArrayList();

            try (Connection conexion = DriverManager.getConnection(
                    origen_conexion, usuario_db, password_usuario_db);
                 PreparedStatement ps = conexion.prepareStatement(
                         "SELECT * FROM JUEGOS");
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    juegos.add(new Juego(
                            rs.getString("NOMBRE"),
                            rs.getDouble("PRECIO"),
                            rs.getString("CONSOLA")));
                }

                tabla.setItems(juegos);

            } catch (Exception ex) {
                System.out.println("Error al mostrar: "
                        + ex.getMessage());
            }
        });

        // Con esto se puede actualizar un juego de la tabla
        btn_actualizar.setOnAction(e -> {
            String sql = "UPDATE JUEGOS SET PRECIO = ?, "
                    + "CONSOLA = ? WHERE NOMBRE = ?";

            try (Connection conexion = DriverManager.getConnection(
                    origen_conexion, usuario_db, password_usuario_db);
                 PreparedStatement ps =
                         conexion.prepareStatement(sql)) {

                ps.setDouble(1,
                        Double.parseDouble(txf_precio.getText()));
                ps.setString(2, txf_consola.getText());
                ps.setString(3, txf_nombre.getText());

                ps.executeUpdate();
                System.out.println("Juego actualizado");

            } catch (Exception ex) {
                System.out.println("Error al actualizar: "
                        + ex.getMessage());
            }
        });

        // Con esto se puede eliminar un juego de la tabla
        btn_eliminar.setOnAction(e -> {
            String sql = "DELETE FROM JUEGOS WHERE NOMBRE = ?";

            try (Connection conexion = DriverManager.getConnection(
                    origen_conexion, usuario_db, password_usuario_db);
                 PreparedStatement ps =
                         conexion.prepareStatement(sql)) {

                ps.setString(1, txf_nombre.getText());

                ps.executeUpdate();
                System.out.println("Juego eliminado");

            } catch (Exception ex) {
                System.out.println("Error al eliminar: "
                        + ex.getMessage());
            }
        });

        // Con esto se puede seleccionar un juego de la tabla
        tabla.setOnMouseClicked(e -> {
            Juego juego = tabla.getSelectionModel().getSelectedItem();

            if (juego != null) {
                txf_nombre.setText(juego.getNombre());
                txf_precio.setText(
                        String.valueOf(juego.getPrecio()));
                txf_consola.setText(juego.getConsola());
            }
        });

        // Inteferfaz grafica de los juegos
        VBox contenedor = new VBox(10,txf_nombre,txf_precio,txf_consola,btn_registrar,btn_mostrar,btn_actualizar,btn_eliminar,tabla);

        Scene escena = new Scene(contenedor, 720, 500);

        primaryStage.setTitle("Gestion de videojuegos");
        primaryStage.setScene(escena);
        primaryStage.show();
    }

    public static class Juego {
        private String nombre;
        private double precio;
        private String consola;

        public Juego(String nombre, double precio, String consola) {
            this.nombre = nombre;
            this.precio = precio;
            this.consola = consola;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public String getConsola() {
            return consola;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
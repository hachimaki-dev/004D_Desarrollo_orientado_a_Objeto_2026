package com.amaro.javadb;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.text.TableView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField txf_nombre_juego = new TextField();
        TextField txf_precio_juego = new TextField();
        TextField txf_consola_juego = new TextField();
        Button btn_registrar = new Button("Registrar");
        Button btn_actualizar = new Button("Actualizar");
        Button btn_eliminar = new Button("Eliminar");
        Label lbl_estado = new Label("Listo para registrar");
        // Aca vamos a crear toda la lógica de nuestra App
        // Paso 1. Crear conxión
        // Cosas importantes: ¿Dónde y con quién me conecto y acceso?
        String origen_conexion = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String usuario_db = "usuario_desarrollador";
        String passwd_usuario_db = "123456";

        // Paso 2. Proceso INSERT
        btn_registrar.setOnAction(e -> {
            String nombre_capturado = txf_nombre_juego.getText();
            int precio_capturado = txf_precio_juego.getLength();
            String consola_capturado = txf_consola_juego.getText();
            try {
                DriverManager.getConnection(origen_conexion, usuario_db, passwd_usuario_db).isValid(2);
                String insertar_datos_sql = "INSERT INTO JUEGOS (nombre, precio, consola) VALUES ('"+ nombre_capturado + "' "+ precio_capturado +" '"+ consola_capturado +"')";
                try {
                    DriverManager.getConnection(origen_conexion, usuario_db, passwd_usuario_db).prepareStatement(insertar_datos_sql).executeUpdate();
                    System.out.println("Datos insertados correctamente");
                } catch (Exception ex) {
                    System.out.println("No se insertó la consulta");
                }
            } catch (Exception ex) {
                System.out.println("No se pudo establecer la conexión");
            }
        });

        // Paso 3. Proceso SELECT
        public VBox crearTablaDatos() {
            TableView<String> tablaDatos = new TableView<>();
            String nombre_capturado = txf_nombre_juego.getText();
            int precio_capturado = txf_precio_juego.getLength();
            String consola_capturado = txf_consola_juego.getText();
            try {
                DriverManager.getConnection(origen_conexion, usuario_db, passwd_usuario_db).isValid(2);
                String seleccionar_datos_sql = "SELECT "+ nombre_capturado +", "+ precio_capturado +", "+ consola_capturado + " FROM JUEGOS ORDER BY id ASC;";
                try {
                    DriverManager.getConnection(origen_conexion, usuario_db, passwd_usuario_db).prepareStatement(seleccionar_datos_sql).executeQuery();
                    while(DriverManager.getConnection(origen_conexion, usuario_db, passwd_usuario_db).prepareStatement(seleccionar_datos_sql).executeQuery().next()) {
                        DriverManager.getConnection(origen_conexion, usuario_db, passwd_usuario_db).prepareStatement(seleccionar_datos_sql).executeQuery().getString("nombre");
                        DriverManager.getConnection(origen_conexion, usuario_db, passwd_usuario_db).prepareStatement(seleccionar_datos_sql).executeQuery().getInt("precio");
                        DriverManager.getConnection(origen_conexion, usuario_db, passwd_usuario_db).prepareStatement(seleccionar_datos_sql).executeQuery().getString("consola");
                        tablaDatos.getItems();
                    }
                } catch (SQLException e) {
                    System.out.println("Error al actualizar JUEGOS " + e.getMessage());
                } 
            } catch (Exception ex) {
                System.out.println("No se pudo establecer la conexión");
            }
        };

        // Paso 4. Proceso UPDATE
        btn_actualizar.setOnAction(e -> {
            String nombre_capturado = txf_nombre_juego.getText();
            int precio_capturado = txf_precio_juego.getLength();
            String consola_capturado = txf_consola_juego.getText();
            try {
                DriverManager.getConnection(origen_conexion, usuario_db, passwd_usuario_db).isValid(2);
                String actualizar_datos_sql = "UPDATE JUEGOS SET nombre = '"+ nombre_capturado +"' , precio = " + precio_capturado +", consola = '"+ consola_capturado +"'";
                try {
                    DriverManager.getConnection(origen_conexion, usuario_db, passwd_usuario_db).prepareStatement(actualizar_datos_sql).executeUpdate();
                    System.out.println("Datos actualizados correctamente");
                } catch (Exception ex) {
                    System.out.println("No se actualizó la consulta");
                }
            } catch (Exception ex) {
                System.out.println("No se pudo establecer la conexión");
            }
        });

        // Paso 5. Proceso DELETE
        btn_eliminar.setOnAction(e -> {
            String nombre_capturado = txf_nombre_juego.getText();
            try {
                DriverManager.getConnection(origen_conexion, usuario_db, passwd_usuario_db).isValid(2);
                String eliminar_datos_sql = "DELETE FROM JUEGOS WHERE nombre = '"+ nombre_capturado +"'";
                try {
                    DriverManager.getConnection(origen_conexion, usuario_db, passwd_usuario_db).prepareStatement(eliminar_datos_sql).executeUpdate();
                    System.out.println("Datos eliminados correctamente");
                } catch (Exception ex) {
                    System.out.println("No se eliminó la consulta");
                }
            } catch (Exception ex) {
                System.out.println("No se pudo establecer la conexión");
            }
        });
    // Aca termina toda la lógica de nuestra App
    VBox contenedor_textfields = new VBox(10, txf_nombre_juego, txf_precio_juego, txf_consola_juego, lbl_estado);
    VBox contenedor_botones = new VBox(10, btn_registrar, btn_actualizar, btn_eliminar);
    VBox contenedor_principal = new VBox(contenedor_textfields, contenedor_botones);
    Scene escena_principal = new Scene(contenedor_principal, 720, 400);
    primaryStage.setScene(escena_principal);
    primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.goxzero8.javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.ResultSet;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        
        TextField txt_nombre = new TextField();
        txt_nombre.setPromptText("Ingrese su nombre");

        Button btn_registrar = new Button("Registrar usuario");

        Button imprimir_datos_en_consola = new Button("Imprimir datos en consola");

        Button Actualizar_datos_en_consola = new Button("Actualizar datos en consola");


        Label lbl_estado = new Label("Listo para registrar.");


        String origen_conexion = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";; // 1 
        String usuario_db = "usuario_desarrollador"; // 2
        String password_usuario_db = "123456";  // 3

    
        btn_registrar.setOnAction(e -> {

            String nombre = txt_nombre.getText();

            if (nombre.isEmpty()) {
                lbl_estado.setText("Ingrese un nombre primero.");
                return;
            }

            String sql = "INSERT INTO TEST(nombre) VALUES (?)";

            try (
                Connection conexion = DriverManager.getConnection(
                    origen_conexion,
                    usuario_db,
                    password_usuario_db
                );

                PreparedStatement ps = conexion.prepareStatement(sql)
            ) {

                ps.setString(1, nombre);

                int filasAfectadas = ps.executeUpdate();

                if (filasAfectadas > 0) {
                    lbl_estado.setText("Usuario registrado correctamente.");
                    txt_nombre.clear();
                }

            } catch (SQLException ex) {
                lbl_estado.setText("Error al registrar: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        imprimir_datos_en_consola.setOnAction(presionaron_el_boton -> {

        });


        Actualizar_datos_en_consola.setOnAction(presionaron_el_boton -> {

        });

        


       
        // Construcción de la interfaz
        VBox contenedor = new VBox(15,
            txt_nombre,
            btn_registrar,
            lbl_estado,
            imprimir_datos_en_consola,
            Actualizar_datos_en_consola
            
        );

        contenedor.setStyle("-fx-padding: 20;");

        Scene escena_principal = new Scene(contenedor, 720, 400);

        primaryStage.setTitle("JavaDB - Registro de usuarios");
        primaryStage.setScene(escena_principal);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

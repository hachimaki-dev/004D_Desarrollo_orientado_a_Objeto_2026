package com.tab.javadb;

import java.sql.DriverManager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button btn_registrar = new Button("Registrar");
        Button btn_actualizar = new Button("Actualizar");
        Button btn_eliminar = new Button("Eliminar");

        // Inicio

        String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";

        String USER = "usuario_desarrollador";

        String PASS = "123456";

        TextField txf_nombre = new TextField();

        btn_registrar.setOnAction(e -> {
            try {
                DriverManager.getConnection(URL, USER, PASS).isValid(2);
                String nombre_insertado = txf_nombre.getText();

                String insertar_datos = "INSERT INTO TEST(nombre) VALUES ('" + nombre_insertado + "')";

                try {
                    DriverManager.getConnection(URL, USER, PASS).prepareStatement(insertar_datos).executeUpdate();
                    System.out.println("Los datos fueron insertados");
                } catch (Exception f) {
                    System.out.println("No se pudo realizar la acción");
                }

            } catch (Exception m) {
                System.out.println("No se pudo establecer la conexión");
            }
        });

        // Fin

        HBox hbox_campo_registro = new HBox(10, txf_nombre, btn_registrar);

        VBox vbox_contenedor_apartados = new VBox(hbox_campo_registro);

        Scene escena_principal = new Scene(vbox_contenedor_apartados, 720, 480);

        stage.setScene(escena_principal);

        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

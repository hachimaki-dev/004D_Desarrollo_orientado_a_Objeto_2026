package com.tokaibenja.javadb;
import java.sql.DriverManager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        Button btn_registrar = new Button("REGISTRAR");

        

        String origenConexion = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String usuariodb = "usuario_desarrollador";
        String password = "123456";
        TextField txfUsuario = new TextField();
        TextField txfApellido = new TextField();
        txfUsuario.setPromptText("Ingresa el nombre de usuario");
        txfApellido.setPromptText("Ingresa el apellido del usuario");

        VBox contenedorBotones = new VBox(btn_registrar, txfUsuario, txfApellido);

        Scene escena = new Scene(contenedorBotones, 720, 400);

        primaryStage.setScene(escena);
        primaryStage.show();

        btn_registrar.setOnAction(e ->{

        try {
            String nombre = txfUsuario.getText();
            String apellido = txfApellido.getText();
            DriverManager.getConnection(origenConexion, usuariodb, password).isValid(2);
            String insertarDatos = "INSERT INTO TEST(nombre, apellido) VALUES ('" + nombre + "','" + apellido + "')";
            System.out.println("Conectado");
            try {
                DriverManager.getConnection(origenConexion, usuariodb, password).prepareStatement(insertarDatos).executeUpdate();
                
            } catch (Exception ex) {
                System.err.println("La consulta no se inserto.");
                // TODO: handle exception
            }

            
        } catch (Exception exc) {
            System.err.println("No se pudo establecer la conexion ");}
            // TODO: handle exception
        

        });
    }



        public static void main(String[] args) {
            launch(args);
        }
    
}

package com.tokaibenja.javadb;
import java.sql.DriverManager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;


public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        Button btn_registrar = new Button("REGISTRAR");
        Button btn_remover = new Button("REMOVER");
        Button btn_actualizar = new Button("ACTUALIZAR");
        System.out.println("Me duele la cabeza, no quiero volver a trabajar de esta manera.");

        

        String origenConexion = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";

        String usuariodb = "usuario_desarrollador";
        String password = "contraseña";
        TextField txfJuego = new TextField();
        TextField txfPrecio = new TextField();
        TextField txfConsola = new TextField();
        TextField txfidABuscar = new TextField();
        ObservableList<String[]> listaJuegos = FXCollections.observableArrayList();
        txfJuego.setPromptText("Ingresa el nombre del juego");
        txfPrecio.setPromptText("Ingresa el precio del juego");
        txfConsola.setPromptText("Ingresa el nombre de la consola");
        txfidABuscar.setPromptText("Ingresa el id del juego");

        TableView<String[]> tablajuegos = new TableView<>();
        TableColumn<String[], String> colId = new TableColumn<>("ID");
        TableColumn<String[], String> colNombre = new TableColumn<>("Nombre");
        TableColumn<String[], String> colPrecio = new TableColumn<>("Precio");
        TableColumn<String[], String> colConsola = new TableColumn<>("Consola");
        colId.setCellValueFactory(e -> new javafx.beans.property.SimpleStringProperty(e.getValue()[0]));
        colNombre.setCellValueFactory(e -> new javafx.beans.property.SimpleStringProperty(e.getValue()[1]));
        colPrecio.setCellValueFactory(e -> new javafx.beans.property.SimpleStringProperty(e.getValue()[2]));
        colConsola.setCellValueFactory(e -> new javafx.beans.property.SimpleStringProperty(e.getValue()[3]));
        tablajuegos.getColumns().addAll(colId, colNombre, colPrecio, colConsola);

        try {
            ResultSet resultado = DriverManager.getConnection(origenConexion, usuariodb, password).prepareStatement("SELECT * FROM JUEGOS").executeQuery();

            while (resultado.next()){
                String[] juego = {
                    resultado.getString("id"),
                    resultado.getString("nombre"),
                    resultado.getString("precio"),
                    resultado.getString("consola")
                };

                listaJuegos.add(juego);
            }

            tablajuegos.setItems(listaJuegos);

            
        } catch (Exception e) {
            // TODO: handle exception
        }



        ComboBox cmbTipo = new ComboBox<>();
        cmbTipo.getItems().addAll("Agregar", "Actualizar", "Remover");
        cmbTipo.setValue("Agregar");

        VBox camposAgregar = new VBox(btn_registrar, txfJuego, txfPrecio, txfConsola);
        VBox camposRemover = new VBox(btn_remover, txfidABuscar);

        VBox camposActualizar = new VBox(btn_actualizar, txfidABuscar, txfJuego, txfPrecio, txfConsola);

        
        camposAgregar.setVisible(true);
        camposAgregar.setManaged(true);

        camposRemover.setVisible(false);
        camposRemover.setManaged(false);

        camposActualizar.setVisible(false);
        camposActualizar.setManaged(false);


        cmbTipo.setOnAction(e -> {
            boolean esJuego = cmbTipo.getValue().equals("Agregar");
            boolean esActualizar = cmbTipo.getValue().equals("Actualizar");
            boolean esRemover= cmbTipo.getValue().equals("Remover");

            camposAgregar.setVisible(esJuego);
            camposAgregar.setManaged(esJuego);

            camposActualizar.setVisible(esActualizar);
            camposActualizar.setManaged(esActualizar);

            camposRemover.setVisible(esRemover);
            camposRemover.setManaged(esRemover);
        });


        VBox formulario = new VBox(cmbTipo, camposAgregar, camposActualizar, camposRemover, tablajuegos);
        Scene escena = new Scene(formulario, 720, 400);

        primaryStage.setScene(escena);
        primaryStage.show();


        btn_remover.setOnAction(e ->{
            try {
                int idAEliminar = Integer.parseInt(txfidABuscar.getText()); 
                
                DriverManager.getConnection(origenConexion, usuariodb, password).isValid(2);
                String removerDatos = "DELETE FROM JUEGOS WHERE id = " + idAEliminar;
                try {
                    DriverManager.getConnection(origenConexion, usuariodb, password).prepareStatement(removerDatos).executeUpdate();
                    Alert alerta = new Alert(AlertType.INFORMATION);
                    alerta.setTitle("EXITO");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Se ha eliminado el juego");
                    alerta.showAndWait();
                    listaJuegos.clear();
                    ResultSet resultado = DriverManager.getConnection(origenConexion, usuariodb, password)
        .prepareStatement("SELECT * FROM JUEGOS").executeQuery();

while (resultado.next()) {
    String[] juego = {
        resultado.getString("id"),
        resultado.getString("nombre"),
        resultado.getString("precio"),
        resultado.getString("consola")
    };

    listaJuegos.add(juego);
}
                
            }   catch (Exception ex) {
                Alert alerta = new Alert(AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText(null);
                alerta.setContentText("No se ha podido eliminar los datos.");
                alerta.showAndWait();
                // TODO: handle exception
            }
                
            } catch (Exception ex) {
                // TODO: handle exception
            }
        });



        btn_actualizar.setOnAction(e ->{
            try {
                int idActualizar = Integer.parseInt(txfidABuscar.getText()); 
                String juego = txfJuego.getText();
                int precio = Integer.parseInt(txfPrecio.getText());
                String consola = txfConsola.getText();
                
                DriverManager.getConnection(origenConexion, usuariodb, password).isValid(2);
                String actualizarDatos = "UPDATE JUEGOS SET nombre = '" + juego + "', precio = " + precio + ", consola = '" + consola + "' WHERE id = " + idActualizar;
                try {
                    DriverManager.getConnection(origenConexion, usuariodb, password).prepareStatement(actualizarDatos).executeUpdate();
                    
                    
                    Alert alerta = new Alert(AlertType.INFORMATION);
                    alerta.setTitle("EXITO");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Se ha actualizado el juego");
                    alerta.showAndWait();
                    listaJuegos.clear();
                    ResultSet resultado = DriverManager.getConnection(origenConexion, usuariodb, password)
        .prepareStatement("SELECT * FROM JUEGOS").executeQuery();

while (resultado.next()) {
    String[] juego3 = {
        resultado.getString("id"),
        resultado.getString("nombre"),
        resultado.getString("precio"),
        resultado.getString("consola")
    };

    listaJuegos.add(juego3);
}
                
            }   catch (Exception ex) {
                Alert alerta = new Alert(AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText(null);
                alerta.setContentText("No se ha podido actualizar los datos.");
                alerta.showAndWait();
                // TODO: handle exception
            }
                
            } catch (Exception ex) {
                // TODO: handle exception
            }
        });

        btn_registrar.setOnAction(e ->{

        try {
            String juego = txfJuego.getText();
            String consola = txfConsola.getText();
            int precio = Integer.parseInt(txfPrecio.getText());
            DriverManager.getConnection(origenConexion, usuariodb, password).isValid(2);
            String insertarDatos = "INSERT INTO JUEGOS(nombre, precio ,consola) VALUES ('" + juego + "','" + precio + "','" + consola + "')";
            try {
                DriverManager.getConnection(origenConexion, usuariodb, password).prepareStatement(insertarDatos).executeUpdate();
                Alert alerta = new Alert(AlertType.INFORMATION);
                alerta.setTitle("EXITO");
                alerta.setHeaderText(null);
                alerta.setContentText("Se han insertado los datos.");
                alerta.showAndWait();
                    listaJuegos.clear();
                    ResultSet resultado = DriverManager.getConnection(origenConexion, usuariodb, password)
        .prepareStatement("SELECT * FROM JUEGOS").executeQuery();

while (resultado.next()) {
    String[] juego1 = {
        resultado.getString("id"),
        resultado.getString("nombre"),
        resultado.getString("precio"),
        resultado.getString("consola")
    };

    listaJuegos.add(juego1);
}
                
                
            } catch (Exception ex) {
                Alert alerta = new Alert(AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText(null);
                alerta.setContentText("No se ha podido insertar los datos.");
                alerta.showAndWait();
                // TODO: handle exception
            }

            
        } catch (Exception exc) {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("No se ha podido establecer conexión con la base de datos.");
            alerta.showAndWait();
            
            // TODO: handle exception
        

        
    }})
        ;
    }



        public static void main(String[] args) {
            launch(args);
        }
    
}

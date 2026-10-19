package com.tab.biblioapp.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Homeview {
    
    public Scene homeScene(){
        
        Label lbl_userRUT = new Label("RUT: ");
        TextField txf_userRUT = new TextField();
        txf_userRUT.setPromptText("Ej: 00.000.000-0");
        Button btn_busqueda_user = new Button("Buscar");

        HBox hbox_busqueda_user = new HBox(10, lbl_userRUT, txf_userRUT, btn_busqueda_user);
        

        Label lbl_user_dataRUT = new Label("Rut: __________");
        Label lbl_user_datanombre = new Label("Nombre: __________");
        Label lbl_user_dataemail = new Label("Email: __________");
        Label lbl_user_dataedad = new Label("Edad: __________");
        Label lbl_user_dataprestamos = new Label("¿Puede solicitar libros?: __________");

        VBox vbox_user_informacion = new VBox(lbl_user_dataRUT, lbl_user_datanombre, lbl_user_dataemail, lbl_user_dataedad, lbl_user_dataprestamos);


        VBox vbox_home = new VBox(20, hbox_busqueda_user, vbox_user_informacion);

        Scene home_scene = new Scene(vbox_home, 800, 600);

        return home_scene;
    }
}

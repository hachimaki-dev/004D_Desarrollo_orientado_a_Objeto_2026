package com.streamhub.view;
import com.streamhub.controller.UsuarioController;
import com.streamhub.model.Usuario;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UserDataView {

    public VBox userData(){
        UsuarioController controller =  new UsuarioController();
        Label lbl_user_rut = new Label("Rut del usuario: ");
        TextField txf_user_rut = new TextField();
        txf_user_rut.setPromptText("Ej: 11.111.111-1");
        Button btn_buscar = new Button("Buscar");

        Label lbl_resultado = new Label();
        Label lbl_rut = new Label("RUT: -");
        Label lbl_nombre = new Label("Nombre: -");
        Label lbl_correo = new Label("Correo: -");
        Label lbl_plan = new Label("Plan: -");

        btn_buscar.setOnAction(e ->{
            lbl_rut.setText("RUT: -");
            lbl_nombre.setText("Nombre: -");
            lbl_correo.setText("Correo: -");
            lbl_plan.setText("Plan: -");
            
            String rut_ingresado = txf_user_rut.getText();

            if (!controller.datos_disponibles()){
                lbl_resultado.setText("No se pudieron cargar los datos");

            }
            else if (rut_ingresado.isBlank()){
                lbl_resultado.setText("escribe un rut antes de buscar");
            }
            else{
                Usuario usuario = controller.buscarUsuario(rut_ingresado);
            
                if(usuario != null){
                lbl_resultado.setText("Usuario encontrado.");
                lbl_rut.setText("RUT: " + usuario.getRut());
                lbl_nombre.setText("Nombre: " + usuario.getNombre());
                lbl_correo.setText("Correo: " + usuario.getEmail());
                lbl_plan.setText("plan: " + usuario.getPlan());
            }

                else{
                    lbl_resultado.setText("usuario no encontrado");
                }
            }
            });
            
            
            
        

        HBox fila_busqueda = new HBox(10, lbl_user_rut, txf_user_rut, btn_buscar);
        VBox box = new VBox(10, fila_busqueda, lbl_resultado, lbl_rut, lbl_nombre, lbl_correo, lbl_plan);
        box.setPadding(new Insets(20));

        return box;
    
        

    }
    
}

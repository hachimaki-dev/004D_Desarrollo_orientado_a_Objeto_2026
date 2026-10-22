package com.hachimakidev.bibliotech.view;
import com.hachimakidev.bibliotech.controller.UserController;
import com.hachimakidev.bibliotech.model.User;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class UserDataView {

    public VBox userData(Runnable IrABuscarLibros){
        UserController controller = new UserController();

        Label lbl_user_rut = new Label("RUT del usuario:");
        TextField txf_user_rut = new TextField();
        txf_user_rut.setPromptText("Ej: 12345678-9");
        Button btn_buscar = new Button("Buscar");
        Button buscar_libro = new Button("BUSCAR LIBRO");
        
        buscar_libro.setOnAction(e -> IrABuscarLibros.run());

       

        Label lbl_resultado = new Label();
        Label lbl_rut = new Label("RUT: -");
        Label lbl_nombre = new Label("Nombre: -");
        Label lbl_correo = new Label("Correo: -");
        Label lbl_edad = new Label("Edad: -");
        Label prestamo = new Label("Permiso de prestamo: -");

        btn_buscar.setOnAction(e ->{
            lbl_rut.setText("RUT: -");
            lbl_nombre.setText("Nombre: -");
            lbl_correo.setText("Correo: -");

            String rut_ingresado = txf_user_rut.getText();

            if (!controller.datosDisponibles()){
                lbl_resultado.setText("ERROR: No se pudieron cargar los datos!");
            }
            else if (rut_ingresado.isBlank()){
                lbl_resultado.setText("Escribe un RUT antes de buscar!");
            }
            else{
                User usuario = controller.buscarUsuario(rut_ingresado);

                if (usuario != null){
                    lbl_resultado.setText("Usuario encontrado.");
                    lbl_rut.setText("RUT: " + usuario.getRut());
                    lbl_nombre.setText("Nombre: " + usuario.getNombre());
                    lbl_correo.setText("Correo: " + usuario.getCorreo());
                    lbl_edad.setText("Edad: " + usuario.getEdad());
                   
                    if (usuario.getPuedeSolicitar() == true){
                        prestamo.setText("Permiso de prestamo: SI");

                    }
                
                    else{
                        prestamo.setText("Permiso de prestamo: NO");
                    };


                }
                else{
                    lbl_resultado.setText("Usuario no encontrado.");
                }
            }
        });

        HBox fila_busqueda = new HBox(10, lbl_user_rut, txf_user_rut, btn_buscar);
        VBox box = new VBox(10, fila_busqueda, lbl_resultado, lbl_rut, lbl_nombre, lbl_correo, lbl_edad, prestamo, buscar_libro);
        box.setPadding(new Insets(20));

        return box;

    }
    
}

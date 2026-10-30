package com.hachimakidev.techstore.view;

import com.hachimakidev.techstore.controller.DispositivoController;
import com.hachimakidev.techstore.model.Dispositivo;
import com.hachimakidev.techstore.model.Notebook;
import com.hachimakidev.techstore.model.Smartphone;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;;

public class CatalogoView {
    @SuppressWarnings("unchecked")
    public VBox catalogo() {

        DispositivoController dispositocontroller = new DispositivoController();

        Label lbl_titulo = new Label("TechStore — Catálogo de Notebooks y Smartphones");
        lbl_titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        
        TableView<Dispositivo> tabla_view = new TableView<>();

        TableColumn<Dispositivo , Integer> colId = new TableColumn<>("Id");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Dispositivo , String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        TableColumn<Dispositivo , String> colMarca = new TableColumn<>("Marca");
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

        TableColumn<Dispositivo , String> colModelo = new TableColumn<>("Modelo");
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        TableColumn<Dispositivo , Integer> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<Dispositivo , String> colEspecificacion = new  TableColumn<>("Especificacion");
        colEspecificacion.setCellValueFactory(new PropertyValueFactory<>("especificacion"));

        
        tabla_view.getColumns().addAll(colId , colTipo , colMarca , colModelo , colPrecio , colEspecificacion );

        tabla_view.setItems(FXCollections.observableArrayList(dispositocontroller.obtenerdispositivos()));


        ComboBox<String> cmdTipo = new ComboBox<>(); 
        cmdTipo.getItems().addAll("Notebook"  , "Smartphone");
        cmdTipo.setValue("Notebook");

        Label lbl_marca = new Label("Marca : ");
        TextField txt_marca = new TextField();

        Label lbl_modelo = new Label("Modelo : ");
        TextField txt_modelo = new TextField();

        Label lbl_precio = new Label("Precio :  ");
        TextField txt_precio = new TextField();

        Label lblRamGb = new Label("RAM (GB) - Solo Notebook :  ");
        TextField txtRamGb = new TextField();
            
        Label lblProcesador = new Label("Procesador - Solo Notebook :");
        TextField txtProcesador = new TextField();
            
        Label lblAlmacenamientoGb = new Label("Almacenamiento (GB) - Solo Smartphone:");
        TextField txtAlmacenamientoGb = new TextField();
            
        Label lblCamaraMp = new Label("Cámara (MP) - Solo Smartphone :");
        TextField txtCamaraMp = new TextField();
        
        HBox campoTipo = new HBox(10 , new Label("Tipo Dispositivo :") , cmdTipo);
        HBox campoMarca = new HBox(10 ,lbl_marca , txt_marca);
        HBox campoModelo = new HBox(10 ,lbl_modelo , txt_modelo);
        HBox campoPrecio = new HBox(10 ,lbl_precio , txt_precio);

        HBox formulario_campos_comunes = new HBox(10 , campoTipo , campoMarca , campoModelo , campoPrecio);


        HBox campoRam = new HBox(10 ,lblRamGb , txtRamGb);
        HBox campoProcesador = new HBox(10 ,lblProcesador , txtProcesador);
        HBox campoAlmacenamiento = new HBox(10 ,lblAlmacenamientoGb , txtAlmacenamientoGb);
        HBox campoCamara = new HBox(10 ,lblCamaraMp , txtCamaraMp);

        HBox formulario_campos_especificos_Notebook = new HBox(10 , campoRam , campoProcesador);
        HBox formulario_campos_especificos_Smartphone = new HBox(10 , campoAlmacenamiento , campoCamara);

        Button btn_agregar = new Button("Agregar Dispositivo");

        btn_agregar.setOnAction(e -> {
            try{
                String tipo_seleccionado = cmdTipo.getValue();

                String marca = txt_marca.getText();
                String modelo = txt_modelo.getText();
                int precio = Integer.parseInt(txt_precio.getText());

                int nuevoId = dispositocontroller.obtenerdispositivos().size() + 1 ;

                if ("Notebook".equalsIgnoreCase(tipo_seleccionado)) {
                    
                    int ramGB = Integer.parseInt(txtRamGb.getText());
                    String procesador = txtProcesador.getText();

                    Notebook ntb = new Notebook(nuevoId , marca , modelo , precio , true ,  ramGB , procesador);
                    dispositocontroller.agregar_dispositivo(ntb);
                }else if ("Smartphone".equalsIgnoreCase(tipo_seleccionado)) {
                    
                    int almacenamiento = Integer.parseInt(txtAlmacenamientoGb.getText());
                    int camara = Integer.parseInt(txtCamaraMp.getText());

                    Smartphone sp = new Smartphone(nuevoId , marca , modelo , precio , true ,  almacenamiento , camara);
                    dispositocontroller.agregar_dispositivo(sp);
                }

                tabla_view.setItems(FXCollections.observableArrayList(dispositocontroller.obtenerdispositivos()));

                txt_marca.clear();
                txt_modelo.clear();
                txt_precio.clear();
                txtRamGb.clear();
                txtProcesador.clear();
                txtAlmacenamientoGb.clear();
                txtCamaraMp.clear();

                
            } catch (NumberFormatException ex) {
                System.out.println("Error : Asegurese de Ingresar los datos correctos y Rellenar los campos espeficos del Tipo de dispositivo Elegido");
            }
        }); 

        VBox pantalla_principal = new VBox(15 , lbl_titulo , tabla_view , formulario_campos_comunes , formulario_campos_especificos_Notebook , formulario_campos_especificos_Smartphone , btn_agregar);
        pantalla_principal.setPadding(new Insets(15));
        
        return pantalla_principal;
    }
}
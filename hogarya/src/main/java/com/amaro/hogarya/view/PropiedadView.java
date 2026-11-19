package com.amaro.hogarya.view;

import com.amaro.hogarya.controller.PropiedadController;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PropiedadView {
    private PropiedadController controller;
    private TableView<Propiedad> tablaUsuarios;
    private TextField txtUsername;
    private TextField txtCorreo;
    private PasswordField txtPassword;
    private ComboBox<String> cmbRol;
    private Label lblEstado;

    // Guarda el ID de la fila seleccionada en la tabla (-1 indica que no hay selección)
    private int idSeleccionado = -1;

}

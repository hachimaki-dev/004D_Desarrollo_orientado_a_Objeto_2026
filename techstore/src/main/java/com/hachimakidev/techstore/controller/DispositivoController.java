package com.hachimakidev.techstore.controller;

import java.util.ArrayList;

import com.hachimakidev.techstore.model.Dispositivo;

public class DispositivoController {
    private DispositivoController dispoController;

    public DispositivoController() {
        dispoController = new DispositivoController();
    }

    public ArrayList<Dispositivo> getDispositivo() {
        return dispoController.getDispositivo();
    }

    // TODO 1: Instanciar DispositivoManager como atributo del controlador.

    // TODO 2: Crear el método que retorne la lista de dispositivos desde el manager hacia la vista.

    // TODO 3: Crear el método para validar y agregar un nuevo Notebook o Smartphone a la lista del manager.

}


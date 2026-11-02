package com.hachimakidev.techstore.controller;

import java.util.ArrayList;

import com.hachimakidev.techstore.model.Dispositivo;
import com.hachimakidev.techstore.model.DispositivoManager;
import com.hachimakidev.techstore.model.Notebook;
import com.hachimakidev.techstore.model.Smartphone;


public class DispositivoController {

    private DispositivoManager manager = new DispositivoManager();

    public DispositivoController(){
        manager = new DispositivoManager();
    }

    public ArrayList<Dispositivo> obtenerDispositivos(){
        return manager.getDispositivos();
    }
// Para agregar un Notebook
    public void agregarNotebook(String marca, String modelo, int precio, boolean disponible, int ramGb, String procesador) {
        int nuevoId = manager.getDispositivos().size() + 1;
        Notebook nb = new Notebook(nuevoId, marca, modelo, precio, disponible, ramGb, procesador);
        manager.agregarDispositivo(nb);
    }

    // Para agregar un Smartphone
    public void agregarSmartphone(String marca, String modelo, int precio, boolean disponible, int almacenamientoGb, int camaraMp) {
        int nuevoId = manager.getDispositivos().size() + 1;
        Smartphone sp = new Smartphone(nuevoId, marca, modelo, precio, disponible, almacenamientoGb, camaraMp);
        manager.agregarDispositivo(sp);
}

    // TODO 1: Instanciar DispositivoManager como atributo del controlador.

    // TODO 2: Crear el método que retorne la lista de dispositivos desde el manager hacia la vista.

    // TODO 3: Crear el método para validar y agregar un nuevo Notebook o Smartphone a la lista del manager.

}


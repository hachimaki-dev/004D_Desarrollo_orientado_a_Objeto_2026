package com.hachimakidev.techstore.controller;

import com.hachimakidev.techstore.model.DispositivoManager;
import java.util.List;
import com.hachimakidev.techstore.model.Dispositivo;

public class DispositivoController {

    private DispositivoManager dispositivoManager = new DispositivoManager();

    public List<Dispositivo> obtenerDispositivo() {
        return dispositivoManager.getListaDispositivos();
    }

    public boolean registrarnuevoDispositivo(Dispositivo dispositivo) {
        if (dispositivo != null) {
            dispositivoManager.agregarDispositivo(dispositivo);
            return true;
        }
        return false;
    }
    // TODO 3: Crear el método para validar y agregar un nuevo Notebook o Smartphone a la lista del manager.

}


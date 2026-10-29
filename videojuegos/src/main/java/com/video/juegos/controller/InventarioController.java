package com.video.juegos.controller;

import java.util.ArrayList;

import com.video.juegos.model.Videojuego;
import com.video.juegos.model.InventarioManager;

public class InventarioController {

    private InventarioManager inventarioManager;

    public InventarioController() {
        inventarioManager = new InventarioManager();
    }

    public ArrayList<Videojuego> getInventario(){
        return inventarioManager.getInventario();
    }
}

package com.amaro.gamevault.controller;

import java.util.ArrayList;

import com.amaro.gamevault.model.Videojuego;

public class InventarioController {
    private InventarioController inventarioController;

    public InventarioController() {
        inventarioController = new InventarioController();
    }

    public ArrayList<Videojuego> getVideojuegos() {
        return inventarioController.getVideojuegos();
    }
}

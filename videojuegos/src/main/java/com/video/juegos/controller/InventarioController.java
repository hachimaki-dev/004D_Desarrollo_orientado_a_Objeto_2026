package com.video.juegos.controller;

import java.util.List;

import com.video.juegos.model.Videojuego;
import com.video.juegos.model.InventarioManager;
import com.video.juegos.model.Usuario;
import com.video.juegos.model.UsuarioManager;

public class InventarioController {

    private InventarioManager materialManager = new InventarioManager();
    //private UsuarioManager userManager = new UsuarioManager();

    public List<Videojuego> obtenerCatalogo() {
        return materialManager.getCatalogo();
    }
}

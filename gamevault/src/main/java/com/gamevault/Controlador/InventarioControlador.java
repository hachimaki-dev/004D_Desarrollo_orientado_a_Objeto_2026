package com.gamevault.Controlador;

import com.gamevault.model.Videojuego;
import com.gamevault.model.InventarioManager;
import java.util.List;

import com.gamevault.Modelo.Videojuego;
import com.gamevault.Modelo.VideojuegoRepositorio;
import com.gamevault.Modelo.VideojuegoJsonRepositorio;
import java.util.List;

public class InventarioControlador {

    private VideojuegoRepositorio repositorio;

    public InventarioControlador() {
        // Inicializamos usando la implementación de JSON (Patrón Repository)
        this.repositorio = new VideojuegoJsonRepositorio();
    }

    public List<Videojuego> obtenerInventarioCompleto() {
        return repositorio.obtenerTodos();
    }
}
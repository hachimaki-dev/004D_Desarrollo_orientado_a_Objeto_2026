package com.gamevault.Modelo;

import java.util.List;

public interface VideojuegoRepositorio {
    List<Videojuego> obtenerTodos();
    void guardar(Videojuego juego);
}
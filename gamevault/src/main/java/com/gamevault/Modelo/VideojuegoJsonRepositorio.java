package com.gamevault.Modelo;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VideojuegoJsonRepositorio implements VideojuegoRepositorio {

    private List<Videojuego> listaVideojuegos;

    public VideojuegoJsonRepositorio() {
        this.listaVideojuegos = new ArrayList<>();
        cargarDesdeJson();
    }

    private void cargarDesdeJson() {
        try {
            InputStream stream = getClass().getResourceAsStream("/inventario.json");
            if (stream != null) {
                InputStreamReader reader = new InputStreamReader(stream);
                Gson gson = new Gson();
                Videojuego[] arreglo = gson.fromJson(reader, Videojuego[].class);
                if (arreglo != null) {
                    listaVideojuegos.addAll(Arrays.asList(arreglo));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar inventario.json: " + e.getMessage());
        }
    }

    @Override
    public List<Videojuego> obtenerTodos() {
        return listaVideojuegos;
    }

    @Override
    public void guardar(Videojuego juego) {
        listaVideojuegos.add(juego);
        // Aquí podrías agregar la lógica para reescribir el JSON si lo necesitas
    }
}
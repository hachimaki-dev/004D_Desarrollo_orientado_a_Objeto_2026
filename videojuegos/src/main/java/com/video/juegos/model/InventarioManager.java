package com.video.juegos.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class InventarioManager {

    private List<Videojuego> inventario = new ArrayList<>();

    public InventarioManager() {
        cargarDesdeJson();
    }

    private void cargarDesdeJson() {
        try {
            InputStream is = getClass().getResourceAsStream("/inventario.json");
            InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8);

            InventarioJson datos = new Gson().fromJson(reader, InventarioJson.class);

            if (datos != null) {
                if (datos.getJuegoFisicos() != null) inventario.addAll(datos.getJuegoFisicos());
                if (datos.getJuegoDigital() != null) inventario.addAll(datos.getJuegoDigital());
            }

            System.out.println("Materiales cargados: " + inventario.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Videojuego> getCatalogo() {
        return inventario;
    }
}
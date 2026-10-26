package com.amaro.gamevault.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class InventarioManager {
    ArrayList<Videojuego> listaVideojuego = new ArrayList<>();
    
    public InventarioManager(){
        loadInventario();
    }

    public void loadInventario(){
        InputStream stream = getClass().getResourceAsStream("/inventario.json");

        if (stream == null) {
            throw new IllegalStateException("No se encontró inventario.json en resources");
        }
        try (InputStreamReader reader = new InputStreamReader(stream)) {
            Gson gson = new Gson();
            JsonObject[] videojuego = gson.fromJson(reader, JsonObject[].class);

            for (JsonObject juego : videojuego) {
                String tipo = juego.get("tipo").getAsString();
                switch (tipo) {
                    case "fisico":
                        String titulo = juego.get("titulo").getAsString();
                        String plataforma = juego.get("plataforma").getAsString();
                        String portada = juego.get("portada").getAsString();
                        int stockTienda = juego.get("stockTienda").getAsInt();
                        int pesoGramos = juego.get("pesoGramos").getAsInt();
                        JuegoFisico juegoFisico = new JuegoFisico(titulo, plataforma, portada, stockTienda, pesoGramos);
                        listaVideojuego.add(juegoFisico);
                        break;
                    case "digital":
                        String titulo = juego.get("titulo").getAsString();
                        String plataforma = juego.get("plataforma").getAsString();
                        String portada = juego.get("portada").getAsString();
                        int tamanoGB = juego.get("tamanoGB").getAsInt();
                        String codigoActivacion = juego.get("codigoActivacion").getAsString();
                        JuegoDigital juegoDigital = new JuegoDigital(titulo, plataforma, portada, tamanoGB, codigoActivacion);
                        listaVideojuego.add(juegoDigital);
                        break;
                    default:
                        System.out.println("Tipo de material desconocido: " + tipo);
                        break;
                }
            }

        } catch (java.io.IOException e) {
            throw new IllegalStateException("No se pudo leer biblioteca.json", e);
        }
    }

    public ArrayList<Videojuego> getVideojuegos() {
        return listaVideojuego;
    }

    public void mostrarMateriales() {
        for (Videojuego juego : listaVideojuego) {
            System.out.println(juego.getTitulo());
        }
    }
}

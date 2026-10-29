package com.video.juegos.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class InventarioManager {

    ArrayList<Videojuego> inventario = new ArrayList<>();

    public InventarioManager() {
        cargarDesdeJson();
    }

    private void cargarDesdeJson() {
        InputStream stream = getClass().getResourceAsStream("/inventario.json");

        if (stream == null) {
            throw new IllegalStateException("No se encontró inventario.json en resources");
        }

        try (InputStreamReader reader = new InputStreamReader(stream)) {
            Gson gson = new Gson();

            JsonObject[] videojuegos = gson.fromJson(reader, JsonObject[].class);

            for (JsonObject videojuego : videojuegos) {
                String tipo = videojuego.get("tipo").getAsString();
            
                switch (tipo) {
                    case "fisico":
                        String tituloFisico = videojuego.get("titulo").getAsString();
                        String plataformaFisico = videojuego.get("plataforma").getAsString();
                        int stockTienda = videojuego.get("stockTienda").getAsInt();
                        double pesoGramos = videojuego.get("pesoGramos").getAsDouble();
                        String portadaFisico = videojuego.get("portada").getAsString();

                        JuegoFisico juegoFisico = new JuegoFisico(tituloFisico, plataformaFisico, portadaFisico, stockTienda, pesoGramos);
                        inventario.add(juegoFisico);

                        break;
                    case "digital":
                        String tituloDigital = videojuego.get("titulo").getAsString();
                        String plataformaDigital = videojuego.get("plataforma").getAsString();
                        double tamanoGB = videojuego.get("tamanoGB").getAsDouble();
                        String codigoActivacion = videojuego.get("codigoActivacion").getAsString();
                        String portadaDigital = videojuego.get("portada").getAsString();

                        JuegoDigital juegoDigital = new JuegoDigital(tituloDigital, plataformaDigital, portadaDigital, tamanoGB, codigoActivacion);
                        inventario.add(juegoDigital);
                        
                        break;
                    default:
                        System.out.println("Tipo de material desconocido: " + tipo);

                        break;
                }
            }
        } catch (java.io.IOException e) {
            throw new IllegalStateException("No se pudo leer inventario.json", e);
        }
    }

    public ArrayList<Videojuego> getInventario() {
        return inventario;
    }
}
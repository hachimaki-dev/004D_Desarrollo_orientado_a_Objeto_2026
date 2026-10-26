package com.hachimakidev.biblioapp.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class InventarioManager {
    

    ArrayList<Videojuego> lista_d_Videojuegos = new ArrayList<>();

    public InventarioManager(){
        loadJuegos();
    }


    public  void loadJuegos(){
        InputStream cadena = getClass().getResourceAsStream("/inventario.json");
    
        InputStreamReader reader = new InputStreamReader(cadena);

        Gson gson = new Gson();

        JsonObject[] listjuegos = gson.fromJson(reader, JsonObject[].class);
    
        for (JsonObject juego : listjuegos ) {
            
            String tipo = juego.get("tipo").getAsString();

            switch (tipo) {
                case "fisico":
                    String titulo = juego.get("titulo").getAsString();

                    String plataforma = juego.get("plataforma").getAsString();

                    int stockTienda = juego.get("stockTienda").getAsInt();
                    int pesoGramos = juego.get("pesoGramos").getAsInt();
                    String  portada = juego.get("portada").getAsString();

                    Juegofisico juego_a_agregar = new  Juegofisico(titulo, plataforma, portada, stockTienda, pesoGramos);
                    
                    lista_d_Videojuego.add(juego_a_agregar);

                    break;
            
                default:
                    break;
            }


            

            
            
        }

    }


}

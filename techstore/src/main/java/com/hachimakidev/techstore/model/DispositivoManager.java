package com.hachimakidev.techstore.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DispositivoManager {

    private ArrayList<Dispositivo> dispositivos = new ArrayList<>();

    public DispositivoManager (){
        cargarDatos();
    }
    public void cargarDatos(){
     InputStream stream = getClass().getResourceAsStream("/dispositivos.json");

     InputStreamReader reader = new InputStreamReader(stream);

     Gson gson = new Gson();
     JsonArray arreglo_dispositivos = gson.fromJson(reader, JsonArray.class);

     for (JsonElement d : arreglo_dispositivos) {
        d.getAsJsonObject();
        JsonObject ar = d.getAsJsonObject();
        
        String tipo = ar.get("tipo").getAsString();

        if(tipo.equals("notebook")){
            Notebook notebook = gson.fromJson(d, Notebook.class);
            dispositivos.add(notebook);
        }
        else if (tipo.equals("smartphone")){
            Smartphone smartphone = gson.fromJson(d, Smartphone.class);
            dispositivos.add(smartphone);
        }
        else {System.err.println("no se puede añadir el dispositivo");

        }
    }

     }

     public ArrayList<Dispositivo> getDispositivos(){
        return dispositivos;
        
     }
     public void agregarDispositivo(Dispositivo nuevo){
        dispositivos.add(nuevo);
     }

      {
        
     }

}


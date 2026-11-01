package com.hachimakidev.techstore.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DispositivoManager {

    private ArrayList<Dispositivo> dispositivos = new ArrayList<>();

    public DispositivoManager(){
        cargarDatos();
    }

    public void cargarDatos(){
        InputStream stream = getClass().getResourceAsStream("/dispositivos.json");
        InputStreamReader reader = new InputStreamReader(stream);
        Gson gson = new Gson();
        JsonObject[] arreglojson = gson.fromJson(reader, JsonObject[].class);
        for (JsonElement e : arreglojson) {
            String tipo = ((JsonObject) e).get("tipo").getAsString();
            if(tipo.equals("notebook")){
                System.out.println("Es un notebook");
                Notebook notebook = gson.fromJson(e, Notebook.class);
                dispositivos.add(notebook);
            }
            else if(tipo.equals("smartphone")){
                System.out.println("es un smartphone");
                Smartphone smartphone = gson.fromJson(e, Smartphone.class);
                dispositivos.add(smartphone);
            }

            }

            
        }

    public ArrayList<Dispositivo> geDispositivos(){
        return dispositivos;    }

    public void agregarDispositivo(Dispositivo nuevo) {
    int nuevoId = 1;

    for (Dispositivo dispositivo : dispositivos) {
        if (dispositivo.getId() >= nuevoId) {
            nuevoId = dispositivo.getId() + 1;
        }
    }

    nuevo.setId(nuevoId);
    dispositivos.add(nuevo);
}

    }



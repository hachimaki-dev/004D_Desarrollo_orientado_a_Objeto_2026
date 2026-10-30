package com.hachimakidev.techstore.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class DispositivoManager {


    private List<Dispositivo> array_dispositivos = new ArrayList<>();

    public void loadData(){
        InputStream stream = getClass().getResourceAsStream("/dispositivos.json");

        InputStreamReader reader = new InputStreamReader(stream);

        Gson gson = new Gson();

        JsonObject[] dispositivos = gson.fromJson(reader, JsonObject[].class);

        for (JsonObject dispositivo : dispositivos) {

            String tipo = dispositivo.get("tipo").getAsString();

            int id = dispositivo.get("id").getAsInt();
            String marca = dispositivo.get("marca").getAsString();
            String modelo = dispositivo.get("modelo").getAsString();
            int precio = dispositivo.get("precio").getAsInt();
            boolean disponible= dispositivo.get("disponible").getAsBoolean();
            int almacenamientoGb = dispositivo.get("almacenamientoGb").getAsInt();
            int camaraMp = dispositivo.get("camaraMp").getAsInt();
            int ramGb = dispositivo.get("ramGb").getAsInt();
            String procesador = dispositivo.get("procesador").getAsString();

            switch (tipo) {
                case "notebook" : {
                    Notebook notebook = new Notebook(id, marca, modelo, precio, disponible, ramGb, procesador);
                    array_dispositivos.add(notebook);
                    break;
                }
                case "smartphone": {
                    Smartphone smartphone = new Smartphone(id, marca, modelo, precio, disponible, almacenamientoGb, camaraMp);
                    array_dispositivos.add(smartphone);
                    break;
                }
            }

        }
    }
    public List<Dispositivo> getListaDispositivos(){
        return array_dispositivos;
    }

    public void agregarDispositivo(Dispositivo dispositivo){
        if (dispositivo != null) {
            this.array_dispositivos.add(dispositivo);
        }
    }
    
}


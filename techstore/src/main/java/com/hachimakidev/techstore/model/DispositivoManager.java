package com.hachimakidev.techstore.model;

import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DispositivoManager {
    private ArrayList<Dispositivo> dispositivos = new ArrayList<>();

    public DispositivoManager() {
        cargarDatos();
    }

    private void cargarDatos(){
        InputStreamReader reader = new InputStreamReader(
            getClass().getResourceAsStream("/dispositivo.json")
            );
            Gson gson = new Gson();
            JsonObject[] arregloJson = gson.fromJson(reader, JsonObject[].class);

            for (JsonObject obj : arregloJson) {
                String tipo = obj.get("tipo").getAsString();
                if (tipo.equals("notebook")) {
                    Notebook nb = gson.fromJson(obj, Notebook.class);
                    dispositivos.add(nb);
                } else if (tipo.equals("smartphone")){
                    Smartphone sp = gson.fromJson(obj, Smartphone.class);
                    dispositivos.add(sp);
                }
    }
    }
    public ArrayList<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void AgregarDispositivo(Dispositivo nuevo) {
        dispositivos.add(nuevo);
    }
}



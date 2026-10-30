package com.hachimakidev.techstore.model;

import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DispositivoManager {


    private ArrayList<Dispositivo> dispositivo = new ArrayList<>();


    public  DispositivoManager(){
        cargardatos();
    }


    public void cargardatos(){
        InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream("/dispositivos.json"));

        Gson gson = new Gson();
        JsonObject[] arregloJson = gson.fromJson(reader, JsonObject[].class);
        
        for (JsonObject ob : arregloJson) {
            
            String tipo = ob.get("tipo").getAsString();

            if (tipo.equals("notebook")) {
                Notebook nb = gson.fromJson(ob, Notebook.class);
                dispositivo.add(nb);
            }else if(tipo.equals("smartphone")) {
                Smartphone sp = gson.fromJson(ob, Smartphone.class);
                dispositivo.add(sp);
            }
        }
    }
    

    public ArrayList<Dispositivo> getDispositivos(){ return dispositivo ; }
    public void agregarDispositivo(Dispositivo nuevo){ dispositivo.add(nuevo); }



}


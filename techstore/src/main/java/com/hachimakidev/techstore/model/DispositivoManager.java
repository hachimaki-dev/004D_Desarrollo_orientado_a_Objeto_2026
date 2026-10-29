package com.hachimakidev.techstore.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DispositivoManager {

// TODO 1: Declarar la lista polimórfica ArrayList<Dispositivo> para almacenar notebooks y smartphones.

    private ArrayList<Dispositivo> dispositivos = new ArrayList<>();

// TODO 2: En el constructor, llamar al método que carga los datos desde "/dispositivos.json".

    public DispositivoManager(ArrayList<Dispositivo> dispositivos) {
        cargarDatos();
    }
    
    // TODO 3: Implementar el método de carga usando Gson y JsonObject[]:
    //   - Si el campo "tipo" es "notebook", convertir el JsonObject a Notebook.class y agregarlo a la lista.
    //   - Si el campo "tipo" es "smartphone", convertir el JsonObject a Smartphone.class y agregarlo a la lista.

    private void cargarDatos(){
    InputStream stream = getClass().getResourceAsStream("/dispositivos.json");
    InputStreamReader reader = new InputStreamReader(stream);

    Gson gson = new Gson();

    JsonObject[] arregloJSon = gson.fromJson(reader, JsonObject[].class);

    for (JsonObject obj : arregloJSon) {
        String tipo = obj.get("tipo").getAsString();
        if (tipo.equals("notebook")){
            Notebook nb = gson.fromJson(obj, Notebook.class);
            dispositivos.add(nb);
        } else if (tipo.equals("smartphone")){
            Smartphone sp = gson.fromJson(obj, Smartphone.class);
            dispositivos.add(sp);
        }
        
    }
    }


    // TODO 4: Implementar un método getter para retornar la lista de dispositivos y un método para agregar un nuevo Dispositivo.
    public ArrayList<Dispositivo> getDispositivos(){
        return dispositivos;
    }

    public void agregarDispositivo(Dispositivo nuevo){
        dispositivos.add(nuevo);
    }
    
}


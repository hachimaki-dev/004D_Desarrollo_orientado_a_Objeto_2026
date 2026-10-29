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

            switch (tipo) {
                case "notebook" :
                    int id = dispositivo.get("id").getAsInt();
                    String marca = dispositivo.get("marca").getAsString();
                    String modelo = dispositivo.get("modelo").getAsString();
                    int precio = dispositivo.get("precio").getAsInt();
                    boolean disponible= dispositivo.get("disponible").getAsBoolean();
                    int almacenamientoGb = dispositivo.get("almacenamientoGb").getAsInt();
                    int camaraMp = dispositivo.get("camaraMp").getAsInt();
                    break;
            
                case "smartphone":
                    break;
            }
        }



    }

    // TODO 3: Implementar el método de carga usando Gson y JsonObject[]:
    //   - Si el campo "tipo" es "notebook", convertir el JsonObject a Notebook.class y agregarlo a la lista.
    //   - Si el campo "tipo" es "smartphone", convertir el JsonObject a Smartphone.class y agregarlo a la lista.

    // TODO 4: Implementar un método getter para retornar la lista de dispositivos y un método para agregar un nuevo Dispositivo.

}


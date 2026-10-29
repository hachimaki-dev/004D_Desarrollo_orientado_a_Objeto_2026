package com.hachimakidev.techstore.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class DispositivoManager {

    private ArrayList<Dispositivo> lista_dispositivos = new ArrayList<>();

    public DispositivoManager()
    {
        cargarRecursos();
    }

    public void cargarRecursos()
    {
        InputStream inputstream = new InputStreamReader.getClass().getResourceAsStream("/dispositivos.json");
            
    }
    // TODO 2: En el constructor, llamar al método que carga los datos desde "/dispositivos.json".

    Gson gson = new Gson();
    // TODO 3: Implementar el método de carga usando Gson y JsonObject[]:
    //   - Si el campo "tipo" es "notebook", convertir el JsonObject a Notebook.class y agregarlo a la lista.
    //   - Si el campo "tipo" es "smartphone", convertir el JsonObject a Smartphone.class y agregarlo a la lista.

    // TODO 4: Implementar un método getter para retornar la lista de dispositivos y un método para agregar un nuevo Dispositivo.

}


package com.hachimakidev.techstore.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DispositivoManager {

    // TODO 1: Declarar la lista polimórfica ArrayList<Dispositivo> para almacenar notebooks y smartphones.

    // TODO 2: En el constructor, llamar al método que carga los datos desde "/dispositivos.json".

    // TODO 3: Implementar el método de carga usando Gson y JsonObject[]:
    //   - Si el campo "tipo" es "notebook", convertir el JsonObject a Notebook.class y agregarlo a la lista.
    //   - Si el campo "tipo" es "smartphone", convertir el JsonObject a Smartphone.class y agregarlo a la lista.

    // TODO 4: Implementar un método getter para retornar la lista de dispositivos y un método para agregar un nuevo Dispositivo.

    private ArrayList<Dispositivo> dispositivos = new ArrayList<>();



    public DispositivoManager() {
        cargarDesdeJson();
    }

    private void cargarDesdeJson() {
        InputStream stream = getClass().getResourceAsStream("/dispositivos.json");
    
        if (stream == null) {
            throw new IllegalStateException("No se encontró dispositivos.json en resources");
        }

        try (InputStreamReader reader = new InputStreamReader(stream)) {
            Gson gson = new Gson();

            JsonObject[] dispositivosJson = gson.fromJson(reader, JsonObject[].class);

            for (JsonObject dispositivo : dispositivosJson) {
                String tipo = dispositivo.get("tipo").getAsString();

                switch (tipo){
                    case "notebook":
                        int idNotebook = dispositivo.get("id").getAsInt();
                        String marcaNotebook = dispositivo.get("marca").getAsString();
                        String modeloNotebook = dispositivo.get("modelo").getAsString();
                        int precioNotebook = dispositivo.get("precio").getAsInt();
                        boolean disponibleNotebook = dispositivo.get("disponible").getAsBoolean();
                        int ramGb = dispositivo.get("ramGB").getAsInt();
                        String procesador = dispositivo.get("procesador").getAsString();

                        Notebook notebook = new Notebook(idNotebook, marcaNotebook, modeloNotebook, precioNotebook, disponibleNotebook, ramGb, procesador);
                        dispositivos.add(notebook);
                        break;
                    case "smartphone":
                        int idSmartphone = dispositivo.get("id").getAsInt();
                        String marcaSmartphone = dispositivo.get("marca").getAsString();
                        String modeloSmartphone = dispositivo.get("modelo").getAsString();
                        int precioSmartphone = dispositivo.get("precio").getAsInt();
                        boolean disponiblSmartphone = dispositivo.get("disponible").getAsBoolean();
                        int almacenamiento = dispositivo.get("almacenamiento").getAsInt();
                        int camaraMP = dispositivo.get("camaraMP").getAsInt();

                        Smartphone smartphone = new Smartphone(idSmartphone, marcaSmartphone, modeloSmartphone, precioSmartphone, disponiblSmartphone, almacenamiento, camaraMP);
                        dispositivos.add(smartphone);
                        break;
                    default:
                        System.out.println("Tipo de dispositivo desconocido: " + tipo);
                        break;
                }
                
            }
            

        } catch (java.io.IOException e) {
            throw new IllegalStateException("No se pudo leer dispositivos.json", e);
        }

    }

    public ArrayList<Dispositivo> geDispositivos() {
        return dispositivos;
    }

    public void agregarDispositivo(Dispositivo nuevo) {
        dispositivos.add(nuevo);
    }

}


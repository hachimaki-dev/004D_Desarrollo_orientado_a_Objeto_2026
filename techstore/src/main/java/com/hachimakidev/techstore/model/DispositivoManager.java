package com.hachimakidev.techstore.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DispositivoManager {

    ArrayList <Dispositivo> DispositivosArraylist = new ArrayList <>();

    public DispositivoManager () {

        cargarDispositivos ();
  }
        public void cargarDispositivos () {


            try (InputStream input = getClass().getResourceAsStream("/dispositivos.json")) {

                Gson gson = new Gson();

                InputStreamReader traduciendo = new InputStreamReader(input);

                JsonObject[] datos_dispositivos = gson.fromJson(traduciendo, JsonObject[].class);



                for (JsonObject obj : datos_dispositivos) {
                
                    String tipo = obj.get("tipo").getAsString();

                    if (tipo.equals("notebook")) {
                       Notebook nb = gson.fromJson(obj, Notebook.class);              
                       
                       DispositivosArraylist.add(nb);     } else if (tipo.equals("smartphone")) {

                        Smartphone sp = gson.fromJson(obj, Smartphone.class);

                        DispositivosArraylist.add(sp);

                       }
                      
            }

            } catch (Exception e) {

                e.printStackTrace();
            }

            
    }


    public ArrayList<Dispositivo> obtenerDispositivos (){


        return DispositivosArraylist;
    }

    public void agregarDispositivo (Dispositivo dispositivo){

        DispositivosArraylist.add(dispositivo);
    }

            


  
}
   

    
    // TODO 1: Declarar la lista polimórfica ArrayList<Dispositivo> para almacenar notebooks y smartphones.

    // TODO 2: En el constructor, llamar al método que carga los datos desde "/dispositivos.json".

    // TODO 3: Implementar el método de carga usando Gson y JsonObject[]:
    //   - Si el campo "tipo" es "notebook", convertir el JsonObject a Notebook.class y agregarlo a la lista.
    //   - Si el campo "tipo" es "smartphone", convertir el JsonObject a Smartphone.class y agregarlo a la lista.

    // TODO 4: Implementar un método getter para retornar la lista de dispositivos y un método para agregar un nuevo Dispositivo.


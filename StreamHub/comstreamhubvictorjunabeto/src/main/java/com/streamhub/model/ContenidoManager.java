package com.streamhub.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.google.gson.Gson;

public class ContenidoManager {

    private ArrayList<Contenido> lista_contenido = new ArrayList<>();
    private boolean datos_cargados = false;

    public ContenidoManager(){
        cargarDatos();
    }

    
    private void cargarDatos(){
        try{
            InputStream stream = getClass().getResourceAsStream("/catalogos.json");
            InputStreamReader reader = new InputStreamReader(stream);

            Gson gson = new Gson();
            Contenido[] arreglo_Contenido = gson.fromJson(reader, Contenido[].class);

            for (Contenido c : arreglo_Contenido) {
                lista_contenido.add(c);
                
                
            }
            datos_cargados = true;
        }catch(Exception e ){
            System.err.println("no se a podido inportar los datos");
        }

    }   

    public boolean isDatosCargados(){
        return  datos_cargados;
    }

    public Contenido buscarTitulo(String titulo){
        for (Contenido u : lista_contenido) {
            if(u.getTitulo().equals(titulo)){
                return u;
            }
            
        }
        return null;
    }


    

}


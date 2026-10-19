package com.hachimakidev.bibliotech.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
public class BookManager {

    private ArrayList<Libro> lista_iibros = new ArrayList<>();
    private boolean datos_cargados = false;

    public BookManager(){
        cargarDatos();
    }

    private void cargarDatos(){
        try {
            InputStream stream = getClass().getResourceAsStream("/libros.json");
            InputStreamReader reader = new InputStreamReader(stream);

            Gson gson = new Gson();
            Libro[] arreglo_libros = gson.fromJson(reader, Libro[].class);

            for (Libro u : arreglo_libros){
                lista_iibros.add(u);
            }

            datos_cargados = true;

        } catch (Exception e) {
            System.err.println("e");
            // TODO: handle exception
        }
    }


            
        

    
            

        public boolean isDatosCargados(){
            return datos_cargados;
        }

        public Libro buscarPorNombre(String libro_a_buscar){
            for (Libro l : lista_iibros){
                if (l.getNombre().equals(libro_a_buscar)) {
                    return l;    
                }
            }

    return null;
}
}



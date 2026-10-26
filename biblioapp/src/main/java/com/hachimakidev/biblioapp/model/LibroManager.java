package com.hachimakidev.biblioapp.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class LibroManager {

    ArrayList<Libros> lista_libros = new ArrayList<>();

    public LibroManager(){
        loadLibros();
    }

    public void loadLibros(){
        InputStream cadena = getClass().getResourceAsStream("/libros.json");

        InputStreamReader reader = new InputStreamReader(cadena);

        Gson gson = new Gson();

        Libros[] libros = gson.fromJson(reader, Libros[].class);

        for( Libros libro : libros ){
            lista_libros.add(libro);
        }
    }


    public void aVerSiEsVerdad(){
        for(Libros u : lista_libros){
            System.out.println("--------------");
            System.out.println(u.getTitulo());
            System.out.println(u.get_fechapublicacion());
            System.out.println(u.getAutor());
            System.out.println(u.getNumeroPaginas());
        }
    }
    
    public Libros devolverTitulo(String titulo){
        for (Libros libro : lista_libros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null ;
            
        }
    }


     

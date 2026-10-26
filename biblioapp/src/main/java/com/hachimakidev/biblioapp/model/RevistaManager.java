package com.hachimakidev.biblioapp.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class RevistaManager {

    ArrayList<Revistas> lista_revistas = new ArrayList<>();

    public RevistaManager(){
        loadRevistas();
    }

    public void loadRevistas(){
        InputStream cadena = getClass().getResourceAsStream("/revistas.json");

        InputStreamReader reader = new InputStreamReader(cadena);

        Gson gson = new Gson();

        Revistas[] revistas = gson.fromJson(reader, Revistas[].class);

        for(Revistas revista : revistas ){
            lista_revistas.add(revista);
        }
    }


    public void aVerSiEsVerdad(){
        for(Revistas u : lista_revistas){
            System.out.println("--------------");
            System.out.println(u.getTitulo());
            System.out.println(u.get_fechapublicacion());
            System.out.println(u.get_editorial());
            System.out.println(u.getPeriodicidad());
        }
    }
    
    public Revistas devolverRevistaPorTitulo(String titulo){
        for (Revistas revista : lista_revistas) {
            if (revista.getTitulo().equals(titulo)) {
                return revista;
            }
        }
        return null ;
            
        }
    }


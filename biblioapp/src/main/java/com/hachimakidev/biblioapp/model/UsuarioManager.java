package com.hachimakidev.biblioapp.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UsuarioManager {
    
    ArrayList<Usuario> lista_usuarios = new ArrayList<>();

    public UsuarioManager(){
        loadUser();
    }


    public  void loadUser(){
        InputStream cadena = getClass().getResourceAsStream("/usuarios.json");
    
        InputStreamReader reader = new InputStreamReader(cadena);

        Gson gson = new Gson();

        Usuario[] users = gson.fromJson(reader, Usuario[].class);
    
        for (Usuario usuario : users) {
            lista_usuarios.add(usuario);
        }

    }

 // public void aVerSiEsVerdad(){
    //    for(User u : user_arraylist){
    //        System.out.println("--------------");
    //        System.out.println(u.getRut());
    //        System.out.println(u.getNombre());
    //        System.out.println(u.getEmail());
    //        System.out.println(u.getEdad());
    //        System.out.println(u.isPuede_solicitar_prestamos());
    //    }


}

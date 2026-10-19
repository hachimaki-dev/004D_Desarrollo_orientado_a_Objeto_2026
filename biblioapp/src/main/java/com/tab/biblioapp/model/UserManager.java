package com.tab.biblioapp.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UserManager {

    ArrayList<User> arraylist_de_users = new ArrayList<>();
    
    public UserManager() {
        loadUser();
    }



    public void loadUser(){
        InputStream cadena = getClass().getResourceAsStream("/resources.json");

        InputStreamReader reader = new InputStreamReader(cadena);

        Gson guiso = new Gson();

        User[] users = guiso.fromJson(reader, User[].class);

        for(User usuario: users){
            arraylist_de_users.add(usuario);
        }
    }



    public void corroborar_verdad(){
        for (User u : arraylist_de_users){
            System.out.println("------------------");
            System.out.println(u.getRut());
            System.out.println(u.getNombre());
            System.out.println(u.getEmail());
            System.out.println(u.getEdad());
            System.out.println(u.isPuede_solicitar_prestamos());
        }
    }
}

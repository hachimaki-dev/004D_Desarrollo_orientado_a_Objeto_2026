package com.hachimakidev.biblioapp.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UserManager {

    ArrayList<User> user_arraylist = new ArrayList<>();

    public UserManager(){
        loadUsers();
    }

    public void loadUsers(){
        InputStream cadena = getClass().getResourceAsStream("/user_data.json");

        InputStreamReader reader = new InputStreamReader(cadena);

        Gson gson = new Gson();

        User[] users = gson.fromJson(reader, User[].class);

        for( User usuario : users ){
            user_arraylist.add(usuario);
        }
    }

    public User devolverUsuarioPorRut(String rut) {
        for (User usuario : user_arraylist) {
            if (usuario.getRut().equals(rut)) {
                return usuario;
            }
        }
        return null;
    }


    public void aVerSiEsVerdad(){
        for(User u : user_arraylist){
            System.out.println("--------------");
            System.out.println(u.getRut());
            System.out.println(u.getNombre());
            System.out.println(u.getEmail());
            System.out.println(u.getEdad());
            System.out.println(u.isPuede_solicitar_prestamos());
        }
    }
    
}

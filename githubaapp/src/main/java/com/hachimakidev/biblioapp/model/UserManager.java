package com.hachimakidev.biblioapp.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.ietf.jgss.GSSContext;

import com.google.gson.Gson;
import com.hachimakidev.biblioapp.User;

public class UserManager {

    ArrayList<User> user_arrayList = new ArrayList<>();

    public UserManager(){
        loadUser();
    }
    

    public void loadUser(){
        InputStream stream = getClass().getResourceAsStream("/user_data.json");

        InputStreamReader reader = new InputStreamReader(stream);
        
        Gson gson = new Gson();

        User[] users = gson.fromJson(reader, User[].class);

        for( User user : users){
            user_arrayList.add(user);
        }
    }


    public void aVerSiEsVerdad() {
        for(User u : user_arrayList){
            System.out.println("---------");
            System.out.println(u.getRut());
            System.out.println(u.getNombre());
            System.out.println(u.getEmail());
            System.out.println(u.getEdad());
            System.out.println(u.isPuede_pedir_prestamo());
        }
    }
}

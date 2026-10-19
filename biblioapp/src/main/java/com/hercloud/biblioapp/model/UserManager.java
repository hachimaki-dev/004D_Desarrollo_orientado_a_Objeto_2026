package com.hercloud.biblioapp.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UserManager 
{
    ArrayList<User> user_ArrayList = new ArrayList<>();

    public 

    public void loadUser()
    {
        InputStream cadena = getClass().getResourceAsStream("/user_data.json");

        // transforma los datos binarios a textos
        InputStreamReader reader = new InputStreamReader(cadena);

        Gson gson = new Gson();

        User[] user = gson.fromJson(reader, User[].class);// [] es mas de un dato

        for(User usuario: users)
        {
            user_ArrayList.add(usuario);
        }
        
    }

    public void 
}

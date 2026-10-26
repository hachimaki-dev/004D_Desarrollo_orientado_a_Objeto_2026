package com.video.juegos.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UsuarioManager {

    ArrayList<Usuario> user_arraylist = new ArrayList<>();

    public UsuarioManager() {
        loadUsers();
    }

    public void loadUsers() {
        InputStream cadena = getClass().getResourceAsStream("/usuarios.json");

        InputStreamReader reader = new InputStreamReader(cadena);

        Gson gson = new Gson();

        Usuario[] users = gson.fromJson(reader, Usuario[].class);

        for( Usuario usuario : users ){
            user_arraylist.add(usuario);
        }
    }

    public Usuario devolverUsuarioPorRut(String rut) {
        for (Usuario usuario : user_arraylist) {
            if(usuario.getRut().equals(rut)) {
                return usuario;
            }
        }
        return null;
    }
    
}

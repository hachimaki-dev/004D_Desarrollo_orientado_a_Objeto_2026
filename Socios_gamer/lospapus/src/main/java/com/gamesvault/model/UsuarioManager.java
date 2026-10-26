package com.gamesvault.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UsuarioManager {
    ArrayList<Usuario> usuario_arraylist = new ArrayList<>();

    public UsuarioManager(){
        Loadusuarios();
    }

    public void Loadusuarios() {
        InputStream cadena = getClass().getResourceAsStream("/usuarios.json");
        InputStreamReader reader = new InputStreamReader(cadena);
        Gson gson = new Gson();
        Usuario[] usuarios = gson.fromJson(reader, Usuario[].class);

        for (Usuario usuario : usuarios){
            usuario_arraylist.add(usuario);
        }
    }

    public Usuario devolverUsuarioPorRut(String rut){
        for (Usuario usuario : usuario_arraylist){
            if (usuario.getRut().equals(rut)) {
                return usuario;
            }
        }
        return null;
    }

    public void aVerSiEsVerdad(){
        for(Usuario u : usuario_arraylist){
            System.out.println("--------------");
            System.out.println(u.getRut());
            System.out.println(u.getNombre());
            System.out.println(u.getEmail());
            System.out.println(u.getNivel_gamer());
        }
    }
}

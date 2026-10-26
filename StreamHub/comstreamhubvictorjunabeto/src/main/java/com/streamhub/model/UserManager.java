package com.streamhub.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GuardedObject;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UserManager {

    private ArrayList<Usuario> lista_usuarios = new ArrayList<>();
    private boolean datos_cargados = false;

    public UserManager(){
        cargarDatos();
    }
    private void cargarDatos(){
        try{
            InputStream stream = getClass().getResourceAsStream("/usuarios.json");
            InputStreamReader reader = new InputStreamReader(stream);

            Gson gson = new Gson();
            Usuario[] arreglo_Usuarios = gson.fromJson(reader, Usuario[].class);

            for (Usuario u : arreglo_Usuarios) {
                lista_usuarios.add(u);
                
            }
            datos_cargados = true;
        }catch(Exception e ){
            System.err.println("no se a podido inportar los datos");
        }



    }   
    public boolean isDatosCargados(){
        return  datos_cargados;
    }

    public Usuario buscarUsuario(String rut){
        for (Usuario u : lista_usuarios) {
            if(u.getRut().equals(rut)){
                return u;
            }
            
        }
        return null;
    }


}

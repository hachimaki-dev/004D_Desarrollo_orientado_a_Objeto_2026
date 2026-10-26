package com.streamhub.controller;

import com.streamhub.model.Usuario;
import com.streamhub.model.UserManager;

public class UsuarioController {
    private  UserManager manager;

    public UsuarioController(){
        manager = new UserManager();
    }

    public boolean datos_disponibles(){
        return  manager.isDatosCargados();
    }
    public Usuario buscarUsuario(String rut_ingresado){
        String rut = rut_ingresado.trim();
        return manager.buscarUsuario(rut);

    } 

}

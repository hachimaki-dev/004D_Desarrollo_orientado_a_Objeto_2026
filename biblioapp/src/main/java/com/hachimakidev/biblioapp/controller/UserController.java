package com.hachimakidev.biblioapp.controller;

import com.hachimakidev.biblioapp.model.User;
import com.hachimakidev.biblioapp.model.UserManager;

public class UserController {
    
    public void test(){
        UserManager userManager = new UserManager();
        userManager.aVerSiEsVerdad();
    }

    public User buscarUsuario(String rut){
        UserManager administracionDeUsuario = new UserManager();

        User usuarioEncontrado = administracionDeUsuario.devolverUsuarioPorRut(rut);
        return usuarioEncontrado;

    }

}

package com.hachimakidev.biblioapp.controller;

import com.hachimakidev.biblioapp.model.UserManager;

public class UserController {
    
    public void test(){
        UserManager userManager = new UserManager();
        userManager.aVerSiEsVerdad();
    }

    public User buscarusuario(String rut){
        UserManager administacionDeUsuario = new UserManager();
        User usuarioEncontrado = administacionDeUsuario.devolverUsuarioPorRut(rut);
        return usuarioEncontrado;
    }

}

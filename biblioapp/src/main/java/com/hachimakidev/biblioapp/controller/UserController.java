package com.hachimakidev.biblioapp.controller;

import com.hachimakidev.biblioapp.model.User;
import com.hachimakidev.biblioapp.model.UserManager;

public class UserController {
    
    public void test(){
        UserManager userManager = new UserManager();
        userManager.aVerSiEsVerdad();
    }

    public User buscarUsuario(String rut){
        UserManager administracionDeUusarios = new UserManager(); //instancia
        User usuario_encontrado = administracionDeUusarios.devolverUsuarioPorRut(rut);

        return usuario_encontrado;

    }

}

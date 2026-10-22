package com.hachimakidev.biblioapp.controller;
import com.hachimakidev.biblioapp.model.User;

import com.hachimakidev.biblioapp.model.UserManager;

public class UserController {
    
    public void test(){
        UserManager userManager = new UserManager();
        userManager.aVerSiEsVerdad();
    }

    public User buscarusuario(String rut){
        UserManager admiistracion_d_user = new UserManager();
        User usuario_encontrado =  admiistracion_d_user.devolverusuarioporrut(rut);

        return usuario_encontrado ;

    }

}

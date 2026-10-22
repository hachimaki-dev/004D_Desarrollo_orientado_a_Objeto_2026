package com.hachimakidev.biblioapp.controller;
import com.hachimakidev.biblioapp.model.UserManager;
import com.hachimakidev.biblioapp.model.User


public class UserController {
    
    public void test(){
        UserManager userManager = new UserManager();
        userManager.aVerSiEsVerdad();
    }

    public User buscarUsuario(String rut)
    {
        UserManager administracionDeUsuario = new UserManager();

        User usuarioEncontrado = administracionDeUsuario.delvolverUsuaruiPorRut(rut);

        return usuarioEncontrado;
    }

}

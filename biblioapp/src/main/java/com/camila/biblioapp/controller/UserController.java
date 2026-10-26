package com.camila.biblioapp.controller;

import com.camila.biblioapp.model.User;
import com.camila.biblioapp.model.UserManager;

public class UserController {
    
    public User buscarUsuario(String rut) {
        UserManager administracionDeUsuarios = new UserManager();
        User usuarioEncontrado = administracionDeUsuarios.devolverUsuarioPorRut(rut);
        return usuarioEncontrado;
    }

}

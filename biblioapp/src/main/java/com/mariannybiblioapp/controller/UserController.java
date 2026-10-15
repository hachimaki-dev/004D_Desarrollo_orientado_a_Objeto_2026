package com.mariannybiblioapp.controller;

import com.mariannybiblioapp.model.User;
import com.mariannybiblioapp.model.UserManager;

public class UserController {
     private UserManager manager;

    public UserController() {
        manager = new UserManager();
    }

    public boolean datosDisponibles() {
        return manager.isDatosCargados();
    }

    public User buscarUsuario(String rut_ingresado) {
        String rut_limpio = rut_ingresado.trim();
        return manager.buscarPorRut(rut_limpio);
    }
}

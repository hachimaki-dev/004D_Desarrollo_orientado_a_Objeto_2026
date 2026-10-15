package com.agcamila.biblioapp.controller;

import com.agcamila.biblioapp.model.User;
import com.agcamila.biblioapp.model.UserManager;

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

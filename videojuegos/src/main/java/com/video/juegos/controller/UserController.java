package com.video.juegos.controller;

import com.video.juegos.model.Usuario;
import com.video.juegos.model.UsuarioManager;

public class UserController {
    
    public Usuario buscarUsuario(String rut) {
        UsuarioManager administracionDeUsuarios = new UsuarioManager();
        Usuario usuarioEncontrado = administracionDeUsuarios.devolverUsuarioPorRut(rut);
        return usuarioEncontrado;
    }

}

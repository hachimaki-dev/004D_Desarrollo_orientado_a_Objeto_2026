package com.shunsui2.controller;

import java.util.ArrayList;

import com.shunsui2.dao.UsuarioDAO;
import com.shunsui2.model.Usuario;

public class UsuarioController {
     private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }
    
    public boolean registrarUsuario(String username, String correo, String password, String rol) {
        if (username == null || username.isBlank() ||
            correo == null || correo.isBlank() ||
            password == null || password.isBlank() ||
            rol == null || rol.isBlank()) {
            return false;
        }

        // Usamos el constructor SIN id porque es un usuario nuevo
        Usuario nuevo = new Usuario(username.trim(), correo.trim(), password, rol);
        return usuarioDAO.guardar(nuevo);
    }

    public ArrayList<Usuario> obtenerUsuarios() {
        return usuarioDAO.obtenerTodos();
    }

    public boolean actualizarUsuario(int id, String username, String correo, String password, String rol) {
        if (id <= 0 ||
            username == null || username.isBlank() ||
            correo == null || correo.isBlank() ||
            password == null || password.isBlank() ||
            rol == null || rol.isBlank()) {
            return false;
        }

        // Usamos el constructor CON id para indicar qué fila se está actualizando
        Usuario editado = new Usuario(id, username.trim(), correo.trim(), password, rol);
        return usuarioDAO.actualizar(editado);
    }

    public boolean eliminarUsuario(int id) {
        if (id <= 0) {
            return false;
        }
        return usuarioDAO.eliminar(id);
    }
}

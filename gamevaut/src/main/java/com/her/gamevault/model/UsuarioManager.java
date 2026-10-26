package com.her.gamevault.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UsuarioManager {
    ArrayList<Usuario> usuarios_ArrayList = new ArrayList<Usuario>();

    public void cargarUsuarios() {

    InputStream usuarioStream = getClass().getResourceAsStream("/usuario.json");
    }
}

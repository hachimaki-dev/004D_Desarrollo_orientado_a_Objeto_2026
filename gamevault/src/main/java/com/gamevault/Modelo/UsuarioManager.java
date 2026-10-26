package com.gamevault.Modelo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UsuarioManager {
    private ArrayList<Usuario> lista_de_usuarios = new ArrayList<>();
    private boolean datos_cargados = false;
    
    public UsuarioManager() {
        cargarDatos();
    }

    private void cargarDatos() {
        try {
            InputStream stream = getClass().getResourceAsStream("/users.json");

            InputStreamReader reader = new InputStreamReader(stream);

            Gson gson = new Gson();
            Usuario[] arreglo_usuarios = gson.fromJson(reader, Usuario[].class);

            for (Usuario u : arreglo_usuarios) {
                lista_de_usuarios.add(u);
            }

            datos_cargados = true;

        } catch (Exception e) {
            System.out.println("Error al cargar users.json: " + e);
        }
    }

    public boolean isDatosCargados() {
        return datos_cargados;
    }

    public Usuario buscarPorRut(String rut_a_buscar) {
        for (Usuario u : lista_de_usuarios) {
            if (u.getRut().equals(rut_a_buscar)) {
                return u;
            }
        }
        return null;
    }
}
    


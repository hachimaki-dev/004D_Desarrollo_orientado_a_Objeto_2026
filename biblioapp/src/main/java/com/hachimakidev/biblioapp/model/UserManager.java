package com.hachimakidev.biblioapp.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UserManager {

    private ArrayList<User> lista_usuarios = new ArrayList<>();
    private boolean datos_cargados = false;

    public UserManager() {
        cargarDatos();
    }

    private void cargarDatos() {
        try {
            InputStream stream = getClass().getResourceAsStream("/users.json");

            InputStreamReader reader = new InputStreamReader(stream);

            Gson gson = new Gson();
            User[] arreglo_usuarios = gson.fromJson(reader, User[].class);

            for (User u : arreglo_usuarios) {
                lista_usuarios.add(u);
            }

            datos_cargados = true;

        } catch (Exception e) {
            System.out.println("Error al cargar users.json: " + e);
        }
    }

    public boolean isDatosCargados() {
        return datos_cargados;
    }

    public User buscarPorRut(String rut_a_buscar) {
        for (User u : lista_usuarios) {
            if (u.getRut().equals(rut_a_buscar)) {
                return u;
            }
        }
        return null;
    }

}

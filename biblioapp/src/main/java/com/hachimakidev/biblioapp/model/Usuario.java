package com.hachimakidev.biblioapp.model;

public class Usuario {
    private String rut;
    private String nombre;
    private String email;
    private String nivelGamer;

    


    public Usuario(String rut, String nombre, String email, String nivelGamer) {
        this.rut = rut;
        this.nombre = nombre;
        this.email = email;
        this.nivelGamer = nivelGamer;
    }
    
    public String getRut() {
        return rut;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    public String getNivelGamer() {
        return nivelGamer;
    }
}

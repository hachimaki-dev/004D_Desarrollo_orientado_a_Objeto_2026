package com.amaro.gamevault.model;

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
    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getNivelGamer() {
        return nivelGamer;
    }
    public void setNivelGamer(String nivelGamer) {
        this.nivelGamer = nivelGamer;
    }

}

package com.hachimakidev.biblioapp.model;

public class User {

    private String rut;
    private String nombre;
    private String correo;

    public User() {
    }

    public User(String rut, String nombre, String correo) {
        this.rut = rut;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

}

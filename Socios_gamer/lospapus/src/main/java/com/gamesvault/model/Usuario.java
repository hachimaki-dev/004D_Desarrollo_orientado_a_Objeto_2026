package com.gamesvault.model;

public class Usuario {
    private String rut;
    private String nombre;
    private String email;
    private int nivel_gamer;

    public Usuario(String rut, String nombre, String email, int nivel_gamer){
        this.rut = rut;
        this.nombre = nombre;
        this.email = email;
        this.nivel_gamer = nivel_gamer;
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
    public int getNivel_gamer() {
        return nivel_gamer;
    }
    public void setNivel_gamer(int nivel_gamer) {
        this.nivel_gamer = nivel_gamer;
    }
}

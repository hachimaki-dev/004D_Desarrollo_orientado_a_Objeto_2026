package com.hachimakidev.bibliotech.model;

public class User {
    private String rut;
    private String nombre;
    private String correo;
    private int edad;
    private boolean puede_solicitar;

    public User() {}

    public User(String rut, String nombre, String correo, int edad, boolean puede_solicitar){
        this.rut = rut;
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
        this.puede_solicitar = puede_solicitar;
    }

    public int getEdad(){
        return edad;
    }

    public boolean getPuedeSolicitar(){
        return puede_solicitar;
    }

    public String getRut(){
        return rut;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCorreo(){
        return correo;
    }
    
}

package com.diego0954_alt.model;

public class Usuario {
    private String rut;
    private String nombre;
    private String email;
    private String plan;
    
    public Usuario(String rut, String nombre, String email, String plan) {
        this.rut = rut;
        this.nombre = nombre;
        this.email = email;
        this.plan = plan;
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
    public String getPlan() {
        return plan;
    }
    public void setPlan(String plan) {
        this.plan = plan;
    }
    
    
}

package com.hachimakidev.biblioapp;

public class User {
    private String rut;
    private String nombre;
    private String email;
    private int edad;
    private boolean puede_pedir_prestamo;

    
    public User(String rut, String nombre, String email, int edad, boolean puede_pedir_prestamo) {
        this.rut = rut;
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.puede_pedir_prestamo = puede_pedir_prestamo;
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
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public boolean isPuede_pedir_prestamo() {
        return puede_pedir_prestamo;
    }
    public void setPuede_pedir_prestamo(boolean puede_pedir_prestamo) {
        this.puede_pedir_prestamo = puede_pedir_prestamo;
    }
}

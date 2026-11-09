package com.flame6672.javadb.model;

public class Usuario {
    private int id;
    private String username;
    private String correo;
    private String password;
    private String rol;

    public Usuario(int id, String username, String correo, String password, String rol) {
        this.id = id;
        this.username = username;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
    }

    public Usuario(String username, String correo, String password, String rol) {
        this.username = username;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
}

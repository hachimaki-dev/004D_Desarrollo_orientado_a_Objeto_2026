package com.gamevault.Modelo;

public class Usuario {
    public String rut;
    public String nombre;
    public String email;
    public String nivelGamer;

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

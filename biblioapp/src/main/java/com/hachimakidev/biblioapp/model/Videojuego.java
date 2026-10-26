package com.hachimakidev.biblioapp.model;

public class Videojuego {
    private String Titulo;
    private String Plataforma;
    private String Portada;


    public  Videojuego(String Titulo , String Plataforma , String Portada){

        this.Titulo = Titulo;
        this.Plataforma = Plataforma ;
        this.Portada = Portada ;

    }


    public String getTitulo() {
        return Titulo;
    }
    public String getPlataforma() {
        return Plataforma;
    }
    public String getPortada() {
        return Portada;
    }
}

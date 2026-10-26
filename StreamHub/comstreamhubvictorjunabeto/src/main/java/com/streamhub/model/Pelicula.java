package com.streamhub.model;

public class Pelicula extends Contenido {
    private int duracionMinutos;
    private String director;

    public Pelicula(String titulo, String genero, String portadaUrl, int duracionMinutos, String director){
        super(titulo, genero, portadaUrl);
        this.duracionMinutos = duracionMinutos;
        this.director = director;
    }







    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public String getDirector() {
        return director;
    }
    
}

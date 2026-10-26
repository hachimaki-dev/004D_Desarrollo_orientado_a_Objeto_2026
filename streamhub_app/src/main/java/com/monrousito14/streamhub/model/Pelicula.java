package com.monrousito14.streamhub.model;

public class Pelicula extends Contenido {
    private int duracionEnMinutos;
    private String director;

    public Pelicula(String titulo, String genero, String portada, int duracionEnMinutos, String director) {
        super(titulo, genero, portada);
        this.duracionEnMinutos = duracionEnMinutos;
        this.director = director;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }


    public String getDirector() {
        return director;
    }

    

}

package com.diego0954_alt.model;

public class Pelicula extends Contenido {

    private int duracionMinuto;
    private String director;

    public Pelicula(String titulo, String genero, String portadaUrl, int duracionMinuto, String director) {
        super(titulo, genero, portadaUrl);
        this.duracionMinuto = duracionMinuto;
        this.director = director;
    }

    public int getDuracionMinuto() {
        return duracionMinuto;
    }

    public void setDuracionMinuto(int duracionMinuto) {
        this.duracionMinuto = duracionMinuto;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    


}

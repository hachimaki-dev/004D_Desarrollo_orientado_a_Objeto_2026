package com.streamhub.models;

public class Pelicula extends Contenido
{
    
    private int duraciónMinutos;

    private String director;

    public Pelicula(String titulo, String genero, String url, int duraciónMinutos, String director)
    {

        super(titulo, genero, url);

        this.duraciónMinutos = duraciónMinutos;

        this.director = director;

    }

    public void setDuraciónMinutos(int duraciónMinutos) 
    {
        this.duraciónMinutos = duraciónMinutos;
    }

    public void setDirector(String director) 
    {
        this.director = director;
    }

    public int getDuraciónMinutos() 
    {
        return duraciónMinutos;
    }

    public String getDirector() 
    {
        return director;
    }

    
}

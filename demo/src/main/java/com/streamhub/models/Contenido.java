package com.streamhub.models;

public abstract class Contenido 
{
    
    private String titulo;

    private String genero;

    private String url;

    public Contenido(String titulo, String genero, String url)
    {
        this.titulo = titulo;

        this.genero = genero;

        this.url = url;
    }
    public String getTitulo() 
    {
        return titulo;
    }

    public void setTitulo(String titulo) 
    {
        this.titulo = titulo;
    }

    public String getGenero() 
    {
        return genero;
    }

    public void setGenero(String genero) 
    {
        this.genero = genero;
    }

    public String getUrl() 
    {
        return url;
    }

    public void setUrl(String url) 
    {
        this.url = url;
    }




}

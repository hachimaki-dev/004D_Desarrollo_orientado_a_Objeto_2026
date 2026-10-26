package com.streamhub.models;

public class Serie extends Contenido
{
    
    private Integer temporadas;

    private Integer capitulosTotales;

    public Serie(String titulo, String genero, String url, Integer temporadas, Integer capitulosTotales)
    {

        super(titulo, genero, url);

        this.temporadas = temporadas;

        this.capitulosTotales = capitulosTotales;
        
    }
    public Integer getTemporadas() 
    {
        return temporadas;
    }

    public void setTemporadas(Integer temporadas) 
    {
        this.temporadas = temporadas;
    }

    public Integer getCapitulosTotales() 
    {
        return capitulosTotales;
    }

    public void setCapitulosTotales(Integer capitulosTotales) 
    {
        this.capitulosTotales = capitulosTotales;
    }



}

package com.streamhub.model;

public class Serie extends Contenido {

    private int temporada;
    private int capitulosTotales;

    public Serie(String titulo, String genero, String portadaUrl, int temporada, int capitulosTotales){
        super(titulo, genero, portadaUrl);
        this.temporada = temporada;
        this.capitulosTotales = capitulosTotales;

    }






    public int getTemporada() {
        return temporada;
    }

    public int getCapitulosTotales() {
        return capitulosTotales;
    }

    
}

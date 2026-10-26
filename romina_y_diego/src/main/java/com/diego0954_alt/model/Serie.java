package com.diego0954_alt.model;

public class Serie extends Contenido {
    private int temporadas;
    private int capitulosTotales;

    public Serie(String titulo, String genero, String portadaUrl, int temporadas, int capitulosTotales) {
        super(titulo, genero, portadaUrl);
        this.temporadas = temporadas;
        this.capitulosTotales = capitulosTotales;
    }
    public int getTemporadas() {
        return temporadas;
    }
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }
    public int getCapitulosTotales() {
        return capitulosTotales;
    }
    public void setCapitulosTotales(int capitulosTotales) {
        this.capitulosTotales = capitulosTotales;
    }

    
    
}

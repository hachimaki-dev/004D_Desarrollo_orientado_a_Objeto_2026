package com.diego0954_alt.model;

public class Contenido {
    private String titulo;
    private String genero;
    private String portadaUrl;

    contenido(){

    }


    public Contenido(String titulo, String genero, String portadaUrl) {
        this.titulo = titulo;
        this.genero = genero;
        this.portadaUrl = portadaUrl;
    }

    public String gettitulo() {
        return titulo;
    }

    public void settitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPortadaUrl() {
        return portadaUrl;
    }

    public void setPortadaUrl(String portadaUrl) {
        this.portadaUrl = portadaUrl;
    }

    
    
}

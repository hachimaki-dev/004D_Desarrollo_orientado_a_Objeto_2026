package com.streamhub.model;

public class Contenido {

    private String titulo;
    private String genero;
    private String portadaUrl;

    public Contenido(String titulo, String genero, String portadaUrl){
        this.titulo = titulo;
        this.genero = genero;
        this.portadaUrl = portadaUrl;
    }


    public String getGenero() {
        return genero;
    }

    public String getPortadaUrl() {
        return portadaUrl;
    }
    public String getTitulo() {
        return titulo;
    }
    
    
}

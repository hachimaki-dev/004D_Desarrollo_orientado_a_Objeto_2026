package com.monrousito14.streamhub.model;

public abstract class Contenido {
    private String titulo;
    private String genero;
    private String portada;

    public Contenido(String titulo, String genero, String portada) {
        this.titulo = titulo;
        this.genero = genero;
        this.portada = portada;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getPortada() {
        return portada;
    }

}

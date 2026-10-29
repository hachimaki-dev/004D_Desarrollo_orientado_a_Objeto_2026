package com.video.juegos.model;

public abstract class Videojuego {
    private String titulo;
    private String plataforma;
    private String portada;
    
    public Videojuego(String titulo, String plataforma, String portada) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.portada = portada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getPortada() {
        return portada;
    }
    
    public void setPortada(String portada) {
        this.portada = portada;
    }

    public abstract String getTipo();
}

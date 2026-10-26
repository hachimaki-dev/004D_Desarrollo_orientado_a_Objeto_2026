package com.gamevault.Modelo;

public class Videojuego {
    public String titulo;
    public String plataforma;
    public String portadaUrl;

    public Videojuego(String titulo, String plataforma, String portadaUrl) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.portadaUrl = portadaUrl;
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

    public String getPortadaUrl() {
        return portadaUrl;
    }

    public void setPortadaUrl(String portadaUrl) {
        this.portadaUrl = portadaUrl;
    }
    
}

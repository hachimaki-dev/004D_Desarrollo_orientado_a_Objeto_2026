package com.gamesvault.model;

public class Videojuego {
    private String titulo;
    private String plataforma;
    private String portadaURL;

    Videojuego(String titulo,String plataforma,String portadaURL){
        titulo = this.titulo;
        plataforma = this.plataforma;
        portadaURL = this.portadaURL;
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
    public String getPortadaURL() {
        return portadaURL;
    }
    public void setPortadaURL(String portadaURL) {
        this.portadaURL = portadaURL;
    }

    
}

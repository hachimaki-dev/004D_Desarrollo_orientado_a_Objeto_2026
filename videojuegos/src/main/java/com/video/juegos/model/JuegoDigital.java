package com.video.juegos.model;

public class JuegoDigital extends Videojuego{

    private int tamanoGB;
    private String codigoActivacion;

    public JuegoDigital(String titulo, String plataforma, String portada, int tamanoGB, String codigoActivacion) {
        super(titulo, plataforma, portada);
        this.tamanoGB = tamanoGB;
        this.codigoActivacion = codigoActivacion;
    }

    public int getTamanoGB() {
        return tamanoGB;
    }

    public void setTamanoGB(int tamanoGB) {
        this.tamanoGB = tamanoGB;
    }

    public String getCodigoActivacion() {
        return codigoActivacion;
    }

    public void setCodigoActivacion(String codigoActivacion) {
        this.codigoActivacion = codigoActivacion;
    }

}

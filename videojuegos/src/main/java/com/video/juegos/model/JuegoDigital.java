package com.video.juegos.model;

public class JuegoDigital extends Videojuego{

    private double tamanoGB;
    private String codigoActivacion;

    public JuegoDigital(String titulo, String plataforma, String portada, double tamanoGB, String codigoActivacion) {
        super(titulo, plataforma, portada);
        this.tamanoGB = tamanoGB;
        this.codigoActivacion = codigoActivacion;
    }

    public double getTamanoGB() {
        return tamanoGB;
    }

    public void setTamanoGB(double tamanoGB) {
        this.tamanoGB = tamanoGB;
    }

    public String getCodigoActivacion() {
        return codigoActivacion;
    }

    public void setCodigoActivacion(String codigoActivacion) {
        this.codigoActivacion = codigoActivacion;
    }

    @Override
    public String getTipo() {
        return "Digital";
    }

}

package com.gamevault.Modelo;

public class JuegoDigital extends Videojuego{
    public int tamanoGB;
    public String codigoActivacion;

    public JuegoDigital(String titulo, String plataforma, String portadaUrl, int tamanoGB, String codigoActivacion) {
        super(titulo, plataforma, portadaUrl);
        this.tamanoGB = tamanoGB;
        this.codigoActivacion = codigoActivacion;


    }

    public int getTamanoGB() {
        return tamanoGB;
    }

    public String getCodigoActivacion() {
        return codigoActivacion;
    }

    
}

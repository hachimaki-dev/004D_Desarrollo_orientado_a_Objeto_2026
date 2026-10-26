package com.gamesvault.model;

public class JuegoDigital extends Videojuego {
    private int tamanoGB;
    private String codigoActivacion;

    JuegoDigital(String titulo,String plataforma,String portadaURL, int tamanoGB, String codigoActivacion){
        super(titulo,plataforma,portadaURL);
        tamanoGB = this.tamanoGB;
        codigoActivacion = this.codigoActivacion;
    }
}

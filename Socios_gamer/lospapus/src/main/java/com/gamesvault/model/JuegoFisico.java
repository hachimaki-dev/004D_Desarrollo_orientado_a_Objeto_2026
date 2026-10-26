package com.gamesvault.model;

public class JuegoFisico extends Videojuego{
    private int StockTienda;
    private int PesoGramos;

    JuegoFisico(String titulo,String plataforma,String portadaURL){
        super(titulo, plataforma, portadaURL);
        StockTienda = this.StockTienda;
        PesoGramos = this.PesoGramos;
    }
}

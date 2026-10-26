package com.hachimakidev.biblioapp.model;

public class Juegofisico extends Videojuego{
    private int StockTienda;
    private int pesoGramos;

    public  Juegofisico(String Titulo , String Plataforma , String Portada , int StockTienda , int pesoGramos ){

        super(Titulo, Plataforma, Portada);
        this.StockTienda = StockTienda ;
        this.pesoGramos = pesoGramos ;

    }



    public int getStockTienda() {
        return StockTienda;
    }
    public int getPesoGramos() {
        return pesoGramos;
    }
}

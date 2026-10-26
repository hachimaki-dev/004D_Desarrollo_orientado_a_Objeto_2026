package com.amaro.gamevault.model;

public class JuegoFisico extends Videojuego{
    private int stockTienda;
    private int pesoGramos;

    JuegoFisico(String titulo, String plataforma, String portada, int stockTienda, int pesoGramos) {
        super(titulo, plataforma, portada);
        this.stockTienda = stockTienda;
        this.pesoGramos = pesoGramos;
    }

    public int getStockTienda() {
        return stockTienda;
    }
    public void setStockTienda(int stockTienda) {
        this.stockTienda = stockTienda;
    }

    public int getPesoGramos() {
        return pesoGramos;
    }
    public void setPesoGramos(int pesoGramos) {
        this.pesoGramos = pesoGramos;
    }
}

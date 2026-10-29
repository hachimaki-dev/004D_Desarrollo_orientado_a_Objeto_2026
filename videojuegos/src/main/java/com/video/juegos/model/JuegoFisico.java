package com.video.juegos.model;

public class JuegoFisico extends Videojuego {
    private int stockTienda;
    private double pesoGramos;

    public JuegoFisico(String titulo, String plataforma, String portada, int stockTienda, double pesoGramos) {
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

    public double getPesoGramos() {
        return pesoGramos;
    }

    public void setPesoGramos(double pesoGramos) {
        this.pesoGramos = pesoGramos;
    }

    @Override
    public String getTipo() {
        return "Físico";
    }

}

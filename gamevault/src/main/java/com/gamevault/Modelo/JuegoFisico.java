package com.gamevault.Modelo;

public class JuegoFisico extends Videojuego{
    public int stockTienda;
    public int pesoGramos;
    
    public JuegoFisico(String titulo, String plataforma, String portadaUrl, int stockTienda, int pesoGramos) {
        super(titulo, plataforma, portadaUrl);
        this.stockTienda = stockTienda;
        this.pesoGramos = pesoGramos;
    }

    public int getStockTienda() {
        return stockTienda;
    }

    public int getPesoGramos() {
        return pesoGramos;
    }
    
    
}

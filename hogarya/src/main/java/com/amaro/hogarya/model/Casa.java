package com.amaro.hogarya.model;

public class Casa extends Propiedad {
    private int cantidadPisos;
    private int tienePatio;

    // INSERT
    public Casa(String tipo, String direccion, int arriendoBase, int metrosCuadrados, int cantidadPisos, int tienePisos) {
        super(tipo, direccion, arriendoBase, metrosCuadrados);
        this.cantidadPisos = cantidadPisos;
        this.tienePatio = tienePisos;
    }

    // SELECT y UPDATE
    public Casa(int id, String tipo, String direccion, int arriendoBase, int metrosCuadrados, int cantidadPisos, int tienePisos) {
        super(id, tipo, direccion, arriendoBase, metrosCuadrados);
        this.cantidadPisos = cantidadPisos;
        this.tienePatio = tienePisos;
    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }
    public void setCantidadPisos(int cantidadPisos) {
        this.cantidadPisos = cantidadPisos;
    }
    public int getTienePatio() {
        return tienePatio;
    }
    public void setTienePatio(int tienePatio) {
        this.tienePatio = tienePatio;
    }

    @Override
    public String obtenerTipo() {
        return getTipo();
        
    }
    @Override
    public int calcularPagoMensual() {
        return getArriendoBase();
    }
    @Override
    public String getDetalles() {
        return "Casa | Pisos: " + getCantidadPisos() + " | Patio (1 = Sí / 0 = No):" + getTienePatio() + " ";
    }
}

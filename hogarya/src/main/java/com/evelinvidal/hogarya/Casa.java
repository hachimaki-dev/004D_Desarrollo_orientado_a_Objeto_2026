package com.evelinvidal.hogarya;

public class Casa extends Propiedad {
    private int cantidadPisos;
    private boolean tienePatio;

    public Casa() {
        super();
    }

    public Casa(String direccion, double arriendoBase, int metrosCuadrados, int cantidadPisos, boolean tienePatio) {
        super(direccion, arriendoBase, metrosCuadrados);
        this.cantidadPisos = cantidadPisos;
        this.tienePatio = tienePatio;
    }

    public Casa(int id, String direccion, double arriendoBase, int metrosCuadrados, int cantidadPisos, boolean tienePatio) {
        super(id, direccion, arriendoBase, metrosCuadrados);
        this.cantidadPisos = cantidadPisos;
        this.tienePatio = tienePatio;
    }

    @Override
    public String getTipo() {
        return "CASA";
    }

    @Override
    public double calcularPagoMensual() {
        return getArriendoBase();
    }

    @Override
    public String getDetalle() {
        return cantidadPisos + " piso(s)" + (tienePatio ? " - Con patio" : " - Sin patio");
    }

    // Getters y Setters
    public int getCantidadPisos() { return cantidadPisos; }
    public void setCantidadPisos(int cantidadPisos) { this.cantidadPisos = cantidadPisos; }

    public boolean isTienePatio() { return tienePatio; }
    public void setTienePatio(boolean tienePatio) { this.tienePatio = tienePatio; }
}
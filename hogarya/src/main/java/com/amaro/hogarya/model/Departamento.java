package com.amaro.hogarya.model;

public class Departamento extends Propiedad {
    private int numeroPiso;
    private int gastosComunes;

    // INSERT
    public Departamento(String tipo, String direccion, int arriendoBase, int metrosCuadrados, int numeroPiso, int gastosComunes) {
        super(tipo, direccion, arriendoBase, metrosCuadrados);
        this.numeroPiso = numeroPiso;
        this.gastosComunes = gastosComunes;
    }

    // SELECT y UPDATE
    public Departamento(int id, String tipo, String direccion, int arriendoBase, int metrosCuadrados, int numeroPiso,
            int gastosComunes) {
        super(id, tipo, direccion, arriendoBase, metrosCuadrados);
        this.numeroPiso = numeroPiso;
        this.gastosComunes = gastosComunes;
    }
    public int getNumeroPiso() {
        return numeroPiso;
    }
    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }
    public int getGastosComunes() {
        return gastosComunes;
    }
    public void setGastosComunes(int gastosComunes) {
        this.gastosComunes = gastosComunes;
    }

    @Override
    public String obtenerTipo() {
        return null;
    }
    @Override
    public int calcularPagoMensual() {
        return getArriendoBase() + getGastosComunes();
    }
    @Override 
    public String getDetalles() {
        return "Casa | Pisos: " + getNumeroPiso() + " | Gastos comunes: $" + getGastosComunes() + " ";
    }
}

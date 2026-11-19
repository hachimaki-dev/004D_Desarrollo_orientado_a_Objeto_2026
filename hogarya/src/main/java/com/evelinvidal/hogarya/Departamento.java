package com.evelinvidal.hogarya;

public class Departamento extends Propiedad {
    private int numeroPiso;
    private double gastosComunes;

    public Departamento() {
        super();
    }

    public Departamento(String direccion, double arriendoBase, int metrosCuadrados, int numeroPiso, double gastosComunes) {
        super(direccion, arriendoBase, metrosCuadrados);
        this.numeroPiso = numeroPiso;
        this.gastosComunes = gastosComunes;
    }

    public Departamento(int id, String direccion, double arriendoBase, int metrosCuadrados, int numeroPiso, double gastosComunes) {
        super(id, direccion, arriendoBase, metrosCuadrados);
        this.numeroPiso = numeroPiso;
        this.gastosComunes = gastosComunes;
    }

    @Override
    public String getTipo() {
        return "DEPARTAMENTO";
    }

    @Override
    public double calcularPagoMensual() {
        return getArriendoBase() + gastosComunes;
    }

    @Override
    public String getDetalle() {
        return "Piso " + numeroPiso + " - Gastos Comunes: $" + (int) gastosComunes;
    }

    // Getters y Setters
    public int getNumeroPiso() { return numeroPiso; }
    public void setNumeroPiso(int numeroPiso) { this.numeroPiso = numeroPiso; }

    public double getGastosComunes() { return gastosComunes; }
    public void setGastosComunes(double gastosComunes) { this.gastosComunes = gastosComunes; }
}

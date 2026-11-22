package com.evelinvidal.Modelo;

public class Departamento extends Propiedad {
    private int numeroPiso;
    private int gastosComunes;

    public Departamento(int id, String direccion, int arriendoBase, int metrosCuadrados, int numeroPiso, int gastosComunes) {
        super(id, direccion, arriendoBase, metrosCuadrados);
        this.numeroPiso = numeroPiso;
        this.gastosComunes = gastosComunes;
    }

    @Override
    public String getTipo() {
        return "DEPARTAMENTO";
    }

    @Override
    public int calcularPagoMensual() {
        return arriendoBase + gastosComunes;
    }

    @Override
    public String getDetalle() {
        return "Piso " + numeroPiso + " | Gastos comunes: $" + gastosComunes;
    }

    public int getNumeroPiso() { return numeroPiso; }
    public void setNumeroPiso(int numeroPiso) { this.numeroPiso = numeroPiso; }

    public int getGastosComunes() { return gastosComunes; }
    public void setGastosComunes(int gastosComunes) { this.gastosComunes = gastosComunes; }
}
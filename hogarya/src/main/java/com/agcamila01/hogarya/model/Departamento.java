package com.agcamila01.hogarya.model;

public class Departamento extends Propiedad {
    private int numeroPiso;
    private int gastosComunes;

    public Departamento(int id, String direccion, int arriendoBase, int metrosCuadrados, int numeroPiso,
            int gastosComunes) {
        super(id, direccion, arriendoBase, metrosCuadrados);
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
    public String getTipo() {
        return "Departamento";
    }

    @Override 
    public int calcularPagoMensual() {
        return this.getArriendoBase() + this.getGastosComunes();
    }

    @Override 
    public String getDetalle() {
        return "COMPLETAR DETALLE DEPARTAMENTO";
    }
}

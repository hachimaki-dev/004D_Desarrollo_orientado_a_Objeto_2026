package com.hachimakidev.musicstore.model;

public class Guitarra extends Instrumento {

    private int cuerdas;
    private String tipoPastilla;

    public Guitarra() {}

    public Guitarra(int id, String marca, String modelo, int precio, boolean disponible, int cuerdas, String tipoPastilla) {
        super(id, marca, modelo, precio, disponible);
        this.cuerdas = cuerdas;
        this.tipoPastilla = tipoPastilla;
    }

    @Override
    public String getTipo() {
        return "Guitarra";
    }

    @Override
    public String getEspecificacion() {
        return cuerdas + " cuerdas · " + tipoPastilla;
    }

    public int getCuerdas() {
        return cuerdas;
    }

    public void setCuerdas(int cuerdas) {
        this.cuerdas = cuerdas;
    }

    public String getTipoPastilla() {
        return tipoPastilla;
    }

    public void setTipoPastilla(String tipoPastilla) {
        this.tipoPastilla = tipoPastilla;
    }
}


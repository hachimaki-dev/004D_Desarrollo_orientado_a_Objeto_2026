package com.hachimakidev.musicstore.model;

public class Teclado extends Instrumento {

    private int teclas;
    private int ritmosIntegrados;

    public Teclado() {}

    public Teclado(int id, String marca, String modelo, int precio, boolean disponible, int teclas, int ritmosIntegrados) {
        super(id, marca, modelo, precio, disponible);
        this.teclas = teclas;
        this.ritmosIntegrados = ritmosIntegrados;
    }

    @Override
    public String getTipo() {
        return "Teclado";
    }

    @Override
    public String getEspecificacion() {
        return teclas + " teclas · " + ritmosIntegrados + " ritmos";
    }

    public int getTeclas() {
        return teclas;
    }

    public void setTeclas(int teclas) {
        this.teclas = teclas;
    }

    public int getRitmosIntegrados() {
        return ritmosIntegrados;
    }

    public void setRitmosIntegrados(int ritmosIntegrados) {
        this.ritmosIntegrados = ritmosIntegrados;
    }
}


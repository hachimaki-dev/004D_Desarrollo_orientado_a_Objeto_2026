package com.hachimakidev.techstore.model;

public class Notebook extends Dispositivo {

    private int ramGb;
    private String procesador;

    public Notebook() {}

    public Notebook(int id, String marca, String modelo, int precio, boolean disponible, int ramGb, String procesador) {
        super(id, marca, modelo, precio, disponible);
        this.ramGb = ramGb;
        this.procesador = procesador;
    }

    @Override
    public String getTipo() {
        return "Notebook";
    }

    @Override
    public String getEspecificacion(){
        return ramGb + " GB RAM · " + procesador ;
    }

    public int getRamGb() {
        return ramGb;
    }

    public void setRamGb(int ramGb) {
        this.ramGb = ramGb;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }
}


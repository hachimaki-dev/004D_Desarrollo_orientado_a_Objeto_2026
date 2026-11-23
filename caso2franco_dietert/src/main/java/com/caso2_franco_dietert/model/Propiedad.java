package com.caso2_franco_dietert.model;

public abstract class Propiedad {

    int id;
    String direccion;
    int arriendoBase;
    int metrosCuadrados;

    public Propiedad (int id, String direccion, int arriendoBase, int metrosCuadrados) {
        this.id = id;
        this.direccion = direccion;
        this.arriendoBase = arriendoBase;
        this.metrosCuadrados = metrosCuadrados;
    }

     public int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getArriendoBase() {
        return arriendoBase;
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public abstract double calcularPagoMensual ();

    public abstract String getTipo ();

    public abstract String getDetalle ();
}




// (id, direccion, arriendoBase, metrosCuadrados) con métodos abstractos getTipo(), calcularPagoMensual() y getDetalle().
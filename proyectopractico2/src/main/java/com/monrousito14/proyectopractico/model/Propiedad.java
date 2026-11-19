package com.monrousito14.proyectopractico.model;

public abstract class Propiedad {
    
    private int id;
    private String direccion;
    private int arriendoBase;
    private int metrosCuadrados;

    public Propiedad(int id, String direccion, int arriendoBase, int metrosCuadrados){ 
        this.id = id;
        this.direccion = direccion;
        this.arriendoBase = arriendoBase;
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getId(){
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getArriendoBase() {
        return arriendoBase;
    }

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public abstract String getTipo();

    public abstract double calcularPagoMensual();

    public abstract String getDetalle();
}

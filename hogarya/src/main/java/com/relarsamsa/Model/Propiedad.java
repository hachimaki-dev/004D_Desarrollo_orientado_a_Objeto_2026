package com.relarsamsa.Model;

public abstract class Propiedad {
    private int id;
    private String direccion;
    private int arriendoBase;
    private int metrosCuadrados;

    public Propiedad(int id, String direccion, int arriendoBase, int metrosCuadrados) {
        this.id = id;
        this.direccion = direccion;
        this.arriendoBase = arriendoBase;
        this.metrosCuadrados = metrosCuadrados;
    }
    
    public Propiedad(String direccion, int arriendoBase, int metrosCuadrados) {
        this.direccion = direccion;
        this.arriendoBase = arriendoBase;
        this.metrosCuadrados = metrosCuadrados;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getArriendoBase() {
        return arriendoBase;
    }
    public void setArriendoBase(int arriendoBase) {
        this.arriendoBase = arriendoBase;
    }
    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }
    public void setMetrosCuadrados(int metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }
    
    public abstract String getTipo();
    public abstract double calcularPagoMensual();
    public abstract String getDetalle();
}

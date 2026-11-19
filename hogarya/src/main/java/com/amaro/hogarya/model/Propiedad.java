package com.amaro.hogarya.model;

public abstract class Propiedad {
    private int id;
    private String tipo;
    private String direccion;
    private int arriendoBase;
    private int metrosCuadrados;
    
    // INSERT
    public Propiedad(String tipo, String direccion, int arriendoBase, int metrosCuadrados) {
        this.tipo = tipo;
        this.direccion = direccion;
        this.arriendoBase = arriendoBase;
        this.metrosCuadrados = metrosCuadrados;
    }
    
    // SELECT and UPDATE
    public Propiedad(int id, String tipo, String direccion, int arriendoBase, int metrosCuadrados) {
        this.id = id;
        this.tipo = tipo;
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
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public abstract String obtenerTipo();

    public abstract int calcularPagoMensual();

    public String getDetalles() {
        return "Tipo: " + getTipo() + " | Dirección: " + getDireccion() + " | Arriendo Base: " + getArriendoBase() + " | Área: " + getMetrosCuadrados() + " m2"; 
    };
}

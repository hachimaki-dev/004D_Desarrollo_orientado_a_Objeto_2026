package com.evelinvidal.hogarya;

public abstract class Propiedad {
    private int id;
    private String direccion;
    private double arriendoBase;
    private int metrosCuadrados;

    public Propiedad() {}

    public Propiedad(String direccion, double arriendoBase, int metrosCuadrados) {
        this.direccion = direccion;
        this.arriendoBase = arriendoBase;
        this.metrosCuadrados = metrosCuadrados;
    }

    public Propiedad(int id, String direccion, double arriendoBase, int metrosCuadrados) {
        this.id = id;
        this.direccion = direccion;
        this.arriendoBase = arriendoBase;
        this.metrosCuadrados = metrosCuadrados;
    }

    public abstract String getTipo();
    public abstract double calcularPagoMensual();
    public abstract String getDetalle();

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public double getArriendoBase() { return arriendoBase; }
    public void setArriendoBase(double arriendoBase) { this.arriendoBase = arriendoBase; }

    public int getMetrosCuadrados() { return metrosCuadrados; }
    public void setMetrosCuadrados(int metrosCuadrados) { this.metrosCuadrados = metrosCuadrados; }
}

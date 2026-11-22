package com.evelinvidal.Modelo;

public abstract class Propiedad {
    protected int id;
    protected String direccion;
    protected int arriendoBase;
    protected int metrosCuadrados;

    public Propiedad(int id, String direccion, int arriendoBase, int metrosCuadrados) {
        this.id = id;
        this.direccion = direccion;
        this.arriendoBase = arriendoBase;
        this.metrosCuadrados = metrosCuadrados;
    }

    // Métodos abstractos exigidos por la pauta
    public abstract String getTipo();
    public abstract int calcularPagoMensual();
    public abstract String getDetalle();

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public int getArriendoBase() { return arriendoBase; }
    public void setArriendoBase(int arriendoBase) { this.arriendoBase = arriendoBase; }

    public int getMetrosCuadrados() { return metrosCuadrados; }
    public void setMetrosCuadrados(int metrosCuadrados) { this.metrosCuadrados = metrosCuadrados; }
}

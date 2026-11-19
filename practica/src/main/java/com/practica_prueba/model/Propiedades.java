package com.practica_prueba.model;

public abstract class  Propiedades {
    private int id;
    private String direccion;
    private double arriendobase;
    private double metroCuadrado;

    public Propiedades(){
    }

    public Propiedades(String direccion,double arriendobase, double metroCuadrado){
        this.direccion = direccion;
        this.arriendobase = arriendobase;
        this.metroCuadrado = metroCuadrado;
    }

     public Propiedades(int id, String direccion, double arriendoBase, double metrosCuadrados) {
        this.id = id;
        this.direccion = direccion;
        this.arriendobase = arriendoBase;
        this.metroCuadrado = metrosCuadrados;
    }

    public abstract String getTipo();

    public abstract double calcularPagoMansual();

    public abstract String  getDetalle();

    public double getPagomensual(){
        return calcularPagoMansual();
    };

    public int setId(){
        return id;
    };

    public void setId(int id ){
        this.id = id;
    };

    public String getDireccion(){
        return direccion;
    };

    public void setDireccion(String direccion){
        this.direccion = direccion;
    };

     public void setArriendoBase(double arriendoBase) {
        this.arriendobase = arriendoBase;
    }

    public double getmetrosCuadrados() {
        return metroCuadrado();
    }

    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metroCuadrado = metrosCuadrados;
    }

}
{}
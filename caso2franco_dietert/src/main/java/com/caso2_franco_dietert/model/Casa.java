package com.caso2_franco_dietert.model;

public class Casa extends Propiedad {

    int cantidadPisos;
    boolean tienePatio;

    public Casa(int id, String direccion, int arriendoBase, int metrosCuadrados, int cantidadPisos, boolean tienePatio) {
        super(id, direccion, arriendoBase, metrosCuadrados);
       
        this.cantidadPisos = cantidadPisos;
        this.tienePatio = tienePatio;

    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public boolean isTienePatio() {
        return tienePatio;
    }

//---------------------------------------------

    @Override 

    public double calcularPagoMensual () {

        return arriendoBase;
    }

    @Override 

    public String getTipo() {

        return "Casa";
    }

    @Override 

    public String getDetalle () {

        String detalle;
        String conPatio;

        if (tienePatio) {

            conPatio = "tiene patio";

            detalle = "Direccion " + direccion + " con " + metrosCuadrados + " metros cuadrados y arriendo base de  $" + arriendoBase  + ", casa de " + cantidadPisos + " pisos y " + conPatio;

        } else {

            conPatio = "no tiene patio";

            detalle = "Direccion " + direccion + " con " + metrosCuadrados + " metros cuadrados y arriendo base de  $" + arriendoBase  + ", casa de " + cantidadPisos + " pisos y " + conPatio;

        }

        return detalle;

    }
    

}

    // int id;
    // String direccion;
    // int arriendoBase;
    // int metrosCuadrados;


// (cantidadPisos, tienePatio): calcularPagoMensual() retorna arriendoBase.
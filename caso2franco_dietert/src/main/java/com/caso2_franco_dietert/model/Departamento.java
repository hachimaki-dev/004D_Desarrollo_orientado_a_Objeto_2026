package com.caso2_franco_dietert.model;

public class Departamento extends Propiedad{

    int numeroPiso;
    int gastosComunes;

    public Departamento(int id, String direccion, int arriendoBase, int metrosCuadrados, int numeroPiso, int gastosComunes) {
        super(id, direccion, arriendoBase, metrosCuadrados);
       
        this.numeroPiso = numeroPiso;
        this.gastosComunes = gastosComunes;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public int getGastosComunes() {
        return gastosComunes;
    }

//----------------------------------------------------

    @Override 

    public double calcularPagoMensual () {

        return arriendoBase + gastosComunes;
    }

    @Override 

    public String getTipo () {

        return "Departamento";
    }

    @Override 

    public String getDetalle () {

        String detalle;

        detalle = "Direccion " + direccion + " departamento con " + metrosCuadrados + " metros cuadrados y ubicado en el piso " + numeroPiso+  ", el arriendo base es $" + arriendoBase + " y $" + gastosComunes + " en gastos comunes";
  
        return detalle;
    }
    
}


// Dirección.
// Metros cuadrados.
// Arriendo base.
// Número de piso.
// Gastos comunes.
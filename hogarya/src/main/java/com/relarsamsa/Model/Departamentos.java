package com.relarsamsa.Model;

public class Departamentos extends Propiedad {
    private int numeroPiso;
    private int gastosComunes;

    public Departamentos(int id, String direccion, int arriendoBase, int metrosCuadrados, int numeroPiso,
            int gastosComunes) {
        super(id, direccion, arriendoBase, metrosCuadrados);
        this.numeroPiso = numeroPiso;
        this.gastosComunes = gastosComunes;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }
    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }
    public int getGastosComunes() {
        return gastosComunes;
    }
    public void setGastosComunes(int gastosComunes) {
        this.gastosComunes = gastosComunes;
    }

    @Override
    public String getTipo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTipo'");
    }

    @Override
    public String getDetalle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDetalle'");
    }
    
    @Override
    public double calcularPagoMensual() {
        // TODO Auto-generated method stub
        return arriendoBase + gastosComunes ;
    }

    
}

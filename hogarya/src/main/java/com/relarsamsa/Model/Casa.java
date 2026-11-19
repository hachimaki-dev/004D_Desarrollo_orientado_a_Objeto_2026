package com.relarsamsa.Model;

public class Casa extends Propiedad{
    private int cantidadPisos;
    private boolean tienePatio;

    public Casa(int id, String direccion, int arriendoBase, int metrosCuadrados, int cantidadPisos,
            boolean tienePatio) {
        super(id, direccion, arriendoBase, metrosCuadrados);
        this.cantidadPisos = cantidadPisos;
        this.tienePatio = tienePatio;
    }

    @Override
    public double calcularPagoMensual() {
        // TODO Auto-generated method stub
        return arriendoBase;
    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }
    public void setCantidadPisos(int cantidadPisos) {
        this.cantidadPisos = cantidadPisos;
    }
    public boolean isTienePatio() {
        return tienePatio;
    }
    public void setTienePatio(boolean tienePatio) {
        this.tienePatio = tienePatio;
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

    
}

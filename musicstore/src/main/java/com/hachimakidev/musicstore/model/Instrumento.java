package com.hachimakidev.musicstore.model;

public abstract class Instrumento {

    private int id;
    private String marca;
    private String modelo;
    private int precio;
    private boolean disponible;

    public Instrumento() {}

    public Instrumento(int id, String marca, String modelo, int precio, boolean disponible) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.disponible = disponible;
    }

    // Métodos polimórficos que cada subclase implementa (útiles para las columnas del TableView)
    public abstract String getTipo();
    public abstract String getEspecificacion();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}


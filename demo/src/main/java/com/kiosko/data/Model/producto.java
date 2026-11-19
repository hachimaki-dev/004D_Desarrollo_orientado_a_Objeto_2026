package com.kiosko.data.Model;

public class producto 
{
    
    private String nombre;

    private String categoria;

    private int precio;

    private int stock;

    public producto(String nombre, String categoria, int precio, int stock)
    {

        this.nombre = nombre;

        this.categoria = categoria;

        this.precio = precio;

        this.stock = stock;

    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getCategoria() 
    {
        return categoria;
    }

    public void setCategoria(String categoria) 
    {
        this.categoria = categoria;
    }

    public int getPrecio() 
    {
        return precio;
    }

    public void setPrecio(int precio) 
    {
        this.precio = precio;
    }

    public int getStock() 
    {
        return stock;
    }

    public void setStock(int stock) 
    {
        this.stock = stock;
    }
}

package com.shunsui2.Modelo;

public class Producto {
    // Clase Producto con id, nombre, categoria, precio y stock, aplicando sobrecarga de constructores (sin id para insertar y con id para leer)
    private int id ;
    private String nombre ;
    private String categoria ;
    private int precio;
    private int stock ;

    // Constructor Sin Id
    public Producto(String nombre , String categoria , int precio , int stock){
        
        this.nombre = nombre;      
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    // Constructor Con Id
    public Producto(int id , String nombre , String categoria , int precio , int stock){
        this.id = id;
        this.nombre = nombre;      
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    // Respectivos Getter y Setter de los Atributos del esta Clase 
    public int getId(){
        return this.id ;
    }

    public  String getNombre(){
        return  this.nombre;
    }

    public  String getCategoria(){
        return  this.categoria;
    }

    public int getPrecio(){
        return this.precio ;
    }

    public int getStock(){
        return this.stock ;
    }


    public void setter_Id(int id){
        this.id = id;
    }

    public void  setter_nombre(String nombre){
        this.nombre = nombre ;
    }

    public void  setter_categoria(String categoria){
        this.categoria = categoria ;
    }

    public void setter_stock(int stock){
         this.stock = stock ;
    }

    public void setter_precio(int precio){
         this.precio = precio ;
    }
    
}

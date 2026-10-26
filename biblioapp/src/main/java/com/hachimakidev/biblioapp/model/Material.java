package com.hachimakidev.biblioapp.model;


public abstract class  Material {

    private String titulo;
    private String fechaPublicacion;

    public Material(String titulo, String fechaPublicacion){
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
    }
    
    public String getTitulo(){
        return titulo;
    }
    

    public String get_fechapublicacion(){
        return fechaPublicacion;
    }




}

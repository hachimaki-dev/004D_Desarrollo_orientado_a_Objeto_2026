package com.hachimakidev.biblioapp.model;

public class Libros extends  Material {
    
    private String autor ;
    private int numero_paginas ;
    
    
    public Libros(String titulo , String fechaPublicacion , String autor , int numero_paginas){

        super(titulo, fechaPublicacion);
        this.autor = autor;
        this.numero_paginas = numero_paginas;
    } 

    public String getAutor(){
        return autor;
    }

    public int getNumeroPaginas(){
        return numero_paginas ;
    }

}

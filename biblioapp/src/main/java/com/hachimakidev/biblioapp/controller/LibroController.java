package com.hachimakidev.biblioapp.controller;
import com.hachimakidev.biblioapp.model.Libros;

import com.hachimakidev.biblioapp.model.LibroManager;

public class LibroController {
    
    public void test(){
        LibroManager libro_manager = new LibroManager();
        libro_manager.aVerSiEsVerdad();
    }

    public Libros buscarPorTitulo(String titulo){
        LibroManager administracion_de_libros = new LibroManager();
        Libros libro_encontrado =  administracion_de_libros.devolverTitulo(titulo);

        return libro_encontrado ;

    }

}

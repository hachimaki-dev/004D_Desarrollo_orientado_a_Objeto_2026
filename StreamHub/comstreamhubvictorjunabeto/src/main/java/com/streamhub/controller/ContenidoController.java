package com.streamhub.controller;

import com.streamhub.model.Contenido;
import com.streamhub.model.ContenidoManager;

public class ContenidoController {
    private  ContenidoManager manager;

    public ContenidoController(){
        manager = new ContenidoManager();
    }

    public boolean datos_disponibles(){
        return  manager.isDatosCargados();
    }
    public Contenido buscarTitulo(String titulo_ingresado){
        String titulo = titulo_ingresado.trim();
        return manager.buscarTitulo(titulo);

    } 

}

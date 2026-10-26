package com.hachimakidev.biblioapp.controller;

import com.hachimakidev.biblioapp.model.RevistaManager;
import com.hachimakidev.biblioapp.model.Revistas;

public class RevistaController {
    
    public void test(){
        RevistaManager revista_manager = new RevistaManager();
        revista_manager.aVerSiEsVerdad();
    }

    public Revistas buscarPorTitulo(String titulo){
        RevistaManager administracion_de_revistas = new  RevistaManager();
        Revistas revista_encontrada =  administracion_de_revistas.devolverRevistaPorTitulo(titulo);

        return revista_encontrada ;

    }

}

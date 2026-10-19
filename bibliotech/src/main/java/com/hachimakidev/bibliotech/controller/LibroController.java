package com.hachimakidev.bibliotech.controller;
import com.hachimakidev.bibliotech.model.BookManager;
import com.hachimakidev.bibliotech.model.Libro;


public class LibroController {
        private BookManager manager;

        public LibroController(){
            manager = new BookManager();
        }

        public boolean datosDisponibles(){
            return manager.isDatosCargados();
        }

        public Libro buscarLibro(String libro_ingresado){
            String libro_limpio = libro_ingresado.trim();
            return manager.buscarPorNombre(libro_limpio);
        }
    }
    

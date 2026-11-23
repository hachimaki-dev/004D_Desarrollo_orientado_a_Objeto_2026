package com.tab.kiosco.controller;

import java.util.ArrayList;

import com.tab.kiosco.dao.ProductoDAO;
import com.tab.kiosco.model.Producto;

public class ProductoController {
        private ProductoDAO productoDAO;

    public ProductoController() {
        this.productoDAO = new ProductoDAO();
    }

    public boolean registrarProducto(String nombre, String categoria, String precioTexto, String stockTexto) {
    if (nombre == null || nombre.isBlank() ||
        categoria == null || categoria.isBlank() ||
        precioTexto == null || precioTexto.isBlank() ||
        stockTexto == null || stockTexto.isBlank()) {
        return false;
}

    try {
    int precio = Integer.parseInt(precioTexto.trim());
    int stock = Integer.parseInt(stockTexto.trim());

    if (precio <= 0 || stock < 0) {
        return false;
    }
    Producto nuevo = new Producto(nombre.trim(), categoria.trim(), precio, stock);
    return productoDAO.guardar(nuevo);

    } catch (NumberFormatException e) {
    return false;
}
    }



    public ArrayList<Producto> obtenerProductos() {
        return productoDAO.obtenerTodos();
    }

    

    public boolean actualizarProducto(int id, String nombre, String categoria, String precioTexto, String stockTexto) {
        if (id <= 0 ||
            nombre == null || nombre.isBlank() ||
            categoria == null || categoria.isBlank() ||
             precioTexto == null|| precioTexto.isBlank() ||
             stockTexto == null|| stockTexto.isBlank()) {
            return false;
        }
    
    try {
    int precio = Integer.parseInt(precioTexto.trim());
    int stock = Integer.parseInt(stockTexto.trim());

    if (precio <= 0 || stock < 0) {
        return false;
    }

        // Usamos el constructor CON id para indicar qué fila se está actualizando
    Producto editado = new Producto(id, nombre.trim(), categoria.trim(), precio, stock);
    return productoDAO.actualizar(editado);
    }
     catch (NumberFormatException e) {
    return false;
    }
}


    public boolean eliminarProducto(int id) {
        if (id <= 0) {
            return false;
        }
        return productoDAO.eliminar(id);
    }
}

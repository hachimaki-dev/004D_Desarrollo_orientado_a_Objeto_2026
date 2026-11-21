package com.tab.kiosco.controller;

import java.util.ArrayList;

import com.tab.kiosco.dao.ProductoDAO;
import com.tab.kiosco.model.Producto;

public class ProductoController {
        private ProductoDAO productoDAO;

    public ProductoController() {
        this.productoDAO = new ProductoDAO();
    }

    public boolean registrarProducto(String nombre, String categoria, int precio, int stock) {
        if (nombre == null || nombre.isBlank() ||
            categoria == null || categoria.isBlank() ||
             precio < 0||
             stock < 0) {
            return false;
        }

        // Usamos el constructor SIN id porque es un usuario nuevo
        Producto nuevo = new Producto(nombre.trim(), categoria.trim(), precio, stock);
        return productoDAO.guardar(nuevo);
    }

    public ArrayList<Producto> obtenerUsuarios() {
        return productoDAO.obtenerTodos();
    }

    public boolean actualizarUsuario(int id, String nombre, String categoria, int precio, int stock) {
        if (id <= 0 ||
            nombre == null || nombre.isBlank() ||
            categoria == null || categoria.isBlank() ||
             precio > 0||
             stock > 0) {
            return false;
        }

        // Usamos el constructor CON id para indicar qué fila se está actualizando
        Producto editado = new Producto(id, nombre.trim(), categoria.trim(), precio, stock);
        return productoDAO.actualizar(editado);
    }

    public boolean eliminarUsuario(int id) {
        if (id <= 0) {
            return false;
        }
        return productoDAO.eliminar(id);
    }
}

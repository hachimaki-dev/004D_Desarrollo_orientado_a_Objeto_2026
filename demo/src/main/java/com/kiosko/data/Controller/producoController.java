package com.kiosko.data.Controller;

import com.kiosko.data.Model.producto;

public class producoController 
{
    public producto chkProductoValido(String nombre, String categoria, int precio, int stock)
    {

        if (nombre == null || nombre.isEmpty() || nombre.length() > 80)
        {
            return null;
        }

        if (categoria == null || categoria.isEmpty() || categoria.length() > 40)
        {
            return null;
        }

        if (precio < 0)
        {
            return null;
        }

        if (stock < 0)
        {
            return null;
        }

        producto producto = new producto(nombre, categoria, precio, stock);

        return producto;
        
    }
}

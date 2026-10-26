package com.her.gamevault.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InventarioManager 
{
    ArrayList<Videojuego> inventario_ArrayList = new ArrayList<>(); 

    public void cargarInventario()
    {
        InputStream invInputStream = getClass().getResourceAsStream("/inventario.json");
    }
}

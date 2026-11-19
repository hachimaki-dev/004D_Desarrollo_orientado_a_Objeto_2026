package com.amaro.hogarya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.amaro.hogarya.database.ConexionDB;
import com.amaro.hogarya.model.Casa;
import com.amaro.hogarya.model.Propiedad;

public class PropiedadDAO {
    // 1. INSERT
    public boolean guardar(Propiedad propiedad) {
        String tipoObtenido = propiedad.getTipo();
        switch(tipoObtenido) {
            case "CASA":
                public boolean guardarCasa(Casa casa) {
                    String sql_casa = "INSERT INTO propiedad (tipo, direccion, arriendo_base, metros_cuadrado, cantidad_piso, tiene_patio) VALUES (?, ?, ?, ?, ?, ?)";
                    try (Connection conn = ConexionDB.obtenerConexion();
                    PreparedStatement ps = conn.prepareStatement(sql_casa)) {
                    ps.setString(1, casa.getDireccion());
                    ps.setInt(2, casa.getArriendoBase());
                    ps.setInt(3, casa.getMetrosCuadrados());
                    ps.setInt(4, casa.getCantidadPisos());
                    ps.setInt(5, casa.getTienePatio());
                    int filasAfectadas = ps.executeUpdate();
                    return filasAfectadas > 0;
                    } catch (SQLException e) {
                    System.out.println("Error al guardar casa: " + e.getMessage());
                    return false;
                    }
                }
            case "DEPARTAMENTO":
                String sql_depto = "INSERT INTO propiedad (tipo, direccion, arriendo_base, metros_cuadrado, numero_piso, gastos_comunes) VALUES (?, ?, ?, ?, ?, ?)";
                try (Connection conn = ConexionDB.obtenerConexion();
                    PreparedStatement ps = conn.prepareStatement(sql_casa)) {
                    ps.setString(1, propiedad.getDireccion());
                    ps.setInt(2, propiedad.getArriendoBase());
                    ps.setInt(3, propiedad.getMetrosCuadrados());
                    ps.setInt(4, propiedad.getCanti());
                    int filasAfectadas = ps.executeUpdate();
                    return filasAfectadas > 0;
                } catch (SQLException e) {
                    System.out.println("Error al guardar usuario: " + e.getMessage());
                    return false;
                }
            default:
        }
    }
    // 2. SELECT
    // 3. UPDATE
    // 4. DELETE
    // 5. SELECT + WHERE
}

package com.agcamila01.hogarya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.agcamila01.hogarya.database.ConexionDB;
import com.agcamila01.hogarya.model.Casa;
import com.agcamila01.hogarya.model.Departamento;
import com.agcamila01.hogarya.model.Propiedad;

public class PropiedadDAO {

    //operacion crear (create - insert)
    public boolean guardarPropiedad(Propiedad propiedad) {
        String insertSQL = """
                INSERT INTO propiedades (tipo, direccion, arriendo_base, metros_cuadrados, cantidad_pisos, tiene_patio, numero_piso, gastos_comunes)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;
        
        try (Connection connection = ConexionDB.obtenerConexion();
             PreparedStatement ps = connection.prepareStatement(insertSQL)){
            
            //datos compartidos
            ps.setString(2, propiedad.getDireccion());
            ps.setInt(3, propiedad.getArriendoBase());
            ps.setInt(4, propiedad.getMetrosCuadrados());

            if (propiedad instanceof Casa casa) {
                ps.setString(1, casa.getTipo());
                ps.setInt(5, casa.getCantidadPisos());
                ps.setInt(6, casa.isTienePatio() ? 1 : 0);
                ps.setNull(7, Types.INTEGER);
                ps.setNull(8, Types.INTEGER);
            } else if (propiedad instanceof Departamento departamento) {
                ps.setString(1, departamento.getTipo());
                ps.setNull(5, Types.INTEGER);
                ps.setNull(6, Types.INTEGER);
                ps.setInt(7, departamento.getNumeroPiso());
                ps.setInt(8, departamento.getGastosComunes());
            } else {
                throw new SQLException("La propiedad solo puede ser CASA o DEPARTAMENTO");
            }

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al guardar la propiedad: " + e.getMessage());
            return false;
        }
    }
    
    //operacion listar todo (read - select)
    public ArrayList<Propiedad> obtenerPropiedades() {
        ArrayList<Propiedad> listaPropiedades = new ArrayList<>();
        String selectSQL = """
                SELECT id, tipo, direccion, arriendo_base, metros_cuadrados, cantidad_pisos, tiene_patio, numero_piso, gastos_comunes
                FROM propiedades
                ORDER BY id ASC
                """;

        try (Connection connection = ConexionDB.obtenerConexion();
             PreparedStatement ps = connection.prepareStatement(selectSQL);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String direccion = rs.getString("direccion");
                int arriendoBase = rs.getInt("arriendo_base");
                int metrosCuadrados = rs. getInt("metros_cuadrados");
                String tipoPropiedad = rs.getString("tipo");

                Propiedad propiedad;
                if ("CASA".equals(tipoPropiedad)) {
                    int cantidadPisos = rs.getInt("cantidad_pisos");
                    boolean tienePatio = rs.getInt("tiene_patio") == 1;
                    propiedad =  new Casa(id, direccion, arriendoBase, metrosCuadrados, cantidadPisos, tienePatio);
                } else if ("DEPARTAMENTO".equals(tipoPropiedad)) {
                    int numeroPiso =  rs.getInt("numero_piso");
                    int gastosComunes = rs.getInt("gastos_comunes");
                    propiedad = new Departamento(id, direccion, arriendoBase, metrosCuadrados, numeroPiso, gastosComunes);
                } else {
                    throw new SQLException("Tipo de propiedad desconocido: " + tipoPropiedad);
                }
                listaPropiedades.add(propiedad);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar propiedades: " + e.getMessage());
        }

        return listaPropiedades;
    }

    //update
    public boolean actualizarPropiedades(Propiedad propiedad) {
        String updateSQL = """
                UPDATE propiedades
                SET tipo = ?, direccion = ?, arriendo_base = ?, metros_cuadrados = ?, cantidad_pisos = ?, tiene_patio = ?, numero_piso = ?, gastos_comunes = ?
                WHERE id = ?
                """;
        
        try (Connection connection = ConexionDB.obtenerConexion();
             PreparedStatement ps = connection.prepareStatement(updateSQL)) {
            
            ps.setString(2, propiedad.getDireccion());
            ps.setInt(3, propiedad.getArriendoBase());
            ps.setInt(4, propiedad.getMetrosCuadrados());

            if (propiedad instanceof Casa casa) {
                ps.setString(1, casa.getTipo());
                ps.setInt(5, casa.getCantidadPisos());
                ps.setInt(6, casa.isTienePatio() ? 1 : 0);
                ps.setNull(7, Types.INTEGER);
                ps.setNull(8, Types.INTEGER);
            } else if (propiedad instanceof Departamento departamento) {
                ps.setString(1, departamento.getTipo());
                ps.setNull(5, Types.INTEGER);
                ps.setNull(6, Types.INTEGER);
                ps.setInt(7, departamento.getNumeroPiso());
                ps.setInt(8, departamento.getGastosComunes());
            } else {
                throw new SQLException("La propiedad solo puede ser CASA o DEPARTAMENTO");
            }

            ps.setInt(9, propiedad.getId());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar la propiedad: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarPropiedad(int id) {
        String deleteSQL = "DELETE FROM propiedades WHERE id = ?";

        try (Connection connection = ConexionDB.obtenerConexion();
             PreparedStatement ps = connection.prepareStatement(deleteSQL)){
            
            ps.setInt(1, id);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar la propiedad: " + e.getMessage());
            return false;
        }
    }
}

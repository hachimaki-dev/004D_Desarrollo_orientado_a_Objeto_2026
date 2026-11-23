package com.caso2_franco_dietert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.caso2_franco_dietert.conexionDB.conexionDB;
import java.util.ArrayList;
import com.caso2_franco_dietert.model.Propiedad;
import com.caso2_franco_dietert.model.Casa;
import com.caso2_franco_dietert.model.Departamento;

public class PropiedadDAO {

//-------------------------------------------------------------------------------------------------------


    public ArrayList<Propiedad> listarPropiedades () {

        ArrayList<Propiedad> propiedades = new ArrayList <>();

        String sql = "SELECT * FROM propiedades";

        try (Connection conexion = conexionDB.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement (sql);
             ResultSet rs = ps.executeQuery()){

            while (rs.next()) {

                String tipo = rs.getString("TIPO");

                if (tipo.equals("CASA")) {

                    int id = rs.getInt("ID");
                    String direccion = rs.getString("DIRECCION");
                    int arriendoBase = rs.getInt("ARRIENDO_BASE");
                    int metrosCuadrados = rs.getInt("METROS_CUADRADOS");
                    int cantidadPisos = rs.getInt("CANTIDAD_PISOS");
                    boolean tienePatio = rs.getBoolean("TIENE_PATIO");

                    Casa c1 = new Casa (id, direccion, arriendoBase, metrosCuadrados, cantidadPisos, tienePatio);

                    propiedades.add(c1);

                } else if (tipo.equals("DEPARTAMENTO")) {

                    int id = rs.getInt("ID");
                    String direccion = rs.getString("DIRECCION");
                    int arriendoBase = rs.getInt("ARRIENDO_BASE");
                    int metrosCuadrados = rs.getInt("METROS_CUADRADOS");
                    int numeroPiso = rs.getInt("NUMERO_PISO");
                    int gastosComunes = rs.getInt("GASTOS_COMUNES");
                    
                    Departamento d1 = new Departamento (id, direccion, arriendoBase, metrosCuadrados, numeroPiso, gastosComunes);

                    propiedades.add(d1);

                }
            } 

        } catch (SQLException e) {

                System.out.println ("Error al listar propiedades" + e.getMessage());
            }

        return propiedades;
    }

//-------------------------------------------------------------------------------------------------------

    public void insertarPropiedad (Propiedad propiedad) {

        if (propiedad instanceof Casa) {

            Casa casa = (Casa) propiedad;

            int id = propiedad.getId();
            String direccion = propiedad.getDireccion();
            int arriendoBase = propiedad.getArriendoBase();
            int metrosCuadrados = propiedad.getMetrosCuadrados();
            int cantidadPisos = casa.getCantidadPisos ();
            boolean tienePatio = casa.isTienePatio ();

            String sql = "INSERT INTO PROPIEDADES (ID, TIPO, DIRECCION, ARRIENDO_BASE, METROS_CUADRADOS, CANTIDAD_PISOS, TIENE_PATIO) VALUES (?, ?, ?, ?, ?, ?, ?);";

            try (Connection conexion = conexionDB.obtenerConexion ();
                 PreparedStatement ps = conexion.prepareStatement (sql);) {

                    ps.setInt    (1, id);
                    ps.setString (2, "CASA");
                    ps.setString (3, direccion);
                    ps.setInt    (4, arriendoBase);
                    ps.setInt    (5, metrosCuadrados);
                    ps.setInt    (6, cantidadPisos);
                    ps.setBoolean(7, tienePatio);

                    ps.executeUpdate();
                    

                 } catch (SQLException e){
                    System.out.println("Error al insertar propiedad" + e.getMessage());
                }

        } else if (propiedad instanceof Departamento) {

            Departamento departamento = (Departamento) propiedad;

            int id = propiedad.getId();
            String direccion = propiedad.getDireccion();
            int arriendoBase = propiedad.getArriendoBase();
            int metrosCuadrados = propiedad.getMetrosCuadrados();
            int numeroPiso = departamento.getNumeroPiso ();
            int gastosComunes = departamento.getGastosComunes ();

            String sql = "INSERT INTO PROPIEDADES (ID, TIPO, DIRECCION, ARRIENDO_BASE, METROS_CUADRADOS, NUMERO_PISO, GASTOS_COMUNES) VALUES (?, ?, ?, ?, ?, ?, ?);";

            try (Connection conexion = conexionDB.obtenerConexion ();
                 PreparedStatement ps = conexion.prepareStatement (sql);) {

                    ps.setInt   (1, id);
                    ps.setString(2, "DEPARTAMENTO");
                    ps.setString(3, direccion);
                    ps.setInt   (4, arriendoBase);
                    ps.setInt   (5, metrosCuadrados);
                    ps.setInt   (6, numeroPiso);
                    ps.setInt   (7, gastosComunes);

                    ps.executeUpdate();

                 } catch (SQLException e){
                    System.out.println("Error al insertar propiedad" + e.getMessage());
                 }
        }

        

        
    }

//-----------------------------------------------------------------------------------

    public void eliminarPropiedad (int id) {

        String sql = "DELETE FROM PROPIEDADES WHERE ID = ?";

        try (Connection conexion = conexionDB.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement (sql)){

                ps.setInt (1, id);
                ps.executeUpdate ();

        } catch (SQLException e) {

            System.out.println("Error al eliminar propiedad:" + e.getMessage());
        }
    }


//---------------------------------------------------------------------------------------

    public void actualizarPropiedad (Propiedad propiedad) {

        if (propiedad instanceof Casa) {

            Casa casa = (Casa) propiedad;

            String sql = "UPDATE PROPIEDADES SET DIRECCION = ?, ARRIENDO_BASE = ?, METROS_CUADRADOS = ?, CANTIDAD_PISOS = ?, TIENE_PATIO = ? WHERE ID = ?";

            try (Connection conexion = conexionDB.obtenerConexion();
                 PreparedStatement ps = conexion.prepareStatement (sql)) {

                    ps.setString (1, propiedad.getDireccion());
                    ps.setInt (2, propiedad.getArriendoBase());
                    ps.setInt (3, propiedad.getMetrosCuadrados());
                    ps.setInt (4, casa.getCantidadPisos());
                    ps.setBoolean (5, casa.isTienePatio());
                    ps.setInt (6, propiedad.getId());

                    ps.executeUpdate();

            } catch (SQLException e) {

                System.out.println("Error al actualizar propiedad" + e.getMessage());

            }
        } else if (propiedad instanceof Departamento) {

            Departamento departamento = (Departamento) propiedad;

            String sql = "UPDATE PROPIEDADES SET DIRECCION = ?, ARRIENDO_BASE = ?, METROS_CUADRADOS = ?, NUMERO_PISO = ?, GASTOS_COMUNES = ? WHERE ID = ?";
       

            try (Connection conexion = conexionDB.obtenerConexion();
                 PreparedStatement ps = conexion.prepareStatement (sql)) {

                    ps.setString (1, propiedad.getDireccion());
                    ps.setInt (2, propiedad.getArriendoBase());
                    ps.setInt (3, propiedad.getMetrosCuadrados());
                    ps.setInt (4, departamento.getNumeroPiso());
                    ps.setInt (5, departamento.getGastosComunes());
                    ps.setInt (6, propiedad.getId());

                    ps.executeUpdate();


            } catch (SQLException e) {

                System.out.println("Error al actualizar propiedad" + e.getMessage());

            }
        }

    }
    
}
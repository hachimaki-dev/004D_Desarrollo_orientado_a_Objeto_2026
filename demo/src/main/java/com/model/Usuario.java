package com.model;

import java.util.HashSet;

public class Usuario
{
    
    private static HashSet<String> coleccion_username = new HashSet<String>();

    private int ID;

    private String username;

    private String correo;

    private String password;

    private String rol;

    public Usuario(int ID, String username, String correo, String password, String rol)
    {
        if (coleccion_username.contains(username))
        {
            throw new IllegalStateException("El username ya existe");
        }

        this.ID = ID;

        this.username = username;

        this.correo = correo;

        this.password = password;

        this.rol = rol;

        coleccion_username.add(username);

    }

    public Usuario(String username, String correo, String password, String rol)
    {
        if (coleccion_username.contains(username))
        {
            throw new IllegalStateException("El username ya existe");
        }

        this.username = username;

        this.correo = correo;

        this.password = password;

        this.rol = rol;

        coleccion_username.add(username);

    }
    
    public int getID() 
    {
        return ID;
    }

    public void setID(int ID) 
    {
        this.ID = ID;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getCorreo() 
    {
        return correo;
    }

    public void setCorreo(String correo) 
    {
        this.correo = correo;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getRol() 
    {
        return rol;
    }

    public void setRol(String rol) 
    {
        this.rol = rol;
    }


}

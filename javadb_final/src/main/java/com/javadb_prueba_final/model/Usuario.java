package com.javadb_prueba_final.model;

public class Usuario {
    
    private int id;
    private String username;
    private String correo;
    private String password;
    private String rol;

    public Usuario (int id, String username, String correo, String password, String rol){

        this.id = id;
        this.username = username;
        this.correo = correo;
        this.password = password;
        this.rol = rol;

    }

    public Usuario (String username, String correo, String password, String rol){

        this.username = username;
        this.correo = correo;
        this.password = password;
        this.rol = rol;

    }

    public int getId(){
        return this.id;
    }

    public String getUsername(){
        return this.username;
    }

    public String getCorreo(){
        return this.correo;
    }
    
    public String getPassword(){
        return this.password;
    }

    public String getRol(){
        return this.rol;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setRol(String rol){
        this.rol = rol;
}




}

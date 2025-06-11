package com.pfrñfe.model.entities;

public class User {
    private int id;
    private String nombre;
    private String codigoUuid;
    private String password;

    
    public User(int id, String nombre, String codigo_uuid, String password) {
        this.id = id;
        this.nombre = nombre;
        this.codigoUuid = codigo_uuid;
        this.password = password;
    }
    
    public User() {
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoUuid() {
        return codigoUuid;
    }

    public void setCodigoUuid(String codigo_uuid) {
        this.codigoUuid = codigo_uuid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", codigoUuid='" + codigoUuid + '\'' +
                ", password='[PROTECTED]'" +
                '}';
    }
/*
    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
    
}
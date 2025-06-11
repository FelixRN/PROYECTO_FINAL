package com.pfrñfe.model.dtos;

public class UserDto {
    private int id;
    private String nombre;
    private String codigoUuid;

    public UserDto() {
    }

    public UserDto(int id, String nombre, String codigoUuid) {
        this.id = id;
        this.nombre = nombre;
        this.codigoUuid = codigoUuid;
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

    public void setCodigoUuid(String codigoUuid) {
        this.codigoUuid = codigoUuid;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", codigoUuid='" + codigoUuid + '\'' +
                '}';
    }
}

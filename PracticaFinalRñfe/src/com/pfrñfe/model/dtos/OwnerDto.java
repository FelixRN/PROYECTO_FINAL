package com.pfrñfe.model.dtos;

public class OwnerDto {
    private int idUsuario;
    private int idCoche;

    public OwnerDto() {
    }

    public OwnerDto(int idUsuario, int idCoche) {
        this.idUsuario = idUsuario;
        this.idCoche = idCoche;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCoche() {
        return idCoche;
    }

    public void setIdCoche(int idCoche) {
        this.idCoche = idCoche;
    }

    @Override
    public String toString() {
        return "OwnerDto{" +
                "idUsuario=" + idUsuario +
                ", idCoche=" + idCoche +
                '}';
    }
}

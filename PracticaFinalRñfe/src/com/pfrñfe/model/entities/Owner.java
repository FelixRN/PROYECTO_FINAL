
package com.pfrñfe.model.entities;


public class Owner {
    private int idUsuario;
    private int idCoche;
    
    // Constructor vacío
    public Owner() {
    }

    public Owner(int idUsuario, int idCoche) {
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
        return "Owner{" +
                "idUsuario=" + idUsuario +
                ", idCoche=" + idCoche +
                '}';
    }
}
package com.pfrñfe.model.entities;

public class Car {
    private int id;
    private String marca;
    private String modelo;
    private String matricula;
    private int anio;
    private String id_usuario_creador;

    
    public void setId_usuario_creador(String id_usuario_creador) {
        this.id_usuario_creador = id_usuario_creador;
    }
    
    public Car() {
    }

    public Car(int id, String marca, String modelo, String matricula, int anio, String id_usuario_creador) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.anio = anio;
        this.id_usuario_creador = id_usuario_creador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public String getId_usuario_creador() {
        return id_usuario_creador;
    }
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", anio=" + anio +
                '}';
    }
}
package com.pfrñfe.model.dtos;

public class CarDto {
    private int id;
    private String marca;
    private String modelo;
    private String matricula;
    private int anio;
    private String idUsuarioCreador;

    public CarDto(int aInt, String string, String string1, String string2, int aInt1) {
    }

    public CarDto(int id, String marca, String modelo, String matricula, int anio, String idUsuarioCreador) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.anio = anio;
        this.idUsuarioCreador = idUsuarioCreador;
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

    public String getIdUsuarioCreador() {
        return idUsuarioCreador;
    }

    public void setIdUsuarioCreador(String idUsuarioCreador) {
        this.idUsuarioCreador = idUsuarioCreador;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", anio=" + anio +
                ", idUsuarioCreador='" + idUsuarioCreador + '\'' +
                '}';
    }

    public int getIdCoche() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

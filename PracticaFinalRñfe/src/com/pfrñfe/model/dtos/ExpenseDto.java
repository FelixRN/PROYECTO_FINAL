package com.pfrñfe.model.dtos;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExpenseDto {
    private int id;
    private int idCoche;
    private String tipo; // String para facilitar transporte en JSON
    private int kilometraje;
    private LocalDate fechaGasto;
    private BigDecimal importe;
    private String descripcion;
    private LocalDateTime fechaRegistro;

    public ExpenseDto(int aInt, String string, double aDouble, Date date, int aInt1) {
    }
    
    public ExpenseDto() {
        this.fechaRegistro = LocalDateTime.now();
    }

    public ExpenseDto(int id, int idCoche, String tipo, int kilometraje, LocalDate fechaGasto, BigDecimal importe, String descripcion, LocalDateTime fechaRegistro) {
        this.id = id;
        this.idCoche = idCoche;
        this.tipo = tipo;
        this.kilometraje = kilometraje;
        this.fechaGasto = fechaGasto;
        this.importe = importe;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCoche() {
        return idCoche;
    }

    public void setIdCoche(int idCoche) {
        this.idCoche = idCoche;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public LocalDate getFechaGasto() {
        return fechaGasto;
    }

    public void setFechaGasto(LocalDate fechaGasto) {
        this.fechaGasto = fechaGasto;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "ExpenseDto{" +
                "id=" + id +
                ", idCoche=" + idCoche +
                ", tipo='" + tipo + '\'' +
                ", kilometraje=" + kilometraje +
                ", fechaGasto=" + fechaGasto +
                ", importe=" + importe +
                ", descripcion='" + descripcion + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }

    public double getCantidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Date getFecha() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

package com.pfrñfe.model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Expense {
    private int id;
    private int idCoche;
    private ExpenseType tipo;
    private int kilometraje;
    private LocalDate fechaGasto;
    private BigDecimal importe;
    private String descripcion;
    private LocalDateTime fechaRegistro;
    
    public Expense() {
        this.fechaRegistro = LocalDateTime.now();
    }

    public Expense(int id, int idCoche, ExpenseType tipo, int kilometraje, LocalDate fechaGasto, BigDecimal importe, String descripcion, LocalDateTime fechaRegistro) {
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

    public ExpenseType getTipo() {
        return tipo;
    }

    public void setTipo(ExpenseType tipo) {
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
    
    public void setFecha(String toString) {
    }

    public String getFecha() {
        throw new UnsupportedOperationException("Not supported yet."); // 
    }
    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", idCoche=" + idCoche +
                ", tipo=" + tipo +
                ", kilometraje=" + kilometraje +
                ", fechaGasto=" + fechaGasto +
                ", importe=" + importe +
                ", descripcion='" + descripcion + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }

    
    
}
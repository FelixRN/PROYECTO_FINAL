package com.pfrñfe.model.repository;

import com.pfrñfe.model.DatabaseConnection;
import com.pfrñfe.model.dtos.CarDto;

import java.io.IOException;
import java.sql.*;

public class CarModel implements ICarModel {

    private Connection connection;

    public CarModel() throws ClassNotFoundException, SQLException, IOException {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void newCar(String modelo, String marca, String matricula, String anno) {
        String query = "INSERT INTO coche (modelo, marca, matricula, anio) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, modelo);
            pst.setString(2, marca);
            pst.setString(3, matricula);
            pst.setInt(4, Integer.parseInt(anno));
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CarDto getCarByModelo(String modelo) throws SQLException, IOException, ClassNotFoundException {
        CarDto car = null;
        String query = "SELECT * FROM coche WHERE modelo = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, modelo);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                car = new CarDto(
                        rs.getInt("id_coche"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("matricula"),
                        rs.getInt("anio")
                );
            }
        }
        return car;
    }

    @Override
    public boolean updateCar(CarDto car) throws SQLException, IOException, ClassNotFoundException {
        String query = "UPDATE coche SET marca=?, modelo=?, matricula=?, anio=? WHERE id_coche=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, car.getMarca());
            pst.setString(2, car.getModelo());
            pst.setString(3, car.getMatricula());
            pst.setInt(4, car.getAnio());
            pst.setInt(5, car.getId());
            pst.executeUpdate();
        }
        return true;
    }

    @Override
    public boolean deleteCar(int idCar) throws SQLException, IOException, ClassNotFoundException {
        String query = "DELETE FROM coche WHERE id_coche=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, idCar);
            pst.executeUpdate();
        }
        return true;
    }

    @Override
    public boolean addOwner(int idCar, String uuidUsuario) throws SQLException {
    String query1 = "SELECT id_usuario FROM usuario WHERE codigo_uuid = ?";
    String query2 = "INSERT INTO propietario (id_usuario, id_coche) VALUES (?, ?)";

    int idUsuario = -1;
    try (PreparedStatement pst1 = connection.prepareStatement(query1)) {
        pst1.setString(1, uuidUsuario);
        ResultSet rs = pst1.executeQuery();
        if (rs.next()) {
            idUsuario = rs.getInt("id_usuario");
        } else {
            return false;
        }
    }

    try (PreparedStatement pst2 = connection.prepareStatement(query2)) {
        pst2.setInt(1, idUsuario);
        pst2.setInt(2, idCar);
        pst2.executeUpdate();
        return true;
    } catch (SQLIntegrityConstraintViolationException e) {
        // Ya existe relación (por clave primaria compuesta), o alguna FK inválida
        return false;
    } catch (SQLException e) {
        e.printStackTrace(); // Log opcional
        return false;
    }
}

    @Override
    public boolean existeModelo(String modelo, int idCar) throws SQLException, IOException, ClassNotFoundException {
        String query = "SELECT 1 FROM coche WHERE modelo = ? AND id_coche != ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, modelo);
            pst.setInt(2, idCar);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        }
    }
    public boolean existeMatricula(String matricula, int idCocheActual) throws SQLException, IOException, ClassNotFoundException {
    String query = "SELECT 1 FROM coche WHERE matricula = ? AND id_coche != ?";
    try (PreparedStatement pst = connection.prepareStatement(query)) {
        pst.setString(1, matricula);
        pst.setInt(2, idCocheActual);
        ResultSet rs = pst.executeQuery();
        return rs.next();
    }
    
    }
}
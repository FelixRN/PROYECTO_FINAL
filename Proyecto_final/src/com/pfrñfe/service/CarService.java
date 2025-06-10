package com.pfrñfe.service;

import com.pfrñfe.model.DatabaseConnection;
import com.pfrñfe.model.dtos.CarDto;

import java.io.IOException;
import java.sql.*;
import java.sql.Statement;

public class CarService {

    public CarDto getCarByModelo(String modelo) throws SQLException, IOException, ClassNotFoundException {
        CarDto car = null;

        String query = "SELECT * FROM coche WHERE modelo = ?";
        try (Connection cn = DatabaseConnection.getConnection();
             PreparedStatement pst = cn.prepareStatement(query)) {

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

    public boolean updateCar(CarDto car) throws SQLException, IOException, ClassNotFoundException {
        
        String query = "UPDATE coche SET marca=?, modelo=?, matricula=?, anio=? WHERE id_coche=?";
        try (Connection cn = DatabaseConnection.getConnection();
             PreparedStatement pst = cn.prepareStatement(query)) {

            pst.setString(1, car.getMarca());
            pst.setString(2, car.getModelo());
            pst.setString(3, car.getMatricula());
            pst.setInt(4, car.getAnio());
            pst.setInt(5, car.getId());

            pst.executeUpdate();
        }
        return false;
    }

    public boolean deleteCar(int idCar) throws SQLException, IOException, ClassNotFoundException {
        String query = "DELETE FROM coche WHERE id_coche=?";
        try (Connection cn = DatabaseConnection.getConnection();
             PreparedStatement pst = cn.prepareStatement(query)) {

            pst.setInt(1, idCar);
            pst.executeUpdate();
            
        }
        return false;
    }

    public void addOwner(int idCar, String uuidUsuario) throws SQLException, IOException, ClassNotFoundException {
        String query1 = "SELECT id_usuario FROM usuario WHERE codigo_uuid = ?";
        String query2 = "INSERT INTO propietario (id_usuario, id_coche) VALUES (?, ?)";

        try (Connection cn = DatabaseConnection.getConnection()) {
            // Buscar el usuario
            int idUsuario = -1;
            try (PreparedStatement pst1 = cn.prepareStatement(query1)) {
                pst1.setString(1, uuidUsuario);
                ResultSet rs = pst1.executeQuery();

                if (rs.next()) {
                    idUsuario = rs.getInt("id_usuario");
                } else {
                    throw new SQLException("No se encontró ningún usuario con ese UUID.");
                }
            }

            // Insertar propietario
            try (PreparedStatement pst2 = cn.prepareStatement(query2)) {
                pst2.setInt(1, idUsuario);
                pst2.setInt(2, idCar);
                pst2.executeUpdate();
            }
        }
    }

    public boolean existeModelo(String modelo, int idCar) throws SQLException, IOException, ClassNotFoundException {
        String query = "SELECT 1 FROM coche WHERE modelo = ? AND id_coche != ?";
        try (Connection cn = DatabaseConnection.getConnection();
             PreparedStatement pst = cn.prepareStatement(query)) {

            pst.setString(1, modelo);
            pst.setInt(2, idCar);
            ResultSet rs = pst.executeQuery();

            return rs.next();
        }
    }

    public boolean addOwnerToCar(String trim, int idCoche) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public CarDto findByModelo(String car_update) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

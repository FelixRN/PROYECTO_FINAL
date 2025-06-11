package com.pfrñfe.model.repository;

import com.pfrñfe.model.dtos.CarDto;
import java.io.IOException;
import java.sql.SQLException;

public interface ICarModel {
    void newCar(String modelo, String marca, String matricula, String anno);
    CarDto getCarByModelo(String modelo) throws SQLException, IOException, ClassNotFoundException;
    boolean updateCar(CarDto car) throws SQLException, IOException, ClassNotFoundException;
    boolean deleteCar(int idCar) throws SQLException, IOException, ClassNotFoundException;
    boolean addOwner(int idCar, String uuidUsuario) throws SQLException, IOException, ClassNotFoundException;
    boolean existeModelo(String modelo, int idCar) throws SQLException, IOException, ClassNotFoundException;
}

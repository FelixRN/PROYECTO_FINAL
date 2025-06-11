package com.pfrñfe.controller;

import com.pfrñfe.model.repository.CarModel;
import com.pfrñfe.model.repository.ICarModel;

import java.io.IOException;
import java.sql.SQLException;

public class CarController implements ICarController {

    private ICarModel carModel;

    public CarController() throws ClassNotFoundException, SQLException, IOException {
        this.carModel = new CarModel();
    }

    @Override
    public void newCar(String modelo, String marca, String matricula, String anno) {
        carModel.newCar(modelo, marca, matricula, anno);
    }

    @Override
    public boolean existeMatricula(String matricula, int idCocheActual) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

package com.pfrñfe.controller;

import com.pfrñfe.model.repository.CarModel;
import com.pfrñfe.model.repository.ICarModel;
import java.io.IOException;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
    public void deleteCar(int id_coche){
        try {
            carModel.deleteCar(id_coche);
        } catch (ClassNotFoundException | SQLException|IOException e) {
            System.err.println("Error en deleteCarController: " + e.getMessage());
        }
    }
    
    @Override
    public boolean addOwner(int idCar, String uuidUsuario){
    try {
        return carModel.addOwner(idCar, uuidUsuario);
    } catch (ClassNotFoundException | SQLException | IOException e) {
        System.err.println("Error en addOwnerController: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Error al agregar propietario: " + e.getMessage());
        return false;
    }
}
    
    @Override
    public boolean existeMatricula(String matricula, int idCocheActual) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateCar(int idCoche, String marca, String modelo, String matricula, String anno) {
        try {
            carModel.updateCar(idCoche, modelo, marca, matricula, anno);
        } catch (ClassNotFoundException | SQLException|IOException e) {
            System.err.println("Error en ExpenseController: " + e.getMessage());
        }
    }
}

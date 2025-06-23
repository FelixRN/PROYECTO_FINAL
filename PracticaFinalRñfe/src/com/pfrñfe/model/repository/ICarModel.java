
package com.pfrñfe.model.repository;

import java.io.IOException;
import java.sql.SQLException;


public interface ICarModel {
    void newCar(String modelo, String marca, String matricula, String anno);
    //CarDto getCarByModelo(String modelo) throws SQLException, IOException, ClassNotFoundException;
    boolean updateCar(int idCoche, String modelo, String marca, String matricula, String anno) throws SQLException, IOException, ClassNotFoundException;
    boolean deleteCar(int idCoche) throws SQLException, IOException, ClassNotFoundException;
    boolean addOwner(int idCar, String uuidUsuario) throws SQLException, IOException, ClassNotFoundException;
    boolean existeModelo(String modelo, int idCar) throws SQLException, IOException, ClassNotFoundException;

    public void updateCar(String modelo, String marca, String matricula, String anno);
}

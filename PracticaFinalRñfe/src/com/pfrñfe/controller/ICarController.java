package com.pfrñfe.controller;

import java.io.IOException;
import java.sql.SQLException;

public interface ICarController {
    public void newCar(String modelo, String marca, String matricula, String anno);
    boolean existeMatricula(String matricula, int idCocheActual) throws SQLException, IOException, ClassNotFoundException;
}

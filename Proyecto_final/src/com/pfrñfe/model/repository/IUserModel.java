package com.pfrñfe.model.repository;

import java.io.IOException;
import java.sql.SQLException;

public interface IUserModel {

    String findUserName(String userName) throws SQLException, IOException, ClassNotFoundException;

    String obtenerNombreUsuario(String user) throws SQLException, IOException, ClassNotFoundException;

}

package com.pfrñfe.model.repository;

import com.pfrñfe.model.DatabaseConnection;

import java.io.IOException;
import java.sql.*;

public class UserModel implements IUserModel {

    private Connection connection;

    public UserModel() throws ClassNotFoundException, SQLException, IOException {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public String findUserName(String userName) throws SQLException {
        String nombreUsuario = null;
        String query = "SELECT nombre FROM usuario WHERE nombre = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, userName);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombreUsuario = rs.getString("nombre");
            }
        }
        return nombreUsuario;
    }

    @Override
    public String obtenerNombreUsuario(String user) throws SQLException, IOException, ClassNotFoundException {
        String nombreUsuario = null;
        String query = "SELECT nombre FROM usuario WHERE nombre = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, user);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombreUsuario = rs.getString("nombre");
            }
        }
        return nombreUsuario;
    }
}

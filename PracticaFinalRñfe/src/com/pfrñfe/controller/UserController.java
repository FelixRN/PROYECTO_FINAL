package com.pfrñfe.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.pfrñfe.model.repository.IUserModel;
import com.pfrñfe.model.repository.UserModel;

public class UserController implements IUserController {

    private IUserModel userModel;

    public UserController() throws ClassNotFoundException, SQLException, IOException {
        this.userModel = new UserModel();
    }

    @Override
    public String findUserName(String userName) {
        String nombre="";
        try {
            nombre = userModel.findUserName(userName);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            System.err.println("Error en ExpenseController: " + e.getMessage());
        }
        return nombre;
    }
}

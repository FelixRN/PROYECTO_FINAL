package com.pfrñfe.controller;
import java.io.IOException;

import java.sql.SQLException;

import com.pfrñfe.model.repository.IUserModel;
import com.pfrñfe.model.repository.UserModel;


public class UserController implements IUserController {
    private IUserModel userModel;
    
    public int validacion =0;
    public String user ="", car_update ="";
    public int ID = 0;

    public UserController() throws ClassNotFoundException, SQLException, IOException {
        this.userModel = new UserModel();
    }
    
    @Override
    public void register(String nombre, String password) {
       userModel.register(nombre, password);
    }

    @Override
    public String findUserName(String userName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}

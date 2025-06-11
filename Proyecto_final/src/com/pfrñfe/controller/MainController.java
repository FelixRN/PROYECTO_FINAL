package com.pfrñfe.controller;

import com.pfrñfe.model.AuthModel;
import com.pfrñfe.model.IAuthModel;
import com.pfrñfe.model.repository.*;

import java.io.IOException;
import java.sql.SQLException;

public class MainController implements IMainController {

    private ICarModel carModel;
    private IExpenseModel expenseModel;
    private IUserModel userModel;
    private IAuthModel authModel;

    public MainController() throws ClassNotFoundException, SQLException, IOException {
        this.carModel = new CarModel();
        this.expenseModel = new ExpenseModel();
        this.userModel = new UserModel();
        this.authModel = new AuthModel();
    }

    @Override
    public void createCar(String marca, String modelo, String matricula, String anno) {
        carModel.newCar(modelo, marca, matricula, anno);
    }
}

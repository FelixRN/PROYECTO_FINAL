package com.pfrñfe.controller;

import com.pfrñfe.model.auth.AuthModel;
import com.pfrñfe.model.auth.IAuthModel;
import com.pfrñfe.model.repository.CarModel;
import com.pfrñfe.model.repository.ExpenseModel;
import com.pfrñfe.model.repository.ICarModel;
import com.pfrñfe.model.repository.IExpenseModel;
import com.pfrñfe.model.repository.IUserModel;
import com.pfrñfe.model.repository.UserModel;
import java.io.IOException;
import java.sql.SQLException;

public class MainController implements IMainController{
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
       carModel.newCar(modelo ,marca, matricula, anno);
    }
    
}

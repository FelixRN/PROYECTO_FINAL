package com.pfrñfe.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.sql.Statement;


import com.pfrñfe.model.repository.ExpenseModel;
import com.pfrñfe.model.repository.IExpenseModel;

public class ExpenseController implements IExpenseController {

    private IExpenseModel expenseModel;

    public ExpenseController() throws ClassNotFoundException, SQLException, IOException {
        this.expenseModel = new ExpenseModel();
    }

    @Override
    public Map<String, Object> getLastExpenseByCarId(int carId) {
        return expenseModel.getLastExpenseByCarId(carId);
    }
}

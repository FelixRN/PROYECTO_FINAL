package com.pfrñfe.model.repository;

import com.pfrñfe.model.dtos.ExpenseDto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IExpenseModel {

    void addExpense(ExpenseDto expense) throws SQLException, IOException, ClassNotFoundException;

    boolean updateExpense(ExpenseDto expense) throws SQLException, IOException, ClassNotFoundException;

    boolean deleteExpense(int expenseId) throws SQLException, IOException, ClassNotFoundException;

    List<ExpenseDto> getAllExpenses() throws SQLException, IOException, ClassNotFoundException;

    ExpenseDto findExpenseById(int expenseId) throws SQLException, IOException, ClassNotFoundException;

    public Map<String, Object> getLastExpenseByCarId(int carId);
}

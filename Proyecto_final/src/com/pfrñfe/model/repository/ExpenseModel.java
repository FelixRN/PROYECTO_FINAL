package com.pfrñfe.model.repository;

import com.pfrñfe.model.DatabaseConnection;
import com.pfrñfe.model.dtos.ExpenseDto;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpenseModel implements IExpenseModel {

    private Connection connection;

    public ExpenseModel() throws ClassNotFoundException, SQLException, IOException {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void addExpense(ExpenseDto expense) throws SQLException, IOException, ClassNotFoundException {
        String query = " \"INSERT INTO gastos (id_coche, tipo, kilometraje, fecha_gasto, importe, descripcion) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, expense.getIdCoche());
            pst.setString(2, expense.getTipo());
            pst.setInt(3, expense.getKilometraje());
            pst.setDate(4, Date.valueOf(expense.getFechaGasto()));
            pst.setBigDecimal(5, expense.getImporte());
            pst.setString(6, expense.getDescripcion());
            
            pst.executeUpdate();
        }
    }

    @Override
    public boolean updateExpense(ExpenseDto expense) throws SQLException, IOException, ClassNotFoundException {
        String query = "UPDATE gasto SET descripcion=?, cantidad=?, fecha=?, id_coche=? WHERE id_gasto=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, expense.getDescripcion());
            pst.setDouble(2, expense.getCantidad());
            pst.setDate(3, expense.getFecha());
            pst.setInt(4, expense.getIdCoche());
            pst.setInt(5, expense.getId());
            pst.executeUpdate();
        }
        return true;
    }

    @Override
    public boolean deleteExpense(int expenseId) throws SQLException, IOException, ClassNotFoundException {
        String query = "DELETE FROM gasto WHERE id_gasto=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, expenseId);
            pst.executeUpdate();
        }
        return true;
    }

    @Override
    public List<ExpenseDto> getAllExpenses() throws SQLException, IOException, ClassNotFoundException {
        List<ExpenseDto> expenses = new ArrayList<>();
        String query = "SELECT * FROM gastos WHERE id_coche = ? ORDER BY fecha_gasto DESC LIMIT 1";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ExpenseDto expense = new ExpenseDto(
                        rs.getInt("id_gasto"),
                        rs.getString("descripcion"),
                        rs.getDouble("cantidad"),
                        rs.getDate("fecha"),
                        rs.getInt("id_coche")
                );
                expenses.add(expense);
            }
        }
        return expenses;
    }

    @Override
    public ExpenseDto findExpenseById(int expenseId) throws SQLException, IOException, ClassNotFoundException {
        ExpenseDto expense = null;
        String query = "SELECT * FROM gasto WHERE id_gasto=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, expenseId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                expense = new ExpenseDto(
                        rs.getInt("id_gasto"),
                        rs.getString("descripcion"),
                        rs.getDouble("cantidad"),
                        rs.getDate("fecha"),
                        rs.getInt("id_coche")
                );
            }
        }
        return expense;
    }

    @Override
    public Map<String, Object> getLastExpenseByCarId(int carId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

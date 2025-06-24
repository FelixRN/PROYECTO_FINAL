package com.pfrñfe.model.repository;

import com.pfrñfe.view.auth.LoginView;
import com.pfrñfe.model.DatabaseConnection;
import com.pfrñfe.view.auth.RegisterView;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class UserModel implements IUserModel{
    public int validacion =0;
    public String user ="", car_update ="";
    public int ID = 0;
    

    @Override
    public void register(String nombre, String password){
        try {
            Connection cn = DatabaseConnection.getConnection(); 
                PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre FROM usuario WHERE nombre = '" + nombre + "'");
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible.");          
                } else {
                    if (validacion == 0) {
                        try {
                             Connection cn2 = DatabaseConnection.getConnection(); 
                             PreparedStatement pst2 = cn2.prepareStatement(
                                "insert into usuario (nombre,password)values (?,?)");
                            pst2.setString(1, nombre);
                            pst2.setString(2, password);
                            
                            pst2.executeUpdate();                   
                            
                            JOptionPane.showMessageDialog(null, "Registro exitoso.");
                            
                            
                        } catch (SQLException e) {
                            System.err.println("Error en registrar usuario" + e);
                            JOptionPane.showMessageDialog(null, "ERROR al registrar!, Contacta al administrador.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
                        
                    }
                    
            }
        } catch (ClassNotFoundException | SQLException|IOException e) {
            System.err.println("Error en ExpenseController: " + e.getMessage());
        }
        
    }       
    
}

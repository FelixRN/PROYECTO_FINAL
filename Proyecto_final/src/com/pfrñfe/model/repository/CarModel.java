/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pfrñfe.model.repository;

import com.pfrñfe.model.DatabaseConnection;
import com.pfrñfe.utils.UsuarioSesion;
import com.pfrñfe.view.auth.RegisterView;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class CarModel implements ICarModel {

    @Override
    public void newCar(String modelo, String marca, String matricula, String anno) {
        
        int validacion = 0;
        
        try {
            Connection cn = DatabaseConnection.getConnection(); 
                PreparedStatement pst = cn.prepareStatement(
                    "SELECT matricula FROM coche WHERE matricula = '" + matricula + "'");
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible.");
                
            } else {
            
                    if (validacion == 0) {
                        try {
                             Connection cn2 = DatabaseConnection.getConnection(); 
                             PreparedStatement pst2 = cn2.prepareStatement(
                               /* "INSERT INTO coche (marca, modelo, matricula, anio) VALUES(?, ?, ?,?)");*/
                                "INSERT INTO coche (marca, modelo, matricula, anio) VALUES(?, ?, ?, ?)",
                                     Statement.RETURN_GENERATED_KEYS);
                             //AGREGADO NUEVO
                             //OPCIONAL Statement.RETURN_GENERATED_KEYS);
                             //Insertar valores dentro de la BBDD
                            pst2.setString(1, marca);
                            pst2.setString(2, modelo);
                            pst2.setString(3, matricula);
                            pst2.setString(4, anno);
                            
                            int filasAfectadas = pst2.executeUpdate();
                            
                            if(filasAfectadas > 0) {
                                // Obtener el ID del coche recién creado
                               ResultSet generatedKeys = pst2.getGeneratedKeys();
                               if(generatedKeys.next()) {
                               int idCoche = generatedKeys.getInt(1);
            
                               // Insertar la relación de propiedad
                               PreparedStatement pstPropietario = cn2.prepareStatement(
                                "INSERT INTO propietario (id_usuario, id_coche) VALUES(?, ?)");
            
                               pstPropietario.setInt(1, UsuarioSesion.getIdUsuario()); // ID del usuario logueado
                               pstPropietario.setInt(2, idCoche);
            
                               pstPropietario.executeUpdate();
                               pstPropietario.close();
                            }
                               generatedKeys.close();
                           }
                            JOptionPane.showMessageDialog(null, "Registro del coche exitoso.");
                            
                        } catch (SQLException e) {
                            System.err.println("Error en registrar coche" + e);
                            JOptionPane.showMessageDialog(null, "ERROR al registrar!, Contacta al administrador.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");  
                    }
                    
            }
        } catch (SQLException e) {
            System.err.println("Error en validar matricula de usuario" + e);
            JOptionPane.showMessageDialog(null, "ERROR al comparar matricula!, contacte al administrador.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegisterView.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}

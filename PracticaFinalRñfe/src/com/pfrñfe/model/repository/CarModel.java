package com.pfrñfe.model.repository;

import com.pfrñfe.model.DatabaseConnection;
import com.pfrñfe.model.entities.UsuarioSesion;
import com.pfrñfe.model.entities.UsuarioSesion;
import com.pfrñfe.view.CreateCarView;
import com.pfrñfe.view.EditCarView;
import com.pfrñfe.view.auth.RegisterView;
import com.pfrñfe.view.SeeOwnCars;
import com.pfrñfe.view.UserView;
import java.awt.Color;
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
    public int validacion =0;
    public String user ="", car_update ="";
    public int ID = 0;
    
    @Override
    public void newCar(String modelo, String marca, String matricula, String anno) {

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
                            /*System.exit(0);
                            new UserView().setVisible(true);*/
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

    @Override
    public boolean deleteCar(int idCoche) {       
      int confirm = JOptionPane.showConfirmDialog(null, 
        "¿Estás seguro de eliminar este coche? Esta acción no se puede deshacer.",
        "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

if (confirm == JOptionPane.YES_OPTION) {
        try {
            Connection cn = DatabaseConnection.getConnection();

            PreparedStatement pst1 = cn.prepareStatement("DELETE FROM propietario WHERE id_usuario = ? AND id_coche = ?");
            pst1.setInt(1, UsuarioSesion.getIdUsuario()); 
            pst1.setInt(2, idCoche);
            pst1.executeUpdate();

            PreparedStatement pst2 = cn.prepareStatement("SELECT COUNT(*) FROM propietario WHERE id_coche = ?");
            pst2.setInt(1, idCoche);
            ResultSet rs = pst2.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                PreparedStatement pst3 = cn.prepareStatement("DELETE FROM coche WHERE id_coche = ?");
                pst3.setInt(1, idCoche);
                pst3.executeUpdate();
                JOptionPane.showMessageDialog(null, "Coche eliminado completamente (sin propietarios restantes).");
            } else {
                JOptionPane.showMessageDialog(null, "Coche eliminado solo de tu cuenta.");
            }

            SeeOwnCars volver = new SeeOwnCars();
            volver.setVisible(true);

            return true;

        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar el coche: " + e.getMessage());
            }
        }else {
        JOptionPane.showMessageDialog(null, "Eliminación cancelada.");
    }  
        return false;
    }

    @Override
    public boolean updateCar(int idCoche, String modelo, String marca, String matricula, String anno){
        
if (validacion == 0) {
        try {
            Connection cn = DatabaseConnection.getConnection();

            // Verificar si hay otro coche con el mismo modelo
            PreparedStatement pst = cn.prepareStatement(
                "SELECT * FROM coche WHERE modelo = ? AND id_coche != ?");
            pst.setString(1, modelo);
            pst.setInt(2, idCoche); // ✅ usar el parámetro correctamente

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El modelo ya está registrado en otro coche.");
                return false;
            }

            // Si el modelo no existe en otro coche, actualizamos
            PreparedStatement pst2 = cn.prepareStatement(
                "UPDATE coche SET marca = ?, modelo = ?, matricula = ?, anio = ? WHERE id_coche = ?");
            pst2.setString(1, marca);
            pst2.setString(2, modelo);
            pst2.setString(3, matricula);
            pst2.setString(4, anno);
            pst2.setInt(5, idCoche);

            int filas = pst2.executeUpdate(); // ✅ ejecutar solo una vez

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Modificación correcta.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el coche.");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e);
            JOptionPane.showMessageDialog(null, "Error en la base de datos.");
        } catch (Exception ex) {
            System.err.println("Error inesperado: " + ex);
            JOptionPane.showMessageDialog(null, "Error inesperado.");
        }


        /*if (validacion == 0 ) {
            
            try {
                Connection cn = DatabaseConnection.getConnection(); 
                PreparedStatement pst = cn.prepareStatement(
                    "select * from coche where modelo = ? and id_coche != ?");
                pst.setString(1, modelo);
                pst.setInt(2, ID);
                
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    
                    JOptionPane.showMessageDialog(null, "Nombre de modelo  no disponilbe");
                    return false;
                } else {
                    
                PreparedStatement pst2 = cn.prepareStatement(
                    "update coche set marca=?, modelo=?, matricula=?, anio=? where id_coche = ?");
                
                pst2.setString(1, marca);
                pst2.setString(2, modelo);
                pst2.setString(3, matricula);
                pst2.setString(4, anno);
                pst2.setInt(5, idCoche);
                pst2.executeUpdate();
                 int filas = pst2.executeUpdate();

                if (filas > 0) {
                    JOptionPane.showMessageDialog(null, "Modificación correcta.");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el coche.");
                    return false;
                }
            }
            } catch (SQLException e) {
                System.err.println("Error al actualizar" + e);
                JOptionPane.showMessageDialog(null, "Error en la base de datos");
            } catch (Exception ex) {
                System.err.println("Error inesperado: " + ex);
                JOptionPane.showMessageDialog(null, "Error inesperado");
            }*/
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todo el campo!");
        }
        return false;
    }
    
    @Override
    public boolean addOwner(int idCar, String uuidUsuario) {
    int confirm = JOptionPane.showConfirmDialog(null, 
        "¿Estás seguro de agregar este propietario al coche?",
        "Confirmar agregar propietario", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        String query1 = "SELECT id_usuario FROM usuario WHERE codigo_uuid = ?";
        String query2 = "INSERT INTO propietario (id_usuario, id_coche) VALUES (?, ?)";
        int idUsuario = -1;
        
        try {
            Connection cn = DatabaseConnection.getConnection();

            PreparedStatement pst1 = cn.prepareStatement(query1);
            pst1.setString(1, uuidUsuario);
            ResultSet rs = pst1.executeQuery();
            
            if (rs.next()) {
                idUsuario = rs.getInt("id_usuario");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el usuario especificado.");
                return false;
            }

            PreparedStatement pst2 = cn.prepareStatement(query2);
            pst2.setInt(1, idUsuario);
            pst2.setInt(2, idCar);
            int rowsAffected = pst2.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Propietario agregado correctamente.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el propietario.");
                return false;
            }
            
        } catch (ClassNotFoundException | SQLException|IOException e) {
            System.err.println("Error en ExpenseController: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Operación cancelada.");
        return false;
    }
        return false;
}

    @Override
    public boolean existeModelo(String modelo, int idCar) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateCar(String modelo, String marca, String matricula, String anno) {
        throw new UnsupportedOperationException("Not supported yet."); 
        
    }
    
}

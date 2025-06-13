package com.pfrñfe.view.cars;

import com.pfrñfe.model.dtos.CarDto;
import com.pfrñfe.model.repository.CarModel;
import com.pfrñfe.view.auth.LoginView;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class EditCarView extends javax.swing.JFrame {
    
    private static final Logger logger = Logger.getLogger(EditCarView.class.getName());
    private final CarModel carModel;
    private CarDto car;
    private final String user;
    private final String car_update;

   
     public EditCarView() throws ClassNotFoundException, SQLException, IOException {
        initComponents();
        carModel = new CarModel();
        user = LoginView.user;
        car_update = SeeOwnCars.car_update;

        setTitle("Información del coche " + car_update + " - Sesión de " + user);
        setSize(650, 430);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/Wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        jLabel_Titulo.setText("Información del coche de " + car_update);

        cargarDatosCar();
    }
     
     private void cargarDatosCar() {
        try {
<<<<<<< HEAD
            car = carModel.getCarByModelo(car_update);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            System.err.println("Error en ExpenseController: " + e.getMessage());
        }
=======
            car = carService.findByModelo(car_update);
        } catch (SQLException | IOException | ClassNotFoundException e ) {
            System.out.println(e);
        } 
>>>>>>> af2cde03a3076dcffa684474f367a58bf1b9dd60
         if (car != null) {
             txt_marca.setText(car.getMarca());
             txt_modelo.setText(car.getModelo());
             txt_matricula.setText(car.getMatricula());
             txt_anno.setText(String.valueOf(car.getAnio()));
         } else {
             JOptionPane.showMessageDialog(this, "No se encontró el coche.", "Error", JOptionPane.ERROR_MESSAGE);
             dispose();
         }
    }
     
     @Override
        public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon_of.png"));
        return retValue;
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txt_marca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_modelo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_matricula = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_anno = new javax.swing.JTextField();
        jButton_Cancelar = new javax.swing.JButton();
        jButton_EditCar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton_Delete = new javax.swing.JButton();
        jLabel_Titulo = new javax.swing.JLabel();
        jButton_AddOwner = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Maca");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 120, 20));

        txt_marca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 160, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Modelo");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 120, 20));

        txt_modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 160, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Matrícula");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 120, 20));

        txt_matricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_matricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 160, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Año");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 120, 20));

        txt_anno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_anno, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 160, -1));

        jButton_Cancelar.setBackground(new java.awt.Color(255, 51, 102));
        jButton_Cancelar.setText("CANCELAR");
        jButton_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 120, 50));

        jButton_EditCar.setBackground(new java.awt.Color(153, 255, 153));
        jButton_EditCar.setText("Actualizar coche");
        jButton_EditCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EditCarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_EditCar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 120, 50));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Maca");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 120, 20));

        jButton_Delete.setText("Eliminar coche");
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 120, 50));

        jLabel_Titulo.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Titulo.setText("Editar coche");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 280, 40));

        jButton_AddOwner.setText("AÑADIR PROPIETARIO");
        jButton_AddOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddOwnerActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_AddOwner, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 150, 50));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_EditCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EditCarActionPerformed
        resetBackground();
        String marca = txt_marca.getText().trim();
        String modelo = txt_modelo.getText().trim();
        String matricula = txt_matricula.getText().trim();
        String anioStr = txt_anno.getText().trim();

        int validacion = 0;
        
        if (marca.isEmpty()) {
            txt_marca.setBackground(Color.red);
            validacion++;
        }
        if (modelo.isEmpty()) {
            txt_modelo.setBackground(Color.red);
            validacion++;
        }
        if (matricula.isEmpty()) {
            txt_matricula.setBackground(Color.red);
            validacion++;
        }
        if (anioStr.isEmpty()) {
            txt_anno.setBackground(Color.red);
            validacion++;
        }
         if (validacion > 0) {
            JOptionPane.showMessageDialog(this, "Debes llenar todos los campos.");
            return;
        } 
            
          try {
            int anio = Integer.parseInt(anioStr);

            car.setMarca(marca);
            car.setModelo(modelo);
            car.setMatricula(matricula);
            car.setAnio(anio);

            boolean actualizado = carModel.updateCar(car);
            if (actualizado) {
                JOptionPane.showMessageDialog(this, "Coche actualizado correctamente.");
                new SeeOwnCars().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el coche.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Año inválido. Debe ser un número.");
            txt_anno.setBackground(Color.red);
        } catch (ClassNotFoundException e) {
            System.err.println("Error en ExpenseController: " + e.getMessage());
        } catch (SQLException ex) {
            System.getLogger(EditCarView.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(EditCarView.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
          
    }//GEN-LAST:event_jButton_EditCarActionPerformed

    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelarActionPerformed
       try {
            new SeeOwnCars().setVisible(true);
            dispose();
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Error al volver a la vista de coches", ex);
            JOptionPane.showMessageDialog(this, "Error al volver: " + ex.getMessage());
        }
                     
    }//GEN-LAST:event_jButton_CancelarActionPerformed

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
      int confirm = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de eliminar este coche? Esta acción no se puede deshacer.",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                boolean eliminado;
                eliminado = carModel.deleteCar(car.getIdCoche());
                if (eliminado) {
                    JOptionPane.showMessageDialog(this, "Coche eliminado correctamente.");
                    new SeeOwnCars().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el coche.");
                }
            } catch (SQLException | IOException ex) {
                logger.log(Level.SEVERE, "Error al eliminar coche", ex);
                JOptionPane.showMessageDialog(this, "Error al eliminar coche: " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                logger.log(Level.SEVERE, "Error al volver a la vista de coches", ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Eliminación cancelada.");
        }
    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jButton_AddOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddOwnerActionPerformed
       
String uuidIngresado = JOptionPane.showInputDialog(this,
                "Introduce el código UUID del nuevo propietario:", "Añadir propietario",
                JOptionPane.QUESTION_MESSAGE);

        if (uuidIngresado == null || uuidIngresado.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes introducir un código UUID válido.");
            return;
        }

        try {
            boolean agregado = carModel.addOwner(car.getId(), uuidIngresado.trim());

            if (agregado) {
                JOptionPane.showMessageDialog(this, "Propietario añadido correctamente.");
                new SeeOwnCars().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "El usuario ya es propietario del coche o no existe.");
            }
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Error al volver a la vista de coches", ex);
        } catch (SQLException ex) {
            System.getLogger(EditCarView.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_jButton_AddOwnerActionPerformed
 private void resetBackground() {
        txt_marca.setBackground(Color.white);
        txt_modelo.setBackground(Color.white);
        txt_matricula.setBackground(Color.white);
        txt_anno.setBackground(Color.white);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AddOwner;
    private javax.swing.JButton jButton_Cancelar;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_EditCar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JTextField txt_anno;
    private javax.swing.JTextField txt_marca;
    private javax.swing.JTextField txt_matricula;
    private javax.swing.JTextField txt_modelo;
    // End of variables declaration//GEN-END:variables
    public void Limpiar(){
        txt_marca.setText("");
        txt_modelo.setText("");
        txt_matricula.setText("");
        txt_anno.setText("");
    }

}

package com.pfrñfe.view;

import com.pfrñfe.model.DatabaseConnection;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleState;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class EditCarView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EditCarView.class.getName());
    
    String user ="", car_update ="";
    int ID;

   
    public EditCarView() {
        initComponents();
        user = LoginView.user;
        car_update =  SeeOwnCars.car_update;
        
        setSize(650,430);
        setResizable(false);
        setTitle("Información del coche " + car_update + "- Sesion de " + user);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
               
        ImageIcon wallpaper = new ImageIcon("src/images/Wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
            jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
            jLabel_Wallpaper.setIcon(icono);
            this.repaint();
            //Pendiente de modificar o eliminar:
        jLabel_Titulo.setText("Información del coche de " + car_update);    
            
         try {
            Connection cn = DatabaseConnection.getConnection(); 
                PreparedStatement pst = cn.prepareStatement(
                    "select * from coche where modelo = ?");
                pst.setString(1, car_update);
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()){
                    ID = rs.getInt("id_coche");
                    
                /*Agregado->*/   /* txt_idCoche.setText(rs.getString("id_coche"));*/
                    txt_marca.setText(rs.getString("marca"));
                    txt_modelo.setText(rs.getString("modelo"));
                    txt_matricula.setText(rs.getString("matricula"));
                    txt_anno.setText(rs.getString("anio"));//Si no funciona cambiarlo por int en la base de datos
                }
                //rs.close();
                //pst.close();
                //cn.close();
        } catch (SQLException e) {
        System.err.println("Error SQL al cargar coche: " + e);
        JOptionPane.showMessageDialog(null, "ERROR al cargar. contacte al administrador!");
        } catch (Exception e) {
        System.err.println("Error general al cargar coche: " + e);
        JOptionPane.showMessageDialog(null, "ERROR al cargar. contacte al administrador!");
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
        jButton_Back = new javax.swing.JButton();
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
        getContentPane().add(jButton_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 120, 50));

        jButton_EditCar.setBackground(new java.awt.Color(153, 255, 153));
        jButton_EditCar.setText("Actualizar coche");
        jButton_EditCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EditCarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_EditCar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 120, 50));

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
        getContentPane().add(jButton_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 120, 50));

        jLabel_Titulo.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Titulo.setText("Editar coche");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 280, 40));
        getContentPane().add(jButton_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 60, 40));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_EditCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EditCarActionPerformed
        
        int  validacion = 0;
        String marca, modelo, matricula, anio;
        
        marca = txt_marca.getText().trim();
        modelo = txt_modelo.getText().trim();
        matricula = txt_matricula.getText().trim();
        anio = txt_anno.getText().trim();
        
        //Agregado ->
        txt_marca.setBackground(Color.white);
        txt_modelo.setBackground(Color.white);
        txt_matricula.setBackground(Color.white);
        txt_anno.setBackground(Color.white);
        
        if (marca.equals("")) {
            txt_marca.setBackground(Color.red);
            validacion++;
        }
        if (modelo.equals("")) {
            txt_modelo.setBackground(Color.red);
            validacion++;
        }
        if (matricula.equals("")) {
            txt_matricula.setBackground(Color.red);
            validacion++;
        }
        if (anio.equals("")) {
            txt_anno.setBackground(Color.red);
            validacion++;
        }
         System.out.println("Validación: " + validacion);  // Depuración
        
        if (validacion == 0 ) {
            
            try {
                Connection cn = DatabaseConnection.getConnection(); 
                PreparedStatement pst = cn.prepareStatement(
                    "select * from coche where modelo = ? and id_coche != ?");
                pst.setString(1, modelo);
                pst.setInt(2, ID);
                
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    txt_modelo.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Nombre de modelo  no disponilbe");
                    
                } else {
                    
            /*Eliminar?*/    Connection cn2 = DatabaseConnection.getConnection(); 
                PreparedStatement pst2 = cn2.prepareStatement(
                    "update coche set marca=?, modelo=?, matricula=?, anio=? where id_coche = ?");
                
                pst2.setString(1, marca);
                pst2.setString(2, modelo);
                pst2.setString(3, matricula);
                pst2.setString(4, anio);
                pst2.setInt(5, ID);
                
                pst2.executeUpdate();
                JOptionPane.showMessageDialog(null, "Modificación correcta");  
                SeeOwnCars vistaUsuario = new SeeOwnCars();
                vistaUsuario.setVisible(true);
            
                EditCarView.this.dispose();
            }
            
                
            } catch (SQLException e) {
                System.err.println("Error al actualizar" + e);
                /*Agregado ->*/ JOptionPane.showMessageDialog(null, "Error en la base de datos");
          /*  } catch (ClassNotFoundException ex) {
                System.getLogger(EditCarView.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);*/
            } catch (Exception ex) {
                /*Agregado ->*/System.err.println("Error inesperado: " + ex);
                //System.getLogger(EditCarView.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                /*Agregado ->*/JOptionPane.showMessageDialog(null, "Error inesperado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todo el campo!");
        }
        
    }//GEN-LAST:event_jButton_EditCarActionPerformed

    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelarActionPerformed
       SeeOwnCars vistaUsuario;
        try {
            vistaUsuario = new SeeOwnCars();
            vistaUsuario.setVisible(true);
            EditCarView.this.dispose();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar la ventana " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error al instaciar SeeOwnCars: " + ex);
            
        }
               
       
    }//GEN-LAST:event_jButton_CancelarActionPerformed

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
      int confirm = JOptionPane.showConfirmDialog(null, 
        "¿Estás seguro de eliminar este coche? Esta acción no se puede deshacer.",
        "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
      
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Connection cn = DatabaseConnection.getConnection();
                PreparedStatement pst = cn.prepareStatement("DELETE FROM coche WHERE id_coche =?");
                pst.setInt(1, ID);

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Coche eliminado correctamente.");
                    this.dispose(); // Cierra la ventana actual
                    // Opcional: Redirigir a la lista de coches
                    SeeOwnCars volver = new SeeOwnCars();
                    volver.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el coche a eliminar.");
                }

            }catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al eliminar el coche: " + e.getMessage());
            }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage());
            }
        }else {
        JOptionPane.showMessageDialog(null, "Eliminación cancelada.");
    }
    }//GEN-LAST:event_jButton_DeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new EditCarView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Back;
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

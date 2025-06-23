package com.pfrñfe.view.auth;

import com.pfrñfe.controller.IUserController;
import com.pfrñfe.controller.UserController;
import com.pfrñfe.view.auth.LoginView;
import com.pfrñfe.model.DatabaseConnection;
import com.pfrñfe.utils.EncryptorUtil;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author practicas1
 */
public class RegisterView extends javax.swing.JFrame {
    
    private IUserController userController;
    private EncryptorUtil strongPasswordEncryptor;
    
    String user;
    public RegisterView() {
        
        this.strongPasswordEncryptor = new EncryptorUtil();
        
        try {
            this.userController = new UserController();
        } catch (ClassNotFoundException | SQLException|IOException e) {
            System.err.println("Error en ExpenseController: " + e.getMessage());
        }
        
        initComponents();
        user = LoginView.user;
        setSize(400,550);
        setResizable(false);
        setTitle("Registrar nuevo usuario - Sesión de " + user);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/Wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
    }
    

    @Override
        public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon_of.png"));
        return retValue;
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_registerNew = new javax.swing.JTextField();
        txt_passwordNew = new javax.swing.JPasswordField();
        jButton_Registrarse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_registerNew.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_registerNew.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_registerNew.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_registerNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 210, 30));

        txt_passwordNew.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_passwordNew.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_passwordNew.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_passwordNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordNewActionPerformed(evt);
            }
        });
        getContentPane().add(txt_passwordNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 210, 30));

        jButton_Registrarse.setBackground(new java.awt.Color(153, 255, 153));
        jButton_Registrarse.setText("REGISTRARSE");
        jButton_Registrarse.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_Registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Registrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 170, 50));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingrese una contraseña:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 130, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingrese un nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 130, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passwordNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordNewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordNewActionPerformed

    private void jButton_RegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarseActionPerformed
        int permisos_cmb, validacion = 0;
        String nombre, password, id_coche;
        
        nombre = txt_registerNew.getText().trim();
        password = txt_passwordNew.getText().trim();
        //ComboBox permisos_cmb = cmb_niveles.getSelectedIndex() + 1;
        
        if(nombre.equals("")){
            txt_registerNew.setBackground(Color.RED);
            validacion++;
        }
        if(password.equals("")){
            txt_passwordNew.setBackground(Color.RED);
            validacion++;
        }
        //Obetener y seleccionar el id_car
        /*if(permisos_cmb.equals ==1){
            id_coche =; 
            validacion++;
        }*/
        
        userController.register(nombre,strongPasswordEncryptor.encrypt(password));
        
        dispose();
        
    }//GEN-LAST:event_jButton_RegistrarseActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Registrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JPasswordField txt_passwordNew;
    private javax.swing.JTextField txt_registerNew;
    // End of variables declaration//GEN-END:variables

    public void Limpiar(){
        txt_registerNew.setText("");
        txt_passwordNew.setText("");
    }
}

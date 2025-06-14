package com.pfrñfe.view.auth;

import com.pfrñfe.model.DatabaseConnection;
import com.pfrñfe.utils.UsuarioSesion;
import com.pfrñfe.view.UserView;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.SQLException;



public class LoginView extends javax.swing.JFrame {
    
   
    public static String user = "";
    String pass = "";
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginView.class.getName());

 
    public LoginView() {
        initComponents();
        setSize(400,550);
        setResizable(false);
        setTitle("Acceso al sistema");
        setLocationRelativeTo(null);
        
        ImageIcon wallpaper = new ImageIcon("src/images/Wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        
        ImageIcon logo = new ImageIcon("src/images/Logo.png");
        Icon icono_logo = new ImageIcon(logo.getImage().getScaledInstance(jLabel_Logo.getWidth(),
        jLabel_Logo.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Logo.setIcon(icono_logo);
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

        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jButton_Acceder = new javax.swing.JButton();
        jLabel_Footer = new javax.swing.JLabel();
        jLabel_Logo = new javax.swing.JLabel();
        jButton_Registrarse = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 330, 210, 30));

        txt_password.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 370, 210, 30));

        jButton_Acceder.setBackground(new java.awt.Color(204, 204, 204));
        jButton_Acceder.setText("ACCEDER");
        jButton_Acceder.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AccederActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 150, -1));

        jLabel_Footer.setFont(new java.awt.Font("Segoe UI Semilight", 0, 10)); // NOI18N
        jLabel_Footer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Footer.setText("Proyecto realizado by: Felix");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 180, -1));
        getContentPane().add(jLabel_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 270, 270));

        jButton_Registrarse.setBackground(new java.awt.Color(153, 255, 153));
        jButton_Registrarse.setText("REGISTRARSE");
        jButton_Registrarse.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton_Registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Registrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 150, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AccederActionPerformed
        
        user = txt_user.getText().trim();
        pass = txt_password.getText().trim();
        
        System.out.println("Usuario ingresado: '" + user + "'");
        System.out.println("Password ingresado: '" + pass + "'");
        
        if (!user.equals("") && !pass.equals("")) {
           
            Connection cn = null; 
            PreparedStatement pst = null;
            ResultSet rs = null;
            //Hasta aqui
            try {
                cn = DatabaseConnection.getConnection(); 
                //???
                String query = "SELECT id_usuario, nombre FROM usuario WHERE nombre = ? AND password = ?";
                pst = cn.prepareStatement(query);
                /*pst = cn.prepareStatement(//CAMBIAMOS EL NOMBRE POR ID_USUARIO
                    "SELECT id_usuario, nombre FROM usuario "
                            + "WHERE nombre = ? AND password = ?");*/
                
            pst.setString(1, user);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            
            if (rs.next()) {
            int idUsuario = rs.getInt("id_usuario");
            String nombreUsuario = rs.getString("nombre");
            
            UsuarioSesion.setUsuario(idUsuario, nombreUsuario);
             System.out.println("Login exitoso para: " + nombreUsuario);
                dispose();
                new UserView().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos");
                txt_user.setText("");
                txt_password.setText("");
            }

        } catch (Exception e) {
            System.err.println("Error en el botón Acceder: " + e);
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión!");
        }//Código agregado ->
            finally {
            // Asegúrate de cerrar los recursos en el bloque finally
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar recursos: " + ex);
            }
        }/*Hasta aqui*/

    } else {
        JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
    }
        
    }//GEN-LAST:event_jButton_AccederActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void jButton_RegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarseActionPerformed
        
        /*Indicar a donde ir después de darle al boton*/
        RegisterView registrarUsuario = new RegisterView();
        registrarUsuario.setVisible(true);
        
    }//GEN-LAST:event_jButton_RegistrarseActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new LoginView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Acceder;
    private javax.swing.JButton jButton_Registrarse;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables

}
package com.pfrñfe.view.auth;


import com.pfrñfe.controller.AuthController;
import com.pfrñfe.controller.IAuthController;

import com.pfrñfe.controller.AuthController;
import com.pfrñfe.model.DatabaseConnection;
import com.pfrñfe.model.dtos.UserLoginDto;
import com.pfrñfe.model.entities.UsuarioSesion;
import com.pfrñfe.view.UserView;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
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
    private IAuthController auth;
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginView.class.getName());

 
    public LoginView() throws ClassNotFoundException, SQLException, IOException {
        initComponents();
        
        try {
        auth = new AuthController();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al iniciar controlador de autenticación: " + e.getMessage());
        e.printStackTrace();
        }
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
        pass = new String(txt_password.getPassword()).trim();
        
        if (!user.equals("") && !pass.equals("")) {
        UserLoginDto userL = new UserLoginDto(user, pass);

        System.out.println("Intentando login con usuario: " + user);
        System.out.println("Password ingresada (en texto plano): " + pass);

        if (auth.login(userL)) {
            JOptionPane.showMessageDialog(this, "¡Login correcto!");

            try {
                Connection cn = DatabaseConnection.getConnection();
                PreparedStatement pst = cn.prepareStatement("SELECT id_usuario FROM usuario WHERE nombre = ?");
                pst.setString(1, user);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    int idUsuario = rs.getInt("id_usuario");
                    UsuarioSesion.setUsuario(idUsuario, user); // Configura la sesión
                    dispose();
                    new UserView().setVisible(true);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al obtener datos del usuario.");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas.");
            txt_user.setText("");
            txt_password.setText("");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Debes llenar todos los campos.");
    }
        
    }//GEN-LAST:event_jButton_AccederActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
      
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void jButton_RegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarseActionPerformed

        RegisterView registrarUsuario = new RegisterView();
        registrarUsuario.setVisible(true);
    }//GEN-LAST:event_jButton_RegistrarseActionPerformed
public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LoginView().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    System.getLogger(LoginView.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                } catch (SQLException ex) {
                    System.getLogger(LoginView.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                } catch (IOException ex) {
                    System.getLogger(LoginView.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }
        });
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
package com.pfrñfe.view;

import com.pfrñfe.controller.IUserController;
import com.pfrñfe.controller.UserController;
import com.pfrñfe.view.cars.SeeOwnCars;
import com.pfrñfe.view.cars.CreateCarView;
import com.pfrñfe.model.repository.IUserModel;
import com.pfrñfe.model.repository.UserModel;

import java.sql.*;

import com.pfrñfe.model.repository.UserModel;
import com.pfrñfe.view.auth.LoginView;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;
import java.io.IOException;


public class UserView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UserView.class.getName());

    String user;
    /*public static int sesion_usuario;*/
    private IUserController userController;
    
    public UserView() {
        initComponents();
        user = LoginView.user;
      /*  sesion_usuario = 1;*/
      
      try {
            this.userController = new UserController();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            logger.severe("Error al inicializar UserController: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error interno: " + e.getMessage());
        }
        
        setSize(650, 430);
        setResizable(false);
        setTitle("Usuario - Sesión de " + user);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Cargar datos del usuario
        cargarDatosUsuario();
               
        ImageIcon wallpaper = new ImageIcon("src/images/Wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
            jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
            jLabel_Wallpaper.setIcon(icono);
            this.repaint();
            
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/Back.png"));
        Image img = icon.getImage().getScaledInstance(jButton_Back2.getWidth(), jButton_Back2.getHeight(), Image.SCALE_SMOOTH);
            jButton_Back2.setIcon(new ImageIcon(img));    
            
         }   
    
        @Override
        public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon_of.png"));
        return retValue;  
        } 
    

private void cargarDatosUsuario() {
    System.out.println("Usuario a buscar: '" + user + "'");

        String nombreUsuario = userController.findUserName(user);
        if (nombreUsuario != null) {
            jLabel_NombreUsuario.setText("Bienvenido: " + nombreUsuario);
        } else {
            jLabel_NombreUsuario.setText("Usuario no encontrado");
            logger.warning("No se encontró el usuario: " + user);
            mostrarErrorUsuarioNoEncontrado();
        }
    }

    private void mostrarErrorUsuarioNoEncontrado() {
        int opcion = JOptionPane.showConfirmDialog(this,
                "El usuario no fue encontrado en la base de datos.\n¿Desea volver al login?",
                "Usuario no encontrado",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
            volverAlLogin();
        }
    }

    private void volverAlLogin() {
        this.dispose();
        new LoginView().setVisible(true);
    }

    private String userUuid;
    
    public void setUserUuid(String uuid) {
        this.userUuid = uuid;
    }
    
    public String getUserUuid() {
        return this.userUuid;
    }
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_NombreUsuario = new javax.swing.JLabel();
        jButton_CrearCoche = new javax.swing.JButton();
        jButton_VerCochesPropios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton_Back2 = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_NombreUsuario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_NombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreUsuario.setText("jLabel1");
        getContentPane().add(jLabel_NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton_CrearCoche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_car.png"))); // NOI18N
        jButton_CrearCoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CrearCocheActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_CrearCoche, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 170, 120));

        jButton_VerCochesPropios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_lens.png"))); // NOI18N
        jButton_VerCochesPropios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VerCochesPropiosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_VerCochesPropios, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 170, 120));

        jLabel1.setText("Ver coches propios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, -1, -1));

        jLabel2.setText("Crear coche");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        jLabel3.setText("Creado por Don Felix");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, -1, -1));

        jButton_Back2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Back2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Back2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 70, 60));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_VerCochesPropiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VerCochesPropiosActionPerformed
        try {
            SeeOwnCars CochesPropios = new SeeOwnCars();
            CochesPropios.setVisible(true);
        } catch (ClassNotFoundException ex) {
            System.getLogger(UserView.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_jButton_VerCochesPropiosActionPerformed

    private void jButton_CrearCocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CrearCocheActionPerformed

        try {
            CreateCarView CrearCoche = new CreateCarView();
            CrearCoche.setVisible(true);
        } catch (ClassNotFoundException ex) {
            System.getLogger(UserView.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(UserView.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(UserView.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_jButton_CrearCocheActionPerformed

    private void jButton_Back2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Back2ActionPerformed
        LoginView volver = new LoginView();
        volver.setVisible(true);
        UserView.this.dispose();
    }//GEN-LAST:event_jButton_Back2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new UserView().setVisible(true));
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Back;
    private javax.swing.JButton jButton_Back1;
    private javax.swing.JButton jButton_Back2;
    private javax.swing.JButton jButton_CrearCoche;
    private javax.swing.JButton jButton_VerCochesPropios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_NombreUsuario;
    private javax.swing.JLabel jLabel_Wallpaper;
    // End of variables declaration//GEN-END:variables
}
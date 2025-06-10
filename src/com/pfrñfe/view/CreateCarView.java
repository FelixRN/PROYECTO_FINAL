package com.pfrñfe.view;


import com.pfrñfe.controller.IMainController;
import com.pfrñfe.controller.MainController;
import com.pfrñfe.model.entities.UsuarioSesion;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.sql.Statement;

public class CreateCarView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CreateCarView.class.getName());

    private IMainController mainController;
   
    public CreateCarView() {
        initComponents();
        setSize(650,430);
        setResizable(false);
        setTitle("Crear coche");
        setLocationRelativeTo(null);
        this.mainController = new MainController(); 
        
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

        jLabel2 = new javax.swing.JLabel();
        txt_marca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_modelo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_matricula = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_anno = new javax.swing.JTextField();
        jButton_Cancel = new javax.swing.JButton();
        jButton_Apply = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
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

        jButton_Cancel.setBackground(new java.awt.Color(255, 51, 102));
        jButton_Cancel.setText("CANCELAR");
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 120, 50));

        jButton_Apply.setBackground(new java.awt.Color(153, 255, 153));
        jButton_Apply.setText("APLICAR");
        jButton_Apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ApplyActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Apply, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 120, 50));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Maca");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 120, 20));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ApplyActionPerformed
        
        int permisos_cmb, validacion = 0;
        String marca, modelo, matricula, anno;
        
        marca = txt_marca.getText().trim();
        modelo = txt_modelo.getText().trim();
        matricula = txt_matricula.getText().trim();
        anno = txt_anno.getText().trim();
       
        if(marca.equals("")){
            txt_marca.setBackground(Color.RED);
            validacion++;
        }
        if(modelo.equals("")){
            txt_modelo.setBackground(Color.RED);
            validacion++;
        }
        if(matricula.equals("")){
            txt_matricula.setBackground(Color.RED);
            validacion++;
        }
        if(anno.equals("")){
            txt_anno.setBackground(Color.RED);
            validacion++;
        }
        
        
    mainController.createCar(marca, modelo, matricula, anno);
    
    Limpiar();
                            
                            txt_marca.setBackground(Color.GREEN);
                            txt_modelo.setBackground(Color.GREEN);
                            txt_matricula.setBackground(Color.GREEN);
                            txt_anno.setBackground(Color.GREEN);
    
    }//GEN-LAST:event_jButton_ApplyActionPerformed

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
       UserView vistaUsuario = new UserView();
       vistaUsuario.setVisible(true);
    }//GEN-LAST:event_jButton_CancelActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new CreateCarView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Apply;
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
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

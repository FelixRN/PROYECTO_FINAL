package com.p10.view;

import com.p10.model.entities.UsuarioSesion;
import com.p10.model.DatabaseConnection;
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

   
    public CreateCarView() {
        initComponents();
        setSize(650,430);
        setResizable(false);
        setTitle("Crear coche");
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

        jLabel2 = new javax.swing.JLabel();
        txt_marca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_modelo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_matricula = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_anno = new javax.swing.JTextField();
        jButton_Cancelar = new javax.swing.JButton();
        jButton_Crear = new javax.swing.JButton();
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

        jButton_Cancelar.setBackground(new java.awt.Color(255, 51, 102));
        jButton_Cancelar.setText("CANCELAR");
        jButton_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 120, 50));

        jButton_Crear.setBackground(new java.awt.Color(153, 255, 153));
        jButton_Crear.setText("CREAR");
        jButton_Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CrearActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 120, 50));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Maca");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 120, 20));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CrearActionPerformed
        
        int permisos_cmb, validacion = 0;
        String marca, modelo, matricula, anno;
        
        marca = txt_marca.getText().trim();
        modelo = txt_modelo.getText().trim();
        matricula = txt_matricula.getText().trim();
        anno = txt_anno.getText().trim();
        
        
        
        //ComboBox permisos_cmb = cmb_niveles.getSelectedIndex() + 1;
        
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
        
    try {
            Connection cn = DatabaseConnection.getConnection(); 
                PreparedStatement pst = cn.prepareStatement(
                    "SELECT matricula FROM coche WHERE matricula = '" + matricula + "'");
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                txt_matricula.setBackground(Color.RED);
                    JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible.");
                    return;
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
                             //  pst2.close();
                             // cn2.close();
                            
                            
                           // pst2.executeUpdate();
                            
                            Limpiar();
                            
                            txt_marca.setBackground(Color.GREEN);
                            txt_modelo.setBackground(Color.GREEN);
                            txt_matricula.setBackground(Color.GREEN);
                            txt_anno.setBackground(Color.GREEN);
                            
                            
                            JOptionPane.showMessageDialog(null, "Registro del coche exitoso.");
                            this.dispose();
                            
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
        
    }//GEN-LAST:event_jButton_CrearActionPerformed

    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelarActionPerformed
       UserView vistaUsuario = new UserView();
       vistaUsuario.setVisible(true);
    }//GEN-LAST:event_jButton_CancelarActionPerformed

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
    private javax.swing.JButton jButton_Cancelar;
    private javax.swing.JButton jButton_Crear;
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

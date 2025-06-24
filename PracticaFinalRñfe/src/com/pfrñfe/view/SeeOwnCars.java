package com.pfrñfe.view;

import com.pfrñfe.controller.CarController;
import com.pfrñfe.controller.ICarController;
import com.pfrñfe.model.DatabaseConnection;
import com.pfrñfe.model.entities.UsuarioSesion;
import com.pfrñfe.view.EditCarView;
import com.pfrñfe.view.ExpenseView;
import com.pfrñfe.view.InfoView;
import com.pfrñfe.view.auth.LoginView;
import com.pfrñfe.view.auth.RegisterView;
import java.awt.Image;
import java.awt.Toolkit;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Icon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


public class SeeOwnCars extends javax.swing.JFrame {

    String user;
    public static String car_update = "";
    DefaultTableModel model = new DefaultTableModel();
    
    public SeeOwnCars() throws ClassNotFoundException {
        initComponents();
        user = LoginView.user;
        setSize(650,430);
        setResizable(false);
        setTitle("Coches propios - Sesión de " + user);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon back = new ImageIcon("src/images/Back.png");
        Icon icono2 = new ImageIcon(back.getImage().getScaledInstance(jButton_Back.getWidth(),
            jButton_Back.getHeight(), Image.SCALE_DEFAULT));
            jButton_Back.setIcon(icono2);
            this.repaint();
        
               
        ImageIcon wallpaper = new ImageIcon("src/images/Wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
            jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
            jLabel_Wallpaper.setIcon(icono);
            this.repaint();
   
            
            try {
            Connection cn = DatabaseConnection.getConnection();
                PreparedStatement pst = cn.prepareStatement(

                        "SELECT c.id_coche, c.marca, c.modelo, c.matricula, c.anio " +
                        "FROM coche c " +
                        "INNER JOIN propietario p ON c.id_coche = p.id_coche " +
                        "WHERE p.id_usuario = ?");
                pst.setInt(1, UsuarioSesion.getIdUsuario());
                ResultSet rs = pst.executeQuery();
                
                jTable_Coches = new JTable(model);
                jScrollPane1.setViewportView(jTable_Coches);
                
                model.addColumn("Id");
                model.addColumn("Marca");
                model.addColumn("Modelo");
                model.addColumn("Matricula");
                model.addColumn("Año");
                
                while(rs.next()){
                    Object[] fila = new Object[5];
                    
                    for (int i = 0; i < 5; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    model.addRow(fila);
                }
                
                if (model.getRowCount() == 0) {
                jButton_Edit.setEnabled(false);
                jButton_Add.setEnabled(false);
                jButton_Info.setEnabled(false);
                } else {
                jButton_Edit.setEnabled(true);
                jButton_Add.setEnabled(true);
                jButton_Info.setEnabled(true);
                }
                
        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla" + e);
                JOptionPane.showMessageDialog(null, "Error al mostrar información !Contacte al administrador!");
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegisterView.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            jTable_Coches.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Coches.rowAtPoint(e.getPoint());
                int columna_point = 2;

        if (fila_point > -1) {
            SeeOwnCars.car_update = (String) model.getValueAt(fila_point, columna_point);
            try {
                ICarController controller = new CarController();
                EditCarView editarCoche = new EditCarView(controller); 
                editarCoche.setVisible(true);
                SeeOwnCars.this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al abrir vista de edición: " + ex.getMessage());
            }
        }
    }
});
            
    }
         @Override
        public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon_of.png"));
        return retValue;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_Info = new javax.swing.JButton();
        jButton_Edit = new javax.swing.JButton();
        jButton_Add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Coches = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton_Back = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_Info.setText("Ver info del coche");
        jButton_Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InfoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 150, 60));

        jButton_Edit.setText("Editar / Eliminar");
        jButton_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EditActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 130, 60));

        jButton_Add.setText("Añadir ");
        jButton_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 130, 60));

        jTable_Coches.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_Coches);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 560, 220));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COCHES PROPIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 16, 280, 30));

        jButton_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BackActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 80, 60));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddActionPerformed
         String inputId = JOptionPane.showInputDialog(null, 
        "Introduzca el ID del coche para añadir/editar gastos", 
        "Seleccionar coche", JOptionPane.QUESTION_MESSAGE);

    if (inputId != null && !inputId.trim().isEmpty()) {
        try {
            int idCoche = Integer.parseInt(inputId.trim());

            Connection cn = DatabaseConnection.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM coche WHERE id_coche = ?");
            pst.setInt(1, idCoche);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                ExpenseView verGastos = new ExpenseView();
                verGastos.idCoche = idCoche;
                verGastos.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un coche con ese ID.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número válido.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al buscar el coche: " + e.getMessage());
        }    catch (ClassNotFoundException ex) {
                 System.getLogger(SeeOwnCars.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
             } catch (IOException ex) {
                 System.getLogger(SeeOwnCars.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
             }
    } else {
        JOptionPane.showMessageDialog(null, "ID no introducido.");
    }

    }//GEN-LAST:event_jButton_AddActionPerformed

    private void jButton_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EditActionPerformed
    
                                                    

    String inputId = JOptionPane.showInputDialog(null, 
        "Introduzca el ID del coche para editarlo", 
        "Editar coche", JOptionPane.QUESTION_MESSAGE);

    if (inputId != null && !inputId.trim().isEmpty()) {
        try {
            int idCoche = Integer.parseInt(inputId.trim());

            Connection cn = DatabaseConnection.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT modelo FROM coche WHERE id_coche = ?");
            pst.setInt(1, idCoche);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String modelo = rs.getString("modelo");
                SeeOwnCars.car_update = modelo; // 🔁 Reutilizas lo que espera tu EditCarView

                ICarController controller = new CarController();
                EditCarView editarCoche = new EditCarView(controller);
                editarCoche.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un coche con ese ID.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número válido.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al buscar el coche: " + e.getMessage());
        } catch (ClassNotFoundException |IOException e) {
            System.err.println("Error en ExpenseController: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "ID no introducido.");
    }

    }//GEN-LAST:event_jButton_EditActionPerformed

    private void jButton_InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InfoActionPerformed
        String inputId = JOptionPane.showInputDialog(null, 
        "Introduzca el ID del coche para ver sus gastos", 
        "Seleccionar coche", JOptionPane.QUESTION_MESSAGE);

    if (inputId != null && !inputId.trim().isEmpty()) {
        try {
            int idCoche = Integer.parseInt(inputId.trim());

            Connection cn = DatabaseConnection.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM coche WHERE id_coche = ?");
            pst.setInt(1, idCoche);
            ResultSet rs = pst.executeQuery();
            System.out.println("Cargando InfoView con id_coche: " + idCoche);
            if (rs.next()) {
                InfoView vista = new InfoView(idCoche);
                vista.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un coche con ese ID.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número válido.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar coche: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "ID no introducido.");
    }
    }//GEN-LAST:event_jButton_InfoActionPerformed

    private void jButton_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BackActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton_BackActionPerformed

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
            java.util.logging.Logger.getLogger(SeeOwnCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeeOwnCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeeOwnCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeeOwnCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeeOwnCars().setVisible(true);
            }
        });*/
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new SeeOwnCars().setVisible(true);
            } catch (ClassNotFoundException ex) {
                System.getLogger(SeeOwnCars.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Add;
    private javax.swing.JButton jButton_Back;
    private javax.swing.JButton jButton_Edit;
    private javax.swing.JButton jButton_Info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Coches;
    // End of variables declaration//GEN-END:variables
}

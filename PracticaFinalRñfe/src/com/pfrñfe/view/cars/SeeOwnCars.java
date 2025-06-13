package com.pfrñfe.view.cars;

import com.pfrñfe.model.DatabaseConnection;
import com.pfrñfe.utils.UsuarioSesion;
import com.pfrñfe.view.cars.EditCarView;
import com.pfrñfe.view.UserView;
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
               
        ImageIcon wallpaper = new ImageIcon("src/images/Wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
            jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
            jLabel_Wallpaper.setIcon(icono);
            this.repaint();
            
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/Back.png"));
        Image img = icon.getImage().getScaledInstance(jButton_Back.getWidth(), jButton_Back.getHeight(), Image.SCALE_SMOOTH);
            jButton_Back.setIcon(new ImageIcon(img));
         
            
            try {
            Connection cn = DatabaseConnection.getConnection();
                PreparedStatement pst = cn.prepareStatement(
                        "SELECT c.id_coche, c.marca, c.modelo, c.matricula, c.anio " +
                        "FROM coche c " +
                        "INNER JOIN propietario p ON c.id_coche = p.id_coche " +
                        "WHERE p.id_usuario = ?");
                pst.setInt(1, UsuarioSesion.getIdUsuario()); 
                ResultSet rs = pst.executeQuery();
            /*Provisional->*/    System.out.println("ID del usuario en sesión: " + UsuarioSesion.getIdUsuario());

                
                jTable_Coches = new JTable(model);
                jScrollPane1.setViewportView(jTable_Coches);
                
                model.addColumn("Id");
                model.addColumn("Marca");
                model.addColumn("Modelo");
                model.addColumn("Matricula");
                model.addColumn("Año");
                
                /*Si encontro resultado*/
                while(rs.next()){
                    Object[] fila = new Object[5];
                    
                    for (int i = 0; i < 5; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    model.addRow(fila);
                }
                
        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla" + e);
                System.err.println("Error al llenar la tabla" + e);
                JOptionPane.showMessageDialog(null, "Error al mostrar información !Contacte al administrador!");
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegisterView.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            jTable_Coches.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    int fila_point = jTable_Coches.rowAtPoint(e.getPoint());
                    int columna_point = 2;
                    
                    if(fila_point > -1){
                        try {
                            car_update = (String)model.getValueAt(fila_point, columna_point);
                            EditCarView editarCoche = new EditCarView();
                            editarCoche.setVisible(true);
                            
                            SeeOwnCars.this.dispose();
                        } catch (ClassNotFoundException ex) {
                            System.getLogger(SeeOwnCars.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                        } catch (SQLException ex) {
                            System.getLogger(SeeOwnCars.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                        } catch (IOException ex) {
                            System.getLogger(SeeOwnCars.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
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
        getContentPane().add(jButton_Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 140, 60));

        jButton_Edit.setText("Editar / Eliminar");
        jButton_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EditActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 130, 60));

        jButton_Add.setText("Añadir / Ver gastos");
        jButton_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 140, 60));

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
        getContentPane().add(jButton_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 70, 60));
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

            // Validamos que el coche exista
            Connection cn = DatabaseConnection.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM coche WHERE id_coche = ?");
            pst.setInt(1, idCoche);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                ExpenseView verGastos = new ExpenseView();
                verGastos.idCoche = idCoche;
                verGastos.cargarUltimoGastoDelCoche();
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
        try {
            EditCarView CrearCoche = new EditCarView();
            CrearCoche.setVisible(true);
        } catch (ClassNotFoundException | SQLException|IOException e) {
            System.err.println("Error en ExpenseController: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton_EditActionPerformed

    private void jButton_InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InfoActionPerformed
        
        
       String inputId = JOptionPane.showInputDialog(this,
        "Introduce el ID del coche para ver la información de sus gastos:",
        "Ver información del coche", JOptionPane.QUESTION_MESSAGE);

    if (inputId != null && !inputId.trim().isEmpty()) {
        try {
            int idCoche = Integer.parseInt(inputId.trim());

            // Validamos que el coche exista
            Connection cn = DatabaseConnection.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM coche WHERE id_coche = ?");
            pst.setInt(1, idCoche);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                InfoView verInfo = new InfoView(idCoche);
                verInfo.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún coche con ese ID.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero válido.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al abrir la vista de información: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Debes introducir un ID de coche.");
    }
    }//GEN-LAST:event_jButton_InfoActionPerformed

    private void jButton_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BackActionPerformed
        UserView volver = new UserView();
        volver.setVisible(true);
        SeeOwnCars.this.dispose();
    }//GEN-LAST:event_jButton_BackActionPerformed

    /**
     * @param args the command line arguments
     */
<<<<<<< HEAD:Proyecto_final/src/com/pfrñfe/view/cars/SeeOwnCars.java
    public static void main(String args[]) {
=======
    public void run() {
        
>>>>>>> e9d454d74519e65603dbc62fb808c4b460a170f8:PracticaFinalRñfe/src/com/pfrñfe/view/cars/SeeOwnCars.java
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

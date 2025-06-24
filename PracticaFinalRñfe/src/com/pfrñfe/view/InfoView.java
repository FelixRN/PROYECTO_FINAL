package com.pfrñfe.view;

import com.pfrñfe.model.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


public class InfoView extends javax.swing.JFrame {

    private int idCoche;
    
    public InfoView(int idCoche) {
        this.idCoche = idCoche;
        initComponents();
        setSize(650,430);
        setResizable(false);
        setTitle("Información coche");
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
            
          cargarGastos();  
    }
    
    public void cargarGastos() {
    try {
        Connection cn = DatabaseConnection.getConnection();

        String query = "SELECT tipo, kilometraje, fecha_gasto, importe, descripcion FROM gastos WHERE id_coche = ?";
        List<Object> params = new ArrayList<>();
        params.add(idCoche);

        if (txtAnio.isSelected()) {
            String anioStr = JOptionPane.showInputDialog(this, "Introduce el año (formato: yyyy):");
            if (anioStr != null && anioStr.matches("\\d{4}")) {
                query += " AND YEAR(fecha_gasto) = ?";
                params.add(Integer.parseInt(anioStr));
            } else {
                JOptionPane.showMessageDialog(this, "Año no válido. Debe tener formato yyyy.");
                return;
            }
        }

        if (txtFecha.isSelected()) {
            String fechaStr = JOptionPane.showInputDialog(this, "Introduce la fecha exacta (formato: yyyy-MM-dd):");
            if (fechaStr != null && fechaStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
                query += " AND fecha_gasto = ?";
                params.add(java.sql.Date.valueOf(fechaStr));
            } else {
                JOptionPane.showMessageDialog(this, "Fecha no válida. Debe tener formato yyyy-MM-dd.");
                return;
            }
        }

        if (txtKmMin.isSelected()) {
            String kmMinStr = JOptionPane.showInputDialog(this, "Introduce el kilometraje mínimo:");
            if (kmMinStr != null && kmMinStr.matches("\\d+")) {
                query += " AND kilometraje >= ?";
                params.add(Integer.parseInt(kmMinStr));
            } else {
                JOptionPane.showMessageDialog(this, "Kilometraje mínimo no válido. Solo números enteros.");
                return;
            }
        }

        if (txtKmMax.isSelected()) {
            String kmMaxStr = JOptionPane.showInputDialog(this, "Introduce el kilometraje máximo:");
            if (kmMaxStr != null && kmMaxStr.matches("\\d+")) {
                query += " AND kilometraje <= ?";
                params.add(Integer.parseInt(kmMaxStr));
            } else {
                JOptionPane.showMessageDialog(this, "Kilometraje máximo no válido. Solo números enteros.");
                return;
            }
        }

        PreparedStatement pst = cn.prepareStatement(query);
        for (int i = 0; i < params.size(); i++) {
            pst.setObject(i + 1, params.get(i));
        }

        ResultSet rs = pst.executeQuery();

        DefaultTableModel model = new DefaultTableModel();
        jTable_Gastos.setModel(model);
        jScrollPaneGastos.setViewportView(jTable_Gastos);

        model.addColumn("Tipo");
        model.addColumn("Kilometraje");
        model.addColumn("Fecha");
        model.addColumn("Importe");
        model.addColumn("Descripción");

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("tipo"),
                rs.getInt("kilometraje"),
                rs.getDate("fecha_gasto"),
                rs.getDouble("importe"),
                rs.getString("descripcion")
            });
        }

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No se encontraron gastos con los filtros seleccionados.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error SQL: " + e.getMessage());
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jButton_Back = new javax.swing.JButton();
        jButton_filtrar = new javax.swing.JButton();
        txtKmMin = new javax.swing.JCheckBox();
        txtAnio = new javax.swing.JCheckBox();
        txtFecha = new javax.swing.JCheckBox();
        txtKmMax = new javax.swing.JCheckBox();
        jScrollPaneGastos = new javax.swing.JScrollPane();
        jTable_Gastos = new javax.swing.JTable();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GASTOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 150, 50));

        jButton_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BackActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 80, 50));

        jButton_filtrar.setText("FILTRAR");
        jButton_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_filtrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_filtrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, 30));

        txtKmMin.setText("KmMin");
        getContentPane().add(txtKmMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

        txtAnio.setText("Año");
        getContentPane().add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        txtFecha.setText("Fecha");
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        txtKmMax.setText("KmMax");
        getContentPane().add(txtKmMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        jTable_Gastos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPaneGastos.setViewportView(jTable_Gastos);

        getContentPane().add(jScrollPaneGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 197, 570, 100));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BackActionPerformed
        try {
            dispose();
            SeeOwnCars volver = new SeeOwnCars();
            volver.setVisible(true);
        } catch (ClassNotFoundException ex) {
            System.getLogger(InfoView.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_jButton_BackActionPerformed

    private void jButton_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_filtrarActionPerformed
        cargarGastos();
    }//GEN-LAST:event_jButton_filtrarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Back;
    private javax.swing.JButton jButton_filtrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPaneGastos;
    private javax.swing.JTable jTable_Gastos;
    private javax.swing.JCheckBox txtAnio;
    private javax.swing.JCheckBox txtFecha;
    private javax.swing.JCheckBox txtKmMax;
    private javax.swing.JCheckBox txtKmMin;
    // End of variables declaration//GEN-END:variables
}

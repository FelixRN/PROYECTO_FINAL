
package com.pfrñfe.view;
import com.pfrñfe.model.DatabaseConnection;


import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;


public class ExpenseView extends javax.swing.JFrame {

    public int idCoche; 
    public boolean modoEdicion = false; 
    public int idGastoActual; 
    
    private final Map<String, String> tipoMap = Map.of(
    "Gasolina", "Gasolina",
    "Revisión", "Revision",
    "ITV", "ITV",
    "Cambio de aceite", "Cambio_aceite",
    "Otros", "Otros"
);

    
    public ExpenseView() {
        initComponents();
        
        jComboBox.removeAllItems(); // Limpia por si acaso
        jComboBox.addItem("Gasolina");
        jComboBox.addItem("Revisión");
        jComboBox.addItem("ITV");
        jComboBox.addItem("Cambio de aceite");
        jComboBox.addItem("Otros");
        /*this.idCoche = idCoche;*/
        setSize(650,430);
        setResizable(false);
        setTitle("Gastos");
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
               
        ImageIcon wallpaper = new ImageIcon("src/images/Wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
            jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
            jLabel_Wallpaper.setIcon(icono);
            this.repaint();
    }
    
    public void cargarUltimoGastoDelCoche() {
        if (idCoche <= 0) {
        JOptionPane.showMessageDialog(this, "ID de coche no válido.");
        return;
        }
        
        try {
            Connection cn = DatabaseConnection.getConnection(); 
                PreparedStatement pst = cn.prepareStatement(
                   "SELECT * FROM gastos WHERE id_coche = ? ORDER BY fecha_gasto DESC LIMIT 1");
                
                pst.setInt(1, idCoche);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                txt_km.setText(String.valueOf(rs.getString("kilometraje")));
                txt_date.setText(rs.getDate("fecha_gasto").toString()); // yyyy-MM-dd
                txt_cost.setText(String.valueOf(rs.getDouble("importe")));
                txt_descripcion.setText(rs.getString("descripcion"));

                String tipo = rs.getString("tipo");
                for (Map.Entry<String, String> entry : tipoMap.entrySet()) {
                if (entry.getValue().equalsIgnoreCase(tipo)) {
                jComboBox.setSelectedItem(entry.getKey());
                 break;
                 }
                    }
                idGastoActual = -1;
                modoEdicion = false;
            } else {
                
                modoEdicion = false;
        }
                
               
        } catch (SQLException e) {
        System.err.println("Error SQL al cargar coche: " + e);
        JOptionPane.showMessageDialog(null, "ERROR al cargar. contacte al administrador!");
        } catch (Exception e) {
        System.err.println("Error general al cargar coche: " + e);
        JOptionPane.showMessageDialog(null, "ERROR al cargar. contacte al administrador!");
        }
    }    
        private String capitalizeFirst(String value){
        if (value == null || value.isEmpty()) return value;
        return value.substring(0,1).toUpperCase() + value.substring(1).toLowerCase();   
    }

     @Override
        public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon_of.png"));
        return retValue;
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Title = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();
        txt_cost = new javax.swing.JTextField();
        txt_date = new javax.swing.JTextField();
        txt_km = new javax.swing.JTextField();
        jPanel_Description = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        jButton_Apply = new javax.swing.JButton();
        jButton_Cancel = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Title.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Title.setText("GASTOS");
        getContentPane().add(jLabel_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 120, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Tipo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Kilometraje:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Fecha:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Importe:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Descripcion:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasolina", "Revisión", "ITV", "Cambio de aceite", "Otros" }));
        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));
        getContentPane().add(txt_cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 140, -1));
        getContentPane().add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 140, -1));
        getContentPane().add(txt_km, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 140, -1));

        jPanel_Description.setBackground(new java.awt.Color(153, 153, 153));

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane1.setViewportView(txt_descripcion);

        javax.swing.GroupLayout jPanel_DescriptionLayout = new javax.swing.GroupLayout(jPanel_Description);
        jPanel_Description.setLayout(jPanel_DescriptionLayout);
        jPanel_DescriptionLayout.setHorizontalGroup(
            jPanel_DescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DescriptionLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel_DescriptionLayout.setVerticalGroup(
            jPanel_DescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel_Description, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 550, 80));

        jButton_Apply.setBackground(new java.awt.Color(153, 255, 153));
        jButton_Apply.setText("APLICAR");
        jButton_Apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ApplyActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Apply, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 120, 50));

        jButton_Cancel.setBackground(new java.awt.Color(255, 51, 102));
        jButton_Cancel.setText("CANCELAR");
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 120, 50));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        
    }//GEN-LAST:event_jComboBoxActionPerformed

    private void jButton_ApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ApplyActionPerformed

        String kilometrajeS = txt_km.getText().trim();
        String fechaS = txt_date.getText().trim(); // Formato esperado: yyyy-MM-dd
        String importeS = txt_cost.getText().trim();
        String tipoVisible = jComboBox.getSelectedItem().toString();
        String tipo = tipoMap.getOrDefault(tipoVisible, "otros"); // Coincide con ENUM
        String descripcion = txt_descripcion.getText().trim(); // JTextArea dentro del JPanel
        
        System.out.println("Seleccionado: " + tipoVisible);

        if (idCoche <= 0) {
        JOptionPane.showMessageDialog(null, "ID del coche no válido. No se puede guardar el gasto.");
        return;
        }
        
        
        if (kilometrajeS.isEmpty() || fechaS.isEmpty() || importeS.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Todos los campos numéricos y la fecha son obligatorios.");
        return;
        
    }
        int kilometraje;
        double importe;
        java.sql.Date fechaGasto;
        
        try {
        kilometraje = Integer.parseInt(kilometrajeS);
        importe = Double.parseDouble(importeS);
        fechaGasto = java.sql.Date.valueOf(fechaS); 
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error en los datos. Verifica formato numérico y fecha (yyyy-MM-dd).");
        return;
    }
        
        try {
        Connection cn = DatabaseConnection.getConnection();
        PreparedStatement pst;

        if (modoEdicion) {
            pst = cn.prepareStatement(
                "UPDATE gastos SET tipo=?, kilometraje=?, fecha_gasto=?, importe=?, descripcion=? WHERE id_gastos=?");
            pst.setString(1, tipo);
            pst.setInt(2, kilometraje);
            pst.setDate(3, fechaGasto);
            pst.setDouble(4, importe);
            pst.setString(5, descripcion);
            pst.setInt(6, idGastoActual);
        } else {
            pst = cn.prepareStatement(
                "INSERT INTO gastos (id_coche, tipo, kilometraje, fecha_gasto, importe, descripcion) VALUES (?, ?, ?, ?, ?, ?)");
            pst.setInt(1, idCoche);
            pst.setString(2, tipo);
            pst.setInt(3, kilometraje);
            pst.setDate(4, fechaGasto);
            pst.setDouble(5, importe);
            pst.setString(6, descripcion);
        }
System.out.println("Insertando gasto: tipo=" + tipo + ", coche=" + idCoche);

        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Gasto guardado correctamente.");
        this.dispose();

        SeeOwnCars verCoches = new SeeOwnCars();
        verCoches.setVisible(true);

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al guardar el gasto: " + e.getMessage());
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error inesperado: " + ex.getMessage());
    }
        
    }//GEN-LAST:event_jButton_ApplyActionPerformed

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
        try {
            dispose();
            SeeOwnCars VerCoches = new SeeOwnCars();
            VerCoches.setVisible(true);
        } catch (ClassNotFoundException ex) {
            System.getLogger(ExpenseView.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }//GEN-LAST:event_jButton_CancelActionPerformed

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
            java.util.logging.Logger.getLogger(ExpenseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExpenseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExpenseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExpenseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExpenseView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Apply;
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_Title;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JPanel jPanel_Description;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_cost;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_km;
    // End of variables declaration//GEN-END:variables
}

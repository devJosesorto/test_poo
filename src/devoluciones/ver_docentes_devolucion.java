
package devoluciones;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.table.DefaultTableModel;


public class ver_docentes_devolucion extends javax.swing.JFrame {

     Conexion con = new Conexion();
    Connection cnn = con.conexion();
    
    public ver_docentes_devolucion() {
        initComponents();
        mostrarRegistros("");
        setLocationRelativeTo(null);
        txtbuscar.setEnabled(false);
        btnBuscar.setEnabled(false);
        cbosexo.setEnabled(false);

    }

 

    public Integer totalregistros;

    void mostrarRegistros(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("CARNET");
        modelo.addColumn("NOMBRES");
        modelo.addColumn("APELLIDOS");
        modelo.addColumn("SEXO");
        
        
        TablaDocentes.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM docente";
        } else {
            sql = "SELECT * FROM docente WHERE (carnet='" + valor + "' OR nombres'" + valor + "')";
        }
        
        String[] datos = new String[5];
        totalregistros = 0;
        try {
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                
                totalregistros = totalregistros + 1;
                modelo.addRow(datos);
                lbltotalregistros.setText("REGISTROS: " + Integer.toString(totalregistros));
            }
            TablaDocentes.setModel(modelo);
            
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoDocente = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        rdGenero = new javax.swing.JRadioButton();
        rdcarnet = new javax.swing.JRadioButton();
        rdEspecialidad = new javax.swing.JRadioButton();
        cbosexo = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRefrescar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDocentes = new javax.swing.JTable();
        lbltotalregistros = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("REGISTRO DE DOCENTES");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 102, 102)));

        grupoDocente.add(rdGenero);
        rdGenero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdGenero.setForeground(new java.awt.Color(153, 0, 0));
        rdGenero.setText("GENERO");
        rdGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdGeneroActionPerformed(evt);
            }
        });

        grupoDocente.add(rdcarnet);
        rdcarnet.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdcarnet.setForeground(new java.awt.Color(153, 0, 0));
        rdcarnet.setText("CARNET");
        rdcarnet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdcarnetActionPerformed(evt);
            }
        });

        grupoDocente.add(rdEspecialidad);
        rdEspecialidad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdEspecialidad.setForeground(new java.awt.Color(153, 0, 0));
        rdEspecialidad.setText("ESPECIALIDAD");
        rdEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdEspecialidadActionPerformed(evt);
            }
        });

        cbosexo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbosexo.setForeground(new java.awt.Color(153, 0, 0));
        cbosexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar:", "M", "F" }));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(153, 0, 0));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/buscar-.png"))); // NOI18N
        btnBuscar.setToolTipText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("SELECCIONE LA OPCION PARA BUSCAR POR:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(rdEspecialidad)
                            .addGap(18, 18, 18)
                            .addComponent(rdcarnet)
                            .addGap(27, 27, 27)
                            .addComponent(rdGenero)
                            .addGap(18, 18, 18)
                            .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdcarnet)
                    .addComponent(rdEspecialidad)
                    .addComponent(rdGenero)
                    .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        btnRefrescar.setBackground(new java.awt.Color(255, 255, 255));
        btnRefrescar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRefrescar.setForeground(new java.awt.Color(153, 0, 0));
        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/refrescar.JPG"))); // NOI18N
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        TablaDocentes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204)));
        TablaDocentes.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        TablaDocentes.setForeground(new java.awt.Color(0, 153, 153));
        TablaDocentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaDocentes.setToolTipText("");
        TablaDocentes.setRowHeight(25);
        TablaDocentes.setSelectionBackground(new java.awt.Color(0, 0, 153));
        TablaDocentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaDocentesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDocentes);

        lbltotalregistros.setBackground(new java.awt.Color(255, 255, 255));
        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(153, 0, 0));
        lbltotalregistros.setText("N°");
        lbltotalregistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        btnsalir.setBackground(new java.awt.Color(255, 255, 255));
        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(153, 0, 0));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/cerrar.JPG"))); // NOI18N
        btnsalir.setToolTipText("SALIR");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 384, Short.MAX_VALUE)
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addComponent(btnsalir, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       
        
        String sexo = cbosexo.getSelectedItem().toString();
        String carnet = txtbuscar.getText();
        String especie = txtbuscar.getText();
        

        if (rdGenero.isSelected() == true) {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("CARNET");
            modelo.addColumn("NOMBRES");
            modelo.addColumn("APELLIDOS");
            modelo.addColumn("SEXO");
            ;
            TablaDocentes.setModel(modelo);
            String sql = "";
                      
                sql = "SELECT * FROM estudiante WHERE Sexo='" + sexo + "'";
            
            String[] datos = new String[5];
            totalregistros = 0;
            
            try {
                
                Statement st = cnn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    datos[3] = rs.getString(4);
                    datos[4] = rs.getString(5);
                    
                    totalregistros = totalregistros + 1;
                    modelo.addRow(datos);
                    lbltotalregistros.setText("REGISTROS: " + Integer.toString(totalregistros));
                }
                TablaDocentes.setModel(modelo);
                
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
            
            cbosexo.setSelectedIndex(0);
            cbosexo.setEnabled(false);

        }
        if (rdcarnet.isSelected() == true) {
            
            DefaultTableModel modelo = new DefaultTableModel();
            
            modelo.addColumn("ID");
            modelo.addColumn("CARNET");
            modelo.addColumn("NOMBRES");
            modelo.addColumn("APELLIDOS");
            modelo.addColumn("SEXO");
            
            
            TablaDocentes.setModel(modelo);
            String sql = "";

            sql = "SELECT * FROM docente WHERE carnet='" + carnet + "'";

            String[] datos = new String[5];
            totalregistros = 0;
            try {
                Statement st = cnn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    datos[3] = rs.getString(4);
                    datos[4] = rs.getString(5);
                  
                    
                    totalregistros = totalregistros + 1;
                    modelo.addRow(datos);
                    lbltotalregistros.setText("REGISTROS: " + Integer.toString(totalregistros));
                }
                TablaDocentes.setModel(modelo);
                
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
            
            txtbuscar.setText("");
            txtbuscar.setEnabled(false);

        }

        if (rdEspecialidad.isSelected() == true) {
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("CARNET");
            modelo.addColumn("NOMBRES");
            modelo.addColumn("APELLIDOS");
            modelo.addColumn("SEXO");
           
            
            TablaDocentes.setModel(modelo);
            String sql = "";

            sql = "SELECT * FROM docente WHERE especialidad ='" + especie + "'";

            String[] datos = new String[5];
            totalregistros = 0;
            
            try {
                
                Statement st = cnn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    datos[3] = rs.getString(4);
                    datos[4] = rs.getString(5);
                 
                    totalregistros = totalregistros + 1;
                    modelo.addRow(datos);
                    lbltotalregistros.setText("REGISTROS: " + Integer.toString(totalregistros));
                }
                TablaDocentes.setModel(modelo);
                
            } catch (SQLException ex) {
                 System.err.println(ex.getMessage());
            }
            
            txtbuscar.setText("");
            txtbuscar.setEnabled(false);
            
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        // TODO add your handling code here:
        mostrarRegistros("");
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void TablaDocentesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDocentesMousePressed
        
        
        if (evt.getClickCount() == 2) {
            
            int fila = TablaDocentes.getSelectedRow();
            
            String cod;
            String valor;
            String especie;
            
            cod = TablaDocentes.getValueAt(fila, 1).toString();
            valor = TablaDocentes.getValueAt(fila, 2).toString() + " " + TablaDocentes.getValueAt(fila, 3).toString();
            especie = TablaDocentes.getValueAt(fila, 4).toString();

   
            
            Menu_devolucion_D.txtCarnet.setText(cod);
            Menu_devolucion_D.txtDocente.setText(valor);

            this.dispose();

        }
    }//GEN-LAST:event_TablaDocentesMousePressed

    private void rdGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdGeneroActionPerformed
        // TODO add your handling code here:
        if (rdGenero.isSelected() == true) {
            cbosexo.setSelectedItem(0);
            btnBuscar.setEnabled(true);
            cbosexo.setEnabled(true);

        }
    }//GEN-LAST:event_rdGeneroActionPerformed

    private void rdcarnetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdcarnetActionPerformed
        // TODO add your handling code here:
        if (rdcarnet.isSelected() == true) {
            cbosexo.setSelectedIndex(0);
            btnBuscar.setEnabled(true);
            txtbuscar.setEnabled(true);
            txtbuscar.requestFocus();
        }
    }//GEN-LAST:event_rdcarnetActionPerformed

    private void rdEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdEspecialidadActionPerformed
        // TODO add your handling code here:
        if (rdEspecialidad.isSelected() == true) {
            cbosexo.setSelectedIndex(0);
            btnBuscar.setEnabled(true);
            txtbuscar.setEnabled(true);
            txtbuscar.requestFocus();
        }
    }//GEN-LAST:event_rdEspecialidadActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ver_docentes_devolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ver_docentes_devolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ver_docentes_devolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ver_docentes_devolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ver_docentes_devolucion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDocentes;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cbosexo;
    private javax.swing.ButtonGroup grupoDocente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JRadioButton rdEspecialidad;
    private javax.swing.JRadioButton rdGenero;
    private javax.swing.JRadioButton rdcarnet;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}

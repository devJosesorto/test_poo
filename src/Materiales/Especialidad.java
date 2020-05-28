
package Materiales;


import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Especialidad extends javax.swing.JFrame {

   Conexion con = new Conexion();
   Connection cnn = con.conexion();
    String id=""; 
   
    public Especialidad() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarEspecialidades("");
        
        
    }
        
        
    
     public Integer num_especialidades;

     
     private void limpiarCajas (){
         txtCodigo.setText("");
         txtEspecialidad.setText("");
         
         
         
     }
     
     
   private void mostrarEspecialidades(String dato1) {
        
        
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("ESPECIALIDAD");
        
        ta_Especialidad.setModel(modelo);
        String sql = "";
        
        if (dato1.equals("")) {
            
            sql = "SELECT * FROM especialidad";
            
        } else {
                        
            sql = "SELECT * FROM libros WHERE (id_especialidad='" + dato1 + "' OR especialidad='" + dato1 + "')";
            
        }
        
             String[] datos = new String[2];
             num_especialidades = 0;
             
            try {
                     Statement st = cnn.createStatement();
                     ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                
                num_especialidades = num_especialidades + 1;
                modelo.addRow(datos);
                lbltotalregistros.setText("ESPECIALIDADES: " + Integer.toString(num_especialidades));
                
            }// cierre while
            
            ta_Especialidad.setModel(modelo);
            
            
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
             
        }
            
            
    }//cierre metodo mostrarEspecialidades
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmEditar = new javax.swing.JMenuItem();
        jmBorrar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEspecialidad = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_Especialidad = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        jmEditar.setBackground(new java.awt.Color(204, 204, 204));
        jmEditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jmEditar.setForeground(new java.awt.Color(204, 0, 0));
        jmEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/Editarr.png"))); // NOI18N
        jmEditar.setText("EDITAR");
        jmEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmEditar);

        jmBorrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jmBorrar.setForeground(new java.awt.Color(204, 0, 0));
        jmBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/borrar.JPG"))); // NOI18N
        jmBorrar.setText("BORRAR");
        jmBorrar.setToolTipText("BORRAR");
        jmBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmBorrarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmBorrar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("REGISTRAR ESPECIALIDAD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(154, 154, 154)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("CÓDIGO");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("ESPECIALIDAD");

        txtEspecialidad.setColumns(20);
        txtEspecialidad.setLineWrap(true);
        txtEspecialidad.setRows(5);
        jScrollPane1.setViewportView(txtEspecialidad);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        ta_Especialidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 0)));
        ta_Especialidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ta_Especialidad.setForeground(new java.awt.Color(0, 153, 204));
        ta_Especialidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ta_Especialidad.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(ta_Especialidad);

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/buscar-.png"))); // NOI18N
        btnBuscar.setToolTipText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnMostrar.setBackground(new java.awt.Color(255, 255, 255));
        btnMostrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(153, 0, 0));
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/refrescar.JPG"))); // NOI18N
        btnMostrar.setToolTipText("REFRESCAR");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 153));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/LAPIZ.JPG"))); // NOI18N
        btnAgregar.setToolTipText("NUEVA");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lbltotalregistros.setBackground(new java.awt.Color(255, 255, 255));
        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(51, 51, 51));
        lbltotalregistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0)));

        btnsalir.setBackground(new java.awt.Color(255, 255, 255));
        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(255, 255, 255));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/cerrar.JPG"))); // NOI18N
        btnsalir.setToolTipText("SALIR");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(153, 0, 0));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/guardarR.png"))); // NOI18N
        btnEditar.setToolTipText("<html> GUARDAR EDICION </html>");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar))
                    .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
 
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
       
        txtCodigo.transferFocus();
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
       
        if (txtCodigo.getText().equals("")||txtEspecialidad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "FAVOR VALIDAR LOS CAMPOS VACIOS");
            
        } else {
            
              try {
                
                  PreparedStatement pst = cnn.prepareStatement("INSERT INTO especialidad(id_especialidad,especialidad) VALUES(?,?)");
            
                     pst.setString(1, txtCodigo.getText());
                     pst.setString(2, txtEspecialidad.getText());
            
                     int dato2 = pst.executeUpdate();
                     if (dato2 > 0) {
                         
                      JOptionPane.showMessageDialog(null, "ESPECIALIDAD DE MATERIA HA SIDO REGISTRADA");
                      limpiarCajas ();
                      mostrarEspecialidades("");
                      
                
            } else {
                         
                JOptionPane.showMessageDialog(null, "EL REGISTRO NO HA SIDO GUARDADO");
            }
                     
        } catch (Exception ex) {
            
            System.err.println(ex.getMessage());
            } 
            
            
        }//cierre else
        
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        mostrarEspecialidades("");
    }//GEN-LAST:event_btnMostrarActionPerformed
       
      
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        

        try {

            PreparedStatement pst = cnn.prepareStatement("UPDATE especialidad SET especialidad='" + txtEspecialidad.getText() 
                 + "',id_especialidad='" + txtCodigo.getText() + "' WHERE id_especialidad='" + id + "' ");
            
            
                 id = txtCodigo.getText();
                 pst.executeUpdate();
                 mostrarEspecialidades("");
           
            JOptionPane.showMessageDialog(null, "LA ACTUALIZACION DE LOS DATOS HAN SIDO ACTUALIZADA");

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "EL REGISTRO NO HA SIDO EDITADO");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
                mostrarEspecialidades(txtbuscar.getText());
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jmEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarActionPerformed
        // String id = "";
         
             int fila = ta_Especialidad.getSelectedRow();
             
        if (fila >= 0) {
                    txtCodigo.setText(ta_Especialidad.getValueAt(fila, 0).toString());
                    txtEspecialidad.setText(ta_Especialidad.getValueAt(fila, 1).toString());
            
            id = ta_Especialidad.getValueAt(fila, 0).toString();
           
        } else {
            
            JOptionPane.showMessageDialog(null, "REGISTRO NO ENCONTRADO");
        }
    }//GEN-LAST:event_jmEditarActionPerformed

    private void jmBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmBorrarActionPerformed
      
        int fila = ta_Especialidad.getSelectedRow();
        
        String codigo = "";
        
        codigo = ta_Especialidad.getValueAt(fila, 0).toString();
        
        int validar = JOptionPane.showConfirmDialog(rootPane, "¿ELIMINAR REGISTRO?", "CONFIRMAR", 2);
        try {
            if (validar == 0) {
                PreparedStatement pst = cnn.prepareStatement("DELETE FROM especialidad WHERE id_especialidad='" + codigo + "'");
                pst.executeUpdate();
                mostrarEspecialidades("");
               
                JOptionPane.showMessageDialog(null, "EL REGISTRO HA SIDO ELIMINIDADO");
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "EL REGISTRO NO HA SIDO ELIMINIDADO");
        }
    }//GEN-LAST:event_jmBorrarActionPerformed

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
            java.util.logging.Logger.getLogger(Especialidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Especialidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Especialidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Especialidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Especialidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem jmBorrar;
    private javax.swing.JMenuItem jmEditar;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable ta_Especialidad;
    public static javax.swing.JTextField txtCodigo;
    public static javax.swing.JTextArea txtEspecialidad;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}

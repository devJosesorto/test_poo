
package Reg_usuarios;


import conexion.Conexion;
import conexion.Hash;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Formulario_Usuarios extends javax.swing.JFrame {

    Conexion con = new Conexion();
    Connection cnn = con.conexion();
  
    
    
    public Formulario_Usuarios() {
        initComponents();
        setLocationRelativeTo(null);
        
        mostrardatos("");
        bloquear_paso1();
        ocultar();
        btnEditar.setEnabled(false);
        
        
        
        
    }

    
         
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        txtPsswd = new javax.swing.JPasswordField();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblconteo = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_usuario = new javax.swing.JTable();
        btnMostrar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        txtPsswd_eliminar = new javax.swing.JPasswordField();

        Editar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Editar.setForeground(new java.awt.Color(204, 0, 0));
        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/Editarr.png"))); // NOI18N
        Editar.setText("EDITAR");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Editar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 1, true));
        jPanel1.setToolTipText("DATOS");
        jPanel1.setName(""); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("USUARIO");

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CONTRASEÑA");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("TIPO DE USUARIO");

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccionar:", "ADMINISTRADOR", "DOCENTE ", "ESTUDIANTE" }));
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(204, 0, 0));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/guardarR.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setToolTipText("");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        btnRegistrar.setName(""); // NOI18N
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(204, 0, 0));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/Editarr.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("No DE USUARIO");

        lblconteo.setText("...");

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/LAPIZ.JPG"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPsswd, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(41, 41, 41)
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblconteo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(40, 40, 40)
                                .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblconteo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPsswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        btnRegistrar.getAccessibleContext().setAccessibleDescription("REGISTRAR");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DE USARIOS");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/usuarios.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabla_usuario.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        tabla_usuario.setForeground(new java.awt.Color(0, 153, 153));
        tabla_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_usuario.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabla_usuario);

        btnMostrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(204, 0, 0));
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/mostrar.JPG"))); // NOI18N
        btnMostrar.setText("<html>VER CONTRASEÑAS</html>");
        btnMostrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        btnMostrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/borrar.JPG"))); // NOI18N
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(204, 0, 51));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/cerrar.JPG"))); // NOI18N
        btnSalir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 2, true));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/aceptar.png"))); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        txtPsswd_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPsswd_eliminar.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPsswd_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(120, 120, 120)
                        .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPsswd_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");
        btnBorrar.getAccessibleContext().setAccessibleName("BORRAR REGISTRO");
        btnSalir.getAccessibleContext().setAccessibleName("SALIR");
        btnSalir.getAccessibleContext().setAccessibleDescription("SALIR");
        btnAceptar.getAccessibleContext().setAccessibleName("ACEPTAR");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       
        try {
            PreparedStatement pst = cnn.prepareStatement("UPDATE usuarios SET ID='" + txtId.getText() + "',usuario='" 
                    + txtUsuario.getText()
                    + "',contrasenia='" + txtPsswd.getText() 
                    + "',tipo_usuario='" 
                    + cbxTipo.getSelectedItem().toString() 
                    + "' WHERE id='" + id + "' ");
            
            
            id = txtId.getText();
            pst.executeUpdate();
            mostrardatos("");
            bloquear_paso2();
            btnEditar.setEnabled(false);

            JOptionPane.showMessageDialog(null, "REGISTRO EDITADO CON EXITO");

        } catch (Exception e) {
            java.lang.System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR! EL REGISTRO NO HA SIDO EDITADO");
        }
        
        
        
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed

    }//GEN-LAST:event_cbxTipoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        if (txtId.getText().equals("") || txtUsuario.getText().equals("") || txtPsswd.getText().equals("")|| cbxTipo.getSelectedItem().equals("seleccionar:")) {
            JOptionPane.showMessageDialog(null, "FAVOR VALIDAR LOS CAMPOS");

        } else {
            try {

                PreparedStatement pst = cnn.prepareStatement("INSERT INTO usuarios (id,usuario,contrasenia,tipo_usuario) VALUES(?,?,?,?)");
                pst.setString(1, txtId.getText());
                pst.setString(2, txtUsuario.getText());
                pst.setString(3, txtPsswd.getText());
                pst.setString(4, cbxTipo.getSelectedItem().toString());

                int valor = pst.executeUpdate();
                if (valor > 0) {
                    JOptionPane.showMessageDialog(null, "EL REGISTRO HA SIDO GUARDADO");
                    mostrardatos("");
                    bloquear_paso1();
                    ocultar();
                    limpiarconteo();

                } else {
                    JOptionPane.showMessageDialog(null, "Error al agregar", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
            }
        }
        
        
        
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        
        mostrardatos ("");
        
        
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        
         habilitar();
        
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
       
        
        int fila = tabla_usuario.getSelectedRow();
        
        if (fila >= 0) {
            txtId.setText(tabla_usuario.getValueAt(fila, 0).toString());
            txtUsuario.setText(tabla_usuario.getValueAt(fila, 1).toString());
            txtPsswd.setText(tabla_usuario.getValueAt(fila, 2).toString());
            cbxTipo.setSelectedItem(tabla_usuario.getValueAt(fila, 3).toString());
            id = tabla_usuario.getValueAt(fila, 0).toString();
            
            
            habilitar_paso2();
            btnBorrar.setEnabled(false);
            txtPsswd_eliminar.setEnabled(false);
            btnAceptar.setEnabled(false);

        } else {
            JOptionPane.showMessageDialog(null, "FAVOR SELECCIONAR UN REGISTRO");
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
     
        int fila = tabla_usuario.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN REGISTRO");

        } else {
            id = tabla_usuario.getValueAt(fila, 0).toString();
            JOptionPane.showMessageDialog(null, "PARA BORRAR ESTE REGISTRO, DEBE INGRESAR LA CONTRASEÑA DEL USUARIO");

            txtId.requestFocus();
        }
            
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
        
        
        
        String validar = "";
        String contrania = "";
        contrania = new String(txtPsswd.getText());

        try {
            if (validar.equals(contrania)) {
                PreparedStatement pst = cnn.prepareStatement("DELETE FROM usuarios WHERE id='" + id + "'");
                pst.executeUpdate();
                mostrardatos("");

                JOptionPane.showMessageDialog(null, "EL USUARIO HA SIDO ELIMINADO");
            }
            bloquear_paso1();

        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, "EL USUARIO *NO* HA SIDO ELIMINADO");
        }
    

    }//GEN-LAST:event_btnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(Formulario_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblconteo;
    public static javax.swing.JTable tabla_usuario;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JPasswordField txtPsswd;
    private javax.swing.JPasswordField txtPsswd_eliminar;
    public static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables


    private void habilitar() {
        txtId.setEnabled(true);
        txtUsuario.setEnabled(true);
        txtPsswd.setEnabled(true);
        cbxTipo.setEnabled(true);
        btnRegistrar.setEnabled(true);

    }
    
    
    private void habilitar_paso2() {
        btnEditar.setEnabled(true);
        txtId.setEnabled(true);
        txtUsuario.setEnabled(true);
        txtPsswd.setEnabled(true);
        cbxTipo.setEnabled(true);

    }

       private void bloquear_paso1 (){
            txtPsswd.setText("");
            txtUsuario.setText("");
            txtId.setText("");
            txtPsswd_eliminar.setText("");
            cbxTipo.setSelectedIndex(0); 
            
            txtUsuario.setEnabled(false);
            txtId.setEnabled(false);
            txtPsswd.setEnabled(false);
            txtPsswd_eliminar.setEnabled(false);
            cbxTipo.setEnabled(false);
            btnRegistrar.setEnabled(false);
            btnEditar.setEnabled(false);
            txtPsswd_eliminar.setEnabled(true);
                     
            
        }
       
    private void bloquear_paso2() {
        
        txtPsswd_eliminar.setText("");
        txtId.setText("");
        txtUsuario.setText("");
        txtPsswd.setText("");
        cbxTipo.setSelectedIndex(0);
        
        btnEditar.setEnabled(false);
        txtId.setEnabled(false);
        txtUsuario.setEnabled(false);
        txtPsswd.setEnabled(false);
        cbxTipo.setEnabled(false);

        
    }
    
     private void limpiarconteo (){           
              
            this.lblconteo.setText("");
        }
        
        

    private void ocultar() {
        tabla_usuario.getColumnModel().getColumn(2).setMaxWidth(2);
        tabla_usuario.getColumnModel().getColumn(2).setMinWidth(2);
        tabla_usuario.getColumnModel().getColumn(2).setPreferredWidth(2);

    }

    String id = "";

    public Integer No_registros;

    public void mostrardatos(String dato1) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Numero Usuario");
        modelo.addColumn("Usuario");
        modelo.addColumn("Contrasenia");
        modelo.addColumn("Tipo de Usuario");

        tabla_usuario.setModel(modelo);
        String sql = "";
        if (dato1.equals("")) {
            sql = "SELECT * FROM usuarios";
        } else {
            sql = "SELECT * FROM usuarios WHERE (id='" + dato1 + "' OR usuario='" + dato1 + "')";
        }
        String[] datos = new String[4];
        No_registros = 0;
        try {
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
               

                No_registros = No_registros + 1;
                modelo.addRow(datos);
                lblconteo.setText("#" + Integer.toString(No_registros));
            }
            tabla_usuario.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    
    
    
    
    
    
    
    
    
    

}//FIN DEL FORMULARIO


package Reg_usuarios;

import Menus.Menu1;
import Menus.Menu2;
import Menus.Menu3;
import static com.sun.javafx.application.PlatformImpl.exit;
import conexion.Conexion;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class loguin_Reset extends javax.swing.JFrame {

    Conexion con = new Conexion ();
    Connection cnn = con.conexion();
    
    
    public loguin_Reset() {
        initComponents();
        
        setLocationRelativeTo(null);
         txtPsswd1.requestFocus();
    }

    private void limpiar() {
        txtPsswd2.setText("");
        txtPsswd2.setText("");
    }
    
    
    void cambio_contrasenia () {
      
      String clave1 = txtPsswd1.getText();
      String clave2 = txtPsswd2.getText();

      if ( ("".equals(clave1)) || ("".equals(clave2) )){
          
          JOptionPane.showMessageDialog(null, "DEBE INGRESAR LOS DATOS");
          txtPsswd1.requestFocus();
      }else {
          
          if ( txtPsswd1.getText().equals(txtPsswd2.getText() )  ){
              
              int resp = JOptionPane.showConfirmDialog(rootPane, "¿DESEA CAMBIAR LA CONTRASEÑA?", "CONFIRMAR", 2);
              
              
              if (resp==0){
                  
                  String dato2 = txtPsswd1.getText();
                  String dato3 = txtUsuario.getText();
              
                  
                try {
                   
                   String sql = "UPDATE usuarios SET contrasenia=? WHERE usuario=?";
                   
                    PreparedStatement pst = cnn.prepareCall(sql);
                    
                    
                    pst.setString(1, dato2);
                    pst.setString(2, dato3);
                   
                    int a = pst.executeUpdate();
                    
                     JOptionPane.showMessageDialog(null, "CONTRASEÑA ACTUALIZADA");
                    
                     
                //try    
                } catch (Exception ex){
                     JOptionPane.showMessageDialog(null, "ERROR! LA CONTRASEÑA NO HA SIDO ACTUALIZADA");
                }
              
                 
                     dispose();
                    Loguin in = new Loguin();
                    in.setVisible(true);
                     
              
          } // if
          
         //if 
       } else{
              
            JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO SON IGUALES ");  
          }
          
      } // else 
      
      
        
    }
    
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPsswd2 = new javax.swing.JPasswordField();
        btnSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPsswd1 = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONTRASEÑA NUEVA");

        btnEntrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEntrar.setText("REGISTRAR");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CONFIRMAR CONTRASEÑA");

        txtPsswd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPsswd2ActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CAMBIO DE CONTRASEÑA");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/login.JPG"))); // NOI18N

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(0, 0, 153));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("USUARIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPsswd1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(txtPsswd2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnEntrar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalir))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPsswd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPsswd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(45, 45, 45)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnEntrar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPsswd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPsswd2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPsswd2ActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
    
          if (txtPsswd1.getText().equals("") || txtPsswd2.getText().equals("") || txtUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR LOS DATOS");
            limpiar ();

        } else {
            String usuario = txtUsuario.getText();
            String psswd = String.valueOf(txtPsswd2.getText());

           cambio_contrasenia();
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    
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
            java.util.logging.Logger.getLogger(loguin_Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loguin_Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loguin_Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loguin_Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new loguin_Reset().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPsswd1;
    private javax.swing.JPasswordField txtPsswd2;
    public static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables


    
     public void entrar (String usuario, String psswd ) {
        String sql = "SELECT * FROM usuarios WHERE usuario='" + usuario + "'&& contrasenia='" + psswd + "'";
        String validar = "";
        try {

            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                validar = rs.getString("tipo_usuario");
            }

            if (validar.equals("ADMINISTRADOR")) {
                Menu1 in = new Menu1 ();
                in.setVisible(true);
                dispose();
                Menu1.jmUsuario.setText("ADMINISTRADOR: " + usuario);
                JOptionPane.showMessageDialog(null, "BIENVENIDO ADMINISTRADOR");
            }

            if (validar.equals("DOCENTE")) {
                Menu2 in = new Menu2();
                in.setVisible(true);
                dispose();
                //Menu2.lblusuario.setText("INVITADO: " + usuario);
                JOptionPane.showMessageDialog(null, "QUE GUSTO VERTE DE NUEVO");

            }
            
             if (validar.equals("ESTUDIANTE")) {
                Menu3 in = new Menu3();
                in.setVisible(true);
                dispose();
                //Menu2.lblusuario.setText("INVITADO: " + usuario);
                JOptionPane.showMessageDialog(null, "QUE GUSTO VERTE DE NUEVO");

            }
            
            

            if ((!validar.equals("ADMINISTRADOR")) && (!validar.equals("ESTUDIANTE")) && (!validar.equals("DOCENTE"))) {
                
                JOptionPane.showMessageDialog(this, "Los Datos que Ingresaste no Existe");

            }

        } catch (SQLException ex) {

            Logger.getLogger(loguin_Reset.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    private void System(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}//cierre de loguin


package Prestamos_Usuarios;


import Prestamos_Usuarios.Menu_pretamos_D2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;


public class ver_libros_D2 extends javax.swing.JFrame {

    conexion.Conexion con = new conexion.Conexion();
    Connection cnn = con.conexion();
    
   
    public ver_libros_D2() {
        initComponents();
        mostrardatos("");
        setLocationRelativeTo(null);
        ocultar_columnas();
        txtbuscar.setEnabled(false);
        btnBuscar.setEnabled(false);

    }
    
   

    void ocultar_columnas() {
        TablaLibros.getColumnModel().getColumn(2).setMaxWidth(2);
        TablaLibros.getColumnModel().getColumn(2).setMinWidth(2);
        TablaLibros.getColumnModel().getColumn(2).setPreferredWidth(2);
    }

    public Integer totalregistros;

    void mostrardatos(String valor) {
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("COD_LIBRO");
        modelo.addColumn("TITULO");
        modelo.addColumn("ID_ESPECIALIDAD");
        modelo.addColumn("ESPECIALIDAD");
        modelo.addColumn("AUTOR");
        modelo.addColumn("EDITORIAL");
        modelo.addColumn("ISBN");
             TablaLibros.setModel(modelo);
                
                
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT\n"
                    + "     libros.`cod_libro` AS cod_libro,\n"
                    + "     libros.`titulo` AS titulo,\n"
                    + "     especialidad.`id_especialidad` AS id_especialidad,\n"
                    + "     especialidad.`especialidad` AS especialidad,\n"
                    + "     libros.`autor` AS autor,\n"
                    + "     libros.`editorial` AS editorial,\n"
                    + "     libros.`isbn` AS isbn\n"
                    + "     FROM\n"
                    + "     `especialidad` especialidad INNER JOIN `libros` libros ON especialidad.`id_especialidad` = libros.`id_especialidad`";
        } else {
            sql = "SELECT * FROM libros WHERE (cod_libro='" + valor + "' OR titulo='" + valor + "')";
        }
        String[] datos = new String[7];
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
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                
                totalregistros = totalregistros + 1;
                modelo.addRow(datos);
                lbltotalregistros.setText("REGISTROS:" + Integer.toString(totalregistros));
                
            }
            
            TablaLibros.setModel(modelo);
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoLibro = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rdcategoria = new javax.swing.JRadioButton();
        rdlibro = new javax.swing.JRadioButton();
        rdcodigo = new javax.swing.JRadioButton();
        txtbuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaLibros = new javax.swing.JTable();
        btnsalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("REGISTRO DE LIBROS");

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 153, 153)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("SELECCIONE LA OPCION PARA BUSCAR POR:");

        GrupoLibro.add(rdcategoria);
        rdcategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdcategoria.setForeground(new java.awt.Color(0, 0, 102));
        rdcategoria.setText("ESPECIALIDAD");
        rdcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdcategoriaActionPerformed(evt);
            }
        });

        GrupoLibro.add(rdlibro);
        rdlibro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdlibro.setForeground(new java.awt.Color(0, 0, 102));
        rdlibro.setText("TITULO");
        rdlibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdlibroActionPerformed(evt);
            }
        });

        GrupoLibro.add(rdcodigo);
        rdcodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdcodigo.setForeground(new java.awt.Color(0, 0, 102));
        rdcodigo.setText("CODIGO");
        rdcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdcodigoActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdcategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdlibro, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdlibro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdcodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        btnMostrar.setBackground(new java.awt.Color(255, 255, 255));
        btnMostrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(204, 0, 0));
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/refrescar.JPG"))); // NOI18N
        btnMostrar.setToolTipText("REFRESCAR");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        lbltotalregistros.setBackground(new java.awt.Color(255, 255, 255));
        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(0, 102, 102));
        lbltotalregistros.setText("N°");
        lbltotalregistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        TablaLibros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        TablaLibros.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        TablaLibros.setForeground(new java.awt.Color(0, 102, 102));
        TablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaLibros.setRowHeight(25);
        TablaLibros.setSelectionBackground(new java.awt.Color(0, 0, 204));
        TablaLibros.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TablaLibrosAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        TablaLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaLibrosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaLibros);

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/eti1.JPG"))); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(321, 321, 321)
                            .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel4)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsalir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbltotalregistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaLibrosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TablaLibrosAncestorAdded
       
    }//GEN-LAST:event_TablaLibrosAncestorAdded

    private void TablaLibrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaLibrosMousePressed
      
        
        if (evt.getClickCount() == 2) {
            int fila = TablaLibros.getSelectedRow();
            String cod;
            String valor;
            String isbn;

            cod = TablaLibros.getValueAt(fila, 0).toString();
            valor = TablaLibros.getValueAt(fila, 1).toString();
            isbn = TablaLibros.getValueAt(fila, 4).toString();

            Menu_pretamos_D2.txtCod_material.setText(cod);
            Menu_pretamos_D2.txtTitulo.setText(valor);
            Menu_pretamos_D2.txtisbn.setText(isbn);


            this.dispose();

        }
    }//GEN-LAST:event_TablaLibrosMousePressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       
        String cod = txtbuscar.getText();
        String libro = txtbuscar.getText();
        String especia = txtbuscar.getText();

        if (rdcodigo.isSelected() == true) {

            DefaultTableModel modelo = new DefaultTableModel();
       
        modelo.addColumn("COD_LIBRO");
        modelo.addColumn("TITULO");
        modelo.addColumn("ID_ESPECIALIDAD");
        modelo.addColumn("ESPECIALIDAD");
        modelo.addColumn("AUTOR");
        modelo.addColumn("EDITORIAL");
        modelo.addColumn("ISBN");
        TablaLibros.setModel(modelo);
             
        String sql = "";
        
            sql = "SELECT\n"
                    + "     libros.`cod_libro` AS cod_libro,\n"
                    + "     libros.`titulo` AS titulo,\n"
                    + "     especialidad.`id_especialidad` AS id_especialidad,\n"
                    + "     especialidad.`especialidad` AS especialidad,\n"
                    + "     libros.`autor` AS autor,\n"
                    + "     libros.`editorial` AS editorial,\n"
                    + "     libros.`isbn` AS isbn\n"
                    + "     FROM\n"
                    + "     `especialidad` especialidad INNER JOIN `libros` libros ON especialidad.`id_especialidad` = libros.`id_especialidad`"
                    + "     WHERE cod_libro='" + cod + "'";
        
        String[] datos = new String[7];
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
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                
                totalregistros = totalregistros + 1;
                modelo.addRow(datos);
                lbltotalregistros.setText("REGISTROS: " + Integer.toString(totalregistros));
            }
            TablaLibros.setModel(modelo);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
           txtbuscar.setText("");
            txtbuscar.setEnabled(false); 

        }
        if (rdlibro.isSelected() == true) {
            
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("COD_LIBRO");
        modelo.addColumn("TITULO");
        modelo.addColumn("ID_ESPECIALIDAD");
        modelo.addColumn("ESPECIALIDAD");
        modelo.addColumn("AUTOR");
        modelo.addColumn("EDITORIAL");
        modelo.addColumn("ISBN");
        TablaLibros.setModel(modelo);
        String sql = "";
        
            sql = "SELECT\n"
                    + "     libros.`cod_Libro` AS cod_libro,\n"
                    + "     libros.`titulo` AS titulo,\n"
                    + "     especialidad.`id_especialidad` AS id_especialidad,\n"
                    + "     especialidad.`especialidad` AS especialidad,\n"
                    + "     libros.`autor` AS autor,\n"
                    + "     libros.`editorial` AS editorial,\n"
                    + "     libros.`isbn` AS isbn\n"
                    + "     FROM\n"
                    + "     `especialidad` especialidad INNER JOIN `libros` libros ON especialidad.`id_especialidad` = libros.`id_especialidad`"
                    + "     WHERE titulo='" + cod + "'";
        
        String[] datos = new String[7];
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
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                totalregistros = totalregistros + 1;
                modelo.addRow(datos);
                lbltotalregistros.setText("REGISTROS: " + Integer.toString(totalregistros));
            }
            
            TablaLibros.setModel(modelo);
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
             
        
        }
            
                 txtbuscar.setText("");
                 txtbuscar.setEnabled(false);

        }

        if (rdcategoria.isSelected() == true) {
           DefaultTableModel modelo = new DefaultTableModel();
            
             modelo.addColumn("COD_LIBRO");
             modelo.addColumn("TITULO");
             modelo.addColumn("ID_ESPECIALIDAD");
             modelo.addColumn("ESPECIALIDAD");
             modelo.addColumn("AUTOR");
             modelo.addColumn("EDITORIAL");
             modelo.addColumn("ISBN");
             TablaLibros.setModel(modelo);
             
             
            String sql = "";
        
            sql = "SELECT\n"
                    + "     libros.`Cod_Libro` AS Cod_Libro,\n"
                    + "     libros.`Nombre_Libro` AS Nombre_Libro,\n"
                    + "     categoria.`id_categoria` AS id_categoria,\n"
                    + "     categoria.`categoria` AS categoria,\n"
                    + "     libros.`Autor` AS Autor,\n"
                    + "     libros.`Editorial` AS Editorial,\n"
                    + "     libros.`Año` AS Año\n"
                    + "FROM\n"
                    + "     `categoria` categoria INNER JOIN `libros` libros ON categoria.`id_categoria` = libros.`id_categoria`"
                    + "WHERE categoria='" + especia + "'";
       
        String[] datos = new String[7];
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
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                
                totalregistros = totalregistros + 1;
                modelo.addRow(datos);
                lbltotalregistros.setText("REGISTROS: " + Integer.toString(totalregistros));
            }
            TablaLibros.setModel(modelo);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
            txtbuscar.setText("");
            txtbuscar.setEnabled(false);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        mostrardatos("");
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void rdcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdcodigoActionPerformed
        // TODO add your handling code here:
        if (rdcodigo.isSelected() == true) {
            txtbuscar.setEnabled(true);
            btnBuscar.setEnabled(true);
            txtbuscar.requestFocus();

        }
    }//GEN-LAST:event_rdcodigoActionPerformed

    private void rdlibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdlibroActionPerformed
        // TODO add your handling code here:
        if (rdlibro.isSelected() == true) {
            btnBuscar.setEnabled(true);
            txtbuscar.setEnabled(true);
            txtbuscar.requestFocus();
        }
    }//GEN-LAST:event_rdlibroActionPerformed

    private void rdcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdcategoriaActionPerformed
        // TODO add your handling code here:
        if (rdcategoria.isSelected() == true) {
            btnBuscar.setEnabled(true);
            txtbuscar.setEnabled(true);
            txtbuscar.requestFocus();
        }
    }//GEN-LAST:event_rdcategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(ver_libros_D2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ver_libros_D2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ver_libros_D2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ver_libros_D2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ver_libros_D2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoLibro;
    private javax.swing.JTable TablaLibros;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JRadioButton rdcategoria;
    private javax.swing.JRadioButton rdcodigo;
    private javax.swing.JRadioButton rdlibro;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables

}

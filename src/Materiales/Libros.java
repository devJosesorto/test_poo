
package Materiales;


import Menus.menu_especialidad;
import conexion.Conexion;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Libros extends javax.swing.JFrame {

   Conexion con = new Conexion();
   Connection cnn = con.conexion();
   
    String id = "";
   
    public Libros() {
        initComponents();
        mostrarRegistros("");
        lbltotalregistros.hide();
       
        desactivar();
        setLocationRelativeTo(null);
        
        Validar_txt validar = new Validar_txt();
        
        validar.Validartxt_texto(txtTitulo);
        validar.Validartxt_texto(txtAutor);
        validar.Validartxt_numerico(txtisbn);
        
        
        txtTitulo.setDocument(new Validar_txt(txtTitulo,75));
        txtAutor.setDocument(new Validar_txt(txtAutor,75));
        txtEditorial.setDocument(new Validar_txt(txtEditorial,75));
        txtisbn.setDocument(new Validar_txt(txtisbn,20));
        
        
    }

  
    private void desactivar(){
        
        txtId_Lib.setText("");
        txtTitulo.setText("");
        txtEditorial.setText("");
        txtisbn.setText("");
        txtAutor.setText("");
        txtEspecia.setText("");
        txtid_especie.setText("");
        txtId_Lib.setEnabled(false);
        txtTitulo.setEnabled(false);
        txtAutor.setEnabled(false);
        txtEditorial.setEnabled(false);
        txtisbn.setEnabled(false);
        btnRegistrar.setEnabled(false);
        btnEditar.setEnabled(false);
        txtid_especie.setEnabled(false);
        txtEspecia.setEnabled(false);
        btnSelec_Especia.setEnabled(false);

        
    }
    
    
    private void activar(){
        
        txtId_Lib.setEnabled(true);
        txtTitulo.setEnabled(true);
        txtAutor.setEnabled(true);
        txtEditorial.setEnabled(true);
        txtisbn.setEnabled(true);
        btnRegistrar.setEnabled(true);
        txtid_especie.setEnabled(false);
        txtEspecia.setEnabled(false);
        btnSelec_Especia.setEnabled(true);

        txtId_Lib.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
        txtEditorial.setText("");
        txtisbn.setText("");
        txtid_especie.setText("");
        txtEspecia.setText("");
        idLibro();
        
    }
    
     void desactivar_editarA() {
        txtId_Lib.setEnabled(true);
        txtTitulo.setEnabled(true);
        txtAutor.setEnabled(true);
        txtEditorial.setEnabled(true);
        txtisbn.setEnabled(true);
        btnSelec_Especia.setEnabled(true);
        btnEditar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnBuscar.setEnabled(false);
        txtBuscar.setEnabled(false);
        btnRegistrar.setEnabled(false);        
    }
    
    void desactivar_editarB() {
        
        txtId_Lib.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
        txtEditorial.setText("");
        txtisbn.setText("");
        txtid_especie.setText("");
        txtEspecia.setText("");
        btnNuevo.setEnabled(true);
        btnBuscar.setEnabled(true);
        txtBuscar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnSelec_Especia.setEnabled(false);
        txtId_Lib.setEnabled(false);
        txtTitulo.setEnabled(false);
        txtAutor.setEnabled(false);
        txtEditorial.setEnabled(false);
        txtisbn.setEnabled(false);

        
    }
    
          public void idLibro(){
        if((Integer.parseInt (lbltotalregistros.getText()))>9){
        txtId_Lib.setText("LIB0"+lbltotalregistros.getText());}
        else if((Integer.parseInt (lbltotalregistros.getText()))==0){
        txtId_Lib.setText("LIB001");
        }else {
         txtId_Lib.setText("LIB00"+lbltotalregistros.getText());
        }
  }
    
    
    
    
    
     public Integer num_registros;
    
  private void mostrarRegistros(String dato) {
      
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID_LIBRO");
        modelo.addColumn("TITULO");
        modelo.addColumn("ID_ESPECIALIDAD");
        modelo.addColumn("ESPECIALIDAD");
        modelo.addColumn("AUTOR");
        modelo.addColumn("EDITORIAL");
        modelo.addColumn("ISBN");
        jtbLibros.setModel(modelo);
       
          String sql = "";
            
             if (dato.equals("")) {
                sql = "SELECT\n"
                + " libros.`cod_libro` AS cod_libro,\n"
                + " libros.`titulo` AS titulo,\n"
                + " especialidad.`id_especialidad` AS id_especialidad,\n"
                + " especialidad.`especialidad` AS especialidad,\n"
                + " libros.`autor` AS autor,\n"
                + " libros.`editorial` AS editorial,\n"
                + " libros.`isbn` AS isbn\n"
                + " FROM\n"
                + " `especialidad` especialidad INNER JOIN `libros` libros ON especialidad.`id_especialidad` = libros.`id_especialidad`";
                 
                 } else {
                           sql = "SELECT * FROM libros WHERE (Cod_Libro='" + dato + "' OR titulo='" + dato + "')";
                        }
                 
                           String[] datos = new String[7];
                           num_registros = 0;
                             
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
                            num_registros = num_registros + 1;
                                 
                            modelo.addRow(datos);
                            lbltotalregistros.setText(Integer.toString(num_registros+1));
                            //lbltotalregistros.setText(Integer.toString(num_registros));
                                
                        }
                                 
                           jtbLibros.setModel(modelo);
                                         
                       } catch (SQLException ex) {
                                    
                          System.err.println(ex.getMessage());
                                        
               }
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmEditar = new javax.swing.JMenuItem();
        jmBorrar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbLibros = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnRefrescar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JTextField();
        txtisbn = new javax.swing.JTextField();
        txtEditorial = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtId_Lib = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtid_especie = new javax.swing.JTextField();
        txtEspecia = new javax.swing.JTextField();
        btnSelec_Especia = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        jmEditar.setBackground(new java.awt.Color(255, 255, 255));
        jmEditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jmEditar.setForeground(new java.awt.Color(153, 51, 0));
        jmEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/Editarr.png"))); // NOI18N
        jmEditar.setText("EDITAR");
        jmEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmEditar);

        jmBorrar.setBackground(new java.awt.Color(255, 255, 255));
        jmBorrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jmBorrar.setForeground(new java.awt.Color(153, 51, 0));
        jmBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/borrar.JPG"))); // NOI18N
        jmBorrar.setText("BORRAR");
        jmBorrar.setToolTipText("BORRAR");
        jmBorrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
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
        jLabel4.setText("REGISTRAR LIBROS");

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));

        jtbLibros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jtbLibros.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jtbLibros.setForeground(new java.awt.Color(0, 153, 153));
        jtbLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jtbLibros.setComponentPopupMenu(jPopupMenu1);
        jtbLibros.setGridColor(new java.awt.Color(0, 153, 153));
        jtbLibros.setRowHeight(26);
        jtbLibros.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jtbLibrosAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(jtbLibros);
        if (jtbLibros.getColumnModel().getColumnCount() > 0) {
            jtbLibros.getColumnModel().getColumn(3).setResizable(false);
        }

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(153, 0, 0));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/eti1.JPG"))); // NOI18N
        btnBuscar.setToolTipText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(204, 0, 0));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnRefrescar.setBackground(new java.awt.Color(255, 255, 255));
        btnRefrescar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRefrescar.setForeground(new java.awt.Color(204, 0, 0));
        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/refrescar.JPG"))); // NOI18N
        btnRefrescar.setToolTipText("REFRESCAR");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefrescar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        txtisbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtisbnActionPerformed(evt);
            }
        });

        txtEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditorialActionPerformed(evt);
            }
        });

        txtAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutorActionPerformed(evt);
            }
        });

        txtId_Lib.setEditable(false);
        txtId_Lib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtId_LibActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("TITULO");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("EDITORIAL");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("<HTML> CODIGO DE LIBRO </HTML>");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("ISBN");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("AUTOR");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 0));
        jLabel8.setText("ESPECIALIDAD");

        txtid_especie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid_especieActionPerformed(evt);
            }
        });

        txtEspecia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEspeciaActionPerformed(evt);
            }
        });

        btnSelec_Especia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSelec_Especia.setForeground(new java.awt.Color(153, 0, 0));
        btnSelec_Especia.setText("ELEJIR");
        btnSelec_Especia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelec_EspeciaActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(153, 0, 0));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/guardarR.png"))); // NOI18N
        btnRegistrar.setToolTipText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(153, 0, 0));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/Editarr.png"))); // NOI18N
        btnEditar.setToolTipText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        lbltotalregistros.setBackground(new java.awt.Color(255, 255, 255));
        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(204, 51, 0));
        lbltotalregistros.setToolTipText("N° REGISTROS");
        lbltotalregistros.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbltotalregistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(153, 51, 0));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/aceptar.png"))); // NOI18N
        btnNuevo.setToolTipText("AGREGAR LIBRO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnsalir.setBackground(new java.awt.Color(255, 255, 255));
        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(153, 51, 0));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/cerrar.JPG"))); // NOI18N
        btnsalir.setToolTipText("SALIR");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtId_Lib, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAutor)
                    .addComponent(txtEditorial)
                    .addComponent(txtEspecia, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSelec_Especia, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtid_especie, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEditar))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtId_Lib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnSelec_Especia)
                                            .addComponent(txtid_especie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))))
                                .addGap(15, 15, 15)
                                .addComponent(txtEspecia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnNuevo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(btnsalir))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbLibrosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jtbLibrosAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbLibrosAncestorAdded

    private void btnSelec_EspeciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelec_EspeciaActionPerformed
        
        menu_especialidad selec = new menu_especialidad();
        selec.setVisible(true);
    }//GEN-LAST:event_btnSelec_EspeciaActionPerformed

    private void txtEspeciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEspeciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEspeciaActionPerformed

    private void txtid_especieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid_especieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid_especieActionPerformed

    private void txtId_LibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId_LibActionPerformed
       
        txtId_Lib.transferFocus();
    }//GEN-LAST:event_txtId_LibActionPerformed

    private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
        
        txtAutor.transferFocus();
    }//GEN-LAST:event_txtAutorActionPerformed

    private void txtEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditorialActionPerformed
    
        txtEditorial.transferFocus();
    }//GEN-LAST:event_txtEditorialActionPerformed

    private void txtisbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtisbnActionPerformed
      
        txtisbn.transferFocus();
    }//GEN-LAST:event_txtisbnActionPerformed

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
   
        txtTitulo.transferFocus();
    }//GEN-LAST:event_txtTituloActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        
       activar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       

        try {

            PreparedStatement ps = cnn.prepareStatement("UPDATE libros SET titulo='" 
                + txtTitulo.getText() + "',cod_libro='" 
                + txtId_Lib.getText() + "',id_especialidad='" 
                + txtid_especie.getText()+ "',autor='" 
                + txtAutor.getText() + "',editorial='" 
                + txtEditorial.getText() + "',isbn='" 
                + txtisbn.getText() + "' WHERE cod_libro='" + id + "' ");
            
            
            
            id = txtid_especie.getText();
            ps.executeUpdate();
            desactivar_editarB();
            
            JOptionPane.showMessageDialog(null, "EL LIBRO HA SIDO EDITADO");

        } catch (Exception ex) {
            
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null," ERROR! EL LIBRO HA SIDO EDITADO" );
        }
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       
        mostrarRegistros(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
      

        if (txtId_Lib.getText().equals("") || txtTitulo.getText().equals("") || txtid_especie.getText().equals("")
            || txtAutor.getText().equals("") || txtEditorial.getText().equals("") || txtisbn.getText().equals("")) {
            
            JOptionPane.showMessageDialog(null, "FAVOR VALIDAR LOS CAMPOS VACIOS");

        } else {
            
            try {
                PreparedStatement ps = cnn.prepareStatement("INSERT INTO libros(cod_libro,titulo,id_especialidad,autor,editorial,isbn) VALUES(?,?,?,?,?,?)");
                ps.setString(1, txtId_Lib.getText());
                ps.setString(2, txtTitulo.getText());
                ps.setString(3, txtid_especie.getText());
                ps.setString(4, txtAutor.getText());
                ps.setString(5, txtEditorial.getText());
                ps.setString(6, txtisbn.getText());
                int valor = ps.executeUpdate();
                
                    if (valor > 0) {
                        
                    JOptionPane.showMessageDialog(null, "LIBRO AGREGADO CON EXITO");
                    mostrarRegistros("");
                    desactivar();
                    
                     } else {
                    JOptionPane.showMessageDialog(null, "EL LIBRO NO HA SIDO AGREGADO");
                }
            } catch (Exception ex) {
                 System.err.println(ex.getMessage());
            } 
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
      
        mostrarRegistros("");
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void jmEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarActionPerformed
       
            int fila = jtbLibros.getSelectedRow();
            if (fila >= 0) {
            
            txtId_Lib.setText(jtbLibros.getValueAt(fila, 0).toString());
            txtTitulo.setText(jtbLibros.getValueAt(fila, 1).toString());
            txtid_especie.setText(jtbLibros.getValueAt(fila, 2).toString());
            txtEspecia.setText(jtbLibros.getValueAt(fila, 3).toString());
            txtAutor.setText(jtbLibros.getValueAt(fila, 4).toString());
            txtEditorial.setText(jtbLibros.getValueAt(fila, 5).toString());
            txtisbn.setText(jtbLibros.getValueAt(fila, 6).toString());
            id = jtbLibros.getValueAt(fila, 0).toString();
            desactivar_editarA();
            
             } else {
            JOptionPane.showMessageDialog(null, "REGISTRO NO HA SIDO ENCONTRADO");
            
            }
    }//GEN-LAST:event_jmEditarActionPerformed

    private void jmBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmBorrarActionPerformed
        
            int fila = jtbLibros.getSelectedRow();
        
                 String codigo = "";
                 codigo = jtbLibros.getValueAt(fila, 0).toString();
             
                 int validar = JOptionPane.showConfirmDialog(rootPane, "BORRAR REGISTRO", "CONFIRMAR", 2);
            
                 try {
                         if (validar == 0) {
                         PreparedStatement pst = cnn.prepareStatement("DELETE FROM libros WHERE cod_libro='" + codigo + "'");
                             pst.executeUpdate();
                             mostrarRegistros("");
                      
                         JOptionPane.showMessageDialog(null, "EL LIBRO HA SIDO ELIMINADO");
                        }

                } catch (Exception ex) {
                     JOptionPane.showMessageDialog(null, "EL REGISTRO NO PUDO SER ELIMINADO");
                    System.err.println(ex.getMessage());
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
            java.util.logging.Logger.getLogger(Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Libros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSelec_Especia;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmBorrar;
    private javax.swing.JMenuItem jmEditar;
    private javax.swing.JTable jtbLibros;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtEditorial;
    public static javax.swing.JTextField txtEspecia;
    private javax.swing.JTextField txtId_Lib;
    private javax.swing.JTextField txtTitulo;
    public static javax.swing.JTextField txtid_especie;
    private javax.swing.JTextField txtisbn;
    // End of variables declaration//GEN-END:variables
}

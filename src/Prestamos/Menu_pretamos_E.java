
package Prestamos;


import conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Bolaines
 */
public final class Menu_pretamos_E extends javax.swing.JFrame {

   Conexion con = new Conexion();
    Connection cnn = con.conexion();
    String id = "";
    
    
    public Menu_pretamos_E() {
        
        initComponents();
        setLocationRelativeTo(null);
        mostrarRegistros("");
        inhabilitar();
    }
    private String accion = "guardar";

    
    
    
    //VALIDAR 
    void ocultar_columnas() {
        Tabla_Prestamo.getColumnModel().getColumn(0).setMaxWidth(0);
        Tabla_Prestamo.getColumnModel().getColumn(0).setMinWidth(0);
        Tabla_Prestamo.getColumnModel().getColumn(0).setPreferredWidth(0);

        Tabla_Prestamo.getColumnModel().getColumn(1).setMaxWidth(0);
        Tabla_Prestamo.getColumnModel().getColumn(1).setMinWidth(0);
        Tabla_Prestamo.getColumnModel().getColumn(1).setPreferredWidth(0);

        Tabla_Prestamo.getColumnModel().getColumn(4).setMaxWidth(0);
        Tabla_Prestamo.getColumnModel().getColumn(4).setMinWidth(0);
        Tabla_Prestamo.getColumnModel().getColumn(4).setPreferredWidth(0);
    }

    void inhabilitar() {
        txtRecibo.setEnabled(false);
        txtCod_material.setEnabled(false);
        txtCarnet.setEnabled(false);

        txtTitulo.setEnabled(false);
        txtisbn.setEnabled(false);
        txtgrado.setEnabled(false);
        txtEstudiante.setEnabled(false);
        txtCantidad.setEnabled(false);
        date_prestamo.setEnabled(false);
        date_devolucion.setEnabled(false);

        btnAgregar.setEnabled(false);
        btnbuscar_alumno.setEnabled(false);
        btnbuscar.setEnabled(false);
        btnEditar.setEnabled(false);

        txtRecibo.setText("");
        txtCarnet.setText("");
        txtTitulo.setText("");
        txtEstudiante.setText("");
        txtCantidad.setText("");
        txtCod_material.setText("");
        txtisbn.setText("");
        txtgrado.setText("");

    }

    void habilitar() {
        txtRecibo.setEnabled(false);
        txtCod_material.setEnabled(false);
        txtCarnet.setEnabled(false);

        txtisbn.setEnabled(false);
        txtgrado.setEnabled(false);
        txtTitulo.setEnabled(false);
        txtEstudiante.setEnabled(false);
        txtCantidad.setEnabled(true);

        date_prestamo.setEnabled(true);
        date_devolucion.setEnabled(true);

        btnAgregar.setEnabled(true);
        btnbuscar_alumno.setEnabled(true);
        btnbuscar.setEnabled(true);

        txtRecibo.setText("");
        txtCarnet.setText("");
        txtTitulo.setText("");
        txtEstudiante.setText("");
        txtCantidad.setText("");
        txtCod_material.setText("");
        txtisbn.setText("");
        txtgrado.setText("");

    }

    void desaHabiEditar() {

        btnEditar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnRefrescar.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnbuscar.setEnabled(true);
        btnbuscar_alumno.setEnabled(true);
        date_prestamo.setEnabled(true);
        date_devolucion.setEnabled(true);
        txtCantidad.setEnabled(true);
    }

    void desaHabiEditar2() {
        btnNuevo.setEnabled(true);
        btnRefrescar.setEnabled(true);
        btnEditar.setEnabled(false);

        date_prestamo.setEnabled(false);
        date_devolucion.setEnabled(false);
        txtCantidad.setEnabled(false);
        btnbuscar.setEnabled(false);
        btnbuscar_alumno.setEnabled(false);

        txtCod_material.setText("");
        txtTitulo.setText("");
        txtisbn.setText("");
        txtgrado.setText("");
        txtEstudiante.setText("");
        txtCantidad.setText("");
        txtCarnet.setText("");
    }

    public Integer totalprestamos;

    
    void mostrarRegistros(String valor) {
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("N° DE RECIBO");
        modelo.addColumn("CODIGO DE LIBRO");
        modelo.addColumn("TITULO");
        modelo.addColumn("ISBN");
        modelo.addColumn("CARNET");
        modelo.addColumn("ESTUDIANTE");
        modelo.addColumn("GRADO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("FECHA DE PRESTAMO");
        modelo.addColumn("FRCHA DE DEVOLUCION");
        
        Tabla_Prestamo.setModel(modelo);
        ocultar_columnas();

        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT\n"
                    + "     prestamo_estudiante.`recibo_E` AS prestamo_estudiante_recibo_E,\n"
                    + "     prestamo_estudiante.`cod_material` AS prestamo_estudiante_cod_material,\n"
                    + "     libros.`titulo` AS libros_titulo_libro,\n"
                    + "     libros.`isbn` AS libros_isbn,\n"
                    + "     prestamo_estudiante.`carnet` AS prestamo_estudiante_carnet_estudiante,\n"
                    + "     concat(estudiante.`nombres`,' ',\n"
                    + "     estudiante.`apellidos`)AS estudiante,\n"
                    + "     concat(estudiante.`grado`,' ',\n"
                    + "     estudiante.`seccion`) AS grado,\n"
                    + "     prestamo_estudiante.`Cantidad` AS prestamo_estudiante_Cantidad,\n"
                    + "     prestamo_estudiante.`Fecha_Prestamo` AS prestamo_estudiante_Fecha_Prestamo,\n"
                    + "     prestamo_estudiante.`Fecha_Devolucion` AS prestamo_estudiante_Fecha_Devolucion\n"
                    + "     FROM\n"
                    + "     `estudiante` estudiante INNER JOIN `prestamo_estudiante` prestamo_estudiante ON estudiante.`carnet` = prestamo_estudiante.`carnet`\n"
                    + "     INNER JOIN `libros` libros ON prestamo_estudiante.`cod_material` = libros.`cod_libro` order by recibo_E desc ";
        } else {
            sql = "SELECT * FROM PRESTAMO_ESTUDIANTE WHERE (cod_material='" + valor + "' OR carnet='" + valor + "')";
        }
        
        String[] datos = new String[10];
        totalprestamos = 0;
        
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
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);

                totalprestamos = totalprestamos + 1;

                modelo.addRow(datos);
                lblregistros.setText("PRESTAMOS REALIZADOS: " + Integer.toString(totalprestamos));
            }
            Tabla_Prestamo.setModel(modelo);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmEditar = new javax.swing.JMenuItem();
        jmBORRAR = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblregistros = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Prestamo = new javax.swing.JTable();
        btnsalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtRecibo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCod_material = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtisbn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCarnet = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtgrado = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        txtEstudiante = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        date_prestamo = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        date_devolucion = new com.toedter.calendar.JDateChooser();
        btnEditar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnbuscar_alumno = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();

        jmEditar.setBackground(new java.awt.Color(153, 0, 0));
        jmEditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jmEditar.setForeground(new java.awt.Color(102, 102, 0));
        jmEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/Editarr.png"))); // NOI18N
        jmEditar.setToolTipText("EDITAR");
        jmEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmEditar);

        jmBORRAR.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jmBORRAR.setForeground(new java.awt.Color(255, 255, 255));
        jmBORRAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/borrar.JPG"))); // NOI18N
        jmBORRAR.setToolTipText("BORRAR");
        jmBORRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmBORRARActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmBORRAR);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REALIZAR PRESTAMO");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 153));
        jLabel16.setText("REALIZAR PRESTAMOS");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/libros.JPG"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblregistros.setBackground(new java.awt.Color(255, 255, 255));
        lblregistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblregistros.setForeground(new java.awt.Color(0, 153, 153));
        lblregistros.setText("REGISTROS");
        lblregistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0)));

        Tabla_Prestamo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        Tabla_Prestamo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Tabla_Prestamo.setForeground(new java.awt.Color(0, 153, 153));
        Tabla_Prestamo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla_Prestamo.setComponentPopupMenu(jPopupMenu1);
        Tabla_Prestamo.setRowHeight(25);
        Tabla_Prestamo.setSelectionBackground(new java.awt.Color(0, 0, 204));
        Tabla_Prestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_PrestamoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Tabla_PrestamoMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Prestamo);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 523, Short.MAX_VALUE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsalir)
                    .addComponent(lblregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 153, 153)));

        txtRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReciboActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("<html>TITULO DEL LIBRO</html>");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("ISBN");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("ESTUDIANTE");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("GRADO");

        txtgrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgradoActionPerformed(evt);
            }
        });

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        btnbuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnbuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/añadir libro.png"))); // NOI18N
        btnbuscar.setToolTipText("SELECCIONAR LIBRO");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setText("CANTIDAD");

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(153, 0, 0));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/aceptar.png"))); // NOI18N
        btnNuevo.setToolTipText("REALIZAR NUEVO PRESTAMO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 0, 0));
        jLabel15.setText("<html>FECHA DE PRESTAMO</html>");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("<html>FECHA DE DEVOLUCIÓN</html>");

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

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(204, 0, 0));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/guardarR.png"))); // NOI18N
        btnAgregar.setToolTipText("GUARDAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnbuscar_alumno.setBackground(new java.awt.Color(255, 255, 255));
        btnbuscar_alumno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnbuscar_alumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/usuarios.jpg"))); // NOI18N
        btnbuscar_alumno.setToolTipText("BUSCAR ESTUDIANTE");
        btnbuscar_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_alumnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(txtRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCod_material, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgrado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(date_devolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnbuscar_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtCod_material, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnbuscar_alumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date_devolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(37, 37, 37))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtgrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        btnRefrescar.setBackground(new java.awt.Color(255, 255, 255));
        btnRefrescar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRefrescar.setForeground(new java.awt.Color(153, 0, 0));
        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/refrescar.JPG"))); // NOI18N
        btnRefrescar.setToolTipText("REFRESCAR");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        habilitar();

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       
       
        
        Funciones_prestamos  pres = new Funciones_prestamos ();
        SQLfunciones func = new SQLfunciones();

        pres.setCod_libro(txtCod_material.getText());
        pres.setCarnet(txtCarnet.getText());
        pres.setCantidad(Integer.parseInt(txtCantidad.getText()));

        Calendar cal;
        int d, m, a;
        cal = date_prestamo.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        pres.setFecha_prestamo(new Date(a, m, d));

        cal = date_devolucion.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        pres.setFecha_devolucion(new Date(a, m, d));

        if (accion.equals("guardar")) {
            if (func.insertar(pres)) {
                JOptionPane.showMessageDialog(rootPane, "PRESTAMO REALIZADO CON EXITO");
               
                mostrarRegistros("");
                inhabilitar();

            } //if 2

        } //if 1

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed

        mostrarRegistros("");
    }//GEN-LAST:event_btnRefrescarActionPerformed
    
    private void jmBORRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmBORRARActionPerformed

       
        int fila = Tabla_Prestamo.getSelectedRow();
        String codigo = "";
        codigo = Tabla_Prestamo.getValueAt(fila, 0).toString();
        int validar = JOptionPane.showConfirmDialog(rootPane, "¿DESEA BORRAR ESTE PRESTAMO?", "CONFIRMAR", 2);
        try {
            if (validar == 0) {
                PreparedStatement ps = cnn.prepareStatement("DELETE FROM prestamo_estudiante WHERE recibo_E ='" + codigo + "'");
                ps.executeUpdate();
                mostrarRegistros("");
                inhabilitar();
                JOptionPane.showMessageDialog(null, "EL PRESTAMO HA SIDO ELIMINADO");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR! EL PRESTAMO NO PUDO SER ELIMINADO");
        }
    }//GEN-LAST:event_jmBORRARActionPerformed

    private void Tabla_PrestamoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_PrestamoMouseClicked
        
    }//GEN-LAST:event_Tabla_PrestamoMouseClicked

    private void btnbuscar_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_alumnoActionPerformed
        // TODO add your handling code here:
        ver_estudiantes alumn = new ver_estudiantes();
        alumn.setVisible(true);
    }//GEN-LAST:event_btnbuscar_alumnoActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
       
        
        ver_libros a = new ver_libros();
        a.setVisible(true);
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void txtReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReciboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReciboActionPerformed

    private void txtgradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgradoActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void jmEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarActionPerformed
        
        int fila = Tabla_Prestamo.getSelectedRow();
        
        if (fila >= 0) {
            
            txtCod_material.setText(Tabla_Prestamo.getValueAt(fila, 1).toString());
            txtTitulo.setText(Tabla_Prestamo.getValueAt(fila, 2).toString());
            txtisbn.setText(Tabla_Prestamo.getValueAt(fila, 3).toString());
            txtCarnet.setText(Tabla_Prestamo.getValueAt(fila, 4).toString());
            txtEstudiante.setText(Tabla_Prestamo.getValueAt(fila, 5).toString());
            txtgrado.setText(Tabla_Prestamo.getValueAt(fila, 6).toString());
            txtCantidad.setText(Tabla_Prestamo.getValueAt(fila, 7).toString());
            id = Tabla_Prestamo.getValueAt(fila, 0).toString();
            
            desaHabiEditar();
        } else {
            JOptionPane.showMessageDialog(null, "NO SE HA ENCONTRADO EL REGISTRO");
        }

    }//GEN-LAST:event_jmEditarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        

        try {

            PreparedStatement ps = cnn.prepareStatement("UPDATE prestamo_estudiante SET cod_material='" + txtCod_material.getText() + "',carnet='" + txtCarnet.getText() + "',Cantidad='" + txtCantidad.getText()
                    + "' WHERE recibo_E='" + id + "' ");
            id = txtCod_material.getText();
            ps.executeUpdate();
            mostrarRegistros("");
            desaHabiEditar2();

            JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO ACTUALIZADOS");

        } catch (Exception e) {
            java.lang.System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR!, NO SE PUDO EDITAR EL REGISTRO");
        }
    }//GEN-LAST:event_btnEditarActionPerformed
    private Connection conec = new Conexion().conexion();

    private void Tabla_PrestamoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_PrestamoMouseEntered
        
    }//GEN-LAST:event_Tabla_PrestamoMouseEntered

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
            java.util.logging.Logger.getLogger(Menu_pretamos_E.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_pretamos_E.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_pretamos_E.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_pretamos_E.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Menu_pretamos_E().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Prestamo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnbuscar_alumno;
    private javax.swing.JButton btnsalir;
    private com.toedter.calendar.JDateChooser date_devolucion;
    private com.toedter.calendar.JDateChooser date_prestamo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmBORRAR;
    private javax.swing.JMenuItem jmEditar;
    private javax.swing.JLabel lblregistros;
    private javax.swing.JTextField txtCantidad;
    public static javax.swing.JTextField txtCarnet;
    public static javax.swing.JTextField txtCod_material;
    public static javax.swing.JTextField txtEstudiante;
    private javax.swing.JTextField txtRecibo;
    public static javax.swing.JTextField txtTitulo;
    public static javax.swing.JTextField txtgrado;
    public static javax.swing.JTextField txtisbn;
    // End of variables declaration//GEN-END:variables
}

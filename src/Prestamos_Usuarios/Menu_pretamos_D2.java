
package Prestamos_Usuarios;


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
public final class Menu_pretamos_D2 extends javax.swing.JFrame {

   Conexion con = new Conexion();
    Connection cnn = con.conexion();
    String id = "";
    
    
    public Menu_pretamos_D2() {
        
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
        txtisbn.setEnabled(false);

        txtisbn.setEnabled(false);
        txtEspecie.setEnabled(false);
        txtTitulo.setEnabled(false);
        txtDocente.setEnabled(false);
        txtCantidad.setEnabled(false);

        date_prestamo.setEnabled(false);
        date_devolucion.setEnabled(false);

        btnAgregar.setEnabled(false);
        //btnEditar.setEnabled(false);
        btnBuscar_docente.setEnabled(false);
        btnbuscar_libro.setEnabled(false);

        txtRecibo.setText("");
        txtCarnet.setText("");
        txtTitulo.setText("");
        txtDocente.setText("");
        txtCantidad.setText("");
        txtCod_material.setText("");
        txtisbn.setText("");
        txtEspecie.setText("");

    }

    void habilitar() {
        txtRecibo.setEnabled(false);
        txtCod_material.setEnabled(false);
        txtCarnet.setEnabled(false);

        txtisbn.setEnabled(false);
        txtEspecie.setEnabled(false);
        txtTitulo.setEnabled(false);
        txtDocente.setEnabled(false);
        txtCantidad.setEnabled(true);

        date_prestamo.setEnabled(true);
        date_devolucion.setEnabled(true);

        btnAgregar.setEnabled(true);
        btnBuscar_docente.setEnabled(true);
        btnbuscar_libro.setEnabled(true);

        txtRecibo.setText("");
        txtCarnet.setText("");
        txtTitulo.setText("");
        txtDocente.setText("");
        txtCantidad.setText("");
        txtCod_material.setText("");
        txtisbn.setText("");
        txtEspecie.setText("");

    }

    void desaHabiEditar() {

        //btnEditar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnRefrescar.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnbuscar_libro.setEnabled(true);
        btnBuscar_docente.setEnabled(true);
        date_prestamo.setEnabled(true);
        date_devolucion.setEnabled(true);
        txtCantidad.setEnabled(true);
    }

    void desaHabiEditar2() {
        btnNuevo.setEnabled(true);
        btnRefrescar.setEnabled(true);
        //btnEditar.setEnabled(false);

        date_prestamo.setEnabled(false);
        date_devolucion.setEnabled(false);
        txtCantidad.setEnabled(false);
        btnbuscar_libro.setEnabled(false);
        btnBuscar_docente.setEnabled(false);

        txtCod_material.setText("");
        txtTitulo.setText("");
        txtisbn.setText("");
        txtEspecie.setText("");
        txtDocente.setText("");
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
        modelo.addColumn("DOCENTE");
        modelo.addColumn("ESPECIALIDAD");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("FECHA DE PRESTAMO");
        modelo.addColumn("FECHA DE DEVOLUCION");
        
        Tabla_Prestamo.setModel(modelo);
        ocultar_columnas();

        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT\n"
                    + "  prestamo_docente.`recibo_D` AS prestamo_docente_Recibo_D,\n"
                    + "  prestamo_docente.`cod_material` AS prestamo_docente_cod_material,\n"
                    + "  libros.`titulo` AS libros_titulo_libro,\n"
                    + "  libros.`isbn` AS libros_isbn,\n"
                    + "  prestamo_docente.`carnet` AS prestamo_docente_carnet_docente,\n"
                    + "  concat( docente.`nombres`,' ',\n"
                    + "  docente.`apellidos`)AS docente,\n"
                    + "  docente.`especialidad` AS docente_especialidad,\n"
                    + "  prestamo_docente.`cantidad` AS prestamo_docente_cantidad,\n"
                    + "  prestamo_docente.`Fecha_Prestamo` AS prestamo_docente_fecha_prestamo,\n"
                    + "  prestamo_docente.`Fecha_Devolucion` AS prestamo_docente_fecha_devolucion\n"
                    + "  FROM\n"
                    + "  `docente` docente INNER JOIN `prestamo_docente` prestamo_docente ON docente.`carnet` = prestamo_docente.`carnet`\n"
                    + "  INNER JOIN `libros` libros ON prestamo_docente.`Cod_material` = libros.`cod_libro` order by recibo_D desc";
            
        } else {
            
            sql = "SELECT * FROM prestamo_docente WHERE (cod_material='" + valor + "' OR carnet='" + valor + "')";
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
        txtTitulo = new javax.swing.JTextField();
        btnbuscar_libro = new javax.swing.JButton();
        txtDocente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        date_prestamo = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        date_devolucion = new com.toedter.calendar.JDateChooser();
        btnAgregar = new javax.swing.JButton();
        btnBuscar_docente = new javax.swing.JButton();
        txtEspecie = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnRefrescar = new javax.swing.JButton();

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
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir))
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
        jLabel3.setText("DOCENTE");

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        btnbuscar_libro.setBackground(new java.awt.Color(255, 255, 255));
        btnbuscar_libro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnbuscar_libro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/añadir libro.png"))); // NOI18N
        btnbuscar_libro.setToolTipText("SELECCIONAR LIBRO");
        btnbuscar_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_libroActionPerformed(evt);
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

        btnBuscar_docente.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar_docente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar_docente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/usuarios.jpg"))); // NOI18N
        btnBuscar_docente.setToolTipText("BUSCAR ESTUDIANTE");
        btnBuscar_docente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar_docenteActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("ESPECIALIDAD");

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
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCod_material, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(date_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar_docente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnbuscar_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(date_devolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                    .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnbuscar_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnBuscar_docente)))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_prestamo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_devolucion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            if (func.insertar_doc(pres)) {
                JOptionPane.showMessageDialog(rootPane, "PRESTAMO REALIZADO CON EXITO");
               
                mostrarRegistros("");
                inhabilitar();

            } //if 2

        } //if 1

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed

        mostrarRegistros("");
    }//GEN-LAST:event_btnRefrescarActionPerformed
    
    private void Tabla_PrestamoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_PrestamoMouseClicked
        
    }//GEN-LAST:event_Tabla_PrestamoMouseClicked

    private void btnBuscar_docenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar_docenteActionPerformed
       
        ver_docentes2 doc = new ver_docentes2();
        doc.setVisible(true);
    }//GEN-LAST:event_btnBuscar_docenteActionPerformed

    private void btnbuscar_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_libroActionPerformed
       
        ver_libros_D2 a = new ver_libros_D2();
        a.setVisible(true);
        
    }//GEN-LAST:event_btnbuscar_libroActionPerformed

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void txtReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReciboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReciboActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed
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
            java.util.logging.Logger.getLogger(Menu_pretamos_D2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_pretamos_D2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_pretamos_D2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_pretamos_D2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Menu_pretamos_D2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Prestamo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar_docente;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnbuscar_libro;
    private javax.swing.JButton btnsalir;
    private com.toedter.calendar.JDateChooser date_devolucion;
    private com.toedter.calendar.JDateChooser date_prestamo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblregistros;
    private javax.swing.JTextField txtCantidad;
    public static javax.swing.JTextField txtCarnet;
    public static javax.swing.JTextField txtCod_material;
    public static javax.swing.JTextField txtDocente;
    public static javax.swing.JTextField txtEspecie;
    private javax.swing.JTextField txtRecibo;
    public static javax.swing.JTextField txtTitulo;
    public static javax.swing.JTextField txtisbn;
    // End of variables declaration//GEN-END:variables
}

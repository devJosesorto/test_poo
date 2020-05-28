package Prestamos;




//import Prestamos_Usuarios.Prestamo;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Prestamos.SQLfunciones;
import Prestamos.SQLEjemplar;
import Prestamos.Ejemplar;

/**
 *
 * @author Bolaines
 */
public final class M_pretamos extends javax.swing.JFrame {
    
    
    public String key;
    public boolean sw=true;
    
   Conexion con = new Conexion();
    Connection cnn = con.conexion();
    String id = "";
    
    
    public M_pretamos() {
        
        initComponents();
        habilitar();
        setLocationRelativeTo(null);
         jCDocente.removeAllItems();
         
         btnAgregar.setVisible(false);  
         jLabel9.setVisible(false);
    }
    private String accion = "guardar";
    
    
    public void CBPrestamos(String codigo){
        
     jCDocente.removeAllItems();
        ArrayList<String> lista = new ArrayList<String>();
        lista = Conexion.llenar_comboV2("ejemplar","cod_ejemplar","cod_libro='LIB001' and status='DISPONIBLE'");
        jCDocente.addItem("Elegir:");
        for(int i = 0; i<lista.size();i++){
            jCDocente.addItem(lista.get(i));
        }
    
    }

    //VALIDAR 
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
        //date_devolucion.setEnabled(false);

        btnAgregar.setEnabled(false);
        
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
        //date_devolucion.setEnabled(true);

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

        
        btnConfirmar.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnbuscar_libro.setEnabled(true);
        btnBuscar_docente.setEnabled(true);
        date_prestamo.setEnabled(true);
        //date_devolucion.setEnabled(true);
        txtCantidad.setEnabled(true);
    }

    void desaHabiEditar2() {
        btnConfirmar.setEnabled(true);
       

        date_prestamo.setEnabled(false);
        //date_devolucion.setEnabled(false);
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
    
    void actualizarCMEJ(){
    
        M_pretamos.jCDocente.removeAllItems();
        ArrayList<String> lista = new ArrayList<String>();
        lista = Conexion.llenar_comboV2("ejemplar","cod_ejemplar","cod_libro='"+txtCod_material.getText()+"' and status='DISPONIBLE'");
        M_pretamos.jCDocente.addItem("Elegir:");
        for(int i = 0; i<lista.size();i++){
            
        M_pretamos.jCDocente.addItem(lista.get(i));
        }
        M_pretamos.txtCantidad.setText(lista.size()+"");
    
    }
    
    void actualizar_ejemplar(){
        
        Ejemplar ej =new Ejemplar();
        SQLEjemplar queryEJ=new SQLEjemplar();
        
        ej.setStatus("PRESTADO");
        ej.setCod_ejemplar(jCDocente.getSelectedItem().toString());
        queryEJ.Update_Prestamos(ej);
        
    
    }

    public Integer totalprestamos;


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmEDITAR = new javax.swing.JMenuItem();
        jmBORRAR = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblregistros = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txtDetalle = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtRecibo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCod_material = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtisbn = new javax.swing.JTextField();
        jLUsuario = new javax.swing.JLabel();
        txtCarnet = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        btnbuscar_libro = new javax.swing.JButton();
        txtDocente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        date_prestamo = new com.toedter.calendar.JDateChooser();
        btnBuscar_docente = new javax.swing.JButton();
        txtEspecie = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jCDocente = new javax.swing.JComboBox<>();
        txtUbicacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jmEDITAR.setBackground(new java.awt.Color(153, 0, 0));
        jmEDITAR.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jmEDITAR.setForeground(new java.awt.Color(102, 102, 0));
        jmEDITAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/Editarr.png"))); // NOI18N
        jmEDITAR.setToolTipText("EDITAR");
        jmEDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEDITARActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmEDITAR);

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

        btnConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(153, 0, 0));
        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/aceptar.png"))); // NOI18N
        btnConfirmar.setToolTipText("REALIZAR NUEVO PRESTAMO");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
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

        txtDetalle.setToolTipText("");
        txtDetalle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        txtDetalle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 0));
        jLabel8.setText("PROCESAR");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 0));
        jLabel9.setText("<HTML>CONFIRMAR<BR>PRESTAMO<HTML>");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34)
                .addComponent(txtDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsalir))))
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
        jLabel5.setText("<html>NOMBRE DEL<BR>PRESTAMISTA</html>");

        txtCod_material.setEditable(false);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("AUTOR");

        txtisbn.setEditable(false);

        jLUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jLUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLUsuario.setForeground(new java.awt.Color(153, 0, 0));
        jLUsuario.setText("CARNET");

        txtCarnet.setEditable(false);

        txtTitulo.setEditable(false);
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

        txtDocente.setEditable(false);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setText("<HTML>CANTIDAD<BR>EJEMPLARES<HTML>");

        txtCantidad.setEditable(false);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 0, 0));
        jLabel15.setText("<html>FECHA DE PRESTAMO</html>");

        btnBuscar_docente.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar_docente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar_docente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/usuarios.jpg"))); // NOI18N
        btnBuscar_docente.setToolTipText("BUSCAR ESTUDIANTE");
        btnBuscar_docente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar_docenteActionPerformed(evt);
            }
        });

        txtEspecie.setEditable(false);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("<HTML>CODIGO<BR>ESPECIALIDAD<HTML>");

        jCDocente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtUbicacion.setEditable(false);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("UBICACION");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 0));
        jLabel10.setText("<html>TITULO DEL LIBRO</html>");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLUsuario)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(txtCod_material, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar_docente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscar_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCod_material, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jCDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLUsuario)
                            .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnbuscar_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnBuscar_docente)))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(date_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(txtRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
    
    if((txtDocente.getText()==""||txtCarnet.getText()==""||date_prestamo.getDate()!=null)){    
    btnAgregar.setVisible(true);
    jLabel9.setVisible(true);
    ArrayList<String> lista2 = new ArrayList<String>();
    
    lista2=Conexion.llenar_comboV2("ejemplar", "ubicacion","cod_ejemplar='"+jCDocente.getSelectedItem().toString()+"'");
            for(int i = 0; i<lista2.size();i++){
            //jCDocente.addItem(lista.get(i));
            txtUbicacion.setText(lista2.get(i));
        }
    
    Calendar cal;
        int d, m, a;
        cal = date_prestamo.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
    
    String detalle;
    detalle="<html>Colegio Amigos De Don Bosco:<br/><br/>"
            + "\n"
            + "\n"
            + "Prestamo a nombre de: "+txtDocente.getText()+"<br/>"
            + "Por el libro: "+txtTitulo.getText()+"<br/>"
            + "CODIGO LIBRO "+txtCod_material.getText()+"<br/>"
            + "UBICACION: "+txtUbicacion.getText()+"<br/>"
            + "FECHA PRESTAMO "+new Date(a, m, d)+"<br/>"
            + "FECHA ENTREGA "+new Date(a, m, d+5)+"<br/><br/>"
            +"PASADA LA FECHA ENTRA EN MORA</html>";
    
    
    
    
    txtDetalle.setText(detalle);
        
}else{
     JOptionPane.showMessageDialog(rootPane, "COMPLETAR CAMPOS");
    }
        
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
if(sw){
        Prestamo  pres = new Prestamo();
        SQLfunciones func = new SQLfunciones();
        int row;
        
        row=func.countRow();
        if(row>9){
        pres.setCod_prestamo("PL0"+row);
        }else if(row==0){
        pres.setCod_prestamo("PL001");
        }else{
        pres.setCod_prestamo("PL00"+row);
        }
       
        
        
        pres.setCod_ejemplar(jCDocente.getSelectedItem().toString());
        pres.setCarnet(txtCarnet.getText());
        
        

        Calendar cal;
        int d, m, a;
        cal = date_prestamo.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        pres.setFecha_prestamo(new Date(a, m, d));
        pres.setFecha_devolucion(new Date(0, 0, 0));
        
        pres.setMora(Double.parseDouble("0"));

        if (accion.equals("guardar")) {
            if (func.insertar_docV2(pres)) {
                actualizar_ejemplar();
                actualizarCMEJ();
                JOptionPane.showMessageDialog(rootPane, "PRESTAMO REALIZADO CON EXITO");
                
             
            } //if 2

        } //if 1    
        }
    }//GEN-LAST:event_btnAgregarActionPerformed
    
    private void btnBuscar_docenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar_docenteActionPerformed
       
        if (M_pretamos.jLUsuario.getText()=="DOCENTE"){
        ver_docentes doc = new ver_docentes();
        doc.setVisible(true);
        }else {
        ver_estudiantes doc = new ver_estudiantes();
        doc.setVisible(true);    
        }
        
    }//GEN-LAST:event_btnBuscar_docenteActionPerformed

    private void btnbuscar_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_libroActionPerformed
       
        ver_libros a = new ver_libros();
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

    private void jmEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEDITARActionPerformed
        
    }//GEN-LAST:event_jmEDITARActionPerformed
    private Connection conec = new Conexion().conexion();

    private void jmBORRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmBORRARActionPerformed

    }//GEN-LAST:event_jmBORRARActionPerformed

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
            java.util.logging.Logger.getLogger(M_pretamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(M_pretamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(M_pretamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(M_pretamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new M_pretamos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar_docente;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnbuscar_libro;
    private javax.swing.JButton btnsalir;
    private com.toedter.calendar.JDateChooser date_prestamo;
    public static javax.swing.JComboBox<String> jCDocente;
    public static javax.swing.JLabel jLUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenuItem jmBORRAR;
    private javax.swing.JMenuItem jmEDITAR;
    private javax.swing.JLabel lblregistros;
    public static javax.swing.JTextField txtCantidad;
    public static javax.swing.JTextField txtCarnet;
    public static javax.swing.JTextField txtCod_material;
    private javax.swing.JLabel txtDetalle;
    public static javax.swing.JTextField txtDocente;
    public static javax.swing.JTextField txtEspecie;
    private javax.swing.JTextField txtRecibo;
    public static javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtUbicacion;
    public static javax.swing.JTextField txtisbn;
    // End of variables declaration//GEN-END:variables
}


package devoluciones;

import Prestamos.Ejemplar;
import Prestamos.SQLEjemplar;
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
import Prestamos_Usuarios.SQLfunciones;
import Prestamos_Usuarios.Prestamo;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;






/**
 *
 * @author Bolaines
 */
public final class M_devolucion extends javax.swing.JFrame {

   Conexion con = new Conexion();
    Connection cnn = con.conexion();
    String id = "";
    
    
    public M_devolucion() {
        
        initComponents();
        setLocationRelativeTo(null);
        mostrarRegistros("");
        btnAgregar.setVisible(false);
        btnPagar.setVisible(false);
        date_prestamo1.setVisible(false);
        //inhabilitar();
    }
    private String accion = "guardar";

    
    
    
    //VALIDAR 
   
    void desaHabiEditar() {

      
        btnNuevo.setEnabled(false);
        btnRefrescar.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnbuscar_libro.setEnabled(true);
        date_prestamo.setEnabled(true);
    }
    
    
     void actualizar_ejemplar(){
        
        Ejemplar ej =new Ejemplar();
        SQLEjemplar queryEJ=new SQLEjemplar();
        
        ej.setStatus("DISPONIBLE");
        ej.setCod_ejemplar(txtEjemplar.getText());
        queryEJ.Update_Prestamos(ej);
        
    
    }
     
     
     
     public void calcularMora(JDateChooser prestamo, JDateChooser devolucion){
         if (prestamo.getDate() !=null && devolucion.getDate() !=null  ){
             
             Calendar inicio = prestamo.getCalendar();
             Calendar fin = devolucion.getCalendar();
              int dias = -1;
            
              double a = dias - 4 ;
              double b = a * 0.75;
              
              while (inicio.before(fin) || inicio.equals(fin)   ){
                  
                  dias++;
                  inicio.add(Calendar.DATE, 1);
                  
              if( dias >= 0 && dias <=4 ){
                   
                  txtMora.setText("NO TIENE MORA");
                  
              } if ( dias > 4 ){
                   
                 
                  
                  a = dias - 4 ;
                  b = a*0.75;
                  
                  
                  txtMora.setText(b+"");
                  
              }
              
              
              } //while       
                
                            
             // 
        
    } else{
             JOptionPane.showConfirmDialog(null, "selecciones algo");
         }
    
    } 
   

    

    public Integer totalprestamos;

    
    void mostrarRegistros(String valor) {
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("N° DE RECIBO");
        modelo.addColumn("CODIGO DE LIBRO");
        modelo.addColumn("CARNET");
        modelo.addColumn("FECHA ENTREGA");
        //modelo.addColumn("FECHA DEVOLUCION");
        //modelo.addColumn("MORA");
        
        Tabla_Devolucion.setModel(modelo);
        //ocultar_columnas();

        String sql = "";
        if (valor.equals("")) {
            sql = "Select*\n" +
                                "from prestamo where f_devolucion='1899-12-31'";
            
        } else {
            
            sql = "SELECT * FROM devolucion_docente WHERE (cod_material='" + valor + "' OR carnet='" + valor + "')";
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
            

                totalprestamos = totalprestamos + 1;

                modelo.addRow(datos);
                lblregistros.setText("REGISTROS: " + Integer.toString(totalprestamos));
            }
            Tabla_Devolucion.setModel(modelo);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmEDITAR = new javax.swing.JMenuItem();
        jmBORRAR = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblregistros = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Devolucion = new javax.swing.JTable();
        btnRefrescar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtRecibo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCod_Prestamo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEjemplar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCarnet = new javax.swing.JTextField();
        txtEntrega = new javax.swing.JTextField();
        btnbuscar_libro = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        date_prestamo = new com.toedter.calendar.JDateChooser();
        btnAgregar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtMora = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
        date_prestamo1 = new com.toedter.calendar.JDateChooser();

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
        jLabel16.setText("REALIZAR DEVOLUCION");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblregistros.setBackground(new java.awt.Color(255, 255, 255));
        lblregistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblregistros.setForeground(new java.awt.Color(0, 153, 153));
        lblregistros.setText("REGISTROS");
        lblregistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0)));

        Tabla_Devolucion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        Tabla_Devolucion.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Tabla_Devolucion.setForeground(new java.awt.Color(0, 153, 153));
        Tabla_Devolucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        Tabla_Devolucion.setComponentPopupMenu(jPopupMenu1);
        Tabla_Devolucion.setRowHeight(25);
        Tabla_Devolucion.setSelectionBackground(new java.awt.Color(0, 0, 204));
        Tabla_Devolucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_DevolucionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Tabla_DevolucionMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Devolucion);

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

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 153));
        jLabel17.setText("EJEMPLARES PENDIENTE DE DEVOLUCION");

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
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(lblregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(182, 182, 182)
                            .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnsalir)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
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
        jLabel5.setText("<html>CODIGO<BR>PRESTAMO</html>");

        txtCod_Prestamo.setEditable(false);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("<html>CODIGO<BR>EJEMPLAR</html>");

        txtEjemplar.setEditable(false);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("<html>CARNET</html>");

        txtCarnet.setEditable(false);

        txtEntrega.setEditable(false);
        txtEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntregaActionPerformed(evt);
            }
        });

        btnbuscar_libro.setBackground(new java.awt.Color(255, 255, 255));
        btnbuscar_libro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnbuscar_libro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/añadir libro.png"))); // NOI18N
        btnbuscar_libro.setToolTipText("SELECCIONAR");
        btnbuscar_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_libroActionPerformed(evt);
            }
        });

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
        jLabel15.setText("<html>FECHA DE<BR> ENTREGA</html>");

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

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 0, 0));
        jLabel18.setText("<html>FECHA DE<BR> DEVOLUCION</html>");

        txtMora.setText("0");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("<html>MORA</html>");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/libros.JPG"))); // NOI18N

        btnPagar.setBackground(new java.awt.Color(255, 255, 255));
        btnPagar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(153, 0, 0));
        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_bi/administrador.png"))); // NOI18N
        btnPagar.setToolTipText("REALIZAR NUEVO PRESTAMO");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMora, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(56, 56, 56)
                                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(date_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCod_Prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnbuscar_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(date_prestamo1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnbuscar_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCod_Prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtMora))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(date_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(txtRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(date_prestamo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:

    if(txtCarnet.getText()==""||date_prestamo.getDate()!=null){
        
        Calendar cal;
        int d, m, a;
        cal = date_prestamo.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
       
        String string = txtEntrega.getText();
        String[] parts = string.split("-");
        String part1 = parts[0]; 
        String part2 = parts[1]; 
        String part3 = parts[2];
        
        String string2 = new Date(a, m, d)+"";
        String[] fecha = string2.split("-");
        String fecha1 = fecha[0]; 
        String fecha2 = fecha[1]; 
        String fecha3 = parts[2]; 
        
        //date_prestamo1.setDate(new Date(Integer.parseInt(part3),Integer.parseInt(part2),Integer.parseInt(part1)));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       
        try {
            date_prestamo1.setDate(dateFormat.parse(txtEntrega.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(M_devolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        calcularMora(date_prestamo1,date_prestamo);
        
        if(txtMora.getText()=="NO TIENE MORA")  {
        btnAgregar.setVisible(true);           
        }else{
        
        JOptionPane.showMessageDialog(rootPane, "USUARIO CON MORA");
        btnAgregar.setVisible(true); 
        }
                
    }else{
    JOptionPane.showMessageDialog(rootPane, "COMPLETAR CAMPOS");
    
    }
          
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
btnAgregar.setVisible(false);
        
        Prestamo  pres = new Prestamo ();
        SQLfunciones func = new SQLfunciones();
        pres.setCarnet(txtCarnet.getText());
        
        
        Calendar cal;
        int d, m, a;
        cal = date_prestamo.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        
        
        pres.setFecha_devolucion(new Date(a, m, d));
        pres.setMora(Double.parseDouble(txtMora.getText()));
        pres.setCod_prestamo(txtCod_Prestamo.getText());
        
        
        
        
        if (accion.equals("guardar")) {
            if (func.actualizar_docV2(pres)) {
                
                actualizar_ejemplar();
                JOptionPane.showMessageDialog(rootPane, "DEVOLUCION REALIZADA CON EXITO");
               
                mostrarRegistros("");
               

            } //if 2

        } //if 1

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed

        mostrarRegistros("");
    }//GEN-LAST:event_btnRefrescarActionPerformed
    
    private void jmBORRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmBORRARActionPerformed

       
        int fila = Tabla_Devolucion.getSelectedRow();
        String codigo = "";
        codigo = Tabla_Devolucion.getValueAt(fila, 0).toString();
        int validar = JOptionPane.showConfirmDialog(rootPane, "¿DESEA BORRAR ESTA DEVOLUCION?", "CONFIRMAR", 2);
        try {
            if (validar == 0) {
                PreparedStatement ps = cnn.prepareStatement("DELETE FROM devolucion_docente WHERE recibo_D ='" + codigo + "'");
                ps.executeUpdate();
                mostrarRegistros("");
           
                JOptionPane.showMessageDialog(null, "LE REGISTRO HA SIDO ELIMINADO");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR! LE REGISTRO  NO PUDO SER ELIMINADO");
        }
    }//GEN-LAST:event_jmBORRARActionPerformed

    private void Tabla_DevolucionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_DevolucionMouseClicked
        
    }//GEN-LAST:event_Tabla_DevolucionMouseClicked

    private void btnbuscar_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_libroActionPerformed
       
        devolucion_ejemplar a = new devolucion_ejemplar();
        a.setVisible(true);
        
    }//GEN-LAST:event_btnbuscar_libroActionPerformed

    private void txtEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntregaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEntregaActionPerformed

    private void txtReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReciboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReciboActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void jmEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEDITARActionPerformed
        
        int fila = Tabla_Devolucion.getSelectedRow();
        
        if (fila >= 0) {
            
            txtCod_Prestamo.setText(Tabla_Devolucion.getValueAt(fila, 1).toString());
            txtEntrega.setText(Tabla_Devolucion.getValueAt(fila, 2).toString());
            txtEjemplar.setText(Tabla_Devolucion.getValueAt(fila, 3).toString());
            txtCarnet.setText(Tabla_Devolucion.getValueAt(fila, 4).toString());
            id = Tabla_Devolucion.getValueAt(fila, 0).toString();
            
            desaHabiEditar();
        } else {
            JOptionPane.showMessageDialog(null, "NO SE HA ENCONTRADO EL REGISTRO");
        }

    }//GEN-LAST:event_jmEDITARActionPerformed
    private Connection conec = new Conexion().conexion();

    private void Tabla_DevolucionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_DevolucionMouseEntered
        
    }//GEN-LAST:event_Tabla_DevolucionMouseEntered

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed

        btnAgregar.setVisible(true);
        btnPagar.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnPagarActionPerformed

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
            java.util.logging.Logger.getLogger(M_devolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(M_devolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(M_devolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(M_devolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new M_devolucion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Devolucion;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnbuscar_libro;
    private javax.swing.JButton btnsalir;
    private com.toedter.calendar.JDateChooser date_prestamo;
    private com.toedter.calendar.JDateChooser date_prestamo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmBORRAR;
    private javax.swing.JMenuItem jmEDITAR;
    private javax.swing.JLabel lblregistros;
    public static javax.swing.JTextField txtCarnet;
    public static javax.swing.JTextField txtCod_Prestamo;
    public static javax.swing.JTextField txtEjemplar;
    public static javax.swing.JTextField txtEntrega;
    private javax.swing.JTextField txtMora;
    private javax.swing.JTextField txtRecibo;
    // End of variables declaration//GEN-END:variables
}

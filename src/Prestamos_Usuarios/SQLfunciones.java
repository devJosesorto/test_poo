/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prestamos_Usuarios;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Bolaines
 */
public class SQLfunciones {
    
    Conexion con = new Conexion();
    Connection cnn = con.conexion();
    private String sql="";
    
    
    
    
       public boolean insertar_docV2(Prestamo prestamoinsr){
        
       sql="INSERT INTO prestamo(cod_prestamo,cod_ejemplar,carnet,f_entrega,f_devolucion,mora)" +
               "values (?,?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cnn.prepareStatement(sql);
           pst.setString(1, prestamoinsr.getCod_prestamo());
           pst.setString(2, prestamoinsr.getCod_ejemplar());
           pst.setString(3, prestamoinsr.getCarnet());
           pst.setDate(4, prestamoinsr.getFecha_prestamo());
           pst.setDate(5, prestamoinsr.getFecha_devolucion());
           pst.setDouble(5, prestamoinsr.getMora());
           
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
           
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
       
       
       public boolean actualizar_docV2(Prestamo prestamoinsr){
        
       sql="UPDATE prestamo SET f_devolucion = ?,mora = ? "
                + " WHERE cod_prestamo = ?";
       try {
           
           PreparedStatement pst=cnn.prepareStatement(sql);
           pst.setDate(1, prestamoinsr.getFecha_devolucion());
           
           pst.setDouble(2, prestamoinsr.getMora());
           
           pst.setString(3, prestamoinsr.getCod_prestamo());
           
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
           
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
    
    
    public boolean insertar(Funciones_prestamos prestamo){
        sql="INSERT INTO prestamo_estudiante(cod_material,carnet,cantidad,fecha_prestamo,fecha_devolucion)" +
               "values (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, prestamo.getCod_libro());
            ps.setString(2, prestamo.getCarnet());
            ps.setInt(3, prestamo.getCantidad());
            ps.setDate(4, prestamo.getFecha_prestamo());
            ps.setDate(5, prestamo.getFecha_devolucion());
            
            int valor=ps.executeUpdate();
            
            if (valor!=0) {
                return true;
            }
            else{
                return false;
            }
         //cierre try   
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex);
            return false;
        }
                
   }
        
   
    
    
    public boolean insertar_doc (Funciones_prestamos prestamo){
        
       sql="INSERT INTO prestamo_docente(cod_material,carnet,cantidad,fecha_prestamo,fecha_devolucion)" +
               "values (?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cnn.prepareStatement(sql);
           pst.setString(1, prestamo.getCod_libro());
           pst.setString(2, prestamo.getCarnet());
           pst.setInt(3, prestamo.getCantidad());
           pst.setDate(4, prestamo.getFecha_prestamo());
           pst.setDate(5, prestamo.getFecha_devolucion());
           
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
           
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }


    public boolean insertar_devolucion_doc (Funciones_prestamos devolucion){
        
       sql="INSERT INTO devolucion_docente(cod_material,carnet,cantidad,fecha_prestamo,fecha_devolucion)" +
               "values (?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cnn.prepareStatement(sql);
           pst.setString(1, devolucion.getCod_libro());
           pst.setString(2, devolucion.getCarnet());
           pst.setInt(3, devolucion.getCantidad());
           pst.setDate(4, devolucion.getFecha_prestamo());
           pst.setDate(5, devolucion.getFecha_devolucion());
           
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
           
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
    
    
    
    
    
        public boolean insertarPrestamo(Funciones_prestamos prestamo){
        sql="INSERT INTO prestamo(cod_prestamo,cod_ejemplar,carnet,f_entrega,f_devolucion,mora)" +
               "values (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, prestamo.getCod_libro());
            ps.setString(2, prestamo.getCarnet());
            ps.setInt(3, prestamo.getCantidad());
            ps.setDate(4, prestamo.getFecha_prestamo());
            ps.setDate(5, prestamo.getFecha_devolucion());
            ps.setDate(6, prestamo.getFecha_devolucion());
            
            int valor=ps.executeUpdate();
            
            if (valor!=0) {
                return true;
            }
            else{
                return false;
            }
         //cierre try   
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex);
            return false;
        }
                
   }
        
        
                public double Mora_usuario (String carnet){
        double sum=0;
       sql="select sum(mora) from prestamo where carnet='"+carnet+"' group by carnet";
       try {
           
           //PreparedStatement pst=cnn.prepareStatement(sql);
           int row=0;
           
           Statement st = cnn.createStatement();
           ResultSet rs = st.executeQuery(sql);
        
           while (rs.next()) {
               sum=rs.getDouble(1);
               row++;
            }
               return sum;


           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return 0;
       }
   }
        
        
        

    
    
    

 //cierre de motodo  
    
}
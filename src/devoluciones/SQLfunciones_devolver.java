/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devoluciones;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Bolaines
 */
public class SQLfunciones_devolver {
    
    Conexion con = new Conexion();
    Connection cnn = con.conexion();
    private String sql="";
    
    
    public boolean insertar_devolucion_doc (Funciones_devoluciones  devolucion){
        
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
    
    public boolean insertar_devolucion_est (Funciones_devoluciones  devolucion){
        
       sql="INSERT INTO devolucion_estudiante(cod_material,carnet,cantidad,fecha_prestamo,fecha_devolucion)" +
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
    

 //cierre de motodo  
    
}

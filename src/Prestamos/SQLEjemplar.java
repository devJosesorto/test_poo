/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prestamos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author José Sorto
 */
public class SQLEjemplar {
    
    
        Conexion con = new Conexion();
        Connection cnn = con.conexion();
        private String sql="";
        
        
        
public boolean Update_Prestamos(Ejemplar ejemplar_up){
    
       /*sql="UPDATE ejemplar SET"
                + "(cod_libro, ubicacion, status)"
                + "VALUES (?, ?, ?) WHERE cod_ejemplar=?";*/
       sql="UPDATE ejemplar SET status = ? "
                + " WHERE cod_ejemplar = ?";
       try {
           
           PreparedStatement pst=cnn.prepareStatement(sql);
           pst.setString(1, ejemplar_up.getStatus());
           pst.setString(2, ejemplar_up.getCod_ejemplar());
           
           
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

public boolean Update_Devolucion(Ejemplar ejemplar_up){
    
       /*sql="UPDATE ejemplar SET"
                + "(cod_libro, ubicacion, status)"
                + "VALUES (?, ?, ?) WHERE cod_ejemplar=?";*/
       sql="UPDATE ejemplar SET status = ? "
                + " WHERE cod_ejemplar = ?";
       try {
           
           PreparedStatement pst=cnn.prepareStatement(sql);
           
           
           
           pst.setString(1, ejemplar_up.getStatus());
           pst.setString(2, ejemplar_up.getCod_ejemplar());
           
           
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



    
       
       
       
       
       
       
       
       
       
    
}

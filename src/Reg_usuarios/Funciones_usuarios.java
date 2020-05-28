
package Reg_usuarios;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


public class Funciones_usuarios {
    
    private static conexion.Conexion con = new Conexion();
    private static Connection conexion = con.conexion();
    private static PreparedStatement ps = null;
    
    
    
    public static boolean isRegister_D( UsuariosSQL s){
       String sql = UsuariosSQL.registrar_D;
      
       try {
           ps = conexion.prepareStatement(sql);
           ps.setString(1, s.getCarnet());
           ps.setString(2, s.getNombres());
           ps.setString(3, s.getApellidos());
           ps.setString(4, s.getSexo());
           ps.setString(5, s.getEspecialidad());
           ps.executeUpdate();
           return true;           
           
       } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
            
       }
    }//CIERRE
    
    
    public static boolean isUpdate_D ( UsuariosSQL s){
       String sql = UsuariosSQL.actualizar_D;
   
       try {
           ps = conexion.prepareStatement(sql);
           ps.setString(1, s.getCarnet());
           ps.setString(2, s.getNombres());
           ps.setString(3, s.getApellidos());
           ps.setString(4, s.getSexo());
           ps.setString(5, s.getEspecialidad());
           ps.setString(6, s.getId());
           ps.executeUpdate();
           return true;           
           
       } catch (SQLException ex) {
            
            return false;
            
       }
    }// cierre
    
    
     public static boolean isDelete_D( UsuariosSQL s){
       String sql = UsuariosSQL.eliminar_D;
   
       try {
           ps = conexion.prepareStatement(sql);
           ps.setString(1, s.getId());
           ps.executeUpdate();
           return true;           
           
       } catch (SQLException ex) {
            //Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
       }
    }// cierre
     
    
    public static boolean isTruncate_D(){
       String sql = UsuariosSQL.eliminar_todo_D;
   
       try {
           ps = conexion.prepareStatement(sql);
           ps.executeUpdate();
           return true;           
           
       } catch (SQLException ex) {
           System.err.println(ex.getMessage());
            return false;
            
       }
    }// cierre
    
    
     public static void setListar_D (String buscar){ 
         DefaultTableModel modelo = (DefaultTableModel)Crud_Docente.tabla1.getModel();
                  
         while(modelo.getRowCount() > 0){
             modelo.removeRow(0);
             
         }
         String sql = "";
         
         if(buscar.equals("")){
             sql = UsuariosSQL.listar_D;
          
         }else{
             sql = "SELECT * FROM docente WHERE ("
                    + "carnet LIKE '"+buscar+"%' OR "
                    + "nombres LIKE '"+buscar+"%' OR "
                    + "apellidos LIKE '"+buscar+"%' OR "
                    + "sexo LIKE '"+buscar+"%' OR "
                    + "Especialidad LIKE '"+buscar+"%' "
                     +")";
                                                
         }
                                       
         String datos [] = new String[6];
         
         try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
             
           while (rs.next()) {
               datos[0] = rs.getString("id");
               datos[1] = rs.getString("carnet");
               datos[2] = rs.getString("nombres");
               datos[3] = rs.getString("apellidos");   
               datos[4] = rs.getString("sexo");
               datos[5] = rs.getString("especialidad");
            
               
               modelo.addRow(datos);
                                    
             }  //cierre while
                 
         } catch (SQLException ex) {
             System.err.println(ex.getMessage());
             
         }
         
     }//cierre buscar
    
     
     public static String estraerIDMAX_D(){
        
        String sql = "SELECT MAX(id) FROM docente";
        int id = 0;
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                id = rs.getInt(1);
            
            }if (id == 0) {
                id = 1;
                
            }else { 
                id = id + 1;
            }
            
            return String.valueOf(id);
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
        
        
    } //cierre
    
    
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     
      public static boolean isRegister_E( UsuariosSQL s){
       String sql = UsuariosSQL.registrar_E;
      
       try {
           ps = conexion.prepareStatement(sql);
           ps.setString(1, s.getCarnet());
           ps.setString(2, s.getNombres());
           ps.setString(3, s.getApellidos());
           ps.setString(4, s.getSexo());
           ps.setString(5, s.getGrado());
           ps.setString(6, s.getSeccion());
           ps.executeUpdate();
           return true;           
           
       } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
            
       }
    }//CIERRE
    
    
    public static boolean isUpdate_E ( UsuariosSQL s){
       String sql = UsuariosSQL.actualizar_E;
   
       try {
           ps = conexion.prepareStatement(sql);
           ps.setString(1, s.getCarnet());
           ps.setString(2, s.getNombres());
           ps.setString(3, s.getApellidos());
           ps.setString(4, s.getSexo());
           ps.setString(5, s.getGrado());
           ps.setString(6, s.getSeccion());
           ps.setString(7, s.getId());
           ps.executeUpdate();
           return true;           
           
       } catch (SQLException ex) {
             System.err.println(ex.getMessage());
            return false;
            
       }
    }// cierre
    
    
     public static boolean isDelete_E( UsuariosSQL s){
       String sql = UsuariosSQL.eliminar_E;
   
       try {
           ps = conexion.prepareStatement(sql);
           ps.setString(1, s.getId());
           ps.executeUpdate();
           return true;           
           
       } catch (SQLException ex) {
             System.err.println(ex.getMessage());
            return false;
            
       }
    }// cierre
     
    
    public static boolean isTruncate_E(){
       String sql = UsuariosSQL.eliminar_todo_E;
   
       try {
           ps = conexion.prepareStatement(sql);
           ps.executeUpdate();
           return true;           
           
       } catch (SQLException ex) {
           System.err.println(ex.getMessage());
            return false;
            
       }
    }// cierre
    
    
     public static void setListar_E (String buscar){ 
         DefaultTableModel modelo = (DefaultTableModel)Crud_Estudiante.tablaEstudiante.getModel();
                  
         while(modelo.getRowCount() > 0){
             modelo.removeRow(0);
             
         }
         String sql = "";
         
         if(buscar.equals("")){
             sql = UsuariosSQL.listar_E;
          
         }else{
             sql = "SELECT * FROM estudiante WHERE ("
                    + "carnet LIKE '"+buscar+"%' OR "
                    + "nombres LIKE '"+buscar+"%' OR "
                    + "apellidos LIKE '"+buscar+"%' OR "
                    + "sexo LIKE '"+buscar+"%' OR "
                    + "grado LIKE '"+buscar+"%' OR "
                    + "seccion LIKE '"+buscar+"%' "
                     +")";
                                                
         }
                                       
         String datos [] = new String[7];
         
         try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
             
           while (rs.next()) {
               datos[0] = rs.getString("id");
               datos[1] = rs.getString("carnet");
               datos[2] = rs.getString("nombres");
               datos[3] = rs.getString("apellidos");   
               datos[4] = rs.getString("sexo");
               datos[5] = rs.getString("grado");
               datos[6] = rs.getString("seccion");
            
               
               modelo.addRow(datos);
                                    
             }  //cierre while
                 
         } catch (SQLException ex) {
             System.err.println(ex.getMessage());
             
         }
         
     }//cierre buscar
    
     
     public static String estraerIDMAX_E(){
        
        String sql = "SELECT MAX(id) FROM estudiante";
        int id = 0;
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                id = rs.getInt(1);
            
            }if (id == 0) {
                id = 1;
                
            }else { 
                id = id + 1;
            }
            
            return String.valueOf(id);
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
        
        
    } //cierre
     
     
     
     
}// CIERRE DE CLASE

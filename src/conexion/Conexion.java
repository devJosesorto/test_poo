
package conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conexion {
    
   public static Connection conection  = null;
   static ResultSet resultado;
   static Statement sentencia;
   
   public Connection conexion(){
       try {
           Class.forName("com.mysql.jdbc.Driver");
           conection   = DriverManager.getConnection ("jdbc:mysql://localhost:3306/colegio_amigos","root","");
           sentencia= conection.createStatement();
           return conection;
           
       } catch (SQLException | ClassNotFoundException ex) {
          System.err.println(ex.getMessage()); 
       } 
        return null;
   }
   
   
   
       public static ArrayList<String> llenar_combo(String tabla, String campo){
        ArrayList<String> lista = new ArrayList<String>();
        
        String q = "SELECT * FROM "+tabla;
        try {
            resultado = sentencia.executeQuery(q);
            
        } catch (Exception e) {
            
        }
        try {
            while(resultado.next()){
                lista.add(resultado.getString(campo));
            }
        } catch (Exception e) {
        }
        return lista;
    }
       
              public static ArrayList<String> llenar_comboV2(String tabla, String campo,String where){
        ArrayList<String> lista = new ArrayList<String>();
        
        String q = "select* from "+tabla+" WHERE "+where;
        try {
            resultado = sentencia.executeQuery(q);
            
        } catch (Exception e) {
            
        }
        try {
            while(resultado.next()){
                lista.add(resultado.getString(campo));
            }
        } catch (Exception e) {
        }
        return lista;
    }

   
    
}// cierre de clase

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;


/**
 *
 * @author usuario1
 */
public class conexion {
    
    
         private static Connection conn=null;
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String user="root";
    private static final String clave="";
    private static final String url= "jdbc:mysql://localhost:3306/citas";
    
    
     public static Connection obtener() throws SQLException, ClassNotFoundException{
   
    if(conn==null){
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url, user, clave);
                   if(conn!=null){
                       System.out.println("Conexion Exitosa");
        }
        
         } catch (SQLException ex) {
             throw new SQLException(ex);
        }catch (ClassNotFoundException ex){
            throw new ClassCastException(ex.getMessage());
        }
    }
    
    return conn;
        
}


      
      
  public static void cerrar() throws SQLException {
      if(conn!=null){
          conn.close();
      }
      
  }
      
    
    
    
}

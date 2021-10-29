/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.sql.Connection;
import modelo.Cita;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author usuario1
 */
public class servicios {

    private final String tabla="cita";
     public void guarda(Connection conexion, Cita cita) throws SQLException{
        
        try {
            
            PreparedStatement consulta;
            
            if(cita.getId_cita()==null){
                consulta=conexion.prepareStatement("INSERT INTO "+ this.tabla +
                        "(nombre_mascota, fecha, sintomas,peso,dueno) VALUE (?,?,?,?,?)");
                
                consulta.setString(1, cita.getNombre_mascota());
                 consulta.setString(2, cita.getFecha()); 
                  consulta.setString(3, cita.getSintomas());
                   consulta.setInt(4, cita.getPeso());
                    consulta.setString(5, cita.getDueno());
            
                     
                             consulta.execute();
            }
      
            System.out.println("Se ha creado correctamente tu cita");
               
                  
                  
        } catch (Exception e) {
             
            throw new SQLException(e);
            
        }
        
        
    }
     
    /**
     *
     * @param conexion
     * @return
     * @throws SQLException
     */
    public List<Cita> recuperarTodas(Connection conexion) throws SQLException{
         
       
        List<Cita> resultados = new ArrayList<>();
        
        try {
            
            PreparedStatement consulta= conexion.prepareStatement("SELECT id_cita, nombre_mascota,fecha,sintomas, peso, dueno FROM "
                    + this.tabla);
            ResultSet resultado=consulta.executeQuery();
            
            while(resultado.next()){
                resultados.add(new Cita( resultado.getInt("id_cita") ,resultado.getString("nombre_mascota"), resultado.getString("fecha"),
                resultado.getString("sintomas"), resultado.getInt("peso"), resultado.getString("dueno")));
           
            }
            
            
            
        } catch (Exception e) {
            
            throw new SQLException(e);
        }
        return resultados;
    }
     
     
    
     public Cita recuperarId(Connection conexion, Integer id) throws SQLException{
         
       
        Cita resultadoId = new Cita();
        
        try {
            
            PreparedStatement consulta;
                    
            consulta = conexion.prepareStatement("SELECT id_cita, nombre_mascota,fecha,sintomas, peso, dueno FROM " + this.tabla + " where id_cita=" + id );
            ResultSet resultado=consulta.executeQuery();
    
            while(resultado.next()){
                
                 resultadoId = new Cita( resultado.getInt("id_cita") ,resultado.getString("nombre_mascota"), resultado.getString("fecha"),
                resultado.getString("sintomas"), resultado.getInt("peso"), resultado.getString("dueno"));
                
                 
            }
              
               
            
        } catch (Exception e) {
            
            throw new SQLException(e);
        }
        return resultadoId;
        
   
    }
     
        public void actualizarDatos(Connection conexion,Cita cita, Integer id) throws SQLException{
         
       
        Cita citaActualizada = cita ;
        
        
        
        try {
            
            PreparedStatement consulta;
                  
                    
            consulta = conexion.prepareStatement("Update " + this.tabla +" SET nombre_mascota= ? , fecha=?, sintomas=?, peso=?, dueno=? where id_cita=" + id );
            
                 consulta.setString(1, cita.getNombre_mascota());
                 consulta.setString(2, cita.getFecha()); 
                  consulta.setString(3, cita.getSintomas());
                   consulta.setInt(4, cita.getPeso());
                    consulta.setString(5, cita.getDueno());

   
                         consulta.executeUpdate();
 
                    
                         
                         JOptionPane.showMessageDialog(null,"Se ha actualizado Correctamente");
            
            
        } catch (Exception e) {
            
            throw new SQLException(e);
        }
       
        
   
    }
        
         public void Eliminar(Connection conexion, Integer id) throws SQLException{
         
       
        
        
        
        try {
            
            PreparedStatement consulta;
                  
                    
            consulta = conexion.prepareStatement("DELETE FROM cita WHERE id_cita = ? ");
            
                consulta.setString(1, Integer.toString(id)); 

   
                         consulta.execute();
 
                    
                         
                         JOptionPane.showMessageDialog(null,"Se ha eliminado Correctamente");
            
            
        } catch (Exception e) {
            
            throw new SQLException(e);
        }
       
        
   
    }
         
         
}

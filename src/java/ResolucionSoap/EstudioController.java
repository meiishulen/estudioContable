/*c
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResolucionSoap;

import java.sql.Connection;
import ResolucionSoap.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IvoSpruth
 */
public class EstudioController {
 
private ConexionBD conexion;


public EstudioController(){

 conexion = new ConexionBD();
}


public boolean validarUsuarioPorId(int id){

    String consulta= "select usuario.id from usuario where id =?";
    
    try {
        PreparedStatement consultaPreparada= conexion.getConnection().prepareStatement(consulta);
        
        consultaPreparada.setInt(1, id);
        
        ResultSet resultadoQuery = consultaPreparada.executeQuery();
        
        if(resultadoQuery.first()){
        return true;
        }
        else{
            return false;
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(EstudioController.class.getName()).log(Level.SEVERE, null, ex);
        
        return false;
    }

    
}    

public boolean validarUsuarioPorNroRegistro(String nro_registro){
    
    String consulta= "select usuario.id from usuario where nro_registro =?";
    
    try {
        PreparedStatement consultaPreparada= conexion.getConnection().prepareStatement(consulta);
        
        consultaPreparada.setString(1, nro_registro);
        
        ResultSet resultadoQuery = consultaPreparada.executeQuery();
        
        if(resultadoQuery.first()){
        return true;
        }
        else{
            return false;
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(EstudioController.class.getName()).log(Level.SEVERE, null, ex);
        
        return false;
    }
    
}

public boolean validarUsuarioPorIdyNroRegistro(int id, String nro_registro){

String consulta= "select usuario.id from usuario where id =? and nro_registro=?";

PreparedStatement consultaPreparada;
    try {
        
       consultaPreparada = conexion.getConnection().prepareStatement(consulta);
        
       consultaPreparada.setInt(1, id);
       consultaPreparada.setString(2, nro_registro);
       
       ResultSet resultadoQuery = consultaPreparada.executeQuery();
   
        if(resultadoQuery.first()){
        return true;
        }
        else{
            return false;
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(EstudioController.class.getName()).log(Level.SEVERE, null, ex);
        System.err.println("Error al ejecutar consulta");
    }

    return false;
    
}

public boolean comprobarEstadoUsuarioPendiente(int id){

    try {
        String consultaEstadoUsuario= "select estado from usuario where id =?";
        
        PreparedStatement consultaPreparada= conexion.getConnection().prepareStatement(consultaEstadoUsuario);
        
        consultaPreparada.setInt(1, id);
        
        ResultSet resultado= consultaPreparada.executeQuery();
        
        while(resultado.next()){
            
            if(resultado.getString(1).equalsIgnoreCase("pendiente")){
            
            
            return true;   
            }
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(EstudioController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return false;
}

public void aprobarEstadoDelUsuario(int id){
    
    String queryParaAprobarEstado= "update usuario set usuario.estado = 'aprobado' where id=?";
    
    if(comprobarEstadoUsuarioPendiente(id)){
       
        try {
      
        PreparedStatement declaracionPreparada= conexion.getConnection().prepareStatement(queryParaAprobarEstado);
        
        declaracionPreparada.setInt(1, id);
        
        declaracionPreparada.execute();
          
    } catch (SQLException ex) {
        Logger.getLogger(EstudioController.class.getName()).log(Level.SEVERE, null, ex);
        System.err.println("Error al aprobar estado del usuario");
    }
        
    }
    
   // String queryParaAprobar= ""
    
   
    
    

}




}

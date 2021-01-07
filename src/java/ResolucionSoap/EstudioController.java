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
       
       
        
    } catch (SQLException ex) {
        Logger.getLogger(EstudioController.class.getName()).log(Level.SEVERE, null, ex);
    }





//ResultSet resultadoQuery = consultaPreparada.executeQuery();
    return false;

}




}

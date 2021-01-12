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

public boolean validarUsuarioPorCuit(String cuit){
    
    String consulta= "select usuario.id from usuario where cuit =?";
    
    try {
        PreparedStatement consultaPreparada= conexion.getConnection().prepareStatement(consulta);
        
        consultaPreparada.setString(1, cuit);
        
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

public boolean comprobarEstadoUsuarioPendientePorCuit(String cuit){

    try {
        String consultaEstadoUsuario= "select estado from usuario where cuit =?";
        
        PreparedStatement consultaPreparada= conexion.getConnection().prepareStatement(consultaEstadoUsuario);
        
        consultaPreparada.setString(1, cuit);
        
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
}

public String getEstadoUsuario(String cuit){

    String queryParaSaberEstado= "select estado from usuario where cuit = ?";
    String estadoUsuario="";
    
    try {
        PreparedStatement declaracionPreparada= conexion.getConnection().prepareStatement(queryParaSaberEstado);
        
        declaracionPreparada.setString(1, cuit);
        
        ResultSet resultado = declaracionPreparada.executeQuery();
        
        estadoUsuario = resultado.getString(1);
        
    } catch (SQLException ex) {
        Logger.getLogger(EstudioController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return estadoUsuario;

}

public boolean eliminarUsuario(String cuit){
    
    String consultaEstadoUsuario= "select estado from usuario where cuit =?";
    String queryParaEliminarUsuario= "update usuario set estado = 'eliminado' where cuit=?";
    
    PreparedStatement consultaPreparada;
    try {
        
        consultaPreparada = conexion.getConnection().prepareStatement(consultaEstadoUsuario);
        
        consultaPreparada.setString(1, cuit);
        
        ResultSet resultado= consultaPreparada.executeQuery();
        
        if(!resultado.first()){
            
            System.out.println("Usuario inexistente");
            return false;
        }
        else{
            while(resultado.next()){
            
                if(comprobarEstadoUsuarioPendientePorCuit(cuit)){
                
                    PreparedStatement queryPreparadaEliminarUsuario = conexion.getConnection().prepareStatement(queryParaEliminarUsuario);

                    queryPreparadaEliminarUsuario.setString(1, cuit);

                    queryPreparadaEliminarUsuario.execute();

                    return true;
                    
                }
               
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(EstudioController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    return false;
}

public void agregarUsuario(String cuit, String nro_registro, double monto){}




}

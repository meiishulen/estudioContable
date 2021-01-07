/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudioController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author GisellePonce
 */
public class java {
    public static void main(String [] args){
        try{
            Connection conect=DriverManager.getConnection("jdbc:mysql://localhost:3306/contable_ocma", "root", "");
            
            Statement state=conect.createStatement();
            
            
            
            
        }catch(Exception ex){
        System.out.println("error");
        ex.printStackTrace();
        }
        
        
      /*  public static void aprobarRegistro( int id, String Cuit){
            if {
                id== null || 
            }
        }*/
        
        
        
    }
    
    
    
    
}

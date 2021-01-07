/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conenctionDb;
import java.sql.*;

/**
 *
 * @author GisellePonce
 */
public class Estudio_Conect {
    public static void main(String [] args){
        try{
            Connection conect=DriverManager.getConnection("jdbc:mysql://localhost:3306/contable_ocma", "root", "");
            
            Statement state=conect.createStatement();
            
            ResultSet result=state.executeQuery("SELECT*FROM USUARIO");
            
            while(result.next()){
                System.out.println(result.getString("ID")+ "" +result.getNString("CUIT"));
            }
            
        
    }catch(Exception ex){
        System.out.println("error");
        ex.printStackTrace();
        
    }    
 }
}

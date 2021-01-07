/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResolucionSoap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IvoSpruth
 */
public class ConexionBD {
 
 
private String url="jdbc:mysql://localhost:3306/conta_ivospruth";
private String user= "conta";
private String password= "Hola1234";
private Connection conexion= null;

public ConexionBD(){
    
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = DriverManager.getConnection(url, user, password);
    } catch (Exception ex) {
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Error de conexion");
    }
    

}

public Connection getConnection() {
    
   return conexion;
}
    
    
}

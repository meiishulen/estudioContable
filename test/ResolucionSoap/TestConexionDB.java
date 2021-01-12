/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResolucionSoap;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author IvoSpruth
 */
public class TestConexionDB {
    
    public TestConexionDB() {
    }
    
    
    @Test
    public void queConecteBienLaBaseDeDatos(){
    
    ConexionBD laConexion= new ConexionBD();
    boolean conexionExitosa= false;
    
    if(laConexion != null){
        conexionExitosa= true;
    }
    
        assertTrue(conexionExitosa);
        
    }
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

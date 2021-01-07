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
public class TestEstudioController {
    
    public TestEstudioController() {
    }
    
    @Test
    public void queValideUsuarioPorId(){
    
        
    EstudioController controlador = new EstudioController();

    boolean usuarioExistente = controlador.validarUsuarioPorId(1);
    
    
        assertTrue(usuarioExistente);
    
    }
    
    @Test 
    public void queSeValideUsuarioPorNroRegistro(){
        
    EstudioController controlador = new EstudioController();

    String nro_usuarioBuscado= "21";
    
    boolean usuarioExistente = controlador.validarUsuarioPorNroRegistro(nro_usuarioBuscado);
    
        assertTrue(usuarioExistente);
        
    }
    
    @Test 
    public void queSeValideUsuarioPorIdyNroRegistro(){
        
        EstudioController controlador = new EstudioController();

        int id_usuariobuscado= 2;
        String nro_usuarioBuscado= "21";

        boolean usuarioExistente = controlador.validarUsuarioPorIdyNroRegistro(id_usuariobuscado, nro_usuarioBuscado);

        assertTrue(usuarioExistente);
        
    }
    
    @Test
    public void comprobarQueElEstadoDelUsuarioSeaPendiente(){
    
    EstudioController controlador = new EstudioController();
    
    int idDelUsuarioaComprobarEstado= 2;
    
    boolean estadoPendienteExitoso = controlador.comprobarEstadoUsuarioPendiente(idDelUsuarioaComprobarEstado);
    
        assertTrue(estadoPendienteExitoso);
        
    }
    
    @Test
    public void comprobarQueSeCambioaEstadoAAprobado(){
    
    EstudioController controlador = new EstudioController();
    
    int idUsuarioaAprobarElEstado= 1;
    
    controlador.aprobarEstadoDelUsuario(idUsuarioaAprobarElEstado);
    
    boolean estadoAprobado= controlador.comprobarEstadoUsuarioPendiente(idUsuarioaAprobarElEstado);
    
        assertFalse(estadoAprobado);
    
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

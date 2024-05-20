package testFuncion;

import calculadora.model.operacion.reales.funcion.FuncionTrigonometrica;
import calculadora.model.operacion.reales.funcion.FuncionTrigonometrica.Modo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestFuncionTrigonometrica {
   
    // Pruebas unitarias de la clase FuncionTrigonometrica
    private FuncionTrigonometrica funcionTrigonometrica;

    @BeforeEach
    public void setUp() {
        // Inicialización de la instancia y asignación del modo
        funcionTrigonometrica = new FuncionTrigonometrica(); 
    }
    @Test
    public void testSeno() {
        //Pruebas en grados
        assertEquals((double)1/2,funcionTrigonometrica.seno(30),0.0001);
        
        assertEquals((Math.sqrt(2))/2,funcionTrigonometrica.seno(45),0.0001);
        assertEquals((Math.sqrt(3))/2,funcionTrigonometrica.seno(60),0.0001);
        
        //Pruebas en radianes
        funcionTrigonometrica.setModo(Modo.RADIANES);
        assertEquals(0,funcionTrigonometrica.seno(Math.PI),0.0001);
        assertEquals((double) 1/2, funcionTrigonometrica.seno(Math.toRadians(30)), 0.0001);
        assertEquals((Math.sqrt(2))/2, funcionTrigonometrica.seno(Math.toRadians(45)), 0.0001);
        assertEquals((Math.sqrt(3))/2, funcionTrigonometrica.seno(Math.toRadians(60)), 0.0001);
        
    }

    @Test
    public void testCoseno() {
        //Pruebas en grados
        assertEquals((Math.sqrt(3))/2,funcionTrigonometrica.coseno(30),0.0001);
        assertEquals((Math.sqrt(2))/2,funcionTrigonometrica.coseno(45),0.0001);
        assertEquals((double) 1/2,funcionTrigonometrica.coseno(60),0.0001);
        
        //Pruebas en radianes
        funcionTrigonometrica.setModo(Modo.RADIANES);
        assertEquals((Math.sqrt(3))/2, funcionTrigonometrica.coseno(Math.toRadians(30)), 0.0001);
        assertEquals((Math.sqrt(2))/2, funcionTrigonometrica.coseno(Math.toRadians(45)), 0.0001);
        assertEquals((double)1/2, funcionTrigonometrica.coseno(Math.toRadians(60)), 0.0001);
    }


    @Test
    public void testTangente() {
        // Pruebas en grados
        assertEquals(Math.sqrt(3)/3, funcionTrigonometrica.tangente(30), 0.0001);
        assertEquals(1, funcionTrigonometrica.tangente(45), 0.0001);
        assertEquals(Math.sqrt(3), funcionTrigonometrica.tangente(60), 0.0001);
    
        // Pruebas en radianes
        funcionTrigonometrica.setModo(Modo.RADIANES);
        assertEquals(Math.sqrt(3)/3, funcionTrigonometrica.tangente(Math.toRadians(30)), 0.0001);
        assertEquals(1, funcionTrigonometrica.tangente(Math.toRadians(45)), 0.0001);
        assertEquals(Math.sqrt(3), funcionTrigonometrica.tangente(Math.toRadians(60)), 0.0001);
    }

    @Test
    public void testCotangente() {
        // Pruebas en grados
        assertEquals(Math.sqrt(3), funcionTrigonometrica.cotangente(30), 0.0001);
        assertEquals(1, funcionTrigonometrica.cotangente(45), 0.0001);
        assertEquals(Math.sqrt(3)/3, funcionTrigonometrica.cotangente(60), 0.0001);
    
        // Pruebas en radianes
        funcionTrigonometrica.setModo(Modo.RADIANES);
        assertEquals(Math.sqrt(3), funcionTrigonometrica.cotangente(Math.toRadians(30)), 0.0001);
        assertEquals(1, funcionTrigonometrica.cotangente(Math.toRadians(45)), 0.0001);
        assertEquals(Math.sqrt(3)/3, funcionTrigonometrica.cotangente(Math.toRadians(60)), 0.0001);
    }

    @Test
    public void testSecante() {
        // Pruebas en grados
        assertEquals(2/Math.sqrt(3), funcionTrigonometrica.secante(30), 0.0001);
        assertEquals(Math.sqrt(2), funcionTrigonometrica.secante(45), 0.0001);
        assertEquals(2, funcionTrigonometrica.secante(60), 0.0001);
    
        // Pruebas en radianes
        funcionTrigonometrica.setModo(Modo.RADIANES);
        assertEquals(2/Math.sqrt(3), funcionTrigonometrica.secante(Math.toRadians(30)), 0.0001);
        assertEquals(Math.sqrt(2), funcionTrigonometrica.secante(Math.toRadians(45)), 0.0001);
        assertEquals(2, funcionTrigonometrica.secante(Math.toRadians(60)), 0.0001);
    }

    @Test
    public void testCosecante() {
        // Pruebas en grados
        assertEquals(2, funcionTrigonometrica.cosecante(30), 0.0001);
        assertEquals(Math.sqrt(2), funcionTrigonometrica.cosecante(45), 0.0001);
        assertEquals(2/Math.sqrt(3), funcionTrigonometrica.cosecante(60), 0.0001);
    
        // Pruebas en radianes
        funcionTrigonometrica.setModo(Modo.RADIANES);
        assertEquals(2, funcionTrigonometrica.cosecante(Math.toRadians(30)), 0.0001);
        assertEquals(Math.sqrt(2), funcionTrigonometrica.cosecante(Math.toRadians(45)), 0.0001);
        assertEquals(2/Math.sqrt(3), funcionTrigonometrica.cosecante(Math.toRadians(60)), 0.0001);
    }

    @Test
    public void testArcSeno() {
        // Pruebas en grados
        assertEquals(30, funcionTrigonometrica.arcSeno( 0.5 ),0.0001);
        assertEquals(45, funcionTrigonometrica.arcSeno( Math.sqrt(2)/2),0.0001);
        assertEquals(60, funcionTrigonometrica.arcSeno( Math.sqrt(3)/2),0.0001);
        
        //Pruebas en radianes
        funcionTrigonometrica.setModo(Modo.RADIANES);
        assertEquals(Math.toRadians(30), funcionTrigonometrica.arcSeno((0.5) ),0.0001);
        assertEquals(Math.toRadians(45), funcionTrigonometrica.arcSeno(Math.sqrt(2)/2 ),0.0001);
        assertEquals(Math.toRadians(60), funcionTrigonometrica.arcSeno(Math.sqrt(3)/2 ),0.0001);
    }

    @Test
    public void testArcCoseno() {
        // Pruebas en grados
        assertEquals(30, funcionTrigonometrica.arcCoseno( Math.sqrt(3)/2 ),0.0001);
        assertEquals(45, funcionTrigonometrica.arcCoseno( Math.sqrt(2)/2 ),0.0001);
        assertEquals(60, funcionTrigonometrica.arcCoseno(0.5 ),0.0001);
        
        // Pruebas en radianes
        funcionTrigonometrica.setModo(Modo.RADIANES);
        assertEquals(Math.toRadians(30), funcionTrigonometrica.arcCoseno(Math.sqrt(3)/2 ),0.0001);
        assertEquals(Math.toRadians(45), funcionTrigonometrica.arcCoseno(Math.sqrt(2)/2),0.0001);
        assertEquals(Math.toRadians(60), funcionTrigonometrica.arcCoseno(0.5 ),0.0001);
    }

    @Test
    public void testArcTangente() {
        // Pruebas en grados
        assertEquals(30, funcionTrigonometrica.arcTangente( Math.sqrt(3)/3 ),0.0001);
        assertEquals(45, funcionTrigonometrica.arcTangente(1 ),0.0001);
        assertEquals(60, funcionTrigonometrica.arcTangente( Math.sqrt(3)),0.0001);
        
        // Pruebas en radianes
        funcionTrigonometrica.setModo(Modo.RADIANES);
        assertEquals(Math.toRadians(30), funcionTrigonometrica.arcTangente(Math.sqrt(3)/3 ),0.0001);
        assertEquals(Math.toRadians(45), funcionTrigonometrica.arcTangente(1 ),0.0001);
        assertEquals(Math.toRadians(60), funcionTrigonometrica.arcTangente( Math.sqrt(3) ),0.0001);
    }

}

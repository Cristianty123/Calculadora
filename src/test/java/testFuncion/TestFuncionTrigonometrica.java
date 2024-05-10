package testFuncion;

import calculadora.model.operacion.reales.funcion.FuncionTrigonometrica;
import calculadora.model.operacion.reales.funcion.FuncionTrigonometrica.Modo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class TestFuncionTrigonometrica {
   
    // Pruebas unitarias de la clase FuncionTrigonometrica

    @Test
    public void testSeno() {
        //Pruebas en grados
        assertEquals((double)1/2,FuncionTrigonometrica.seno(30,Modo.DEG),0.0001);
        assertEquals((Math.sqrt(2))/2,FuncionTrigonometrica.seno(45,Modo.DEG),0.0001);
        assertEquals((Math.sqrt(3))/2,FuncionTrigonometrica.seno(60,Modo.DEG),0.0001);
        
        //Pruebas en radianes
        assertEquals((double) 1/2, FuncionTrigonometrica.seno(Math.toRadians(30), Modo.RADIANES), 0.0001);
        assertEquals((Math.sqrt(2))/2, FuncionTrigonometrica.seno(Math.toRadians(45), Modo.RADIANES), 0.0001);
        assertEquals((Math.sqrt(3))/2, FuncionTrigonometrica.seno(Math.toRadians(60), Modo.RADIANES), 0.0001);
        
    }

    @Test
    public void testCoseno() {
        //Pruebas en grados
        assertEquals((Math.sqrt(3))/2,FuncionTrigonometrica.coseno(30,Modo.DEG),0.0001);
        assertEquals((Math.sqrt(2))/2,FuncionTrigonometrica.coseno(45,Modo.DEG),0.0001);
        assertEquals((double) 1/2,FuncionTrigonometrica.coseno(60,Modo.DEG),0.0001);
        
        //Pruebas en radianes
        assertEquals((Math.sqrt(3))/2, FuncionTrigonometrica.coseno(Math.toRadians(30), Modo.RADIANES), 0.0001);
        assertEquals((Math.sqrt(2))/2, FuncionTrigonometrica.coseno(Math.toRadians(45), Modo.RADIANES), 0.0001);
        assertEquals((double)1/2, FuncionTrigonometrica.coseno(Math.toRadians(60), Modo.RADIANES), 0.0001);
    }


    @Test
    public void testTangente() {
        // Pruebas en grados
        assertEquals(Math.sqrt(3)/3, FuncionTrigonometrica.tangente(30, Modo.DEG), 0.0001);
        assertEquals(1, FuncionTrigonometrica.tangente(45, Modo.DEG), 0.0001);
        assertEquals(Math.sqrt(3), FuncionTrigonometrica.tangente(60, Modo.DEG), 0.0001);
    
        // Pruebas en radianes
        assertEquals(Math.sqrt(3)/3, FuncionTrigonometrica.tangente(Math.toRadians(30), Modo.RADIANES), 0.0001);
        assertEquals(1, FuncionTrigonometrica.tangente(Math.toRadians(45), Modo.RADIANES), 0.0001);
        assertEquals(Math.sqrt(3), FuncionTrigonometrica.tangente(Math.toRadians(60), Modo.RADIANES), 0.0001);
    }

    @Test
    public void testCotangente() {
        // Pruebas en grados
        assertEquals(Math.sqrt(3), FuncionTrigonometrica.cotangente(30, Modo.DEG), 0.0001);
        assertEquals(1, FuncionTrigonometrica.cotangente(45, Modo.DEG), 0.0001);
        assertEquals(Math.sqrt(3)/3, FuncionTrigonometrica.cotangente(60, Modo.DEG), 0.0001);
    
        // Pruebas en radianes
        assertEquals(Math.sqrt(3), FuncionTrigonometrica.cotangente(Math.toRadians(30), Modo.RADIANES), 0.0001);
        assertEquals(1, FuncionTrigonometrica.cotangente(Math.toRadians(45), Modo.RADIANES), 0.0001);
        assertEquals(Math.sqrt(3)/3, FuncionTrigonometrica.cotangente(Math.toRadians(60), Modo.RADIANES), 0.0001);
    }

    @Test
    public void testSecante() {
        // Pruebas en grados
        assertEquals(2/Math.sqrt(3), FuncionTrigonometrica.secante(30, Modo.DEG), 0.0001);
        assertEquals(Math.sqrt(2), FuncionTrigonometrica.secante(45, Modo.DEG), 0.0001);
        assertEquals(2, FuncionTrigonometrica.secante(60, Modo.DEG), 0.0001);
    
        // Pruebas en radianes
        assertEquals(2/Math.sqrt(3), FuncionTrigonometrica.secante(Math.toRadians(30), Modo.RADIANES), 0.0001);
        assertEquals(Math.sqrt(2), FuncionTrigonometrica.secante(Math.toRadians(45), Modo.RADIANES), 0.0001);
        assertEquals(2, FuncionTrigonometrica.secante(Math.toRadians(60), Modo.RADIANES), 0.0001);
    }

    @Test
    public void testCosecante() {
        // Pruebas en grados
        assertEquals(2, FuncionTrigonometrica.cosecante(30, Modo.DEG), 0.0001);
        assertEquals(Math.sqrt(2), FuncionTrigonometrica.cosecante(45, Modo.DEG), 0.0001);
        assertEquals(2/Math.sqrt(3), FuncionTrigonometrica.cosecante(60, Modo.DEG), 0.0001);
    
        // Pruebas en radianes
        assertEquals(2, FuncionTrigonometrica.cosecante(Math.toRadians(30), Modo.RADIANES), 0.0001);
        assertEquals(Math.sqrt(2), FuncionTrigonometrica.cosecante(Math.toRadians(45), Modo.RADIANES), 0.0001);
        assertEquals(2/Math.sqrt(3), FuncionTrigonometrica.cosecante(Math.toRadians(60), Modo.RADIANES), 0.0001);
    }

    @Test
    public void testArcSeno() {
        // Pruebas en grados
        assertEquals(30, FuncionTrigonometrica.arcSeno( 0.5 ,Modo.DEG),0.0001);
        assertEquals(45, FuncionTrigonometrica.arcSeno( Math.sqrt(2)/2 ,Modo.DEG),0.0001);
        assertEquals(60, FuncionTrigonometrica.arcSeno( Math.sqrt(3)/2 ,Modo.DEG),0.0001);
        
        //Pruebas en radianes
        assertEquals(Math.toRadians(30), FuncionTrigonometrica.arcSeno((0.5) ,Modo.RADIANES),0.0001);
        assertEquals(Math.toRadians(45), FuncionTrigonometrica.arcSeno(Math.sqrt(2)/2 ,Modo.RADIANES),0.0001);
        assertEquals(Math.toRadians(60), FuncionTrigonometrica.arcSeno(Math.sqrt(3)/2 ,Modo.RADIANES),0.0001);
    }

    @Test
    public void testArcCoseno() {
        // Pruebas en grados
        assertEquals(30, FuncionTrigonometrica.arcCoseno( Math.sqrt(3)/2 ,Modo.DEG),0.0001);
        assertEquals(45, FuncionTrigonometrica.arcCoseno( Math.sqrt(2)/2 ,Modo.DEG),0.0001);
        assertEquals(60, FuncionTrigonometrica.arcCoseno(0.5 ,Modo.DEG),0.0001);
        
        // Pruebas en radianes
        assertEquals(Math.toRadians(30), FuncionTrigonometrica.arcCoseno(Math.sqrt(3)/2 ,Modo.RADIANES),0.0001);
        assertEquals(Math.toRadians(45), FuncionTrigonometrica.arcCoseno(Math.sqrt(2)/2 ,Modo.RADIANES),0.0001);
        assertEquals(Math.toRadians(60), FuncionTrigonometrica.arcCoseno(0.5 ,Modo.RADIANES),0.0001);
    }

    @Test
    public void testArcTangente() {
        // Pruebas en grados
        assertEquals(30, FuncionTrigonometrica.arcTangente( Math.sqrt(3)/3 ,Modo.DEG),0.0001);
        assertEquals(45, FuncionTrigonometrica.arcTangente(1 ,Modo.DEG),0.0001);
        assertEquals(60, FuncionTrigonometrica.arcTangente( Math.sqrt(3) ,Modo.DEG),0.0001);
        
        // Pruebas en radianes
        assertEquals(Math.toRadians(30), FuncionTrigonometrica.arcTangente(Math.sqrt(3)/3 ,Modo.RADIANES),0.0001);
        assertEquals(Math.toRadians(45), FuncionTrigonometrica.arcTangente(1 ,Modo.RADIANES),0.0001);
        assertEquals(Math.toRadians(60), FuncionTrigonometrica.arcTangente( Math.sqrt(3) ,Modo.RADIANES),0.0001);
    }

}

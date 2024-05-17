package testOperacionAlgebraica;

import calculadora.model.operacion.reales.OperacionAlgebraica;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class TestOperacionAlgebraica {
    
//Pruebas unitarias de la clase OperacionAlgebraica
@Test
public void testSuma(){
    assertEquals(10.0, OperacionAlgebraica.suma(5.0, 5.0));
    assertEquals(13.2, OperacionAlgebraica.suma(4.1, 9.2), 0.1);        
}
  public void testResta() {
        assertEquals(0.0, OperacionAlgebraica.resta(5.0, 5.0));
        assertEquals(-5.1, OperacionAlgebraica.resta(4.1, 9.2), 0.1);
       
    }
    
    @Test
    public void testMultiplicacion() {
        assertEquals(25.0, OperacionAlgebraica.multiplicacion(5.0, 5.0));
        assertEquals(37.72, OperacionAlgebraica.multiplicacion(4.1, 9.2), 0.1);
        
    }
    
    @Test
    public void testDivision() {
        assertEquals(1.0, OperacionAlgebraica.division(5.0, 5.0));
        assertEquals(0.445, OperacionAlgebraica.division(4.1, 9.2), 0.001);
       
    
    }
    @Test
    public void testDivisionPorCero() {
        assertThrows(ArithmeticException.class, () -> {
            OperacionAlgebraica.division(5.0, 0.0);
        });
    }
    
    @Test
    public void testLogaritmoNatural() {
        assertEquals(1.0, OperacionAlgebraica.logaritmoNatural(Math.E), 0.0001);
       
    }
    
    @Test
    public void testLogaritmoBase10() {
        assertEquals(2.0, OperacionAlgebraica.logaritmoBase10(100.0));
        assertEquals(3.0, OperacionAlgebraica.logaritmoBase10(1000.0));
       
    }
    
    @Test
    public void testPotencia() {
        assertEquals(8.0, OperacionAlgebraica.potencia(2.0, 3.0));
        assertEquals(16.0, OperacionAlgebraica.potencia(2.0, 4.0));
       
    }
    
    @Test
    public void testRaizCuadrada() {
        assertEquals(5.0, OperacionAlgebraica.raizCuadrada(25.0));
        assertEquals(4.0, OperacionAlgebraica.raizCuadrada(16.0));
        
    }
    
    @Test
    public void testRaiz() {
        assertEquals(3.0, OperacionAlgebraica.raiz(27.0, 3.0));
        assertEquals(4.0, OperacionAlgebraica.raiz(256.0, 4.0));
       
    }
}   




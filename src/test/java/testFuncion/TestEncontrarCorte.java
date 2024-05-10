package testFuncion;

import calculadora.model.operacion.reales.funcion.EncontrarCorte;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class TestEncontrarCorte {

    @Test
    public void testCorteConRaicesReales() {
        double a = 5; 
        double b = 6;
        double c = -3;
        String[] resultadoEsperado = {"0.37979589711327116", "-1.579795897113271"};
        String[] resultadoCalculado = EncontrarCorte.CalcularCorte(a, b, c);
        
        assertArrayEquals(resultadoEsperado, resultadoCalculado);
    }

    @Test
    public void testCorteConUnaRaizReal() {
        
        double a = 1;
        double b = 0;
        double c = 0;
        String[] resultadoEsperado = {"0", "0"};
        String[] resultadoCalculado = EncontrarCorte.CalcularCorte(a, b, c);
        
        assertArrayEquals(resultadoEsperado, resultadoCalculado);
    }

    @Test
    public void testCorteConRaicesImaginarias() {
        
        double a = 3;
        double b = 5;
        double c = 6;
        String[] resultadoEsperado = {"-0.8333333333333334 + 1.1426091000668406i", "-0.8333333333333334 - 1.1426091000668406i"};
        String[] resultadoCalculado = EncontrarCorte.CalcularCorte(a, b, c);
        
        assertArrayEquals(resultadoEsperado, resultadoCalculado);
    }
}

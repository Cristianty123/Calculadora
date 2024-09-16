package testCalcularOperacion;

import calculadora.model.calcularoperacion.CalcularOperacion;
import calculadora.model.operacion.reales.funcion.FuncionTrigonometrica;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class testCalcularOperacionAlgebraica {
    
    private CalcularOperacion calcularOperacion;
    FuncionTrigonometrica funcionTrigonometrica;

    @BeforeEach
    public void setUp() {
        funcionTrigonometrica = new FuncionTrigonometrica();
        calcularOperacion = new CalcularOperacion(funcionTrigonometrica);
    }
    
    @Test
    public void testCalcularOperacionesAlgebraicas() {
        assertEquals(new BigDecimal("8.400"), calcularOperacion.calcular("6 + 3 / 5 x 9 - 3"));
        assertEquals(new BigDecimal("6.718"), calcularOperacion.calcular("4 + e"));
        assertEquals(new BigDecimal("1.571"), calcularOperacion.calcular("π / 2"));
        assertEquals(new BigDecimal("6561"), calcularOperacion.calcular("9 ^ 2 ^ 2"));
        assertEquals(new BigDecimal("9"), calcularOperacion.calcular("6,6 + 3 / 5 x 9 - 3"));
        assertEquals(new BigDecimal("40"), calcularOperacion.calcular("5 ^ 2 + 6 + 9"));
        assertEquals(new BigDecimal("-3"), calcularOperacion.calcular("6,6 + 3 / 5 x 9 - 3 x (4 - 6 + 7)"));
        assertEquals(new BigDecimal("30.333"), calcularOperacion.calcular("(((((9 + 3) x 25 / 9) - 3)))"));
    }
    
    @Test
    public void testCalcularOperacionesAlgebraicasCuandoSeDivideEn0() {
        assertThrows(ArithmeticException.class, () -> {
            calcularOperacion.calcular("5 + 6 + 7 / 0 + 6 x 6");
        });
    }
    
    @Test
    public void testCalcularMod() {
        assertEquals(new BigDecimal("5"), calcularOperacion.calcular("5 Mod 9"));
    }
}

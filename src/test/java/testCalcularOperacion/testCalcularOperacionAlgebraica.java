package testCalcularOperacion;

import calculadora.model.calcularoperacion.CalcularOperacion;
import calculadora.model.operacion.reales.funcion.FuncionTrigonometrica;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testCalcularOperacionAlgebraica {
    
    private CalcularOperacion calcularOperacion;
    FuncionTrigonometrica funcionTrigonometrica;

    @BeforeEach
    public void setUp() {
        // Inicialización de la instancia y asignación del modo
        funcionTrigonometrica = new FuncionTrigonometrica();
        calcularOperacion = new CalcularOperacion(funcionTrigonometrica);
    }
    
    @Test
    public void testCalcularOperacionesAlgebraicas(){
        
        assertEquals(8.4,calcularOperacion.calcular("6 + 3 ÷ 5 x 9 - 3"));
        assertEquals(9,calcularOperacion.calcular("6,6 + 3 ÷ 5 x 9 - 3"));
        assertEquals(-3,calcularOperacion.calcular("6,6 + 3 ÷ 5 x 9 - 3 x (4 - 6 + 7)"));
        assertEquals(255,calcularOperacion.calcular("6,6 + 3 ÷ 5 x 9 - 3 + (3 ^ 5 + 3)"));
        
    }
    @Test
    public void testCalcularOperacionesAlgebraicasCuandoSeDivideEn0(){
        assertThrows(ArithmeticException.class, () -> {
            calcularOperacion.calcular("5 + 6 + 7 ÷ 0 + 6 x 6");
        });
        
    }
    @Test
    public void testCalcularTrigonometricas(){
        
        assertEquals(3.7071 ,calcularOperacion.calcular("sen(45) + 3"),0.001);
        assertEquals(0.7071 ,calcularOperacion.calcular("sen(45)"),0.001);
        assertEquals(21.1647 ,calcularOperacion.calcular("sen(45) + 3 + arcSen(0,3)"),0.001);
        assertThrows(ArithmeticException.class, () -> {
            calcularOperacion.calcular("sen(45) + 3 + arcSen(2)");
        });
    }
    @Test
    public void testCalcularLogaritmicas(){
        assertEquals(4.6094 ,calcularOperacion.calcular("ln(5) + 3"),0.001);
        assertEquals(-81.09724 ,calcularOperacion.calcular("log(5) + 6 - ln(6) x (7 + 7 x 6)"),0.001);
        assertThrows(ArithmeticException.class, () -> {
            calcularOperacion.calcular("ln(0)");
        });
    }
   
    
}

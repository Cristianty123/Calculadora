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
        assertEquals(6561,calcularOperacion.calcular("9 ^ 2 ^ 2"));
        assertEquals(9,calcularOperacion.calcular("6,6 + 3 ÷ 5 x 9 - 3"));
        assertEquals(40,calcularOperacion.calcular("5 ^ 2 + 6 + 9"));
        assertEquals(-3,calcularOperacion.calcular("6,6 + 3 ÷ 5 x 9 - 3 x (4 - 6 + 7)"));
        assertEquals(30.33333333333333,calcularOperacion.calcular("(((((9 + 3) x 25 ÷ 9) - 3)))"),0.001);
        
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
        assertEquals(0.1391 ,calcularOperacion.calcular("sen(3 + 5)"),0.001);
        assertEquals(1.738136 ,calcularOperacion.calcular("sen(3 + 5 x sen(30)) + cos(45 + 5) + cos(sen(45) + ln(3))"),0.001);
        assertEquals(0.012341 ,calcularOperacion.calcular("sen(sen(45))"),0.001);
        assertEquals(1 ,calcularOperacion.calcular("(sen(sen(45)) ^ 2) + (cos(sen(45)) ^ 2)"),0.001);
        assertEquals(21.1647 ,calcularOperacion.calcular("sen(45) + 3 + arcSen(0,3)"),0.001);
        assertThrows(ArithmeticException.class, () -> {
            calcularOperacion.calcular("sen(45) + 3 + arcSen(2)");
        });
    }
    @Test
    public void testCalcularLogaritmicas(){
        assertEquals(4.6094 ,calcularOperacion.calcular("ln(5) + 3"),0.001);
        assertEquals(1.2304 , calcularOperacion.calcular("log(17)"),0.001);
        assertEquals(0.090063 , calcularOperacion.calcular("log(log(17))"),0.001);
        assertEquals(-81.09724 ,calcularOperacion.calcular("log(5) + 6 - ln(6) x (7 + 7 x 6)"),0.001);
        assertEquals(186853.3909 ,calcularOperacion.calcular("3 + 4 x (sen(45) x 87 - 7 + 6 ^ 6 + ln(8))"),0.001);
        assertThrows(ArithmeticException.class, () -> {
            calcularOperacion.calcular("ln(0)");
        });
    }
   
    
}

package calculadora.model;

import calculadora.model.calcularoperacion.CalcularOperacion;
import calculadora.model.operacion.reales.funcion.FuncionTrigonometrica;

public class CalculadoraModel {
    
    private FuncionTrigonometrica funcionTrigonometrica;
    private CalcularOperacion calcularOperacion;
    
    public CalculadoraModel(){
        
        this.funcionTrigonometrica = new FuncionTrigonometrica();
        this.calcularOperacion = new CalcularOperacion(funcionTrigonometrica);
    }
    
    public void cambiarModoFuncionTrigonometrica(FuncionTrigonometrica.Modo nuevoModo) {
        funcionTrigonometrica.setModo(nuevoModo);
    }
    
    public double calcularOperacion(String operacion){
       return calcularOperacion.calcular(operacion);
    }
    
}

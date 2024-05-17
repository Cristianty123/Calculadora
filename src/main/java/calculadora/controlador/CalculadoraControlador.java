package calculadora.controlador;

import calculadora.model.CalculadoraModel;
import calculadora.model.operacion.reales.funcion.FuncionTrigonometrica;
import calculadora.vista.CalculadoraVista;


public class CalculadoraControlador {
    
    private CalculadoraModel calculadoraModel;
    private CalculadoraVista calculadoraVista;
    
    public CalculadoraControlador(CalculadoraVista calculadoraVista,CalculadoraModel calculadoraModel){
        this.calculadoraModel = calculadoraModel;
        this.calculadoraVista = calculadoraVista;
    }
    
    public void cambiarModoFuncionTrigonometrica(FuncionTrigonometrica.Modo nuevoModo) {
    calculadoraModel.cambiarModoFuncionTrigonometrica(nuevoModo);
   }
    public double calcularOperacion(String operacion){
        return calculadoraModel.calcularOperacion(operacion);
    }
    public void start() {
        calculadoraVista.iniciar();
    }
    
}

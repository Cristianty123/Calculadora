package calculadora.controlador;

import calculadora.model.operacion.reales.funcion.FuncionTrigonometrica;


public class CalculadoraControlador {
    
    private FuncionTrigonometrica funcionTrigonometrica = new FuncionTrigonometrica();
    
    public void cambiarModoFuncionTrigonometrica(FuncionTrigonometrica.Modo nuevoModo) {
    // Aquí obtienes la instancia de la FuncionTrigonometrica y le asignas el nuevo modo
    funcionTrigonometrica.setModo(nuevoModo);
}
    
}

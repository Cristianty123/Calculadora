package calculadora.model.operacion.reales.funcion;

// Clase encargada de calcular los valores de los angulos de cada funcion trigonometrica
public class FuncionTrigonometrica {
    
    private Modo modo = Modo.DEG; // Modo por defecto
    
    // Enum para definir el modo de operación (radianes o grados)
    public enum Modo {
        RADIANES,
        DEG
    }
    
    public void setModo(Modo modo) {
        this.modo = modo;
    }
    
    public Modo getModo() {
        return modo;
    }
    
    // Método para calcular el seno de un ángulo
    public double seno(double angulo) {
        // Si el modo está en grados se pasa el ángulo a radianes
        if (modo == Modo.DEG) {
            angulo = Math.toRadians(angulo); 
        }
        // Se calcula el seno del ángulo
        return Math.sin(angulo);
    }
    
    // Método para calcular el coseno de un ángulo
    public double coseno(double angulo) {
        // Si el modo está en grados se pasa el ángulo a radianes
        if (modo == Modo.DEG) {
            angulo = Math.toRadians(angulo); 
        }
        // Se calcula el coseno del ángulo
        return Math.cos(angulo);
    }
    
    // Método para calcular la tangente de un ángulo
    public double tangente(double angulo) {
        // Si el modo está en grados se pasa el ángulo a radianes
        if (modo == Modo.DEG) {
            angulo = Math.toRadians(angulo); 
        }
        // Se calcula la tangente del ángulo
        return Math.tan(angulo);
    }
    
    // Método para calcular la cotangente de un ángulo
    public double cotangente(double angulo) {
        // Se llama a la función tangente y se le halla el inverso
        return 1 / tangente(angulo);
    }
    
    // Método para calcular la secante de un ángulo
    public double secante(double angulo) {
        // Se llama a la función coseno y se le halla el inverso
        return 1 / coseno(angulo);
    }
    
    // Método para calcular la cosecante de un ángulo
    public double cosecante(double angulo) {
        // Se llama a la función seno y se le halla el inverso
        return 1 / seno(angulo);
    }
    
    // Método para calcular el arcoseno
    public double arcSeno(double valor) {
        // Se calcula el arcoseno
        if(valor < -1 || valor > 1){
            throw new ArithmeticException("Error Matematico");
        }
        double arcSeno = Math.asin(valor);
        // Si el modo está en grados se pasa el ángulo dado a grados
        if (modo == Modo.DEG) {
            arcSeno = Math.toDegrees(arcSeno);
        }
        return arcSeno;
    }
    
    // Método para calcular el arcocoseno de un valor
    public double arcCoseno(double valor) {
        // Se calcula el arcocoseno
        if(valor < -1 || valor > 1){
            throw new ArithmeticException("Error Matematico");
        }
        double arcCoseno = Math.acos(valor);
        // Si el modo está en grados se pasa el ángulo dado a grados
        if (modo == Modo.DEG) {
            arcCoseno = Math.toDegrees(arcCoseno);
        }
        return arcCoseno;
    }
    
    // Método para calcular el arcotangente de un valor
    public double arcTangente(double valor) {
        // Se calcula el arcotangente
        double arcTangente = Math.atan(valor);
        // Si el modo está en grados se pasa el ángulo dado a grados
        if (modo == Modo.DEG) {
            arcTangente = Math.toDegrees(arcTangente);
        }
        return arcTangente;
    }
}




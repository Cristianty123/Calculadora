package calculadora.model.operacion.reales.funcion;

// Clase encargada de calcular los valores de los angulos de cada funcion trigonometrica

public class FuncionTrigonometrica {

    // Enum para definir el modo de operación (radianes o grados)
    public enum Modo {
        RADIANES,
        DEG
    }

    // Método estático para calcular el seno de un ángulo
    // angulo: el ángulo en radianes o grados, dependiendo del modo
    // modo: el modo en el que se especifica el ángulo (radianes o grados)
    // Retorna el seno del ángulo
    public static double seno(double angulo, Modo modo) {
        // Si el modo está en grados se pasa el ángulo a radianes
        if (modo == Modo.DEG) {
            angulo = Math.toRadians(angulo); 
        }
        // Se calcula el seno del ángulo
        return Math.sin(angulo);
    }

    // Método estático para calcular el coseno de un ángulo
    // angulo: el ángulo en radianes o grados, dependiendo del modo
    // modo: el modo en el que se especifica el ángulo (radianes o grados)
    // Retorna el coseno del ángulo
    public static double coseno(double angulo, Modo modo) {
        // Si el modo está en grados se pasa el ángulo a radianes
        if (modo == Modo.DEG) {
            angulo = Math.toRadians(angulo); 
        }
        // Se calcula el coseno del ángulo
        return Math.cos(angulo);
    }

    // Método estático para calcular la tangente de un ángulo
    // angulo: el ángulo en radianes o grados, dependiendo del modo
    // modo: el modo en el que se especifica el ángulo (radianes o grados)
    // Retorna la tangente del ángulo
    public static double tangente(double angulo, Modo modo) {
        // Si el modo está en grados se pasa el ángulo a radianes
        if (modo == Modo.DEG) {
            angulo = Math.toRadians(angulo); 
        }
        // Se calcula la tangente del ángulo
        return Math.tan(angulo);
    }

    // Método estático para calcular la cotangente de un ángulo
    // angulo: el ángulo en radianes o grados, dependiendo del modo
    // modo: el modo en el que se especifica el ángulo (radianes o grados)
    // Retorna la cotangente del ángulo
    public static double cotangente(double angulo, Modo modo) {
        // Se llama a la función tangente y se le halla el inverso
        return 1 / tangente(angulo, modo);
    }

    // Método estático para calcular la secante de un ángulo
    // angulo: el ángulo en radianes o grados, dependiendo del modo
    // modo: el modo en el que se especifica el ángulo (radianes o grados)
    // Retorna la secante del ángulo
    public static double secante(double angulo, Modo modo) {
        // Se llama a la función coseno y se le halla el inverso
        return 1 / coseno(angulo, modo);
    }

    // Método estático para calcular la cosecante de un ángulo
    // angulo: el ángulo en radianes o grados, dependiendo del modo
    // modo: el modo en el que se especifica el ángulo (radianes o grados)
    // Retorna la cosecante del ángulo
    public static double cosecante(double angulo, Modo modo) {
        // Se llama a la función seno y se le halla el inverso
        return 1 / seno(angulo, modo);
    }

    // Método estático para calcular el arcoseno
    // valor: el valor del seno, en radianes o grados, dependiendo del modo
    // modo: el modo en el que se especifica el ángulo (radianes o grados)
    // Retorna el arcoseno del valor dado
    public static double arcSeno(double valor, Modo modo) {
        // Se calcula el arcoseno
        double arcSeno = Math.asin(valor);
        // Si el modo está en grados se pasa el ángulo dado a grados
        if (modo == Modo.DEG) {
            arcSeno = Math.toDegrees(arcSeno);
        }
        return arcSeno;
    }

    // Método estático para calcular el arcocoseno de un valor
    // valor: el valor del coseno, en radianes o grados, dependiendo del modo
    // modo: el modo en el que se especifica el ángulo (radianes o grados)
    // Retorna el arcocoseno del valor dado
    public static double arcCoseno(double valor, Modo modo) {
        // Se calcula el arcocoseno
        double arcCoseno = Math.acos(valor);
        // Si el modo está en grados se pasa el ángulo dado a grados
        if (modo == Modo.DEG) {
            arcCoseno = Math.toDegrees(arcCoseno);
        }
        return arcCoseno;
    }

    // Método estático para calcular el arcotangente de un valor
    // valor: el valor de la tangente, en radianes o grados, dependiendo del modo
    // modo: el modo en el que se especifica el ángulo (radianes o grados)
    // Retorna el arcotangente del valor dado
    public static double arcTangente(double valor, Modo modo) {
        // Se calcula el arcotangente
        double arcTangente = Math.atan(valor);
        // Si el modo está en grados se pasa el ángulo dado a grados
        if (modo == Modo.DEG) {
            arcTangente = Math.toDegrees(arcTangente);
        }
        return arcTangente;
    }   
}



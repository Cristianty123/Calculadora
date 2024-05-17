
package calculadora.model.operacion.reales;


public class OperacionAlgebraica {

    // Método para calcular la suma de dos números
    public static double suma(double numero1, double numero2) {
        return numero1 + numero2;
    }

    // Método para calcular la resta de dos números
    public static double resta(double numero1, double numero2) {
        return numero1 - numero2;
    }

    // Método para calcular la multiplicación de dos números
    public static double multiplicacion(double numero1, double numero2) {
        return numero1 * numero2;
    }

    // Método para calcular la división de dos números
    public static double division(double dividendo, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return dividendo / divisor;
    }

    // Método para calcular el logaritmo natural de un número
    public static double logaritmoNatural(double numero) {
        if (numero <=0) {
            throw new ArithmeticException("Error matematico");
        }
        return Math.log(numero);
    }

    // Método para calcular el logaritmo en base 10 de un número
    public static double logaritmoBase10(double numero) {
        return Math.log10(numero);
    }

    // Método para calcular la potencia de un número
    public static double potencia(double numero, double exponente) {
        return Math.pow(numero, exponente);
    }

    // Método para calcular la raíz cuadrada de un número
    public static double raizCuadrada(double numero) {
        return Math.sqrt(numero);
    }

    // Método para calcular cualquier raíz de un número
    public static double raiz(double numero, double indice) {
        return Math.pow(numero, 1.0 / indice);
    }
}

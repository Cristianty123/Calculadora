package calculadora.model.calcularoperacion;

import calculadora.model.operacion.reales.OperacionAlgebraica;
import calculadora.model.operacion.reales.funcion.FuncionTrigonometrica;
import estructuras.stack.Stack;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcularOperacion {
    private FuncionTrigonometrica funcionesTrigonometricas;

    // Constructor que recibe una instancia de FuncionTrigonometrica
    public CalcularOperacion(FuncionTrigonometrica funcionesTrigonometricas) {
        this.funcionesTrigonometricas = funcionesTrigonometricas;
    }

    private String resolverParentesis(String expresion) {
        expresion = expresion.replace("√", "R");
        int inicioParentesis = expresion.indexOf("(");
        while (inicioParentesis != -1) {
        int indicePrevio = inicioParentesis - 1;
        while (indicePrevio >= 0 && Character.isWhitespace(expresion.charAt(indicePrevio))) {
            indicePrevio--;
        }
        
        boolean esFuncion = false;
        String posibleFuncion = "";
        if (indicePrevio >= 0) {
            int inicioFuncion = indicePrevio;
            while (inicioFuncion >= 0 && Character.isLetter(expresion.charAt(inicioFuncion))) {
                inicioFuncion--;
            }
            posibleFuncion = expresion.substring(inicioFuncion + 1, inicioParentesis);
            
            esFuncion = esFuncionTrigonometrica(posibleFuncion) || esLogaritmo(posibleFuncion) || esRaiz(posibleFuncion);
        }

        int contador = 1;
        int finParentesis = inicioParentesis + 1;
        while (contador != 0 && finParentesis < expresion.length()) {
            if (expresion.charAt(finParentesis) == '(') {
                contador++;
            } else if (expresion.charAt(finParentesis) == ')') {
                contador--;
            }
            finParentesis++;
        }
        
        String expresionParentesis = expresion.substring(inicioParentesis + 1, finParentesis - 1);
        BigDecimal resultadoParentesis = calcular(expresionParentesis);
        String resultadoParentesisStr = String.valueOf(resultadoParentesis);

        if (esFuncion) {
            expresion = expresion.substring(0, inicioParentesis + 1) + resultadoParentesisStr + expresion.substring(finParentesis - 1);
            inicioParentesis = expresion.indexOf("(", inicioParentesis + resultadoParentesisStr.length() + 1);
        } else {
            expresion = expresion.substring(0, inicioParentesis) + resultadoParentesisStr + expresion.substring(finParentesis);
            inicioParentesis = expresion.indexOf("(");
        }
    }
        expresion = expresion.replace("R", "√");
        return expresion;
}

    private String reemplazarConstantes(String expresion) {
        expresion = expresion.replaceAll("(?<=\\b|\\()\\b(e|π)\\b",String.valueOf(Math.E));
        expresion = expresion.replace("( " + String.valueOf(Math.E), "(e");
        expresion = expresion.replace("( " + String.valueOf(Math.PI), "(π");

        // Reemplazar si la constante está al inicio del string
        if (expresion.startsWith("e")) {
            expresion = String.valueOf(Math.E) + expresion.substring(1);
        } else if (expresion.startsWith("π")) {
            expresion = String.valueOf(Math.PI) + expresion.substring(1);
        }
    return expresion;
    }

    public BigDecimal calcular(String expresion) {
        expresion = expresion.replace(",", ".");
        expresion = reemplazarConstantes(expresion);
        expresion = resolverParentesis(expresion);
        System.out.println("Expresion sin parentesis: " + expresion);
        String[] tokens = expresion.split(" ");

        // Inicializar las pilas
        Stack<BigDecimal> operandos = new Stack<>();
        Stack<String> operadores = new Stack<>();

        for (String token : tokens) {
            if (esNumero(token)) {
                operandos.push(new BigDecimal(token));
            } else if (token.equals("(")) {
                operadores.push(token);
            } else if (token.equals(")")) {
                while (!operadores.peek().equals("(")) {
                    resolverOperacion(operandos, operadores);
                }
                operadores.pop();
            } else {
                while (!operadores.isEmpty() && prioridad(operadores.peek()) >= prioridad(token)) {
                    resolverOperacion(operandos, operadores);
                }
                operadores.push(token);
            }
        }

        while (!operadores.isEmpty()) {
            resolverOperacion(operandos, operadores);
        }

        // El resultado es el último valor en la pila de operandos
        BigDecimal resultado = operandos.pop();
        resultado = redondearResultado(resultado);
        return resultado;
    }

    private void resolverOperacion(Stack<BigDecimal> operandos, Stack<String> operadores) {
        BigDecimal numero2 = operandos.pop();
        BigDecimal numero1 = operandos.pop();
        String operador = operadores.pop();

        switch (operador) {
            case "+":
                operandos.push(numero1.add(numero2)); // Suma
                break;
            case "-":
                operandos.push(numero1.subtract(numero2)); // Resta
                break;
            case "x":
                operandos.push(numero1.multiply(numero2)); // Multiplicación
                break;
            case "/":
                operandos.push(numero1.divide(numero2, 10, RoundingMode.HALF_UP)); // División, con 10 decimales de precisión
                break;
            case "^":
                operandos.push(numero1.pow(numero2.intValue())); // Potencia
                break;
            case "Mod":
                operandos.push(numero1.remainder(numero2)); // Módulo
                break;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }

    private boolean esNumero(String cadena) {
        try {
            new BigDecimal(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private BigDecimal redondearResultado(BigDecimal resultado) {
        // Redondear el resultado a 3 decimales
        resultado = resultado.setScale(3, RoundingMode.HALF_UP);
        
        // Verificar si el resultado es un número entero
        if (resultado.stripTrailingZeros().scale() <= 0) {
            // Si es un entero, devolverlo sin decimales
            return resultado.setScale(0, RoundingMode.HALF_UP);
        }
        
        // Devolver el número con 3 decimales si no es entero
        return resultado;
    }

    private boolean esFuncionTrigonometrica(String cadena) {
        return cadena.contains("sen") || cadena.contains("cos") || cadena.contains("tan") ||
                cadena.contains("cot") || cadena.contains("sec") || cadena.contains("csc") ||
                cadena.contains("arcSen") || cadena.contains("arcCos") || cadena.contains("arcTan");
    }

    private double calcularFuncionTrigonometrica(String funcion, double angulo) {
        switch (funcion) {
            case "sen":
                return funcionesTrigonometricas.seno(angulo);
            case "cos":
                return funcionesTrigonometricas.coseno(angulo);
            case "tan":
                return funcionesTrigonometricas.tangente(angulo);
            case "cot":
                return funcionesTrigonometricas.cotangente(angulo);
            case "sec":
                return funcionesTrigonometricas.secante(angulo);
            case "csc":
                return funcionesTrigonometricas.cosecante(angulo);
            case "arcSen":
                return funcionesTrigonometricas.arcSeno(angulo);
            case "arcCos":
                return funcionesTrigonometricas.arcCoseno(angulo);
            case "arcTan":
                return funcionesTrigonometricas.arcTangente(angulo);
            default:
                throw new IllegalArgumentException("Función trigonométrica no válida: " + funcion);
        }
    }

    private int prioridad(String operador) {
        switch (operador) {
            case "+":
            case "-":
                return 1;
            case "x":
            case "/":
            case "Mod": 
                return 2;
            case "^":
                return 3;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }

    private double redondearResultado(double resultado) {
        String resultadoStr = String.valueOf(resultado);
        if (resultadoStr.matches(".*9999+.*")) {
            BigDecimal bd = new BigDecimal(resultado);
            bd = bd.setScale(1, RoundingMode.HALF_UP);
            return bd.doubleValue();
        }
        return resultado;
    }

    private boolean esLogaritmo(String cadena) {
        return cadena.contains("log") || cadena.contains("ln");
    }

    private double calcularLogaritmo(String funcion, double numero) {
        switch (funcion) {
            case "ln":
                return OperacionAlgebraica.logaritmoNatural(numero);
            case "log":
                return OperacionAlgebraica.logaritmoBase10(numero);
            default:
                throw new IllegalArgumentException("Logaritmo no válido: " + funcion);
        }
    }

    private boolean esRaiz(String cadena) {
        return cadena.contains("√") || cadena.contains("R");
    }

    private double calcularRaiz(String funcion, double numero) {
    // Verificar si la función contiene el símbolo de raíz y un número como índice
    
    if (funcion.contains("√")) {
        // Obtener el índice después del símbolo de raíz (√)
        
        int indiceParentesis = funcion.indexOf('√');
        // Si hay más caracteres después del símbolo de raíz
        if (indiceParentesis > 0) {
            // Obtener el índice como un número después del símbolo de raíz
            double indice = Double.parseDouble(funcion.substring(0,indiceParentesis));
            // Calcular la raíz con el índice proporcionado
            return OperacionAlgebraica.raiz(numero, indice);
        }
    }
    // Si no hay un número después del símbolo de raíz, usar 2 como índice por defecto
    return OperacionAlgebraica.raiz(numero, 2);
}
}


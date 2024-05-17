package calculadora.model.calcularoperacion;

import calculadora.model.operacion.reales.OperacionAlgebraica;
import calculadora.model.operacion.reales.funcion.FuncionTrigonometrica;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class CalcularOperacion {
    private FuncionTrigonometrica funcionesTrigonometricas;

    // Constructor que recibe una instancia de FuncionTrigonometrica
    public CalcularOperacion(FuncionTrigonometrica funcionesTrigonometricas) {
        this.funcionesTrigonometricas = funcionesTrigonometricas;
    }
    
     private String resolverParentesis(String expresion) {
    // Buscar el primer par de paréntesis
    int inicioParentesis = expresion.indexOf("(");
    while (inicioParentesis != -1) {
        // Verificar si el paréntesis está precedido por una función trigonométrica o logaritmo
        int indicePrevio = inicioParentesis - 1;
        while (indicePrevio >= 0 && Character.isWhitespace(expresion.charAt(indicePrevio))) {
            indicePrevio--;
        }
        boolean esFuncion = false;
        if (indicePrevio >= 0) {
            int inicioFuncion = indicePrevio;
            while (inicioFuncion >= 0 && Character.isLetter(expresion.charAt(inicioFuncion))) {
                inicioFuncion--;
            }
            String posibleFuncion = expresion.substring(inicioFuncion + 1, inicioParentesis);
            esFuncion = esFuncionTrigonometrica(posibleFuncion) || esLogaritmo(posibleFuncion);
        }

        if (esFuncion) {
            // Encontrar el paréntesis correspondiente de cierre para la función trigonométrica o logaritmo
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
            inicioParentesis = expresion.indexOf("(", finParentesis); // Buscar el siguiente paréntesis de apertura
        } else {
            // Encontrar el paréntesis correspondiente de cierre y resolver la expresión dentro de los paréntesis
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
            // Resolver la expresión dentro de los paréntesis
            String expresionParentesis = expresion.substring(inicioParentesis + 1, finParentesis - 1);
            double resultadoParentesis = calcular(expresionParentesis);
            // Reemplazar la expresión entre paréntesis por su resultado
            expresion = expresion.substring(0, inicioParentesis) + resultadoParentesis + expresion.substring(finParentesis);
            // Buscar el siguiente paréntesis de apertura
            inicioParentesis = expresion.indexOf("(");
        }
    }
    return expresion;
}
    // Método para calcular una expresión matemática representada como cadena de texto
    public double calcular(String expresion) {
        // Reemplazar ',' por '.' para asegurar que los números tienen el formato correcto
        expresion = expresion.replace(",", ".");
        
        expresion = resolverParentesis(expresion);
        // Convertir la expresión en una serie de tokens
        String[] tokens = expresion.split(" ");
        
        if(tokens.length == 1){
            if(esFuncionTrigonometrica(tokens[0])){
                int indiceParentesis = tokens[0].indexOf('(');
                String funcion = tokens[0].substring(0, indiceParentesis);
                double angulo = Double.parseDouble(tokens[0].substring(indiceParentesis + 1, tokens[0].length() - 1)); // Obtener el ángulo de la función
                double resultado = calcularFuncionTrigonometrica(funcion, angulo); // Calcular el resultado
                tokens[0] = String.valueOf(resultado); // Reemplazar la función por su resultado   
            }
            if(esLogaritmo(tokens[0])){
                int indiceParentesis = tokens[0].indexOf('(');
                String funcion = tokens[0].substring(0, indiceParentesis);
                double numero = Double.parseDouble(tokens[0].substring(indiceParentesis + 1, tokens[0].length() - 1)); // Obtener el ángulo de la función
                double resultado = calcularLogaritmo(funcion, numero); // Calcular el resultado
                tokens[0] = String.valueOf(resultado);
                
            }
            return Double.parseDouble(tokens[0]);
            
        }
        
        // Procesar la expresión para reemplazar funciones trigonométricas por valores numéricos
        for (int i = 0; i < tokens.length; i++) {
            if (esFuncionTrigonometrica(tokens[i])) {
                int indiceParentesis = tokens[i].indexOf('(');
                String funcion = tokens[i].substring(0, indiceParentesis);
                double angulo = Double.parseDouble(tokens[i].substring(indiceParentesis + 1, tokens[i].length() - 1)); // Obtener el ángulo de la función
                double resultado = calcularFuncionTrigonometrica(funcion, angulo); // Calcular el resultado
                tokens[i] = String.valueOf(resultado); // Reemplazar la función por su resultado
                
            }
            if(esLogaritmo(tokens[i])){
                int indiceParentesis = tokens[i].indexOf('(');
                String funcion = tokens[i].substring(0, indiceParentesis);
                double numero = Double.parseDouble(tokens[i].substring(indiceParentesis + 1, tokens[i].length() - 1)); // Obtener el ángulo de la función
                double resultado = calcularLogaritmo(funcion, numero); // Calcular el resultado
                tokens[i] = String.valueOf(resultado);
                
            }
        }
        
        // Pila para operandos y operadores
        Stack<Double> operandos = new Stack<>();
        Stack<String> operadores = new Stack<>();
        
        for (String token : tokens) {
            // Si el token es un número, se apila en la pila de operandos
            if (esNumero(token)) {
                operandos.push(Double.parseDouble(token));
            } else if (token.equals("(")) {
                // Si el token es '(', se apila en la pila de operadores
                operadores.push(token);
            } else if (token.equals(")")) {
                // Si el token es ')', se resuelve la operación dentro del paréntesis
                while (!operadores.peek().equals("(")) {
                    resolverOperacion(operandos, operadores);
                }
                operadores.pop(); // Eliminar el '(' de la pila de operadores
            } else {
                // Si el token es un operador, se resuelven las operaciones pendientes de mayor prioridad
                while (!operadores.isEmpty() && prioridad(operadores.peek()) >= prioridad(token)) {
                    resolverOperacion(operandos, operadores);
                }
                operadores.push(token); // Se apila el operador actual
            }
        }
        
        // Se resuelven las operaciones restantes en las pilas
        while (!operadores.isEmpty()) {
            resolverOperacion(operandos, operadores);
        }
        
        // El resultado final es el único elemento en la pila de operandos
        double resultado = operandos.pop();
        // Redondear el resultado si contiene una secuencia repetida de 9
        resultado = redondearResultado(resultado);
        return resultado;
    }
    
    // Método para resolver una operación binaria
    private void resolverOperacion(Stack<Double> operandos, Stack<String> operadores) {
        double numero2 = operandos.pop();
        double numero1 = operandos.pop();
        String operador = operadores.pop();
        
        // Realizar la operación correspondiente y apilar el resultado
        switch (operador) {
            case "+":
                operandos.push(OperacionAlgebraica.suma(numero1, numero2));
                break;
            case "-":
                operandos.push(OperacionAlgebraica.resta(numero1, numero2));
                break;
            case "x": // Utilizar el operador "x" en lugar de "*"
                operandos.push(OperacionAlgebraica.multiplicacion(numero1, numero2));
                break;
            case "÷": // Utilizar el operador "÷" en lugar de "/"
                operandos.push(OperacionAlgebraica.division(numero1, numero2));
                break;
            case "^":
                operandos.push(OperacionAlgebraica.potencia(numero1, numero2));
                break;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }
    
    // Método para verificar si una cadena es un número
    private boolean esNumero(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    // Método para verificar si una cadena representa una función trigonométrica
    private boolean esFuncionTrigonometrica(String cadena) {
        return cadena.contains("sen") || cadena.contains("cos") || cadena.contains("tan") ||
               cadena.contains("cot") || cadena.contains("sec") || cadena.contains("csc") ||
               cadena.contains("arcSen") || cadena.contains("arcCos") || cadena.contains("arcTan");
    }
    
    // Método para calcular el resultado de una función trigonométrica con un ángulo dado
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
    // Método para obtener la prioridad de un operador
    private int prioridad(String operador) {
        switch (operador) {
            case "+":
            case "-":
                return 1;
            case "x":
            case "÷":
                return 2;
            case "^":
                return 3;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }
    private double redondearResultado(double resultado) {
        String resultadoStr = String.valueOf(resultado);
        // Si el resultado contiene una secuencia repetida de 9, redondearlo
        if (resultadoStr.matches(".*9999+.*")) {
            BigDecimal bd = new BigDecimal(resultado);
            bd = bd.setScale(1, RoundingMode.HALF_UP); // Redondear a una cifra decimal
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
}
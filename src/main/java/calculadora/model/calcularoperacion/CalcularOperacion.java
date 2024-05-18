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
                esFuncion = esFuncionTrigonometrica(posibleFuncion) || esLogaritmo(posibleFuncion);
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
            double resultadoParentesis = calcular(expresionParentesis);
            String resultadoParentesisStr = String.valueOf(resultadoParentesis);

            if (esFuncion) {
                expresion = expresion.substring(0, inicioParentesis + 1) + resultadoParentesisStr + expresion.substring(finParentesis - 1);
                inicioParentesis = expresion.indexOf("(", inicioParentesis + resultadoParentesisStr.length() + 1);
            } else {
                expresion = expresion.substring(0, inicioParentesis) + resultadoParentesisStr + expresion.substring(finParentesis);
                inicioParentesis = expresion.indexOf("(");
            }
        }
        return expresion;
    }

    public double calcular(String expresion) {
        expresion = expresion.replace(",", ".");
        System.out.println("Expresion: " + expresion);
        expresion = resolverParentesis(expresion);
        System.out.println("Expresion sin parentesis: " + expresion);
        String[] tokens = expresion.split(" ");

        if (tokens.length == 1) {
            if (esFuncionTrigonometrica(tokens[0])) {
                int indiceParentesis = tokens[0].indexOf('(');
                String funcion = tokens[0].substring(0, indiceParentesis);
                double angulo = Double.parseDouble(tokens[0].substring(indiceParentesis + 1, tokens[0].length() - 1));
                double resultado = calcularFuncionTrigonometrica(funcion, angulo);
                tokens[0] = String.valueOf(resultado);
            }
            if (esLogaritmo(tokens[0])) {
                int indiceParentesis = tokens[0].indexOf('(');
                String funcion = tokens[0].substring(0, indiceParentesis);
                double numero = Double.parseDouble(tokens[0].substring(indiceParentesis + 1, tokens[0].length() - 1));
                double resultado = calcularLogaritmo(funcion, numero);
                tokens[0] = String.valueOf(resultado);
            }
            return Double.parseDouble(tokens[0]);
        }

        for (int i = 0; i < tokens.length; i++) {
            System.out.println("Token: " + tokens[i]);
            if (esFuncionTrigonometrica(tokens[i])) {
                int indiceParentesis = tokens[i].indexOf('(');
                String funcion = tokens[i].substring(0, indiceParentesis);
                double angulo = Double.parseDouble(tokens[i].substring(indiceParentesis + 1, tokens[i].length() - 1));
                double resultado = calcularFuncionTrigonometrica(funcion, angulo);
                tokens[i] = String.valueOf(resultado);
            }
            if (esLogaritmo(tokens[i])) {
                int indiceParentesis = tokens[i].indexOf('(');
                String funcion = tokens[i].substring(0, indiceParentesis);
                double numero = Double.parseDouble(tokens[i].substring(indiceParentesis + 1, tokens[i].length() - 1));
                double resultado = calcularLogaritmo(funcion, numero);
                tokens[i] = String.valueOf(resultado);
            }
        }

        Stack<Double> operandos = new Stack<>();
        Stack<String> operadores = new Stack<>();

        for (String token : tokens) {
            if (esNumero(token)) {
                operandos.push(Double.parseDouble(token));
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

        double resultado = operandos.pop();
        resultado = redondearResultado(resultado);
        return resultado;
    }

    private void resolverOperacion(Stack<Double> operandos, Stack<String> operadores) {
        double numero2 = operandos.pop();
        double numero1 = operandos.pop();
        String operador = operadores.pop();

        switch (operador) {
            case "+":
                operandos.push(OperacionAlgebraica.suma(numero1, numero2));
                break;
            case "-":
                operandos.push(OperacionAlgebraica.resta(numero1, numero2));
                break;
            case "x":
                operandos.push(OperacionAlgebraica.multiplicacion(numero1, numero2));
                break;
            case "÷":
                operandos.push(OperacionAlgebraica.division(numero1, numero2));
                break;
            case "^":
                operandos.push(OperacionAlgebraica.potencia(numero1, numero2));
                break;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }

    private boolean esNumero(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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
}



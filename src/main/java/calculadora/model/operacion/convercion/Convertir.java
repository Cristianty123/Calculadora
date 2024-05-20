package calculadora.model.operacion.convercion;

public class Convertir {

    private static final String PATTERN_BINARY = "[01]+";
    private static final String PATTERN_OCTAL = "[0-7]+";
    private static final String PATTERN_DECIMAL = "[0-9]+";
    private static final String PATTERN_HEXADECIMAL = "[0-9A-Fa-f]+";

    public String toDecimal(String num) {
        try {
            if (num.matches(PATTERN_BINARY)) {
                return String.valueOf(Integer.parseInt(num, 2));
            } else if (num.matches(PATTERN_OCTAL)) {
                return String.valueOf(Integer.parseInt(num, 8));
            } else if (num.matches(PATTERN_DECIMAL)) {
                return num;
            } else if (num.matches(PATTERN_HEXADECIMAL)) {
                return String.valueOf(Integer.parseInt(num, 16));
            } else {
                return "Formato no válido";
            }
        } catch (NumberFormatException e) {
            return "Error de conversión";
        }
    }

    public String toHexadecimal(String num) {
        try {
            if (num.matches(PATTERN_BINARY)) {
                int decimal = Integer.parseInt(num, 2);
                return String.format("%x", decimal);
            } else if (num.matches(PATTERN_OCTAL)) {
                int decimal = Integer.parseInt(num, 8);
                return String.format("%x", decimal);
            } else if (num.matches(PATTERN_HEXADECIMAL)) {
                return num;
            } else {
                int decimal = Integer.parseInt(num);
                return String.format("%x", decimal);
            }
        } catch (NumberFormatException e) {
            return "Error de conversión";
        }
    }

    public String toOctal(String num) {
        try {
            if (num.matches(PATTERN_BINARY)) {
                int decimal = Integer.parseInt(num, 2);
                return String.format("%o", decimal);
            } else if (num.matches(PATTERN_OCTAL)) {
                return num;
            } else if (num.matches(PATTERN_HEXADECIMAL)) {
                int decimal = Integer.parseInt(num, 16);
                return String.format("%o", decimal);
            } else {
                int decimal = Integer.parseInt(num);
                return String.format("%o", decimal);
            }
        } catch (NumberFormatException e) {
            return "Error de conversión";
        }
    }

    public String toBinary(String num) {
        try {
            if (num.matches(PATTERN_BINARY)) {
                return num;
            } else if (num.matches(PATTERN_OCTAL)) {
                int decimal = Integer.parseInt(num, 8);
                return String.format("%32s", Integer.toBinaryString(decimal)).replace(' ', '0');
            } else if (num.matches(PATTERN_HEXADECIMAL)) {
                int decimal = Integer.parseInt(num, 16);
                return String.format("%32s", Integer.toBinaryString(decimal)).replace(' ', '0');
            } else {
                int decimal = Integer.parseInt(num);
                return String.format("%32s", Integer.toBinaryString(decimal)).replace(' ', '0');
            }
        } catch (NumberFormatException e) {
            return "Error de conversión";
        }
    }
    
    public String decimalToBinary(String num) {
        try {
            int decimal = Integer.parseInt(num);
            return String.format("%32s", Integer.toBinaryString(decimal)).replace(' ', '0');
        } catch (NumberFormatException e) {
            return "Error de conversión";
        }
    }

    public String decimalToOctal(String num) {
        try {
            int decimal = Integer.parseInt(num);
            return String.format("%o", decimal);
        } catch (NumberFormatException e) {
            return "Error de conversión";
        }
    }

    public String decimalToHexadecimal(String num) {
        try {
            int decimal = Integer.parseInt(num);
            return String.format("%x", decimal);
        } catch (NumberFormatException e) {
            return "Error de conversión";
        }
    }
    
}
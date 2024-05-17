package calculadora.model.operacion.complex;

public class OperacionCompleja {
    
    // Método para realizar la suma de dos números complejos
    public String suma(String n1, String n2) {
         // Convertir los Strings a enteros
    int num1 = Integer.parseInt(n1);
    int num2 = Integer.parseInt(n2);
    
    int sum = num1 + num2;
    
    return Integer.toString(sum);
    }

    // Método para realizar la resta de dos números complejos
    public String resta(String n1, String n2) {
          if (n2.length() > n1.length() || (n2.length() == n1.length() && n2.compareTo(n1) > 0)) {
        return "Error: n1 debe ser mayor o igual a n2";
    }

    StringBuilder result = new StringBuilder();
    int borrow = 0;
    int n1Length = n1.length();
    int n2Length = n2.length();

    for (int i = 0; i < n1Length; i++) {
        int digit1 = n1.charAt(n1Length - 1 - i) - '0';
        int digit2 = (i < n2Length) ? n2.charAt(n2Length - 1 - i) - '0' : 0;

        int diff = digit1 - digit2 - borrow;
        if (diff < 0) {
            diff += 10;
            borrow = 1;
        } else {
            borrow = 0;
        }
        result.append(diff);
    }

    while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
        result.deleteCharAt(result.length() - 1);
    }

    return result.reverse().toString();
}
    

    // Método para realizar la multiplicación de dos números complejos
    public String multiplicacion(String n1, String n2) {
       if (n1.equals("0") || n2.equals("0")) {
        return "0";
    }

    // Longitud de los números
    int len1 = n1.length();
    int len2 = n2.length();
    int[] result = new int[len1 + len2];

    // Multiplicar cada dígito de n1 con cada dígito de n2
    for (int i = len1 - 1; i >= 0; i--) {
        int digit1 = n1.charAt(i) - '0';
        for (int j = len2 - 1; j >= 0; j--) {
            int digit2 = n2.charAt(j) - '0';
            int product = digit1 * digit2;
            int posLow = i + j + 1;
            int posHigh = i + j;

            // Sumar el producto al resultado y manejar el acarreo
            int sum = product + result[posLow];
            result[posLow] = sum % 10;
            result[posHigh] += sum / 10;
        }
    }

    // Convertir el array de resultados a una cadena
    StringBuilder resultStr = new StringBuilder();
    for (int num : result) {
        // Evitar agregar ceros a la izquierda
        if (!(resultStr.length() == 0 && num == 0)) {
            resultStr.append(num);
        }
    }

    return resultStr.toString();
    }

    // Método para realizar la división de dos números complejos
      public String division(String n1, String n2) {
    try {
        // Convertir las cadenas a números
        double num1 = Double.parseDouble(n1);
        double num2 = Double.parseDouble(n2);

        // Verificar si el divisor es cero
        if (num2 == 0) {
            return "Error: División por cero";
        }

        // Realizar la división
        double result = num1 / num2;

        // Devolver el resultado como cadena
        return String.valueOf(result);
    } catch (NumberFormatException e) {
        // Capturar excepciones si las entradas no son números válidos
        return "Error: Entrada no válida";
    }
    }
    }  




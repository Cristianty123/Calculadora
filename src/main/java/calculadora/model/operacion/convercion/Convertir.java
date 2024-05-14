package calculadora.model.operacion.convercion;

public class Convertir {

    // Método para convertir un número decimal a binario
    public String decBin(String dec) {
        int decimal = Integer.parseInt(dec);
        return Integer.toBinaryString(decimal);
    }

    // Método para convertir un número decimal a hexadecimal
    public String decHex(String dec) {
        int decimal = Integer.parseInt(dec);
        return Integer.toHexString(decimal);
    }

    // Método para convertir un número decimal a octal
    public String decOct(String dec) {
        int decimal = Integer.parseInt(dec);
        return Integer.toOctalString(decimal);
    }

    // Método para convertir un número binario a decimal
    public String binDec(String bin) {
        return String.valueOf(Integer.parseInt(bin, 2));
    }

    // Método para convertir un número binario a hexadecimal
    public String binHex(String bin) {
        int decimal = Integer.parseInt(bin, 2);
        return Integer.toHexString(decimal);
    }

    // Método para convertir un número binario a octal
    public String binOct(String bin) {
        int decimal = Integer.parseInt(bin, 2);
        return Integer.toOctalString(decimal);
    }

    // Método para convertir un número hexadecimal a decimal
    public String hexDec(String hex) {
        return String.valueOf(Integer.parseInt(hex, 16));
    }

    // Método para convertir un número hexadecimal a binario
    public String hexBin(String hex) {
        int decimal = Integer.parseInt(hex, 16);
        return Integer.toBinaryString(decimal);
    }

    // Método para convertir un número hexadecimal a octal
    public String hexOct(String hex) {
        int decimal = Integer.parseInt(hex, 16);
        return Integer.toOctalString(decimal);
    }

    // Método para convertir un número octal a decimal
    public String octDec(String oct) {
        return String.valueOf(Integer.parseInt(oct, 8));
    }

    // Método para convertir un número octal a binario
    public String octBin(String oct) {
        int decimal = Integer.parseInt(oct, 8);
        return Integer.toBinaryString(decimal);
    }

    // Método para convertir un número octal a hexadecimal
    public String octHex(String oct) {
        int decimal = Integer.parseInt(oct, 8);
        return Integer.toHexString(decimal);
    }
}
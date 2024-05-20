/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora.model.operacion.convercion;

import java.math.BigInteger;

/**
 *
 * @author elpeo
 */
public class Suma {
    public static String sumaHexadecimal(String hex1, String hex2) {
        BigInteger num1 = new BigInteger(hex1, 16);
        BigInteger num2 = new BigInteger(hex2, 16);
        BigInteger resultado = num1.add(num2);
        return "Hexadecimal: " + resultado.toString(16).toUpperCase();
    }
    
    public static String sumaOctal(String octal1, String octal2) {
        BigInteger num1 = new BigInteger(octal1, 8);
        BigInteger num2 = new BigInteger(octal2, 8);
        BigInteger resultado = num1.add(num2);
        return "Octal: " + resultado.toString(8);
    }
    
    public static String sumaBinaria(String binario1, String binario2) {
        BigInteger num1 = new BigInteger(binario1, 2);
        BigInteger num2 = new BigInteger(binario2, 2);
        BigInteger resultado = num1.add(num2);
        return "Binario: " + resultado.toString(2);
    }
    
    public static String sumaDecimal(String decimal1, String decimal2) {
        BigInteger num1 = new BigInteger(decimal1);
        BigInteger num2 = new BigInteger(decimal2);
        BigInteger resultado = num1.add(num2);
        return "Decimal: " + resultado.toString();
    }
}

package calculadora.model.operacion.reales.funcion;

public class EncontrarCorte {
    
    public static String[] CalcularCorte(double a, double b, double c) {
        double discriminante = b * b - 4 * a * c;
        String[] resultado = new String[2];

        if (discriminante > 0) {
            resultado[0] = Double.toString((-b + Math.sqrt(discriminante)) / (2 * a));
            resultado[1] = Double.toString((-b - Math.sqrt(discriminante)) / (2 * a));
        } else if (discriminante == 0) {
            resultado[0] = Double.toString(-b / (2 * a));
            resultado[1] = Double.toString(-b / (2 * a));
        } else {
            double realPart = -b / (2 * a);
            double imagPart = Math.sqrt(-discriminante) / (2 * a);
            resultado[0] = realPart + " + " + imagPart + "i";
            resultado[1] = realPart + " - " + imagPart + "i";
        }
        if("-0.0".equals(resultado[0])){
            resultado[0] = "0" ;
        }
        if("-0.0".equals(resultado[1])){
            resultado[1] = "0" ;
        }
        
        return resultado;
    }
}
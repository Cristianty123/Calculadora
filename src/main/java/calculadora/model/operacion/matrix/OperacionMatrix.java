package calculadora.model.operacion.matrix;


public class OperacionMatrix {
    
    // Método para realizar la suma de dos matrices
    public float[][] suma(float[][] m1, float[][] m2) {
        //Verificar que las matrices sean del mismo tamaño
        if(m1.length != m2.length || m1[0].length != m2[0].length){
            throw new IllegalArgumentException("Las matrices deben tener el mismo tamaño para la suma");
        }
        
        float[][] resultado = new float[m1.length][m1[0].length];
        for(int i = 0; i < m1.length ; i++){
            for(int j = 0; j < m1[0].length; j++){
                resultado[i][j] = m1[i][j] + m2[i][j];   
            }
        }
        return resultado;
    }

    // Método para realizar la resta de dos matrices
    public float[][] resta(float[][] m1, float[][] m2) {
        //Verificar que las matrices sean del mismo tamaño
        if(m1.length != m2.length || m1[0].length != m2[0].length){
            throw new IllegalArgumentException("Las matrices deben tener el mismo tamaño para la suma");
        }
        
        float[][] resultado = new float[m1.length][m1[0].length];
        for(int i = 0; i < m1.length ; i++){
            for(int j = 0; j < m1[0].length; j++){
                resultado[i][j] = m1[i][j] - m2[i][j];   
            }
        }
        return resultado;
    }

    // Método para realizar la multiplicación de dos matrices
    public float[][] multiplicacion(float[][] m1, float[][] m2) {
        // Verificar si las matrices son compatibles para la multiplicación
        if (m1[0].length != m2.length) {
            throw new IllegalArgumentException("Las matrices no son compatibles para la multiplicación");
        }

        // Crear la matriz resultado
        float[][] resultado = new float[m1.length][m2[0].length];

        // Calcular el producto punto
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                float sum = 0;
                for (int k = 0; k < m1[0].length; k++) {
                    sum += m1[i][k] * m2[k][j];
                }
            resultado[i][j] = sum;
        }
    }
    return resultado;
}
    // Método para multiplicar una matriz por un escalar
    public float[][] multiplicacionEscalar(float[][] matriz, float escalar) {
        // Crear una nueva matriz para almacenar el resultado
        float[][] resultado = new float[matriz.length][matriz[0].length];
        
        // Iterar sobre la matriz original y multiplicar cada elemento por el escalar
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                resultado[i][j] = matriz[i][j] * escalar;
            }
        }
        
        return resultado;
    }
    
    // Método para dividir una matriz por un escalar
    public float[][] divisionEscalar(float[][] matriz, float escalar) {
        // Crear una nueva matriz para almacenar el resultado
        float[][] resultado = new float[matriz.length][matriz[0].length];
        
        // Iterar sobre la matriz original y dividir cada elemento por el escalar
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                resultado[i][j] = matriz[i][j] / escalar;
            }
        }
        
        return resultado;
    }
}


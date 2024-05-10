package testMatrix;

import calculadora.model.operacion.matrix.OperacionMatrix;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class TestOperacionMatrix {

    @Test
    public void testSuma() {
        OperacionMatrix operacionMatrix = new OperacionMatrix();
        float[][] matriz1 = {{1, 2}, {3, 4}};
        float[][] matriz2 = {{5, 6}, {7, 8}};
        float[][] resultadoEsperado = {{6, 8}, {10, 12}};
        float[][] resultadoCalculado = operacionMatrix.suma(matriz1, matriz2);
        assertArrayEquals(resultadoEsperado, resultadoCalculado);
    }

    @Test
    public void testResta() {
        OperacionMatrix operacionMatrix = new OperacionMatrix();
        float[][] matriz1 = {{1, 2}, {3, 4}};
        float[][] matriz2 = {{5, 6}, {7, 8}};
        float[][] resultadoEsperado = {{-4, -4}, {-4, -4}};
        float[][] resultadoCalculado = operacionMatrix.resta(matriz1, matriz2);
        assertArrayEquals(resultadoEsperado, resultadoCalculado);
    }

    @Test
    public void testMultiplicacion() {
        OperacionMatrix operacionMatrix = new OperacionMatrix();
        float[][] matriz1 = {{1, 2}, {3, 4}};
        float[][] matriz2 = {{5, 6}, {7, 8}};
        float[][] resultadoEsperado = {{19, 22}, {43, 50}};
        float[][] resultadoCalculado = operacionMatrix.multiplicacion(matriz1, matriz2);
        assertArrayEquals(resultadoEsperado, resultadoCalculado);
    }

    @Test
    public void testMultiplicacionEscalar() {
        OperacionMatrix operacionMatrix = new OperacionMatrix();
        float[][] matriz = {{1, 2}, {3, 4}};
        float escalar = 2;
        float[][] resultadoEsperado = {{2, 4}, {6, 8}};
        float[][] resultadoCalculado = operacionMatrix.multiplicacionEscalar(matriz, escalar);
        assertArrayEquals(resultadoEsperado, resultadoCalculado);
    }

    @Test
    public void testDivisionEscalar() {
        OperacionMatrix operacionMatrix = new OperacionMatrix();
        float[][] matriz = {{2, 4}, {6, 8}};
        float escalar = 2;
        float[][] resultadoEsperado = {{1, 2}, {3, 4}};
        float[][] resultadoCalculado = operacionMatrix.divisionEscalar(matriz, escalar);
        assertArrayEquals(resultadoEsperado, resultadoCalculado);
    }
    @Test
    public void testSumaMatricesTamanosDiferentes() {
        OperacionMatrix operacionMatrix = new OperacionMatrix();
        float[][] matriz1 = {{1, 2}, {3, 4}};
        float[][] matriz2 = {{5, 6}, {7, 8}, {9, 10}}; // Matriz con tamaño diferente
        assertThrows(IllegalArgumentException.class, () -> {
            operacionMatrix.suma(matriz1, matriz2);
        });
    }

    @Test
    public void testRestaMatricesTamanosDiferentes() {
        OperacionMatrix operacionMatrix = new OperacionMatrix();
        float[][] matriz1 = {{1, 2}, {3, 4}};
        float[][] matriz2 = {{5, 6}, {7, 8}, {9, 10}}; // Matriz con tamaño diferente
        assertThrows(IllegalArgumentException.class, () -> {
            operacionMatrix.resta(matriz1, matriz2);
        });
    }
    @Test
    public void testMultiplicacionMatricesTamanosIncompatibles() {
        OperacionMatrix operacionMatrix = new OperacionMatrix();
        float[][] matriz1 = {{1, 2}, {3, 4}};
        float[][] matriz2 = {{5, 6, 7}, {8, 9, 10},{10,11,12}}; // Matriz con tamaños incompatibles
        assertThrows(IllegalArgumentException.class, () -> {
            operacionMatrix.multiplicacion(matriz1, matriz2);
        });
    }
}
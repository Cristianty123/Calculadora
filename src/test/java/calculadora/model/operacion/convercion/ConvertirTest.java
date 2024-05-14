package calculadora.model.operacion.convercion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertirTest {
    private Convertir convertir = new Convertir();

    @Test
    void testBinDec() {
        assertEquals("10", convertir.binDec("1010"));
        assertEquals("255", convertir.binDec("11111111"));
        assertEquals("0", convertir.binDec("0"));
    }

    @Test
    void testBinHex() {
        assertEquals("a", convertir.binHex("1010"));
        assertEquals("ff", convertir.binHex("11111111"));
        assertEquals("0", convertir.binHex("0"));
    }

    @Test
    void testBinOct() {
        assertEquals("12", convertir.binOct("1010"));
        assertEquals("377", convertir.binOct("11111111"));
        assertEquals("0", convertir.binOct("0"));
    }

    @Test
    void testDecBin() {
        assertEquals("1010", convertir.decBin("10"));
        assertEquals("11111111", convertir.decBin("255"));
        assertEquals("0", convertir.decBin("0"));
    }

    @Test
    void testDecHex() {
        assertEquals("a", convertir.decHex("10"));
        assertEquals("ff", convertir.decHex("255"));
        assertEquals("0", convertir.decHex("0"));
    }

    @Test
    void testDecOct() {
        assertEquals("12", convertir.decOct("10"));
        assertEquals("377", convertir.decOct("255"));
        assertEquals("0", convertir.decOct("0"));
    }

    @Test
    void testHexBin() {
        assertEquals("1010", convertir.hexBin("a"));
        assertEquals("11111111", convertir.hexBin("ff"));
        assertEquals("0", convertir.hexBin("0"));
    }

    @Test
    void testHexDec() {
        assertEquals("10", convertir.hexDec("a"));
        assertEquals("255", convertir.hexDec("ff"));
        assertEquals("0", convertir.hexDec("0"));
    }

    @Test
    void testHexOct() {
        assertEquals("12", convertir.hexOct("a"));
        assertEquals("377", convertir.hexOct("ff"));
        assertEquals("0", convertir.hexOct("0"));
    }

    @Test
    void testOctBin() {
        assertEquals("1010", convertir.octBin("12"));
        assertEquals("11111111", convertir.octBin("377"));
        assertEquals("0", convertir.octBin("0"));
    }

    @Test
    void testOctDec() {
        assertEquals("10", convertir.octDec("12"));
        assertEquals("255", convertir.octDec("377"));
        assertEquals("0", convertir.octDec("0"));
    }

    @Test
    void testOctHex() {
        assertEquals("a", convertir.octHex("12"));
        assertEquals("ff", convertir.octHex("377"));
        assertEquals("0", convertir.octHex("0"));
    }
}
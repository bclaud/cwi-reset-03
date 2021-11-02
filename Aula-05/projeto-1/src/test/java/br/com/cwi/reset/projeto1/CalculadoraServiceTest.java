package br.com.cwi.reset.projeto1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraServiceTest {

    private CalculadoraService service = new CalculadoraService();

    @Test
    public void testMultiplicar() {
        // Arrange
        Double primeiroNumero = 2.0;
        Double segundoNumero = 5.0;
        Double expected = 10.0;

        // Action
        Double result = service.multiplicar(primeiroNumero, segundoNumero);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomarComDoisNumerosInteirosPositivos() {
        // Arrange
        Double primeiroNumero = 4.0;
        Double segundoNumero = 9.0;
        Double expected = 13.0;

        // Action
        Double result = service.somar(primeiroNumero, segundoNumero);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomarComUmInteiroEOutroNegativo() {
        // Arrange
        Double primeiroNumero = 10.0;
        Double segundoNumero = -9.0;
        Double expected = 1.0;

        // Action
        Double result = service.somar(primeiroNumero, segundoNumero);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomarComUmInteiroEOutroNegativoResultadoNegativo() {
        // Arrange
        Double primeiroNumero = 10.0;
        Double segundoNumero = -20.0;
        Double expected = -10.0;

        // Action
        Double result = service.somar(primeiroNumero, segundoNumero);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testDividirComNumeroSobreZero() {
        Double primeiroNumero = 10.0;
        double segundoNumero = 0.0;
        
        Assertions.assertThrows(ArithmeticException.class, () -> service.dividir(primeiroNumero, segundoNumero));
    }

}
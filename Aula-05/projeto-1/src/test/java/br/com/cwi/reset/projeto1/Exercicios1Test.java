package br.com.cwi.reset.projeto1;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercicios1Test {

    private Exercicios1 metodos = new Exercicios1();

    @Test
    public void somarList_SomandoListaCintoInteiros() {
        List<Integer> listaInteiros = Arrays.asList(1, 2, 3, 4, 5);
        Integer expected = 15;
        Integer actual = metodos.somarLista(listaInteiros);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void somarList_SomandoListaCintoInteirosSendoUmNegativo() {
        List<Integer> listaInteiros = Arrays.asList(1, 2, 3, 4, -5);
        Integer expected = 5;
        Integer actual = metodos.somarLista(listaInteiros);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void somarList_SomandoListaCintoInteirosSendoTresNegativo() {
        List<Integer> listaInteiros = Arrays.asList(-1, -2, 3, 4, -5);
        Integer expected = -1;
        Integer actual = metodos.somarLista(listaInteiros);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void somarList_SomandoListaCintoInteirosZero() {
        List<Integer> listaInteiros = Arrays.asList(0, 0, 0, 0, 0);
        Integer expected = 0;
        Integer actual = metodos.somarLista(listaInteiros);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void somarList_SomandoListaVazia() {
        List<Integer> listaInteiros = Arrays.asList();
        Integer expected = 0;
        Integer actual = metodos.somarLista(listaInteiros);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calcularMedia_calcularMediaListaCintoInteiros() {
        List<Integer> listaInteiros = Arrays.asList(1, 2, 3, 4, 5);
        Double expected = 3.0;
        Double actual = metodos.calcularMedia(listaInteiros);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calcularMedia_calcularMediaCintoInteirosSendoUmNegativo() {
        List<Integer> listaInteiros = Arrays.asList(1, 2, 3, 4, -5);
        Double expected = 1.0;
        Double actual = metodos.calcularMedia(listaInteiros);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calcularMedia_calcularMediaCintoInteirosSendoTresNegativo() {
        List<Integer> listaInteiros = Arrays.asList(-1, -2, 3, 4, -5);
        double expected = -0.2;
        double actual = metodos.calcularMedia(listaInteiros);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calcularMedia_calcularMediaCintoInteirosZero() {
        List<Integer> listaInteiros = Arrays.asList(0, 0, 0, 0, 0);
        Double expected = 0.0;
        Double actual = metodos.calcularMedia(listaInteiros);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calcularMedia_calcularMediaVazia() {
        List<Integer> listaInteiros = Arrays.asList();
        Double actual = metodos.calcularMedia(listaInteiros);

        Assertions.assertNull(actual);
    }

    @Test
    void obterPalavraInvertida_QuandoAbacate() {
        String palavra = "Abacate";
        String expected = "etacabA";
        String actual = metodos.obterPalavraInvertida(palavra);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void obterPalavraInvertida_QuandoBanana() {
        String palavra = "Banana";
        String expected = "ananaB";
        String actual = metodos.obterPalavraInvertida(palavra);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void obterPalavraInvertida_QuandoPessego() {
        String palavra = "Pessego";
        String expected = "ogesseP";
        String actual = metodos.obterPalavraInvertida(palavra);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void obterPalavraInvertida_QuandoMorango() {
        String palavra = "Morango";
        String expected = "ognaroM";
        String actual = metodos.obterPalavraInvertida(palavra);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void ordenarLista_NumerosInteirosComNegativos() {
        List<Integer> lista = Arrays.asList(5, 11, 1, 90, 111, -1);
        List<Integer> expected = Arrays.asList(-1, 1, 5, 11, 90, 111);
        List<Integer> actual = metodos.ordenarLista(lista);
        Assertions.assertEquals(expected, actual);
    }

}

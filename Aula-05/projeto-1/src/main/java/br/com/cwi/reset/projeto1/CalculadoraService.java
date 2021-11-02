package br.com.cwi.reset.projeto1;

import java.util.Scanner;

public class CalculadoraService {

    public Double multiplicar(Double primeiroNumero, Double segundoNumero) {
        return primeiroNumero * segundoNumero;
    }

    public Double somar(Double primeiroNumero, Double segundoNumero) {
        return primeiroNumero + segundoNumero;
    }

    public Double subtrair(Double primeiroNumero, Double segundoNumero) {
        return primeiroNumero - segundoNumero;
    }

    public Double dividir(Double primeiroNumero, Double segundoNumero) {
        if (segundoNumero == 0) {
            throw new ArithmeticException();
        }
        return primeiroNumero / segundoNumero;
    }

    public Double multiplicarUsandoTeclado() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro numero: ");
        Double numeroUm = scanner.nextDouble();
        System.out.println("Digite o segundo numero: ");
        Double numeroDois = scanner.nextDouble();
        return numeroUm * numeroDois;
    }
}

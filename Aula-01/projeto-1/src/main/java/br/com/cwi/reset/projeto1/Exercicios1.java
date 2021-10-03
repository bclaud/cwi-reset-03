package br.com.cwi.reset.projeto1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercicios1 {

    public Integer somarLista(List<Integer> numeros) {
        Integer soma = 0;
        for(Integer numero : numeros){
            soma += numero;
        }
        return soma;
    }

    public Double calcularMedia(List<Integer> numeros) {
        Integer soma = somarLista(numeros);
        Double media = (double) soma / (double) numeros.size();

        return media;
    }

    public Integer obterMaiorNumero(List<Integer> numeros) {
        Integer maior = Integer.MIN_VALUE;

        for(Integer numero : numeros){
            if(numero > maior){
                maior = numero;
            }
        }

        return maior;
    }

    public String obterPalavraInvertida(String palavra) {

        String invertido = "";

        for(int i = palavra.length()-1; i >= 0; i--){
            invertido += palavra.charAt(i);
        }

        return invertido;
    }

    public List<Integer> ordenarLista(List<Integer> numeros) {
        List<Integer> listaOrdenada = new ArrayList<>();
        Integer aux = 0;

        for(Integer numero : numeros) {
            listaOrdenada.add(numero);
        }

        for(int i = 0; i < listaOrdenada.size(); i++){
            for(int j = i+1; j < listaOrdenada.size(); j++){
                if(listaOrdenada.get(j) < listaOrdenada.get(i)){
                    aux = listaOrdenada.get(j);

                    listaOrdenada.set(j, listaOrdenada.get(i));
                    listaOrdenada.set(i, aux);
                }
            }
        }

        return listaOrdenada;
    }
}


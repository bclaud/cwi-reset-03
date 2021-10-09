package com.bclaud.filme.model;

import com.bclaud.filme.exceptions.AvaliacaoForaDoPadraoException;

public class Filme {
    private String nome;
    private String descricao;
    private Integer duracaoEmMinutos;
    private Integer anoDeLancamento;
    private Double avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, Integer duracaoEmMinutos,Integer anoDeLancamento,Double avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.anoDeLancamento = anoDeLancamento;
        this.avaliacao = validarAvaliacaoFilme(avaliacao);
        this.diretor = diretor;
    }

    public Double validarAvaliacaoFilme(Double avaliacao){
        double notaMinima = 1.00;
        double notaMaxima = 5.00;
        if(avaliacao >= notaMinima && avaliacao <= notaMaxima){
            return avaliacao;
        }

        throw new AvaliacaoForaDoPadraoException();
    }

    public void reproduzir(){
        System.out.printf("Reproduzindo %n Filme: %s %n Descrição: %s %n Duração: %dmin. %n Diretor: %s %n", nome, descricao, duracaoEmMinutos, diretor.getNome());
    }

}

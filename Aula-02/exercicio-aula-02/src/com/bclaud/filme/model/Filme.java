package com.bclaud.filme.model;

public class Filme {
    private String nome;
    private String descricao;
    private Integer duracaoEmMinutos;
    private Integer anoDeLancamento;
    private Integer avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, Integer duracaoEmMinutos,Integer anoDeLancamento, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.anoDeLancamento = anoDeLancamento;
        this.diretor = diretor;
    }

    public void reproduzir(){
        System.out.printf("Reproduzindo %n Filme: %s %n Descrição: %s %n Duração: %dmin. %n Diretor: %s %n", nome, descricao, duracaoEmMinutos, diretor.getNome());
    }

}

package com.bclaud.filme.model;

import com.bclaud.filme.model.enuns.Genero;

public class Ator {
    
    private String nome;
    private Integer idade;
    private Integer qtdOscars;
    private Genero generoEnum;

    public Ator(String nome, Integer idade, Integer qtdOscars, Genero generoEnum ) {
        this.nome = nome;
        this.idade = idade;
        this.qtdOscars = qtdOscars;
        this.generoEnum = generoEnum;
    }

    public void imprimirInformacoes(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Ator [generoEnum=" + generoEnum.getDescricao() + ", idade=" + idade + ", nome=" + nome + "]";
    }
    
}

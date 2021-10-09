package com.bclaud.filme.model;

import com.bclaud.filme.enuns.Genero;

public abstract class Funcionario {
    private String nome;
    private Integer idade;
    private Genero generoEnum;

    protected Funcionario(String nome, Integer idade, Genero generoEnum) {
        this.nome = nome;
        this.idade = idade;
        this.generoEnum = generoEnum;
    }
    
    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public Integer getIdade() {
        return idade;
    }


    public void setIdade(Integer idade) {
        this.idade = idade;
    }


    public Genero getGeneroEnum() {
        return generoEnum;
    }


    public void setGeneroEnum(Genero generoEnum) {
        this.generoEnum = generoEnum;
    }


    public void imprimirInformacoes(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Diretor [generoEnum=" + generoEnum.getDescricao() + ", idade=" + idade + ", nome=" + nome + "]";
    }
}

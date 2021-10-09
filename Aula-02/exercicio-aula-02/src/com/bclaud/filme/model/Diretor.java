package com.bclaud.filme.model;

import com.bclaud.filme.model.enuns.Genero;

public class Diretor {
    private String nome;
    private Integer idade;
    private Integer qtdFilmesDirigidos;
    private Genero generoEnum;

    public Diretor(String nome, Integer idade, Integer qtdFilmesDirigidos, Genero generoEnum) {
        this.nome = nome;
        this.idade = idade;
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
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
    public Integer getQtdFilmesDirigidos() {
        return qtdFilmesDirigidos;
    }
    public void setQtdFilmesDirigidos(Integer qtdFilmesDirigidos) {
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }

    public void imprimirInformacoes(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Diretor [generoEnum=" + generoEnum.getDescricao() + ", idade=" + idade + ", nome=" + nome + "]";
    }
    
}

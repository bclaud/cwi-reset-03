package com.bclaud.filme.model;

public class Diretor {
    private String nome;
    private Integer idade;
    private Integer qtdFilmesDirigidos;

    public Diretor(String nome, Integer idade, Integer qtdFilmesDirigidos) {
        this.nome = nome;
        this.idade = idade;
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
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

    
}

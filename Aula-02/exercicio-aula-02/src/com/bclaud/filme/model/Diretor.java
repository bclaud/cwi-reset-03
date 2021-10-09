package com.bclaud.filme.model;

import com.bclaud.filme.enuns.Genero;

public class Diretor extends Funcionario {
    private Integer qtdFilmesDirigidos;

    public Diretor(String nome, Integer idade, Integer qtdFilmesDirigidos, Genero generoEnum) {
        super(nome, idade, generoEnum);
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }

    public Integer getQtdFilmesDirigidos() {
        return qtdFilmesDirigidos;
    }
    public void setQtdFilmesDirigidos(Integer qtdFilmesDirigidos) {
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }

}

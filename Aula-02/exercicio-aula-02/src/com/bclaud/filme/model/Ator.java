package com.bclaud.filme.model;

import com.bclaud.filme.enuns.Genero;

public class Ator extends Funcionario{
    
    private Integer qtdOscars;

    public Ator(String nome, String dataNascimento, Integer qtdOscars, Genero generoEnum ) {
        super(nome, dataNascimento, generoEnum);
        this.qtdOscars  = qtdOscars;
    }

    public Integer getQtdOscars() {
        return qtdOscars;
    }

    public void setQtdOscars(Integer qtdOscars) {
        this.qtdOscars = qtdOscars;
    }

    
}

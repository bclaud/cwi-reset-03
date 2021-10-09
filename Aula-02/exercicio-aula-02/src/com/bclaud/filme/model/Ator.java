package com.bclaud.filme.model;

import com.bclaud.filme.enuns.Genero;

public class Ator extends Funcionario{
    
    private Integer qtdOscars;

    public Ator(String nome, Integer idade, Integer qtdOscars, Genero generoEnum ) {
        super(nome, idade, generoEnum);
        this.qtdOscars  = qtdOscars;
    }

    public Integer getQtdOscars() {
        return qtdOscars;
    }

    public void setQtdOscars(Integer qtdOscars) {
        this.qtdOscars = qtdOscars;
    }

}

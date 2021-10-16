package br.com.cwi.reset.primeiroprojetospring.model;

import br.com.cwi.reset.primeiroprojetospring.enums.Genero;

public class Ator extends Funcionario{
    
    private Integer qtdOscars;

    public Ator(String nome, String dataNascimento, Integer qtdOscars, Genero generoEnum ) {
        super(nome, dataNascimento, generoEnum);
        this.qtdOscars  = qtdOscars;
    }

    public Ator(){
        super();
    }

    public Integer getQtdOscars() {
        return qtdOscars;
    }

    public void setQtdOscars(Integer qtdOscars) {
        this.qtdOscars = qtdOscars;
    }

    
}

package br.com.cwi.reset.primeiroprojetospring.model;

import br.com.cwi.reset.primeiroprojetospring.enums.Genero;

public class Diretor extends Funcionario {
    private Integer qtdFilmesDirigidos;

    public Diretor(String nome, String dataNascimento, Integer qtdFilmesDirigidos, Genero generoEnum) {
        super(nome, dataNascimento, generoEnum);
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }

    public Integer getQtdFilmesDirigidos() {
        return qtdFilmesDirigidos;
    }
    public void setQtdFilmesDirigidos(Integer qtdFilmesDirigidos) {
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }

}
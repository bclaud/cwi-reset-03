package br.com.cwi.reset.bclaud.apiresetflix.models;

import br.com.cwi.reset.bclaud.apiresetflix.enums.StatusAtividade;

public class Estudio {
    private Long id;
    private String nome;
    private String descricao;
    private StatusAtividade statusAtividade;
    
    public Estudio(Long id, String nome, String descricao, StatusAtividade statusAtividade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.statusAtividade = statusAtividade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusAtividade getStatusAtividade() {
        return statusAtividade;
    }

    public void setStatusAtividade(StatusAtividade statusAtividade) {
        this.statusAtividade = statusAtividade;
    }
}

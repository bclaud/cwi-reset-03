package br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels;

import java.time.LocalDate;

import br.com.cwi.reset.bclaud.apiresetflix.enums.StatusAtividade;

public class EstudioRequest {
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
    private StatusAtividade statusAtividade;

    public EstudioRequest() {
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
    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public StatusAtividade getStatusAtividade() {
        return statusAtividade;
    }
    public void setStatusAtividade(StatusAtividade statusAtividade) {
        this.statusAtividade = statusAtividade;
    }
    
}

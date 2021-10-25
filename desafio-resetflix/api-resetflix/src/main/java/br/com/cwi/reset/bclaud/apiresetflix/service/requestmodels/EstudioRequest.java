package br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import br.com.cwi.reset.bclaud.apiresetflix.enums.StatusAtividade;

public class EstudioRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo nome.")
    private String nome;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo descricao.")
    private String descricao;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo dataCriacao.")
    private LocalDate dataCriacao;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo statusAtividade.")
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

package br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels;

import javax.validation.constraints.NotNull;

import br.com.cwi.reset.bclaud.apiresetflix.enums.TipoAtuacao;

public class PersonagemRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo idAtor.")
    private Long idAtor;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo nomePersonagem.")
    private String nomePersonagem;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo descricaoPersonagem.")
    private String descricaoPersonagem;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo tipoAtuacao.")
    private TipoAtuacao tipoAtuacao;

    public PersonagemRequest() {
    }

    public Long getIdAtor() {
        return idAtor;
    }
    public void setIdAtor(Long atorId) {
        this.idAtor = atorId;
    }
    public String getNomePersonagem() {
        return nomePersonagem;
    }
    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }
    public String getDescricaoPersonagem() {
        return descricaoPersonagem;
    }
    public void setDescricaoPersonagem(String descricaoPersonagem) {
        this.descricaoPersonagem = descricaoPersonagem;
    }
    public TipoAtuacao getTipoAtuacao() {
        return tipoAtuacao;
    }
    public void setTipoAtuacao(TipoAtuacao tipoAtuacao) {
        this.tipoAtuacao = tipoAtuacao;
    }

}

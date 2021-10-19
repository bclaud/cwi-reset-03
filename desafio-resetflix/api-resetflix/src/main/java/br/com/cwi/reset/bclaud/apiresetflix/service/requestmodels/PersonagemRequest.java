package br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels;

import br.com.cwi.reset.bclaud.apiresetflix.enums.TipoAtuacao;

public class PersonagemRequest {
    private Long atorId;
    private String nomePersonagem;
    private String descricaoPersonagem;
    private TipoAtuacao tipoAtuacao;

    public PersonagemRequest() {
    }

    public Long getAtorId() {
        return atorId;
    }
    public void setAtorId(Long atorId) {
        this.atorId = atorId;
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

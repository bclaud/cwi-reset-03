package br.com.cwi.reset.bclaud.models;

import br.com.cwi.reset.bclaud.enums.TipoAtuacao;

public class PersonagemAtor {
    
    private Long id;
    private Ator ator;
    private String nomePersonagem;
    private TipoAtuacao tipoAtuacao;

    public PersonagemAtor(Long id, Ator ator, String nomePersonagem, TipoAtuacao tipoAtuacao) {
        this.id = id;
        this.ator = ator;
        this.nomePersonagem = nomePersonagem;
        this.tipoAtuacao = tipoAtuacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public TipoAtuacao getTipoAtuacao() {
        return tipoAtuacao;
    }

    public void setTipoAtuacao(TipoAtuacao tipoAtuacao) {
        this.tipoAtuacao = tipoAtuacao;
    }
}

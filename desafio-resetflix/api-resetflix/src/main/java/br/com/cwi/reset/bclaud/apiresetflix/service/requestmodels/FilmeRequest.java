package br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels;

import java.util.List;

import br.com.cwi.reset.bclaud.apiresetflix.enums.Genero;

public class FilmeRequest {

    private String nome;
    private Integer anoLancamento;
    private String capaFilme;
    private List<Genero> generos;
    private Long idDiretor;
    private Long idEstudio;
    private String resumo;
    private List<PersonagemRequest> personagens;

    public FilmeRequest(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getCapaFilme() {
        return capaFilme;
    }

    public void setCapaFilme(String capaFilme) {
        this.capaFilme = capaFilme;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public Long getIdDiretor() {
        return idDiretor;
    }

    public void setIdDiretor(Long diretorId) {
        this.idDiretor = diretorId;
    }

    public Long getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(Long estudioId) {
        this.idEstudio = estudioId;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public List<PersonagemRequest> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<PersonagemRequest> personagens) {
        this.personagens = personagens;
    }
}

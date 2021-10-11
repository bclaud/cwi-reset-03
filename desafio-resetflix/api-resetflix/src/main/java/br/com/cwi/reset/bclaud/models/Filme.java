package br.com.cwi.reset.bclaud.models;

import java.util.List;

import br.com.cwi.reset.bclaud.enums.Genero;

public class Filme {
    
    private Long id;
    private String nome;
    private String capaFilme;
    private List<Genero> generos;
    private Diretor diretor;
    private List<PersonagemAtor> personagens;
    private String resumo;

    public Filme(){

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

    public String getCapaFilme() {
        return capaFilme;
    }

    public void setCapaFilme(String capaFilme) {
        this.capaFilme = capaFilme;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public List<PersonagemAtor> getPersonagens() {
        return personagens;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    
}

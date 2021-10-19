package br.com.cwi.reset.bclaud.apiresetflix.service.responsemodels;

import java.time.LocalDate;

import br.com.cwi.reset.bclaud.apiresetflix.models.Ator;

public class AtorEmAtividade {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;

    public AtorEmAtividade(Ator ator){
        this.id = ator.getId();
        this.nome = ator.getNome();
        this.dataNascimento = ator.getDataNascimento();
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

package br.com.cwi.reset.bclaud.models;

import java.time.LocalDate;

public interface FuncionarioInterface {
    
    public Long getId();

    public void setId(Long id);

    public String getNome();

    public void setNome(String nome);

    public LocalDate getDataNascimento();

    public void setDataNascimento(LocalDate dataNascimento);

    public Integer getAnoInicioAtividade();

    public void setAnoInicioAtividade(Integer anoInicioAtividade);
}

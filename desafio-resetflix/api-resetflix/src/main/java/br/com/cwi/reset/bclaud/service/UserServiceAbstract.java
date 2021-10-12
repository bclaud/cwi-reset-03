package br.com.cwi.reset.bclaud.service;

import java.time.LocalDate;

import br.com.cwi.reset.bclaud.models.FuncionarioInterface;
import br.com.cwi.reset.bclaud.repositories.RepositoryInterface;

public abstract class UserServiceAbstract {
    
    RepositoryInterface repository;

    protected UserServiceAbstract(RepositoryInterface repository){
        this.repository = repository;
    }

    public boolean isDuplicated(FuncionarioInterface t){
        return repository.listarAtores().stream()
        .anyMatch(a -> a.getNome().equalsIgnoreCase(t.getNome()));
    }

    public boolean isValidBirthdate(FuncionarioInterface t){
        return t.getDataNascimento().isBefore(LocalDate.now());
    }

    public boolean isValidActivityStartdate(FuncionarioInterface t){
        return t.getAnoInicioAtividade() > t.getDataNascimento().getYear();
    }

    public boolean isValidName(FuncionarioInterface t){
        return t.getNome().contains(" ");
    }
}

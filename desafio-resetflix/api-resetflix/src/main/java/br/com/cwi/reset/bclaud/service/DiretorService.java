package br.com.cwi.reset.bclaud.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.com.cwi.reset.bclaud.models.Diretor;
import br.com.cwi.reset.bclaud.repositories.Repository;

public class DiretorService {
    Repository diretorRepository;

    public DiretorService(Repository diretorRepository){
        this.diretorRepository = diretorRepository;
    }

    public void cadastrarDiretor(Diretor diretor){
        //TODO custom exceptions
        diretor.setId(idGenerator());
        diretorRepository.salvarDiretor(diretor);
    }

    public List<Diretor> listarDiretores(String filtroNome){
        //TODO custom exceptions
        return diretorRepository.listarDiretores().stream()
        .filter(diretor -> diretor.getNome().toUpperCase().contains(filtroNome.toUpperCase()))
        .collect(Collectors.toList());
    }

    public List<Diretor> listarDiretores(){
        //TODO custom exceptions
        return diretorRepository.listarDiretores().stream()
        .collect(Collectors.toList());
    }

    public Diretor consultarDiretor(Long id){
        //TODO custom exceptions
        return diretorRepository.consultarDiretor(id).get();
    }

    public Long idGenerator(){
        return (long) diretorRepository.listarDiretores().size();
    }
}

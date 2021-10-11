package br.com.cwi.reset.bclaud.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cwi.reset.bclaud.models.Ator;
import br.com.cwi.reset.bclaud.repositories.Repository;

public class AtorService {
    
    private Repository atorRepository;

    public AtorService(Repository atorRepository){
        this.atorRepository = atorRepository;
    }

    public void criarAtor(Ator ator){
        ator.setId(idGenerator());
        atorRepository.salvarAtor(ator);
        //TODO adicionar as exceptions
    }

    public List<Ator> listarAtoresEmAtividade(){
        //TODO adicionar as exceptions
        return atorRepository.listarAtores().stream()
        .filter(ator -> ator.getStatusCarreira().toString().equals("EM_ATIVIDADE"))
        .collect(Collectors.toList());
    }

    public List<Ator> listarAtoresEmAtividade(String filtroNome){
        //TODO adicionar as exceptions
        return listarAtoresEmAtividade().stream()
        .filter(ator -> ator.getNome().toUpperCase().contains(filtroNome.toUpperCase()))
        .collect(Collectors.toList());
    }

    public Ator consultarAtor(Long id){
        //TODO adicionar as exceptions
        return atorRepository.consultarAtor(id).get();
    }

    public List<Ator> consultarAtores(){
        //TODO adicionar as expcetions
        return atorRepository.listarAtores();
    }

    public Long idGenerator(){
        return (long) atorRepository.listarAtores().size();
    }
}

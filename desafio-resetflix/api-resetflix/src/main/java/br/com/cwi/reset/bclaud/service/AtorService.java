package br.com.cwi.reset.bclaud.service;

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
    }    
    

    public Long idGenerator(){
        return (long) atorRepository.listarAtores().size();
    }
}

package br.com.cwi.reset.bclaud.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.cwi.reset.bclaud.exceptions.AtorExceptions;
import br.com.cwi.reset.bclaud.models.Ator;
import br.com.cwi.reset.bclaud.repositories.Repository;

public class AtorService {
    
    private Repository atorRepository;

    public AtorService(Repository atorRepository){
        this.atorRepository = atorRepository;
    }

    public void criarAtor(Ator ator) throws AtorExceptions {
        if(isDuplicated(ator)){
            throw new AtorExceptions("Já existe um ator cadastrado para o nome " + ator.getNome());
        }
        
        if(!isValidBirthdate(ator)){
            throw new AtorExceptions("Não é possível cadastrar atores não nascidos.");
        }

        if(!isValidActivityStartdate(ator)){
            throw new AtorExceptions("Ano de início de atividade inválido para o ator cadastrado.");
        }

        ator.setId(idGenerator());
        atorRepository.salvarAtor(ator);
        //TODO falta a exception de obrigatorio nome e sobre nome e de campos faltando
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

    public boolean isDuplicated(Ator ator){
        return atorRepository.listarAtores().stream()
        .anyMatch(a -> a.getNome().equalsIgnoreCase(ator.getNome()));
    }

    public boolean isValidBirthdate(Ator ator){
        return ator.getDataNascimento().isBefore(LocalDate.now());
    }

    public boolean isValidActivityStartdate(Ator ator){
        return ator.getAnoInicioAtividade() > ator.getDataNascimento().getYear();
    }

    public Long idGenerator(){
        return (long) atorRepository.listarAtores().size();
    }
}

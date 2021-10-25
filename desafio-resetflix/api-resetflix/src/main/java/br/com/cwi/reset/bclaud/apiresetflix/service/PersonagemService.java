package br.com.cwi.reset.bclaud.apiresetflix.service;

import javax.validation.Valid;

import br.com.cwi.reset.bclaud.apiresetflix.exceptions.CampoVazioException;
import br.com.cwi.reset.bclaud.apiresetflix.models.PersonagemAtor;
import br.com.cwi.reset.bclaud.apiresetflix.repositories.Repository;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.PersonagemRequest;

public class PersonagemService {
    public static PersonagemService personagemService = new PersonagemService(Repository.getInstance(), AtorService.getInstance());

    public static PersonagemService getInstance(){
        return personagemService;
    }

    private Repository personagemRepository;
    private AtorService atorService;

    public PersonagemService(Repository personagemRepository, AtorService atorService) {
        this.personagemRepository = personagemRepository;
        this.atorService = atorService;
    }

    public PersonagemAtor criarPersonagem(@Valid PersonagemRequest request) throws CampoVazioException {
        PersonagemAtor personagem = personagemRequestoToPersonagem(request);
        personagem.setId(idGenerator());

        personagemRepository.persistePersonagem(personagem);
        return personagem;
    }

    private PersonagemAtor personagemRequestoToPersonagem(PersonagemRequest request) {
        PersonagemAtor personagem = new PersonagemAtor();
        personagem.setNomePersonagem(request.getNomePersonagem());
        personagem.setAtor(atorService.consultarAtor(request.getIdAtor()));
        personagem.setTipoAtuacao(request.getTipoAtuacao());
        return personagem;
    }

    private Long idGenerator() {
        return (long) personagemRepository.recuperaPersonagens().size() + 1;
    }
}

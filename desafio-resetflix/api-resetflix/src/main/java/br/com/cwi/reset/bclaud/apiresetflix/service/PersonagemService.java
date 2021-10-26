package br.com.cwi.reset.bclaud.apiresetflix.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.reset.bclaud.apiresetflix.exceptions.CampoVazioException;
import br.com.cwi.reset.bclaud.apiresetflix.models.PersonagemAtor;
import br.com.cwi.reset.bclaud.apiresetflix.repositories.PersonagemAtorRepository;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.PersonagemRequest;

@Service
public class PersonagemService {

    @Autowired
    PersonagemAtorRepository personagemRepository;

    @Autowired
    AtorService atorService;

    public PersonagemAtor criarPersonagem(@Valid PersonagemRequest request) throws CampoVazioException {
        PersonagemAtor personagem = personagemRequestoToPersonagem(request);

        personagemRepository.save(personagem);
        return personagem;
    }

    private PersonagemAtor personagemRequestoToPersonagem(PersonagemRequest request) {
        PersonagemAtor personagem = new PersonagemAtor();
        personagem.setNomePersonagem(request.getNomePersonagem());
        personagem.setAtor(atorService.consultarAtor(request.getIdAtor()));
        personagem.setTipoAtuacao(request.getTipoAtuacao());
        return personagem;
    }
}

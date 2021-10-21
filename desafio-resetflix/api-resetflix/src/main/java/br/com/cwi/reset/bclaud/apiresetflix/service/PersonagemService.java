package br.com.cwi.reset.bclaud.apiresetflix.service;

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

    public PersonagemAtor criarPersonagem(PersonagemRequest request) throws CampoVazioException {
        String checkCampos = checkNullFields(request);
        if (checkCampos != null) {
            throw new CampoVazioException(checkCampos);
        }
        PersonagemAtor personagem = personagemRequestoToPersonagem(request);
        personagem.setId(idGenerator());

        personagemRepository.persistePersonagem(personagem);
        return personagem;
    }

    private String checkNullFields(PersonagemRequest request) {
        if (request.getNomePersonagem() == null)
            return "nome personagem";

        if (request.getIdAtor() == null)
            return "ator id";

        if (request.getDescricaoPersonagem() == null)
            return "descricao personagem";

        if (request.getTipoAtuacao() == null)
            return "tipo atuacao";

        return null;
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

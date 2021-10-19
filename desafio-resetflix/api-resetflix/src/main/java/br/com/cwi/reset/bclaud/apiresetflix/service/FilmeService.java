package br.com.cwi.reset.bclaud.apiresetflix.service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import br.com.cwi.reset.bclaud.apiresetflix.exceptions.CampoVazioException;
import br.com.cwi.reset.bclaud.apiresetflix.exceptions.FilmeExceptions;
import br.com.cwi.reset.bclaud.apiresetflix.models.Filme;
import br.com.cwi.reset.bclaud.apiresetflix.models.PersonagemAtor;
import br.com.cwi.reset.bclaud.apiresetflix.repositories.Repository;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.FilmeRequest;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.PersonagemRequest;

public class FilmeService {

    private Repository filmeRepository;
    private AtorService atorService;
    private DiretorService diretorService;
    private EstudioService estudioService;
    private PersonagemService personagemService;

    public FilmeService(Repository filmeRepository, AtorService atorService, DiretorService diretorService,
            EstudioService estudioService, PersonagemService personagemService) {
        this.filmeRepository = filmeRepository;
        this.atorService = atorService;
        this.diretorService = diretorService;
        this.estudioService = estudioService;
        this.personagemService = personagemService;
    }

    public void criarFilme(FilmeRequest request) {
        String checkCampos = checkNullFields(request);
        if (checkCampos != null) {
            throw new CampoVazioException(checkCampos);
        }
        if (isDuplicatedGenre(request)) {
            throw new FilmeExceptions("Não é permitido informar o mesmo gênero mais de uma vez para o mesmo filme.");
        }
        if (isDuplicatedByActorId(request)){
            throw new FilmeExceptions("Não é permitido informar o mesmo ator/personagem mais de uma vez para o mesmo filme.");
        }

        Filme filme = filmeRequestToFilme(request);
        filme.setId(idGenerator());
        filmeRepository.persisteFilme(filme);
    }

    public List<Filme> consultarFilmes(){
        if(filmeRepository.recuperaFilmes().isEmpty()){
            throw new FilmeExceptions("Nenhum filme cadastrado, favor cadastar filmes.");
        }
        return filmeRepository.recuperaFilmes();
    }

    private boolean isDuplicatedGenre(FilmeRequest request) {
        return request.getGeneros().stream().map(Enum::toString).distinct().count() < request.getGeneros().size();
    }

    private boolean isDuplicatedByActorId(FilmeRequest request) {
        return request.getPersonagens().stream().map(PersonagemRequest::getIdAtor).distinct().count() < request
                .getPersonagens().size();
    }

    private Filme filmeRequestToFilme(FilmeRequest request) {
        Filme filme = new Filme();
        filme.setNome(request.getNome());
        filme.setAnoLancamento(request.getAnoLancamento());
        filme.setCapaFilme(request.getCapaFilme());
        filme.setGeneros(request.getGeneros());
        filme.setDiretor(diretorService.consultarDiretor(request.getIdDiretor()));
        filme.setEstudio(estudioService.consultarEstudio(request.getIdEstudio()));
        List<PersonagemAtor> listaPersonagem = request.getPersonagens().stream()
                .map(p -> personagemService.criarPersonagem(p)).collect(Collectors.toList());
        filme.setPersonagens(listaPersonagem);
        filme.setResumo(request.getResumo());
        return filme;
    }

    private String checkNullFields(FilmeRequest request) {
        if (request.getNome() == null)
            return "nome";

        if (request.getAnoLancamento() == null)
            return "ano de lancamento";

        if (request.getCapaFilme() == null)
            return "capa filme";

        if (request.getGeneros() == null)
            return "lista de generos";

        if (request.getIdDiretor() == null)
            return "diretor id";

        if (request.getIdEstudio() == null)
            return "estudio id";

        if (request.getResumo() == null)
            return "resumo";

        if (request.getPersonagens() == null)
            return "personagens";

        return null;
    }

    private Long idGenerator() {
        return (long) filmeRepository.recuperaFilmes().size() + 1;
    }
}

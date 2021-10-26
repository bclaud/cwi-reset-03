package br.com.cwi.reset.bclaud.apiresetflix.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.reset.bclaud.apiresetflix.exceptions.FilmeExceptions;
import br.com.cwi.reset.bclaud.apiresetflix.models.Filme;
import br.com.cwi.reset.bclaud.apiresetflix.models.PersonagemAtor;
import br.com.cwi.reset.bclaud.apiresetflix.repositories.FilmeRepository;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.FilmeRequest;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.PersonagemRequest;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private DiretorService diretorService;
    @Autowired
    private EstudioService estudioService;
    @Autowired
    private PersonagemService personagemService;

    public void criarFilme(FilmeRequest request) {
        if (isDuplicatedGenre(request)) {
            throw new FilmeExceptions("Não é permitido informar o mesmo gênero mais de uma vez para o mesmo filme.");
        }
        if (isDuplicatedByActorIdAndActorName(request)) {
            throw new FilmeExceptions(
                    "Não é permitido informar o mesmo ator/personagem mais de uma vez para o mesmo filme.");
        }
        if (request.getGeneros().isEmpty()) {
            throw new FilmeExceptions("Deve ser informado pelo menos um gênero para o cadastro do filme.");
        }

        Filme filme = filmeRequestToFilme(request);
        filmeRepository.save(filme);
    }

    public List<Filme> consultarFilmes() {
        if (filmeRepository.findAll().isEmpty()) {
            throw new FilmeExceptions("Nenhum filme cadastrado, favor cadastar filmes.");
        }
        return filmeRepository.findAll();
    }

    public List<Filme> consultarFilmes(String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) {

        List<Filme> listaFiltrada = consultarFilmes().stream().filter(f -> !nomeFilme.equals("")
                && f.getNome().toUpperCase().contains(nomeFilme.toUpperCase())
                || !nomeDiretor.equals("") && f.getDiretor().getNome().toUpperCase().contains(nomeDiretor.toUpperCase())
                || !nomePersonagem.equals("") && f.getPersonagens().stream()
                        .anyMatch(p -> p.getNomePersonagem().toUpperCase().contains(nomePersonagem.toUpperCase()))
                || !nomePersonagem.equals("") && f.getPersonagens().stream()
                        .anyMatch(a -> a.getAtor().getNome().toUpperCase().contains(nomeAtor.toUpperCase())))
                .collect(Collectors.toList());

        if (listaFiltrada.isEmpty()) {
            throw new FilmeExceptions("Filme não encontrato com os filtros nomeFilme=" + nomeFilme + ", nomeDiretor="
                    + nomeDiretor + ", nomePersonagem=" + nomePersonagem + ", nomeAtor=" + nomeAtor
                    + ", favor informar outros filtros.");
        }

        return listaFiltrada;
    }

    private boolean isDuplicatedGenre(FilmeRequest request) {
        return request.getGeneros().stream().map(Enum::toString).distinct().count() < request.getGeneros().size();
    }

    private boolean isDuplicatedByActorIdAndActorName(FilmeRequest request) {
        return request.getPersonagens().stream().map(PersonagemRequest::getIdAtor).distinct().count() < request
                .getPersonagens().size()
                && request.getPersonagens().stream().map(PersonagemRequest::getNomePersonagem).distinct()
                        .count() < request.getPersonagens().size();
    }

    private Filme filmeRequestToFilme(FilmeRequest request) {
        Filme filme = new Filme();
        filme.setNome(request.getNome());
        filme.setAnoLancamento(request.getAnoLancamento());
        filme.setCapaFilme(request.getCapaFilme());
        filme.setGeneros(request.getGeneros());
        filme.setDiretor(diretorService.consultarDiretor(request.getIdDiretor()));
        filme.setEstudio(estudioService.consultarEstudio(request.getIdEstudio()));
        filme.setPersonagens(createCharacterByMovieRequest(request));
        filme.setResumo(request.getResumo());
        return filme;
    }

    private List<PersonagemAtor> createCharacterByMovieRequest(FilmeRequest request) {
        return request.getPersonagens().stream().map(p -> personagemService.criarPersonagem(p))
                .collect(Collectors.toList());
    }
}

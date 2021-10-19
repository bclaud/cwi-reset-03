package br.com.cwi.reset.bclaud.apiresetflix.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.cwi.reset.bclaud.apiresetflix.models.Ator;
import br.com.cwi.reset.bclaud.apiresetflix.models.Diretor;
import br.com.cwi.reset.bclaud.apiresetflix.models.Estudio;
import br.com.cwi.reset.bclaud.apiresetflix.models.Filme;
import br.com.cwi.reset.bclaud.apiresetflix.models.PersonagemAtor;

public class Repository {

    public static Repository repository = new Repository();

    public static Repository getInstance(){
        return repository;
    }

    private Repository(){
        
    }

    List<Ator> atores = new ArrayList<>();
    List<Diretor> diretores = new ArrayList<>();
    private List<Estudio> estudios = new ArrayList<>();
    private List<Filme> filmes = new ArrayList<>();
    private List<PersonagemAtor> personagens = new ArrayList<>();


    public void persisteAtor(Ator ator){
        atores.add(ator);
    }

    public List<Ator> recuperaAtores(){
        return atores;
    }

    public Optional<Ator> consultarAtor(Long id){
        return atores.stream()
        .filter(ator -> ator.getId().equals(id))
        .findFirst();
    }

    public void persisteDiretor(Diretor diretor){
        diretores.add(diretor);
    }

    public List<Diretor> recuperaDiretores(){
        return diretores;
    }

    public Optional<Diretor> consultarDiretor(Long id){
        return diretores.stream()
        .filter(ator -> ator.getId().equals(id))
        .findFirst();
    }
}

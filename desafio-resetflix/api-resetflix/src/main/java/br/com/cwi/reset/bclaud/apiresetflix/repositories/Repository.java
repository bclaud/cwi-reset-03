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

    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();
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

    public void persisteEstudio(Estudio estudio){
        estudios.add(estudio);
    }

    public List<Estudio> recuperaEstudios(){
        return estudios;
    }

    public Optional<Estudio> consultarEstudio(Long id){
        return estudios.stream()
        .filter(estudio -> estudio.getId().equals(id))
        .findFirst();
    }

    public void persisteFilme(Filme filme){
        filmes.add(filme);
    }

    public List<Filme> recuperaFilmes(){
        return filmes;
    }

    public Optional<Filme> consultarFilme(Long id){
        return filmes.stream()
        .filter(filme -> filme.getId().equals(id))
        .findFirst();
    }

    public void persistePersonagem(PersonagemAtor personagemAtor){
        personagens.add(personagemAtor);
    }

    public List<PersonagemAtor> recuperaPersonagens(){
        return personagens;
    }

    public Optional<PersonagemAtor> consultarPersonagemAtor(Long id){
        return personagens.stream()
        .filter(personagem -> personagem.getId().equals(id))
        .findFirst();
    }
}

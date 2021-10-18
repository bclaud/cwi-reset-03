package br.com.cwi.reset.bclaud.apiresetflix.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.cwi.reset.bclaud.apiresetflix.models.Ator;
import br.com.cwi.reset.bclaud.apiresetflix.models.Diretor;

public class Repository {

    List<Ator> listaDeAtores = new ArrayList<>();
    List<Diretor> listaDeDiretores = new ArrayList<>();


    public void salvarAtor(Ator ator){
        listaDeAtores.add(ator);
    }

    public List<Ator> listarAtores(){
        return listaDeAtores;
    }

    public Optional<Ator> consultarAtor(Long id){
        return listaDeAtores.stream()
        .filter(ator -> ator.getId().equals(id))
        .findFirst();
    }

    public void salvarDiretor(Diretor diretor){
        listaDeDiretores.add(diretor);
    }

    public List<Diretor> listarDiretores(){
        return listaDeDiretores;
    }

    public Optional<Diretor> consultarDiretor(Long id){
        return listaDeDiretores.stream()
        .filter(ator -> ator.getId().equals(id))
        .findFirst();
    }
}
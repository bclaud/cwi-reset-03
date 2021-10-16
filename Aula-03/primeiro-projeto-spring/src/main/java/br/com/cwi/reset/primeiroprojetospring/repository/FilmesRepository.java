package br.com.cwi.reset.primeiroprojetospring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.reset.primeiroprojetospring.model.Filme;

@Repository
public class FilmesRepository {
    private List<Filme> listaFilmes = new ArrayList<>();

    public FilmesRepository() {
    }

    public void addFilme(Filme filme){
        listaFilmes.add(filme);
    }

    public void removerFilme(Filme filme){
        listaFilmes.remove(filme);
    }

    public List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    public void setListaFilmes(List<Filme> listaFilmes) {
        listaFilmes = listaFilmes;
    }

    public void atualizarFilme(Filme filme){
        listaFilmes.add(filme);
    }
}

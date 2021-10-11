package br.com.cwi.reset.bclaud.service;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.reset.bclaud.models.Ator;

public class AtorService {
    
    List<Ator> listaDeAtores = new ArrayList<>();

    public void criarAtor(Ator ator){
        listaDeAtores.add(ator);
    }
}

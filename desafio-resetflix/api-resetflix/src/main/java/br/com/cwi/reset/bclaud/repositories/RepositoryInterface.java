package br.com.cwi.reset.bclaud.repositories;

import java.util.List;
import java.util.Optional;

import br.com.cwi.reset.bclaud.models.Ator;
import br.com.cwi.reset.bclaud.models.Diretor;

public interface RepositoryInterface {
    
    public void salvarAtor(Ator ator);

    public List<Ator> listarAtores();

    public Optional<Ator> consultarAtor(Long id);
    
    public void salvarDiretor(Diretor diretor);

    public List<Diretor> listarDiretores();
    
    public Optional<Diretor> consultarDiretor(Long id);
}

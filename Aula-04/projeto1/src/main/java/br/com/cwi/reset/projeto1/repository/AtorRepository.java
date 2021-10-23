package br.com.cwi.reset.projeto1.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cwi.reset.projeto1.domain.Ator;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Integer> {
    
    List<Ator> findAll();

    Ator findByNome(String nome);

    List<Ator> findByNumeroOscarsGreaterThanAndDataNascimentoAfter(Integer numeroOscars, LocalDate dataNascimento);
}

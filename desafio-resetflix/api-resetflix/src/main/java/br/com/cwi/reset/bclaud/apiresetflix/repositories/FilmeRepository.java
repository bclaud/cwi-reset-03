package br.com.cwi.reset.bclaud.apiresetflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cwi.reset.bclaud.apiresetflix.models.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    
}

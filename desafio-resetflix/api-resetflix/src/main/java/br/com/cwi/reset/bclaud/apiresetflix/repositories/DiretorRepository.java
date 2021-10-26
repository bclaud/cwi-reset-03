package br.com.cwi.reset.bclaud.apiresetflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cwi.reset.bclaud.apiresetflix.models.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Long> {
    
}

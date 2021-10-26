package br.com.cwi.reset.bclaud.apiresetflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cwi.reset.bclaud.apiresetflix.models.Estudio;

public interface EstudioRepository extends JpaRepository<Estudio, Long> {
    
}

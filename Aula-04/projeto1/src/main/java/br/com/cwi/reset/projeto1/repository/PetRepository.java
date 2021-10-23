package br.com.cwi.reset.projeto1.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cwi.reset.projeto1.domain.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {

    Pet findByNome(String nome);

    List<Pet> findAll();
}

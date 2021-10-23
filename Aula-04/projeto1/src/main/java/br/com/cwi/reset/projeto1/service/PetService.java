package br.com.cwi.reset.projeto1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetException;
import br.com.cwi.reset.projeto1.repository.PetRepository;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public List<Pet> getPet() {
        return repository.findAll();
    }

    public Pet getByNome(String nome) {
        Pet pet = repository.findByNome(nome);

        if (pet == null) {
            throw new PetException("Pet " + nome + " nao encontrado");
        }

        return pet;
    }

    public Pet cadastrarPet(Pet pet) {
        repository.save(pet);
        return pet;
    }

    public void atualizarPet(Pet pet) {
        repository.save(pet);
    }

    public void deletarPet(String nome) {
        repository.delete(getByNome(nome));
    }

}

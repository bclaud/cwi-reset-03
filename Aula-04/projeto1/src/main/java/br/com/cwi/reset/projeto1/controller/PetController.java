package br.com.cwi.reset.projeto1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.service.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping
    public List<Pet> getPet() {
        return service.getPet();
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Pet> getById(@PathVariable String nome) {
        return ResponseEntity.ok(service.getByNome(nome));
    }

    @PostMapping
    public Pet cadastrarPet(@RequestBody Pet pet) {
        return service.cadastrarPet(pet);
    }

    @PutMapping
    public void atualizarPet(@RequestBody Pet pet) {
        service.atualizarPet(pet);
    }

    @DeleteMapping("/{nome}")
    public void deletarPet(@PathVariable String nome) {
        service.deletarPet(nome);
    }
}

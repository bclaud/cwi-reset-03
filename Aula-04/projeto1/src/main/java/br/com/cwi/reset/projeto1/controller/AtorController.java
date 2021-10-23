package br.com.cwi.reset.projeto1.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.repository.AtorRepository;


@RestController
@RequestMapping("/ator")
public class AtorController {

    @Autowired
    private AtorRepository atorRepository;

    @PostMapping
    public void addAtor(@RequestBody Ator ator){
        atorRepository.save(ator);
    }
    
    @GetMapping
    public Ator buscarAtorPorNome(@RequestParam String nome) {
        return atorRepository.findByNome(nome);
    }

    @GetMapping("/filtro")
    public List<Ator> buscarAtorFiltro(@RequestParam int numeroOscars, Integer anoNascimento){
        LocalDate dataNascimento = LocalDate.of(anoNascimento, 1, 1);
        return atorRepository.findByNumeroOscarsGreaterThanAndDataNascimentoAfter(numeroOscars, dataNascimento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarAtor(@PathVariable Integer id){
        atorRepository.delete(atorRepository.findById(id).get());
        return ResponseEntity.ok().build();
    }

    
}

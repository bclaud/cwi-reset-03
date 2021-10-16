package br.com.cwi.reset.primeiroprojetospring.controller;

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

import br.com.cwi.reset.primeiroprojetospring.model.Filme;
import br.com.cwi.reset.primeiroprojetospring.repository.FilmesRepository;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    @Autowired
    FilmesRepository repository;
    
    @GetMapping
    public List<Filme> getFilme(){
        return repository.getListaFilmes();
    }

    @PostMapping
    public ResponseEntity<Filme> adicionarFilme(@RequestBody Filme dto){
        if(isDuplicated(dto)){
            return ResponseEntity.badRequest().build();
        }
        repository.addFilme(dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Filme> buscarPorNome(@PathVariable String nome){
        return ResponseEntity.ok(repository.getListaFilmes().stream().filter(f -> f.getNome().toLowerCase().contains(nome.toLowerCase()))
        .findFirst().get());
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<Filme> deletarPorNome(@PathVariable String nome){
        if(filtarPorNome(nome).equals(null)){
            return ResponseEntity.notFound().build();
        }
        repository.removerFilme(filtarPorNome(nome));
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Filme> atualizarPorNome(@RequestBody Filme filme){
        if(filtarPorNome(filme.getNome()).equals(null)){
            return ResponseEntity.notFound().build();
        }
        repository.removerFilme(filtarPorNome(filme.getNome()));
        repository.addFilme(filme);
        return ResponseEntity.ok().build();
    }

    private Filme filtarPorNome(String nome){
        return repository.getListaFilmes().stream().filter(f -> f.getNome().toLowerCase().contains(nome.toLowerCase())).findFirst().orElse(null);
    }

    private boolean isDuplicated(Filme filme){
        return repository.getListaFilmes().stream().anyMatch(f -> f.getNome().equals(filme.getNome()));
    }
}

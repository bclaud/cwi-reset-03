package br.com.cwi.reset.projeto1.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.reset.projeto1.domain.Filme;
import br.com.cwi.reset.projeto1.exception.FilmeJaExistenteException;
import br.com.cwi.reset.projeto1.exception.FilmeNaoExistenteException;
import br.com.cwi.reset.projeto1.service.FilmeService;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    
    
    private FilmeService filmeService = new FilmeService();

    @PostMapping
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody Filme filme) {
        try {
            Filme filmeSalvo = filmeService.salvar(filme);
            return ResponseEntity.ok(filmeSalvo);
        } catch (FilmeJaExistenteException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public List<Filme> consultarTodos() {
        return filmeService.listarTodos();
    }

    @GetMapping("/{nome}")
    public Filme buscarFilmePeloNome(@PathVariable String nome) {
        return filmeService.buscarPorNome(nome);
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<?> deletarFilme(@PathVariable String nome) {
        try {
            filmeService.deletar(nome);
            return ResponseEntity.ok().build();
        } catch (FilmeNaoExistenteException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Filme> atualizarFilme(@RequestBody Filme filme) {
        try {
            return ResponseEntity.ok(filmeService.atualizar(filme));
        } catch (FilmeNaoExistenteException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}

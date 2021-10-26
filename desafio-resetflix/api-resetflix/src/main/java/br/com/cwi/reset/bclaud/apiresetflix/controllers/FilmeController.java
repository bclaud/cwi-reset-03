package br.com.cwi.reset.bclaud.apiresetflix.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.reset.bclaud.apiresetflix.models.Filme;
import br.com.cwi.reset.bclaud.apiresetflix.service.FilmeService;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.FilmeRequest;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFilme(@RequestBody @Valid FilmeRequest filmeRequest) {
        filmeService.criarFilme(filmeRequest);
    }

    @GetMapping(params = { "nomeFilme", "nomeDiretor", "nomePersonagem", "nomeAtor" })
    @ResponseStatus(HttpStatus.OK)
    public List<Filme> consultarFilmes(@RequestParam String nomeFilme, @RequestParam String nomeDiretor,
            @RequestParam String nomePersonagem, @RequestParam String nomeAtor) {
        return filmeService.consultarFilmes(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Filme> consultarFilmes() {
        return filmeService.consultarFilmes();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removerFilme(@PathVariable Long id){
        filmeService.removerFilme(id);
    }
}

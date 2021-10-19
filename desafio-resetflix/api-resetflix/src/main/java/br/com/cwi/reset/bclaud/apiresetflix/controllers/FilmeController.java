package br.com.cwi.reset.bclaud.apiresetflix.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.reset.bclaud.apiresetflix.repositories.Repository;
import br.com.cwi.reset.bclaud.apiresetflix.service.AtorService;
import br.com.cwi.reset.bclaud.apiresetflix.service.DiretorService;
import br.com.cwi.reset.bclaud.apiresetflix.service.EstudioService;
import br.com.cwi.reset.bclaud.apiresetflix.service.FilmeService;
import br.com.cwi.reset.bclaud.apiresetflix.service.PersonagemService;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.FilmeRequest;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private FilmeService filmeService;
    private AtorService atorService;
    private DiretorService diretorService;
    private EstudioService estudioService;
    private PersonagemService personagemService;


    public FilmeController( AtorService atorService, DiretorService diretorService, EstudioService estudioService,
    PersonagemService personagemService){
        this.filmeService = new FilmeService(Repository.getInstance(), atorService, diretorService, estudioService, personagemService);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFilme(@RequestBody FilmeRequest filmeRequest) {
        filmeService.criarFilme(filmeRequest);
    }
}

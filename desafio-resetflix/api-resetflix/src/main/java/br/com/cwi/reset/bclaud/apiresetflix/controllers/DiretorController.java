package br.com.cwi.reset.bclaud.apiresetflix.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.reset.bclaud.apiresetflix.repositories.Repository;
import br.com.cwi.reset.bclaud.apiresetflix.service.DiretorService;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.DiretorRequest;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private DiretorService diretorService;

    public DiretorController(){
        this.diretorService = new DiretorService(Repository.getInstance());
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody DiretorRequest diretorRequest){
        diretorService.cadastrarDiretor(diretorRequest);
    }
}

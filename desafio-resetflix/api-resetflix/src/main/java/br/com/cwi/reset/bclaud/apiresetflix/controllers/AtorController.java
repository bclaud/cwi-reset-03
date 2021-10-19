package br.com.cwi.reset.bclaud.apiresetflix.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.reset.bclaud.apiresetflix.repositories.Repository;
import br.com.cwi.reset.bclaud.apiresetflix.service.AtorService;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.AtorRequest;
import br.com.cwi.reset.bclaud.apiresetflix.service.responsemodels.AtorEmAtividade;

@RestController
@RequestMapping("/atores")
public class AtorController {
    
    private AtorService atorService;

    public AtorController(){
        this.atorService = new AtorService(Repository.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody AtorRequest atorRequest){
        atorService.criarAtor(atorRequest);
    }

    @GetMapping("em_atividade")
    @ResponseStatus(HttpStatus.OK)
    public List<AtorEmAtividade> listarAtoresEmAtividade(){
        return atorService.listarAtoresEmAtividade();
    }


}

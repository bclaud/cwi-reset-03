package br.com.cwi.reset.bclaud.apiresetflix.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.reset.bclaud.apiresetflix.models.Ator;
import br.com.cwi.reset.bclaud.apiresetflix.service.AtorService;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.AtorRequest;
import br.com.cwi.reset.bclaud.apiresetflix.service.responsemodels.AtorEmAtividade;

@RestController
@RequestMapping("/atores")
public class AtorController {
    
    @Autowired
    private AtorService atorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody @Valid AtorRequest atorRequest){
        atorService.criarAtor(atorRequest);
    }

    @GetMapping(value = "em_atividade", params = {"filtroNome"})
    @ResponseStatus(HttpStatus.OK)
    public List<AtorEmAtividade> listarAtoresEmAtividade(@RequestParam String filtroNome){
        return atorService.listarAtoresEmAtividade(filtroNome);
    }

    @GetMapping(value = "em_atividade")
    @ResponseStatus(HttpStatus.OK)
    public List<AtorEmAtividade> listarAtoresEmAtividade(){
        return atorService.listarAtoresEmAtividade();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ator consultarAtor(@PathVariable Long id){
        return atorService.consultarAtor(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Ator> consultarAtores(){
        return atorService.consultarAtores();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarAtor(@PathVariable Long id, @RequestBody AtorRequest request){
        atorService.atualizarAtor(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removerAtor(@PathVariable Long id){
        atorService.removerAtor(id);
    }
}

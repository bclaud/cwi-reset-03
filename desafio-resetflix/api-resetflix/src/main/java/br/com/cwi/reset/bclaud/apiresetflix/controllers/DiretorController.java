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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.reset.bclaud.apiresetflix.models.Diretor;
import br.com.cwi.reset.bclaud.apiresetflix.service.DiretorService;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.DiretorRequest;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    @Autowired
    private DiretorService diretorService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody @Valid DiretorRequest diretorRequest){
        diretorService.cadastrarDiretor(diretorRequest);
    }

    @GetMapping(params = {"filtroNome"})
    @ResponseStatus(HttpStatus.OK)
    public List<Diretor> consultarDiretores(String filtroNome){
        return diretorService.listarDiretores(filtroNome);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Diretor> consultarDiretores(){
        return diretorService.listarDiretores();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Diretor consultarDiretor(@PathVariable Long id){
        return diretorService.consultarDiretor(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarAtor(@PathVariable Long id, @RequestBody DiretorRequest request){
        diretorService.atualizarDiretor(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removerDiretor(@PathVariable Long id){
        diretorService.removerDiretor(id);
    }
}


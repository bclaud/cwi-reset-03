package br.com.cwi.reset.bclaud.apiresetflix.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.reset.bclaud.apiresetflix.models.Estudio;
import br.com.cwi.reset.bclaud.apiresetflix.repositories.Repository;
import br.com.cwi.reset.bclaud.apiresetflix.service.EstudioService;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.EstudioRequest;

@RestController
@RequestMapping("estudios")
public class EstudioController {
    
    private EstudioService estudioService;

    public EstudioController(){
        this.estudioService = new EstudioService(Repository.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio(@RequestBody @Valid EstudioRequest request){
        estudioService.criarEstudio(request);
    }

    @GetMapping(params = {"filtroNome"})
    @ResponseStatus(HttpStatus.OK)
    public List<Estudio> consultarEstudios(@RequestParam String filtroNome){
        return estudioService.consultarEstudios(filtroNome);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Estudio> consultarEstudios(){
        return estudioService.consultarEstudios();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Estudio consultarEstudio(@PathVariable Long id){
        return estudioService.consultarEstudio(id);
    }
}

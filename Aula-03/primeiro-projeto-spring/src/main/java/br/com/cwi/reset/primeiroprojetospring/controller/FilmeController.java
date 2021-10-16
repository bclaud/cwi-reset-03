package br.com.cwi.reset.primeiroprojetospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.reset.primeiroprojetospring.enums.Genero;
import br.com.cwi.reset.primeiroprojetospring.model.Diretor;
import br.com.cwi.reset.primeiroprojetospring.model.Filme;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    
    @GetMapping
    public Filme getFilme(){
        return new Filme("Meu amigo totoro", "Tem um gatonibus maneirasso", 120, 2001, 5.00, new Diretor("Miyamoto", "1975-01-01", 21, Genero.MASCULINO));
    }
}

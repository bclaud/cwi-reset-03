package br.com.cwi.reset.projeto1.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ator")
public class Ator extends Pessoa {

    private Integer numeroOscars;

    public Integer getNumeroOscars() {
        return numeroOscars;
    }

    public void setNumeroOscars(Integer numeroOscars) {
        this.numeroOscars = numeroOscars;
    }

    public Ator(String nome, LocalDate nascimento, Integer numeroOscars, Genero genero) {
        super(nome, nascimento, genero);
        this.numeroOscars = numeroOscars;
    }

    public Ator() {
        super();
    }

}

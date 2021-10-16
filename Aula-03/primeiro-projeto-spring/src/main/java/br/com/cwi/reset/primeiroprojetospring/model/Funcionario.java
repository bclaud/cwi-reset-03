package br.com.cwi.reset.primeiroprojetospring.model;

import java.time.LocalDate;
import java.time.Period;

import br.com.cwi.reset.primeiroprojetospring.enums.Genero;

public abstract class Funcionario {
    private String nome;
    private LocalDate dataNascimento;
    private Genero generoEnum;
    
    protected Funcionario(String nome, String dataNascimento, Genero generoEnum) {
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento);
        this.generoEnum = generoEnum;
    }

    public Funcionario(){
        
    }
    
    public Integer calcularIdade(){
        
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
    
    public void imprimirInformacoes(){
        System.out.println(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setIdade(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Genero getGeneroEnum() {
        return generoEnum;
    }

    public void setGeneroEnum(Genero generoEnum) {
        this.generoEnum = generoEnum;
    }

    @Override
    public String toString() {
        return "Diretor [generoEnum=" + generoEnum.getDescricao() + ", idade=" + calcularIdade() + ", nome=" + nome + "]";
    }
}
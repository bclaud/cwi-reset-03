package br.com.cwi.reset.primeiroprojetospring.model;

import br.com.cwi.reset.primeiroprojetospring.exceptions.AvaliacaoForaDoPadraoException;

public class Filme {
    private String nome;
    private String descricao;
    private Integer duracaoEmMinutos;
    private Integer anoDeLancamento;
    private Double avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, Integer duracaoEmMinutos,Integer anoDeLancamento,Double avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.anoDeLancamento = anoDeLancamento;
        this.avaliacao = validarAvaliacaoFilme(avaliacao);
        this.diretor = diretor;
    }

    public Double validarAvaliacaoFilme(Double avaliacao){
        double notaMinima = 1.00;
        double notaMaxima = 5.00;
        if(avaliacao >= notaMinima && avaliacao <= notaMaxima){
            return avaliacao;
        }

        throw new AvaliacaoForaDoPadraoException();
    }

    public void reproduzir(){
        System.out.printf("Reproduzindo %n Filme: %s %n Descrição: %s %n Duração: %dmin. %n Diretor: %s %n", nome, descricao, duracaoEmMinutos, diretor.getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public Integer getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(Integer anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    
}

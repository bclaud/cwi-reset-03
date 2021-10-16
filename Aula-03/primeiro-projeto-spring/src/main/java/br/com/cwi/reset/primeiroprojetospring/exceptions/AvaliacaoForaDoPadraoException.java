package br.com.cwi.reset.primeiroprojetospring.exceptions;

public class AvaliacaoForaDoPadraoException extends RuntimeException {
    
    public AvaliacaoForaDoPadraoException(){
        super("A avaliação deve ser entre 1 e 5");
    }
}

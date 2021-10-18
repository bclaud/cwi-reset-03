package br.com.cwi.reset.bclaud.apiresetflix.exceptions;

public class CampoVazioException extends RuntimeException {
    
    public CampoVazioException(String campo){
        super("Campo obrigatório não informado. Favor informar o campo "+campo+".");
    }
}

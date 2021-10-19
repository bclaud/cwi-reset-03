package br.com.cwi.reset.bclaud.apiresetflix.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EstudioExceptions extends RuntimeException {
    
    public EstudioExceptions(String msg){
        super(msg);
    }
}

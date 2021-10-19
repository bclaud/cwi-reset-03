package br.com.cwi.reset.bclaud.apiresetflix.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FilmeExceptions extends RuntimeException {

    public FilmeExceptions(String msg) {
        super(msg);
    }
}

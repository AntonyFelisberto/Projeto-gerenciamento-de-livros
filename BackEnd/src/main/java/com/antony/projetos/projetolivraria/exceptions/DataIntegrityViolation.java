package com.antony.projetos.projetolivraria.exceptions;

public class DataIntegrityViolation extends RuntimeException{

    public DataIntegrityViolation(String message){
        super(message);
    }

    public DataIntegrityViolation(String message, Throwable cause){
        super(message, cause);
    }

}

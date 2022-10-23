package com.antony.projetos.projetolivraria.handler;

import com.antony.projetos.projetolivraria.exceptions.DataIntegrityViolation;
import com.antony.projetos.projetolivraria.exceptions.ObjectNotFound;
import com.antony.projetos.projetolivraria.models.StandardError;
import com.antony.projetos.projetolivraria.models.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFound.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFound exception) {
        StandardError error = new StandardError(System.currentTimeMillis(),
                                                HttpStatus.NOT_FOUND.value(),
                                                exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolation.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolation exception) {
        StandardError error = new StandardError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException exception){
        ValidationError erro = new ValidationError(System.currentTimeMillis(),
                                                HttpStatus.BAD_REQUEST.value(),
                                                "Erro na validação de Campos");
        for(FieldError erros: exception.getBindingResult().getFieldErrors()){
            erro.addErrors(erros.getField(),erros.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

}

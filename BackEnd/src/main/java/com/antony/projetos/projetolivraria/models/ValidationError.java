package com.antony.projetos.projetolivraria.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ValidationError extends StandardError{

    private List<FieldErrorMessage> errors = new ArrayList<>();

    public ValidationError() {
        super();
    }

    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public void addErrors(String error, String message) {
        this.errors.add(new FieldErrorMessage(error, message));
    }

}

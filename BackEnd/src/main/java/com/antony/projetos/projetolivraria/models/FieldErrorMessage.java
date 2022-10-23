package com.antony.projetos.projetolivraria.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldErrorMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fieldName;
    private String message;

}

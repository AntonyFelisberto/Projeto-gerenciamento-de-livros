package com.antony.projetos.projetolivraria.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    private Integer id;
    private String titulo;
    private String nomeAutor;
    private String texto;

    private Categoria categoria;
}

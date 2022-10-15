package com.antony.projetos.projetolivraria.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer livroId;
    private String titulo;
    private String nomeAutor;
    private String texto;

    @ManyToOne
    @JoinColumn(name = "categoriaId")
    private Categoria categoria;
}

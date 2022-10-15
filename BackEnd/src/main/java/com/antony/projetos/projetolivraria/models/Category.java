package com.antony.projetos.projetolivraria.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer categoriaId;
    private String name;
    private String description;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Books> books = new ArrayList<>();


    public Category(String nome, String descricao) {
        this.name = nome;
        this.description = descricao;
    }

}

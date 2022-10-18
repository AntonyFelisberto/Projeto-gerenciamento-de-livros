package com.antony.projetos.projetolivraria.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@Entity
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer categoryId;
    private String name;
    private String description;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Books> books = new ArrayList<>();


    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

}

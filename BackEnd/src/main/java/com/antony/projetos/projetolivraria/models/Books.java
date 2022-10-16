package com.antony.projetos.projetolivraria.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Books implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer livroId;
    private String title;
    private String authorName;
    private String text;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

}

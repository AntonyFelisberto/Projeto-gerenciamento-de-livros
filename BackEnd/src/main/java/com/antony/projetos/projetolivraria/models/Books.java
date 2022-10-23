package com.antony.projetos.projetolivraria.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer bookId;
    @NotEmpty(message = "Campo title é requerido")
    @Length(min = 3, max = 50, message = "Campo title precisa de pelo menos 3 caracteres e no maximo 50")
    private String title;
    @NotEmpty(message = "Campo nome autor é requerido")
    @Length(min = 3, max = 50, message = "Campo nome autor precisa de pelo menos 3 caracteres e no maximo 50")
    private String authorName;
    @Lob
    @NotEmpty(message = "Campo text é requerido")
    @Length(min = 10, max = 2000000000, message = "Campo text precisa de pelo menos 10 caracteres e no maximo 2000000000")
    private String text;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

}

package com.antony.projetos.projetolivraria.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Campo nome é requerido")
    @Length(min = 3, max = 100, message = "Campo nome precisa de pelo menos 3 caracteres e no maximo 100")
    private String name;
    @NotEmpty(message = "Campo description é requerido")
    @Length(min = 3, max = 200, message = "Campo description precisa de pelo menos 3 caracteres e no maximo 200")
    private String description;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Books> books = new ArrayList<>();


    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

}

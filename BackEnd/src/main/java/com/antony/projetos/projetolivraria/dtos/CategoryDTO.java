package com.antony.projetos.projetolivraria.dtos;


import com.antony.projetos.projetolivraria.models.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String description;

    public CategoryDTO(Category object) {
        super();
        this.id = object.getCategoryId();
        this.name = object.getName();
        this.description = object.getDescription();
    }

}

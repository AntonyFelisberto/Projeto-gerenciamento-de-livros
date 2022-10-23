package com.antony.projetos.projetolivraria.dtos;


import com.antony.projetos.projetolivraria.models.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Campo nome é requerido")
    @Length(min = 3, max = 100, message = "Campo nome precisa de pelo menos 3 caracteres e no maximo 100")
    private String name;
    @NotEmpty(message = "Campo description é requerido")
    @Length(min = 3, max = 200, message = "Campo description precisa de pelo menos 3 caracteres e no maximo 200")
    private String description;

    public CategoryDTO(Category object) {
        super();
        this.id = object.getCategoryId();
        this.name = object.getName();
        this.description = object.getDescription();
    }

}

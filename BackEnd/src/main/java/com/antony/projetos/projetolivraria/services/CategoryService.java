package com.antony.projetos.projetolivraria.services;

import com.antony.projetos.projetolivraria.exceptions.ObjectNotFound;
import com.antony.projetos.projetolivraria.models.Category;
import com.antony.projetos.projetolivraria.repository.CategoryRepositoy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepositoy categoryRepositoy;

    public Category findById(Integer categoryId) {
        Optional<Category> category = categoryRepositoy.findById(categoryId);
        return category.orElseThrow(() -> new ObjectNotFound(
                "Objeto não encontrado para o id: " + categoryId + ", Tipo: " + Category.class.getName())
        );
    }

}

package com.antony.projetos.projetolivraria.services;

import com.antony.projetos.projetolivraria.dtos.CategoryDTO;
import com.antony.projetos.projetolivraria.exceptions.ObjectNotFound;
import com.antony.projetos.projetolivraria.models.Category;
import com.antony.projetos.projetolivraria.repository.CategoryRepositoy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Category> findAll() {
        return categoryRepositoy.findAll();
    }

    public Category save(Category category) {
        category.setCategoryId(null);
        return categoryRepositoy.save(category);
    }

    public Category update(Integer categoryId, CategoryDTO categoryDto) {
        Category category = findById(categoryId);
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return categoryRepositoy.save(category);
    }
}

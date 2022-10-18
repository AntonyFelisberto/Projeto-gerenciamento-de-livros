package com.antony.projetos.projetolivraria.controller;

import com.antony.projetos.projetolivraria.dtos.CategoryDTO;
import com.antony.projetos.projetolivraria.models.Category;
import com.antony.projetos.projetolivraria.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoriesController {

    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<Category> category = categoryService.findAll();
        List<CategoryDTO> categoryDTOS = category.stream()
                                                .map(obj -> new CategoryDTO(obj))
                                                .collect(Collectors.toList());
        return ResponseEntity.ok().body(categoryDTOS);
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        category = categoryService.save(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                                            .path("/{id}")
                                            .buildAndExpand(category.getCategoryId())
                                            .toUri();

        return ResponseEntity.created(uri).body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Integer id, @RequestBody CategoryDTO categoryDto) {
        Category category = categoryService.update(id, categoryDto);
        return ResponseEntity.ok().body(new CategoryDTO(category));
    }

    @DeleteMapping("/{deleteId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer deleteId){
        categoryService.delete(deleteId);
        return ResponseEntity.noContent().build();
    }

}

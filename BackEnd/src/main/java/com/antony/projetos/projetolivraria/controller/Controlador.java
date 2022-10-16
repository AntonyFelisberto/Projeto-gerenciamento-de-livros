package com.antony.projetos.projetolivraria.controller;

import com.antony.projetos.projetolivraria.models.Category;
import com.antony.projetos.projetolivraria.repository.BookRepository;
import com.antony.projetos.projetolivraria.repository.CategoryRepositoy;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/categorias")
public class Controlador {

    private BookRepository bookRepository;

    private CategoryRepositoy categoryRepositoy;

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
    }
    
}

package com.antony.projetos.projetolivraria.services;

import com.antony.projetos.projetolivraria.exceptions.ObjectNotFound;
import com.antony.projetos.projetolivraria.models.Books;
import com.antony.projetos.projetolivraria.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;
    private CategoryService categoryService;

    public Books findById(Integer id) {
        Optional<Books> book = bookRepository.findById(id);
        return book.orElseThrow(() -> new ObjectNotFound(
                "Livro não encontrado id: " + id + ", Tipo" + bookRepository.getClass())
        );
    }

    public List<Books> findAll(Integer categoryId){
        categoryService.findById(categoryId);
        return bookRepository.findAllByCategory(categoryId);
    }

}

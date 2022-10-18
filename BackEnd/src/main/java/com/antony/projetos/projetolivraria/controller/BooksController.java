package com.antony.projetos.projetolivraria.controller;

import com.antony.projetos.projetolivraria.models.Books;
import com.antony.projetos.projetolivraria.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/book")
public class BooksController {

    private BookService bookService;

    @GetMapping("/{bookId}")
    public ResponseEntity<Books> findById(@PathVariable Integer bookId){
        Books book = bookService.findById(bookId);
        return ResponseEntity.ok().body(book);
    }

}

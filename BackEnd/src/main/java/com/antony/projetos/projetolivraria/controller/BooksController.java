package com.antony.projetos.projetolivraria.controller;

import com.antony.projetos.projetolivraria.dtos.BookDTO;
import com.antony.projetos.projetolivraria.models.Books;
import com.antony.projetos.projetolivraria.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    //TESTAR E FAZER BOOK WITH MAPPING findAll e update
    @GetMapping()
    public ResponseEntity<List<BookDTO>> findAll(@RequestParam(value = "category",defaultValue = "0")Integer id) {
        List<Books> list = bookService.findAll(id);
        List<BookDTO> bookDTO = list.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(bookDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Books> update(@PathVariable Integer id,@RequestBody Books books){
        Books book = bookService.update(id,books);
        return ResponseEntity.ok().body(book);
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<Books> updatePatch(@PathVariable Integer id,@RequestBody Books books){
        Books book = bookService.update(id,books);
        return ResponseEntity.ok().body(book);
    }
}

package com.antony.projetos.projetolivraria.controller;

import com.antony.projetos.projetolivraria.dtos.BookDTO;
import com.antony.projetos.projetolivraria.models.Books;
import com.antony.projetos.projetolivraria.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping       //Http:localhost:8080/book?category=id  -------- FORMATO URL SEM INSERÇÃO PADRÃO E REQUEST PARAM --------
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

    @PatchMapping ("/{idBook}")
    public ResponseEntity<Books> updatePatch(@PathVariable Integer idBook,@RequestBody Books books){
        Books book = bookService.update(idBook,books);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping    //Http:localhost:8080/book?category=id  -------- FORMATO URL SEM INSERÇÃO PADRÃO E REQUEST PARAM--------
    public ResponseEntity<Books> insert(@RequestParam(value = "category",defaultValue = "0")Integer idCategory,
                                        @RequestBody Books book){
        Books books = bookService.insert(idCategory,book);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/book/{id}").buildAndExpand(books.getBookId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

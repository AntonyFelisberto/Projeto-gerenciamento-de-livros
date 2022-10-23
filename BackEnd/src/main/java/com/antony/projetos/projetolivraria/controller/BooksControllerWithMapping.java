package com.antony.projetos.projetolivraria.controller;

import com.antony.projetos.projetolivraria.dtos.BookDTO;
import com.antony.projetos.projetolivraria.models.Books;
import com.antony.projetos.projetolivraria.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/book")
public class BooksControllerWithMapping {

    private BookService bookService;

    @GetMapping("/{idRequisition}")
    public ResponseEntity<Books> findById(@PathVariable Integer idRequisition){
        Books book = bookService.findById(idRequisition);
        return ResponseEntity.ok().body(book);
    }

    @GetMapping("/requisicao/{id}")
    public ResponseEntity<List<BookDTO>> findAll(@PathVariable Integer id) {
        List<Books> list = bookService.findAll(id);
        List<BookDTO> bookDTO = list.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(bookDTO);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Books> update(@PathVariable Integer id,@RequestBody Books books){
        Books book = bookService.update(id,books);
        return ResponseEntity.ok().body(book);
    }

    @PatchMapping ("/atualizarPatch/{id}")
    public ResponseEntity<Books> updatePatch(@PathVariable Integer id,@RequestBody Books books){
        Books book = bookService.update(id,books);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping("/adicionarSemCategoria")
    public ResponseEntity<Books> insertWithoutId(@RequestBody Books book) throws MalformedURLException, URISyntaxException {
        Books books = bookService.insert(book);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/book/{bookId}")
                .buildAndExpand(books.getBookId())
                .toUri();

        String formatarUri = uri.toString().replace("/adicionarSemCategoria", "");
        URL urlFormatarUriDeBusca = new URL(formatarUri);
        URI urlDeBusca = new URI(urlFormatarUriDeBusca.getProtocol(),
                urlFormatarUriDeBusca.getUserInfo(),
                urlFormatarUriDeBusca.getHost(),
                urlFormatarUriDeBusca.getPort(),
                urlFormatarUriDeBusca.getPath(),
                urlFormatarUriDeBusca.getQuery(),
                urlFormatarUriDeBusca.getRef()
        );

        return ResponseEntity.created(urlDeBusca).build();
    }

    @PostMapping("/adicionar/{idCategory}")
    public ResponseEntity<Books> insert(@PathVariable Integer idCategory,
                                        @RequestBody Books book) throws MalformedURLException, URISyntaxException {
        Books books = bookService.insert(idCategory,book);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/book/{bookId}")
                .buildAndExpand(books.getBookId())
                .toUri();

        String formatarUri = uri.toString().replace("/adicionar/{idCategory}", "");
        URL urlFormatarUriDeBusca = new URL(formatarUri);
        URI urlDeBusca = new URI(urlFormatarUriDeBusca.getProtocol(),
                urlFormatarUriDeBusca.getUserInfo(),
                urlFormatarUriDeBusca.getHost(),
                urlFormatarUriDeBusca.getPort(),
                urlFormatarUriDeBusca.getPath(),
                urlFormatarUriDeBusca.getQuery(),
                urlFormatarUriDeBusca.getRef()
        );

        return ResponseEntity.created(urlDeBusca).build();
    }

}

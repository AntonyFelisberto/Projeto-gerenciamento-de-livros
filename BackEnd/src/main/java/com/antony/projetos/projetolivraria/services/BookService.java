package com.antony.projetos.projetolivraria.services;

import com.antony.projetos.projetolivraria.exceptions.ObjectNotFound;
import com.antony.projetos.projetolivraria.models.Books;
import com.antony.projetos.projetolivraria.models.Category;
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
        return bookRepository.findByCategory(categoryId);
    }

    public Books update(Integer id, Books books) {
        Books bookAtualizar  = findById(id);
        Books bookAtualizado = updateBook(bookAtualizar,books);
        return bookRepository.save(bookAtualizado);
    }

    private Books updateBook(Books bookAtualizar, Books books) {
        bookAtualizar.setText(books.getText());
        bookAtualizar.setAuthorName(books.getAuthorName());
        bookAtualizar.setTitle(books.getTitle());
        return bookAtualizar;
    }

    public Books insert(Integer idCategory, Books book) {
        book.setBookId(null);
        Category category = categoryService.findById(idCategory);
        book.setCategory(category);
        return bookRepository.save(book);
    }

    public Books insert(Books book) {
        book.setBookId(null);
        book.setCategory(null);
        return bookRepository.save(book);
    }

}

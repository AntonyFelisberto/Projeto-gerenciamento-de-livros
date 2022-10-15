package com.antony.projetos.projetolivraria;

import com.antony.projetos.projetolivraria.models.Category;
import com.antony.projetos.projetolivraria.models.Books;
import com.antony.projetos.projetolivraria.repository.CategoriaRepositoy;
import com.antony.projetos.projetolivraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ProjetoLivrariaApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepositoy categoriaRepositoy;
    @Autowired
    private LivroRepository livroRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjetoLivrariaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category categoria = new Category("Informatica","Livros de TI");
        Books livro = new Books(null,"Cleans","Robertos ARKAS","Lorem ipsumlom",categoria);
        categoria.getBooks().addAll(Arrays.asList(livro));


        this.categoriaRepositoy.saveAll(Arrays.asList(categoria));
        this.livroRepository.saveAll(Arrays.asList(livro));
    }
}

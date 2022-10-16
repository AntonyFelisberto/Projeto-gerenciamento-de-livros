package com.antony.projetos.projetolivraria.services;

import com.antony.projetos.projetolivraria.models.Books;
import com.antony.projetos.projetolivraria.models.Category;
import com.antony.projetos.projetolivraria.repository.CategoriaRepositoy;
import com.antony.projetos.projetolivraria.repository.LivroRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
@AllArgsConstructor
public class Services{

    private CategoriaRepositoy categoriaRepositoy;

    private LivroRepository livroRepository;

    public void instanciaBaseDeDados(){
        Category categoria = new Category("Informatica","Livros de TI");
        Category categoriaDois = new Category("Medicina","Livros de Medicina");
        Category categoriaTres = new Category("Portugues","Livros de Didatica");

        Books livro = new Books(null,"Cleans","Robertos ARS","Lorem ipsumlom",categoria);
        Books livroDois = new Books(null,"Clans","Robertos AS","Lorem ipsumlom",categoria);
        Books livroTres = new Books(null,"Clean","Robertos KAS","Lorem ipsumlom",categoria);
        Books livroQuatro = new Books(null,"Ceans","Robertos ARK","Lorem ipsumlom",categoriaDois);
        Books livroCinco = new Books(null,"Clea","Robertos AKAS","Lorem ipsumlom",categoriaDois);
        Books livroSeis = new Books(null,"leans","Robertos ARKA","Lorem ipsumlom",categoriaDois);

        categoria.getBooks().addAll(Arrays.asList(livro,livroDois,livroTres));
        categoriaDois.getBooks().addAll(Arrays.asList(livroQuatro,livroCinco,livroSeis));

        this.categoriaRepositoy.saveAll(Arrays.asList(categoria,categoriaDois,categoriaTres));
        this.livroRepository.saveAll(Arrays.asList(livro,livroDois,livroTres,livroQuatro,livroCinco,livroSeis));
    }
}

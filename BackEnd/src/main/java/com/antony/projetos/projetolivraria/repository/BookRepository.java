package com.antony.projetos.projetolivraria.repository;

import com.antony.projetos.projetolivraria.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books,Integer> {
}

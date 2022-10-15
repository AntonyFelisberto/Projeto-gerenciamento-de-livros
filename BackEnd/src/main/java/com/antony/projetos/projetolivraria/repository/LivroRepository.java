package com.antony.projetos.projetolivraria.repository;

import com.antony.projetos.projetolivraria.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Integer> {
}

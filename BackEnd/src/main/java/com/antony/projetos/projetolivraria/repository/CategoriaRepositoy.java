package com.antony.projetos.projetolivraria.repository;

import com.antony.projetos.projetolivraria.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositoy extends JpaRepository<Category,Integer> {
}

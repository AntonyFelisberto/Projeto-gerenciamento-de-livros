package com.antony.projetos.projetolivraria.repository;

import com.antony.projetos.projetolivraria.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books,Integer> {
    @Query("SELECT obj FROM Books WHERE obj.categoryId = :categoryId ORDER BY title")
    List<Books> findAllByCategory(@Param(value =  "categoryId") Integer categoryId);
}

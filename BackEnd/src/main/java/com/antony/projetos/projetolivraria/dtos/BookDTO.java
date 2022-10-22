package com.antony.projetos.projetolivraria.dtos;

import com.antony.projetos.projetolivraria.models.Books;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class BookDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;

    public BookDTO() {
        super();
    }

    public BookDTO(Books books) {
        super();
        this.id = books.getBookId();
        this.title = books.getTitle();
    }

}

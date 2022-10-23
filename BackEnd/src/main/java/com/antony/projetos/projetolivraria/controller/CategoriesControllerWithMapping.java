package com.antony.projetos.projetolivraria.controller;

import com.antony.projetos.projetolivraria.dtos.CategoryDTO;
import com.antony.projetos.projetolivraria.models.Category;
import com.antony.projetos.projetolivraria.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoriesControllerWithMapping {

    private CategoryService categoryService;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<Category> category = categoryService.findAll();
        List<CategoryDTO> categoryDTOS = category.stream()
                                                .map(obj -> new CategoryDTO(obj))
                                                .collect(Collectors.toList());
        return ResponseEntity.ok().body(categoryDTOS);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category) throws MalformedURLException, URISyntaxException {
        category = categoryService.save(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                                            .path("/buscar/{id}")
                                            .buildAndExpand(category.getCategoryId())
                                            .toUri();

        String formatarUri = uri.toString().replace("/adicionar", "");
        URL urlFormatarUriDeBusca = new URL(formatarUri);
        URI urlDeBusca = new URI(urlFormatarUriDeBusca.getProtocol(),
                                urlFormatarUriDeBusca.getUserInfo(),
                                urlFormatarUriDeBusca.getHost(),
                                urlFormatarUriDeBusca.getPort(),
                                urlFormatarUriDeBusca.getPath(),
                                urlFormatarUriDeBusca.getQuery(),
                                urlFormatarUriDeBusca.getRef()
                            );

        return ResponseEntity.created(urlDeBusca).body(category);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Integer id,@Valid @RequestBody CategoryDTO categoryDto) {
        Category category = categoryService.update(id, categoryDto);
        return ResponseEntity.ok().body(new CategoryDTO(category));
    }

    @DeleteMapping("/delete/{deleteId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer deleteId){
        categoryService.delete(deleteId);
        return ResponseEntity.noContent().build();
    }

}

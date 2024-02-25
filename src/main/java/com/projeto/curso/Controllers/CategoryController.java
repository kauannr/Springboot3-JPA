package com.projeto.curso.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.curso.Services.CategoryService;
import com.projeto.curso.entities.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> listcCategories = categoryService.findAll();
        return ResponseEntity.ok().body(listcCategories);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Category> findById(@PathVariable long id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }
}

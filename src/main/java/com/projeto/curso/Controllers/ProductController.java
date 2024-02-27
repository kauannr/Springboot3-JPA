package com.projeto.curso.Controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.curso.Services.ProductService;
import com.projeto.curso.entities.Product;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    ResponseEntity<List<Product>> findAll(){
        List<Product> lispProducts = productService.findAll();
        return ResponseEntity.ok().body(lispProducts);
    }

    @GetMapping(value = "{id}")
    ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = productService.findbyId(id);
        return ResponseEntity.ok().body(obj);

    }
}

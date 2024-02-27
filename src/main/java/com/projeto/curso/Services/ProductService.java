package com.projeto.curso.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.curso.entities.Product;
import com.projeto.curso.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        List<Product> listProduct = productRepository.findAll();
        return listProduct;
    }

    public Product findbyId(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }
}

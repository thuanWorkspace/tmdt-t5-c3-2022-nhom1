package com.example.tmdtnhom1.service;

import com.example.tmdtnhom1.model.Product;
import com.example.tmdtnhom1.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	@Autowired
    ProductRepository productRepository;

    public Optional<Product> getById(String id_product) {
        return productRepository.findById(id_product);
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getByid(String id) {
        return productRepository.findById(id);
    }
}

package com.example.tmdtnhom1.repository;

import com.example.tmdtnhom1.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}

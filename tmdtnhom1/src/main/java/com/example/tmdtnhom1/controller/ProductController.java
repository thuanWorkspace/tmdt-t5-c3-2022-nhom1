package com.example.tmdtnhom1.controller;

import com.example.tmdtnhom1.model.Product;
import com.example.tmdtnhom1.model.User;
import com.example.tmdtnhom1.service.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * members must identify parameters, output response in order to use.
 * @author MyPC
 *
 */
@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/productapi")
public class ProductController {
	@Autowired
	ProductService productService;

	//phu
	//api: /products
	@GetMapping("/products")
	public ResponseEntity<List<Product>> listProducts() {
		try {
			List<Product> list = productService.getAllProducts();
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//phu
	//api: /product/{id}
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable String id) {
		try {
			Optional<Product> productData = productService.getByid(id);
			if (productData.isPresent()){
				Product product = productData.get();
				return new ResponseEntity<>(product,HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

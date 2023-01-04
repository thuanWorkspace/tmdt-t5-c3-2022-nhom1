package com.example.tmdtnhom1.controller;

import com.example.tmdtnhom1.model.Product;
import com.example.tmdtnhom1.model.UserProduct;
import com.example.tmdtnhom1.model.admin.Product_statictial;
import com.example.tmdtnhom1.service.ProductService;
import com.example.tmdtnhom1.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/adminapi")
public class AdminController {

    @Autowired
    ProductService productService;

    @Autowired
    UserProductService userProductService;

    //bao gom : ten product,so luong da ban,tong doanh thu
    @GetMapping("/statistical/products")
    public ResponseEntity<List<Product_statictial>> getProductstatictial(){
        try{
            List<Product> listproduct = productService.getAllProducts();
            List<Product_statictial> list = new ArrayList<>();
            List<UserProduct> listsaled = userProductService.finAll();

            for (Product p : listproduct){
                list.add(new Product_statictial(p.getProduct_name(),0,0));
            }

            for(Product_statictial p : list){
                for(UserProduct up : listsaled){
                    System.out.println(up.getId_product());
                    Product uproduct = productService.getById(up.getId_product()).get();
                    if (uproduct.getProduct_name().equals(p.getProduct_name())){
                        p.setSaled_count(p.getSaled_count() +1);
                        p.setIncome(p.getIncome() + uproduct.getPrice());
                    }
                }
            }

            return new ResponseEntity<List<Product_statictial>>(list, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

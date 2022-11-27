package com.example.tmdtnhom1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Product {
    @Id
    private String id;
    private int id_product;
    private String product_name;
    private double price;
    private int score;

    public Product(int id_product, String product_name, double price, int score) {
        this.id_product = id_product;
        this.product_name = product_name;
        this.price = price;
        this.score = score;
    }

    public Product() {
        super();
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_product=" + id_product +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                ", score=" + score +
                '}';
    }
}

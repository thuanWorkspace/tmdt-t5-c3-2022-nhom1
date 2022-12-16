package com.example.tmdtnhom1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Product")
public class Product {
    @Id
    private String id;
    private String product_name;
    private double storage;// = byte
    private double transfer;//= byte
    private int period ;//= hour

    private double price;
    private int score;



    public Product(String product_name, double storage, double transfer, int period, double price, int score) {
        this.product_name = product_name;
        this.storage = storage;
        this.transfer = transfer;
        this.period = period;
        this.price = price;
        this.score = score;
    }

    public Product() {
        super();
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

    public String getId() {
        return id;
    }

    public double getStorage() {
        return storage;
    }

    public void setStorage(double storage) {
        this.storage = storage;
    }

    public double getTransfer() {
        return transfer;
    }

    public void setTransfer(double transfer) {
        this.transfer = transfer;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", storage=" + storage +
                ", transfer=" + transfer +
                ", period=" + period +
                ", price=" + price +
                ", score=" + score +
                '}';
    }

}

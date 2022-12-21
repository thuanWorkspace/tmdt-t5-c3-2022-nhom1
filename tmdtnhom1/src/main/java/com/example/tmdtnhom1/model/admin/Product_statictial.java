package com.example.tmdtnhom1.model.admin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection = "Product_statictial")
public class Product_statictial {
//    @Id
    private String id;

    private String product_name;
    private int saled_count;
    private double income;

    public Product_statictial(String product_name, int saled_count, double income) {
        this.product_name = product_name;
        this.saled_count = saled_count;
        this.income = income;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setName(String name) {
        this.product_name = name;
    }

    public int getSaled_count() {
        return saled_count;
    }

    public void setSaled_count(int saled_count) {
        this.saled_count = saled_count;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}

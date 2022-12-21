package com.example.tmdtnhom1.model;

import com.example.tmdtnhom1.Utils.DateUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "UserProduct")
public class UserProduct {
    @Id
    private String id;
    private String id_user;
    private String id_product;
    private String purchase_date;
    private boolean available;

    public UserProduct() {
        super();
    }

    public UserProduct(String id_user, String id_product,boolean available, Date purchase_date) {
        super();
        this.id_user = id_user;
        this.id_product = id_product;
        this.available = available;
        setPurchase_date(purchase_date);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Date getPurchase_date() {
        return DateUtils.StringtoDate(purchase_date);
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = DateUtils.DatetoString(purchase_date);
    }

    @Override
    public String toString() {
        return "UserProduct{" +
                "id='" + id + '\'' +
                ", id_user='" + id_user + '\'' +
                ", id_product='" + id_product + '\'' +
                ", purchase_date='" + purchase_date + '\'' +
                '}';
    }
}

package com.example.tmdtnhom1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User_file")
public class User_file {
    @Id
    private String id;
    private String id_user;

    private String id_file;

    public User_file( String id_user, String id_file) {
        super();
        this.id_user = id_user;
        this.id_file = id_file;
    }

    public User_file() {
        super();
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

    public String getId_file() {
        return id_file;
    }

    public void setId_file(String id_file) {
        this.id_file = id_file;
    }

    @Override
    public String toString() {
        return "User_file{" +
                "id='" + id + '\'' +
                ", id_user='" + id_user + '\'' +
                ", id_file='" + id_file + '\'' +
                '}';
    }
}

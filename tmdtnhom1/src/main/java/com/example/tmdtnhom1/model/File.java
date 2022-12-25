package com.example.tmdtnhom1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "File")
public class File {
    @Id
    private String id;
    private String file_name;
    private String owner;
    private double size;


    public File(String name, String owner, double size) {
        this.file_name = name;
        this.owner = owner;
        this.size = size;
    }

    public File(String id, String file_name, String owner, double size) {
        this.id = id;
        this.file_name = file_name;
        this.owner = owner;
        this.size = size;
    }

    public File(String jsonFile){
        super();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }


    @Override
    public String toString() {
        return "File{" +
                "name='" + file_name + '\'' +
                ", owner='" + owner + '\'' +
                ", size=" + size +
                '}';
    }
}

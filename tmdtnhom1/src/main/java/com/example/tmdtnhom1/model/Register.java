package com.example.tmdtnhom1.model;

public class Register {
    private String username;
    private String email;
    private String password;
    private String gender;

    public Register(String username, String email, String password, String gender) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

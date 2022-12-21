package com.example.tmdtnhom1.model;

import java.util.Date;

public class TokenItem {
    private String role;
    private String sub;
    private long iat;
    private long exp;

    public TokenItem(String role, String sub, long iat, long exp) {
        this.role = role;
        this.sub = sub;
        this.iat = iat;
        this.exp = exp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }


    public long getIat() {
        return iat;
    }

    public void setIat(long iat) {
        this.iat = iat;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "TokenItem{" +
                "role='" + role + '\'' +
                ", sub='" + sub + '\'' +
                ", iat=" + iat +
                ", exp=" + exp +
                '}';
    }
}

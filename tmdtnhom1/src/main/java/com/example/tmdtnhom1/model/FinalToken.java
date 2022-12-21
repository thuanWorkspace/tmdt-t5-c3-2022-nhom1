package com.example.tmdtnhom1.model;

import java.util.Date;

public class FinalToken {
    private String idRole;
    private String idUser;
    private Date iat;
    private Date exp;

    public FinalToken(String idRole, String idUser, Date iat, Date exp) {
        this.idRole = idRole;
        this.idUser = idUser;
        this.iat = iat;
        this.exp = exp;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Date getIat() {
        return iat;
    }

    public void setIat(Date iat) {
        this.iat = iat;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }
}

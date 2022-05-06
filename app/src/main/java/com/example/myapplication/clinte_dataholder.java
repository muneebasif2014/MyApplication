package com.example.myapplication;

public class clinte_dataholder {
    String clinte_name,email_clinte,  clinte_number, clinte_add , clinte_city ,  clinte_remarks;

    public clinte_dataholder(String clinte_name, String email_clinte, String clinte_number, String clinte_add, String clinte_city, String clinte_remarks) {
        this.clinte_name = clinte_name;
        this.email_clinte = email_clinte;
        this.clinte_number = clinte_number;
        this.clinte_add = clinte_add;
        this.clinte_city = clinte_city;
        this.clinte_remarks = clinte_remarks;
    }

    public String getClinte_name() {
        return clinte_name;
    }

    public void setClinte_name(String clinte_name) {
        this.clinte_name = clinte_name;
    }

    public String getEmail_clinte() {
        return email_clinte;
    }

    public void setEmail_clinte(String email_clinte) {
        this.email_clinte = email_clinte;
    }

    public String getClinte_number() {
        return clinte_number;
    }

    public void setClinte_number(String clinte_number) {
        this.clinte_number = clinte_number;
    }

    public String getClinte_add() {
        return clinte_add;
    }

    public void setClinte_add(String clinte_add) {
        this.clinte_add = clinte_add;
    }

    public String getClinte_city() {
        return clinte_city;
    }

    public void setClinte_city(String clinte_city) {
        this.clinte_city = clinte_city;
    }

    public String getClinte_remarks() {
        return clinte_remarks;
    }

    public void setClinte_remarks(String clinte_remarks) {
        this.clinte_remarks = clinte_remarks;
    }
}

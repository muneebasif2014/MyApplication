package com.example.myapplication;

public class clinte_dataholder {
    String  clinte_add, clinte_city, clinte_number, clinte_email, clinte_remarks;

    public clinte_dataholder(String clinte_add, String clinte_city, String clinte_number, String clinte_email, String clinte_remarks) {
        this.clinte_add = clinte_add;
        this.clinte_city = clinte_city;
        this.clinte_number = clinte_number;
        this.clinte_email = clinte_email;
        this.clinte_remarks = clinte_remarks;
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

    public String getClinte_number() {
        return clinte_number;
    }

    public void setClinte_number(String clinte_number) {
        this.clinte_number = clinte_number;
    }

    public String getClinte_email() {
        return clinte_email;
    }

    public void setClinte_email(String clinte_email) {
        this.clinte_email = clinte_email;
    }

    public String getClinte_remarks() {
        return clinte_remarks;
    }

    public void setClinte_remarks(String clinte_remarks) {
        this.clinte_remarks = clinte_remarks;
    }
}

package com.example.myapplication;

public class Model {
    private int id;
    private String name;
    private String number;
    private String address;
    private String category;
    private String remarks;
    //generate constructor

    public Model(int id, String name, String number,String address ,String category ,String remarks) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.address=address;
        this.category=category;
        this.remarks=remarks;
    }
    //generate getter and setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}


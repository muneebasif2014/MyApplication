package com.example.myapplication;

public class model {

    String addr,catag,name,number;

    public model() {
    }

    public model(String addr, String catag, String name, String number) {
        this.addr = addr;
        this.catag = catag;
        this.name = name;
        this.number = number;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCatag() {
        return catag;
    }

    public void setCatag(String catag) {
        this.catag = catag;
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
}

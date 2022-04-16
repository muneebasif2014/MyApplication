package com.example.myapplication;

public class Lawyer_details_dataholder {
    String  name, num, addr, catag,rem;

    public Lawyer_details_dataholder(String id, String name, String num, String addr, String catag) {

        this.name = name;
        this.num = num;
        this.addr = addr;
        this.catag = catag;
        this.rem = rem;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    public String getRem() {
        return rem;
    }

    public void setRem(String rem) {
        this.rem = rem;
    }
}

package com.example.myapplication;

public class case_DataHolder {
    String case_status, clinte_name,case_name,case_date,remarks;

    public case_DataHolder(String case_status, String clinte_name, String case_name, String case_date, String remarks) {
        this.case_status = case_status;
        this.clinte_name = clinte_name;
        this.case_name = case_name;
        this.case_date = case_date;
        this.remarks = remarks;
    }

    public String getCase_status() {
        return case_status;
    }

    public void setCase_status(String case_status) {
        this.case_status = case_status;
    }

    public String getClinte_name() {
        return clinte_name;
    }

    public void setClinte_name(String clinte_name) {
        this.clinte_name = clinte_name;
    }

    public String getCase_name() {
        return case_name;
    }

    public void setCase_name(String case_name) {
        this.case_name = case_name;
    }

    public String getCase_date() {
        return case_date;
    }

    public void setCase_date(String case_date) {
        this.case_date = case_date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

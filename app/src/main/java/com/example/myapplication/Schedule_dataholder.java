package com.example.myapplication;

public class Schedule_dataholder {
    String case_status, drop ,clintename  , case_name, case_date , sc_remarks ;

    public Schedule_dataholder(String case_status, String drop, String clintename, String case_name, String case_date, String sc_remarks) {
        this.case_status = case_status;
        this.drop = drop;
        this.clintename = clintename;
        this.case_name = case_name;
        this.case_date = case_date;
        this.sc_remarks = sc_remarks;
    }

    public String getCase_status() {
        return case_status;
    }

    public void setCase_status(String case_status) {
        this.case_status = case_status;
    }

    public String getDrop() {
        return drop;
    }

    public void setDrop(String drop) {
        this.drop = drop;
    }

    public String getClintename() {
        return clintename;
    }

    public void setClintename(String clintename) {
        this.clintename = clintename;
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

    public String getSc_remarks() {
        return sc_remarks;
    }

    public void setSc_remarks(String sc_remarks) {
        this.sc_remarks = sc_remarks;
    }
}

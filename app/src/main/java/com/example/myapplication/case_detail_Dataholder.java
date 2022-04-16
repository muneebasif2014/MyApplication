package com.example.myapplication;

public class case_detail_Dataholder {
    String case_type , case_charges ,     case_petitioner   , case_responder;

    public case_detail_Dataholder(String case_type, String case_charges, String case_petitioner, String case_responder) {

        this.case_type = case_type;
        this.case_charges = case_charges;
        this.case_petitioner = case_petitioner;
        this.case_responder = case_responder;
    }

    public String getCase_type() {
        return case_type;
    }

    public void setCase_type(String case_type) {
        this.case_type = case_type;
    }

    public String getCase_charges() {
        return case_charges;
    }

    public void setCase_charges(String case_charges) {
        this.case_charges = case_charges;
    }

    public String getCase_petitioner() {
        return case_petitioner;
    }

    public void setCase_petitioner(String case_petitioner) {
        this.case_petitioner = case_petitioner;
    }

    public String getCase_responder() {
        return case_responder;
    }

    public void setCase_responder(String case_responder) {
        this.case_responder = case_responder;
    }
}

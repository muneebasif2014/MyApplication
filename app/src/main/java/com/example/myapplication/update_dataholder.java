package com.example.myapplication;

public class update_dataholder {
    String case_status_up , case_name_up , case_date_up ,case_update_up ;

    public update_dataholder(String case_status_up, String cas_num_up, String case_name_up, String case_date_up) {

        this.case_status_up = case_status_up;

        this.case_name_up = case_name_up;
        this.case_date_up = case_date_up;
        this.case_update_up = case_update_up;
    }

    public String getCase_status_up() {
        return case_status_up;
    }

    public void setCase_status_up(String case_status_up) {
        this.case_status_up = case_status_up;
    }



    public String getCase_name_up() {
        return case_name_up;
    }

    public void setCase_name_up(String case_name_up) {
        this.case_name_up = case_name_up;
    }

    public String getCase_date_up() {
        return case_date_up;
    }

    public void setCase_date_up(String case_date_up) {
        this.case_date_up = case_date_up;
    }

    public String getCase_update_up() {
        return case_update_up;
    }

    public void setCase_update_up(String case_update_up) {
        this.case_update_up = case_update_up;
    }
}

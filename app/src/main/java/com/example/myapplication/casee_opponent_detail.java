package com.example.myapplication;

public class casee_opponent_detail {
    String   oppname ,    opplawyer,   oppcont;

    public casee_opponent_detail(String oppname, String opplawyer, String oppcont) {
        this.oppname = oppname;
        this.opplawyer = opplawyer;
        this.oppcont = oppcont;
    }

    public String getOppname() {
        return oppname;
    }

    public void setOppname(String oppname) {
        this.oppname = oppname;
    }

    public String getOpplawyer() {
        return opplawyer;
    }

    public void setOpplawyer(String opplawyer) {
        this.opplawyer = opplawyer;
    }

    public String getOppcont() {
        return oppcont;
    }

    public void setOppcont(String oppcont) {
        this.oppcont = oppcont;
    }
}

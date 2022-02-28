package com.example.di_la_covid;

public class Statisticsuser {

    public String affectedval,diedval,recoveredval,activeval,seriousval;

    public Statisticsuser (String affectedval, String diedval, String recoveredval, String activeval, String seriousval){
        this.affectedval =affectedval;
        this.diedval = diedval;
        this.recoveredval = recoveredval;
        this.activeval = activeval;
        this.seriousval = seriousval;
    }
}

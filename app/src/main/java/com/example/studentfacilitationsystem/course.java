package com.example.studentfacilitationsystem;

public class course {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getTchr() {
        return tchr;
    }

    public void setTchr(String tchr) {
        this.tchr = tchr;
    }

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    public course(String name, String roll, String tchr, String dpt) {
        this.name = name;
        this.roll = roll;
        this.tchr = tchr;
        this.dpt = dpt;
    }

    String name,roll,tchr,dpt;



}


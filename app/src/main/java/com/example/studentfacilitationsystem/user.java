package com.example.studentfacilitationsystem;

public class user {
    String uname,pwd,roll,dpt,phone;
    public user(String uname, String pwd, String roll, String dpt, String phone) {
        this.uname = uname;
        this.pwd = pwd;
        this.roll = roll;
        this.dpt = dpt;
        this.phone = phone;
    }

    public user(String uname, String pwd) {
        this.uname = uname;
        this.pwd = pwd;

    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

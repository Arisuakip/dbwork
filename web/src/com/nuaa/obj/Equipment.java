package com.nuaa.obj;

import java.sql.Date;

//设备类
public class Equipment {
    private int e_id;
    private String e_name;
    private int e_count;
    private Date e_date;

    public Equipment(){

    }

    public Equipment(int e_id, String e_name, int e_count, Date e_date) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.e_count = e_count;
        this.e_date = e_date;
    }

    public Equipment(String e_name, int e_count, Date e_date) {
        this.e_name = e_name;
        this.e_count = e_count;
        this.e_date = e_date;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public int getE_count() {
        return e_count;
    }

    public void setE_count(int e_count) {
        this.e_count = e_count;
    }

    public Date getE_date() {
        return e_date;
    }

    public void setE_date(Date e_date) {
        this.e_date = e_date;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "e_id=" + e_id +
                ", e_name='" + e_name + '\'' +
                ", e_count=" + e_count +
                ", e_date='" + e_date + '\'' +
                '}';
    }
}

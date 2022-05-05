package com.nuaa.obj;

import java.sql.Date;

public class Record {
    private int r_rid;
    private int r_eid;
    private String r_tid;
    private Date r_date;
    private String r_remark;
    private String r_ename;
    private String r_tname;

    public Record(){

    }

    public Record(int r_rid, int r_eid, String r_tid, Date r_date, String r_remark, String r_ename, String r_tname) {
        this.r_rid = r_rid;
        this.r_eid = r_eid;
        this.r_tid = r_tid;
        this.r_date = r_date;
        this.r_remark = r_remark;
        this.r_ename = r_ename;
        this.r_tname = r_tname;
    }

    public Record(int r_rid, int r_eid, String r_tid, Date r_date, String r_remark) {
        this.r_rid = r_rid;
        this.r_eid = r_eid;
        this.r_tid = r_tid;
        this.r_date = r_date;
        this.r_remark = r_remark;
    }

    public Record(int r_eid, String r_tid, Date r_date, String r_remark) {
        this.r_eid = r_eid;
        this.r_tid = r_tid;
        this.r_date = r_date;
        this.r_remark = r_remark;
    }

    public String getR_ename() {
        return r_ename;
    }

    public void setR_ename(String r_ename) {
        this.r_ename = r_ename;
    }

    public String getR_tname() {
        return r_tname;
    }

    public void setR_tname(String r_tname) {
        this.r_tname = r_tname;
    }

    public int getR_rid() {
        return r_rid;
    }

    public void setR_rid(int r_rid) {
        this.r_rid = r_rid;
    }

    public int getR_eid() {
        return r_eid;
    }

    public void setR_eid(int r_eid) {
        this.r_eid = r_eid;
    }

    public String getR_tid() {
        return r_tid;
    }

    public void setR_tid(String r_tid) {
        this.r_tid = r_tid;
    }

    public Date getR_date() {
        return r_date;
    }

    public void setR_date(Date r_date) {
        this.r_date = r_date;
    }

    public String getR_remark() {
        return r_remark;
    }

    public void setR_remark(String r_remark) {
        this.r_remark = r_remark;
    }

    @Override
    public String toString() {
        return "Record{" +
                "r_rid=" + r_rid +
                ", r_eid=" + r_eid +
                ", r_tid='" + r_tid + '\'' +
                ", r_date='" + r_date + '\'' +
                ", r_remark='" + r_remark + '\'' +
                '}';
    }
}

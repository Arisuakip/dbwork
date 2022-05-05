package com.nuaa.obj;
//人员信息类
public class Member {
    private String t_type;
    private String t_id;
    private String t_name;
    private String t_sex;
    private String t_phone;
    private String t_teacherid;
    private String t_level;

    public String getT_teachername() {
        return t_teachername;
    }

    public void setT_teachername(String t_teachername) {
        this.t_teachername = t_teachername;
    }

    private String t_teachername;

    public Member(){

    }

    public Member(String t_type, String t_id, String t_name, String t_sex, String t_phone, String t_teacherid, String t_level) {
        this.t_type = t_type;
        this.t_id = t_id;
        this.t_name = t_name;
        this.t_sex = t_sex;
        this.t_phone = t_phone;
        this.t_teacherid = t_teacherid;
        this.t_level = t_level;
    }

    public Member(String t_type, String t_id, String t_name, String t_sex, String t_phone, String t_teacherid, String t_level, String t_teachername) {
        this.t_type = t_type;
        this.t_id = t_id;
        this.t_name = t_name;
        this.t_sex = t_sex;
        this.t_phone = t_phone;
        this.t_teacherid = t_teacherid;
        this.t_level = t_level;
        this.t_teachername = t_teachername;
    }

    public String getT_type() {
        return t_type;
    }

    public void setT_type(String t_type) {
        this.t_type = t_type;
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_sex() {
        return t_sex;
    }

    public void setT_sex(String t_sex) {
        this.t_sex = t_sex;
    }

    public String getT_phone() {
        return t_phone;
    }

    public void setT_phone(String t_phone) {
        this.t_phone = t_phone;
    }

    public String getT_teacherid() {
        return t_teacherid;
    }

    public void setT_teacherid(String t_teacherid) {
        this.t_teacherid = t_teacherid;
    }

    public String getT_level() {
        return t_level;
    }

    public void setT_level(String t_level) {
        this.t_level = t_level;
    }

    @Override
    public String toString() {
        return "Member{" +
                "t_type='" + t_type + '\'' +
                ", t_id='" + t_id + '\'' +
                ", t_name='" + t_name + '\'' +
                ", t_sex='" + t_sex + '\'' +
                ", t_phone='" + t_phone + '\'' +
                ", t_teacherid='" + t_teacherid + '\'' +
                ", t_level='" + t_level + '\'' +
                ", t_teachername='" + t_teachername + '\'' +
                '}';
    }
}

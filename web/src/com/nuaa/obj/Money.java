package com.nuaa.obj;

import java.math.BigDecimal;
import java.sql.Date;

//账目类
public class Money {
    private int m_id;
    private String m_action;
    private BigDecimal m_count;
    private Date m_date;
    private String m_userid;
    private String m_username;
    public Money(){

    }

    public Money(int m_id, String m_action, BigDecimal m_count, Date m_date, String m_userid, String m_username) {
        this.m_id = m_id;
        this.m_action = m_action;
        this.m_count = m_count;
        this.m_date = m_date;
        this.m_userid = m_userid;
        this.m_username = m_username;
    }

    public Money(int m_id, String m_action, BigDecimal m_count, Date m_date, String m_userid) {
        this.m_id = m_id;
        this.m_action = m_action;
        this.m_count = m_count;
        this.m_date = m_date;
        this.m_userid = m_userid;
    }

    public Money(String m_action, BigDecimal m_count, Date m_date, String m_userid) {
        this.m_action = m_action;
        this.m_count = m_count;
        this.m_date = m_date;
        this.m_userid = m_userid;
    }

    public String getM_username() {
        return m_username;
    }

    public void setM_username(String m_username) {
        this.m_username = m_username;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_action() {
        return m_action;
    }

    public void setM_action(String m_action) {
        this.m_action = m_action;
    }

    public BigDecimal getM_count() {
        return m_count;
    }

    public void setM_count(BigDecimal m_count) {
        this.m_count = m_count;
    }

    public Date getM_date() {
        return m_date;
    }

    public void setM_date(Date m_date) {
        this.m_date = m_date;
    }

    public String getM_userid() {
        return m_userid;
    }

    public void setM_userid(String m_userid) {
        this.m_userid = m_userid;
    }

    @Override
    public String toString() {
        return "Money{" +
                "m_id=" + m_id +
                ", m_action='" + m_action + '\'' +
                ", m_count=" + m_count +
                ", m_date='" + m_date + '\'' +
                ", m_userid='" + m_userid + '\'' +
                '}';
    }
}

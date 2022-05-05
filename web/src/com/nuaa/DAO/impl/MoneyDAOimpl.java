package com.nuaa.DAO.impl;

import com.nuaa.DAO.MoneyDAO;
import com.nuaa.DAO.impl.Base.BaseDAO;
import com.nuaa.obj.Money;

import java.util.List;

public class MoneyDAOimpl extends BaseDAO<Money> implements MoneyDAO {
    @Override
    public List<Money> getMoneyList(String keyword,int pageNo) {
        String sql = "SELECT m.m_id,m.m_action,m.m_count,m.m_date,m.m_userid,t.t_name m_username FROM moneyinfo m,memberinfo t WHERE (m_id LIKE ? OR m_userid LIKE ?) AND (m.m_userid = t.t_id) LIMIT ?,7";
        return super.excuteQuery(sql,"%"+keyword+"%","%"+keyword+"%",(pageNo-1)*7);
    }

    @Override
    public boolean addMoney(Money money) {
        String sql = "insert into moneyinfo values (0,?,?,?,?)";
        return super.excuteUpdate(sql,money.getM_action(),money.getM_count(),money.getM_date(),money.getM_userid());
    }

    @Override
    public boolean deleteMoney(int mid) {
        String sql = "delete from moneyinfo where m_id=?";
        return super.excuteUpdate(sql, mid);
    }

    @Override
    public int getMoneyCount(String keyword) {
        String sql = "SELECT COUNT(*) FROM equipinfo";
        return ((Long)super.excuteComplexQuery(sql)[0]).intValue();
    }

    @Override
    public Money getMoneyById(int m_id) {
        String sql = "SELECT * FROM moneyinfo WHERE m_id=?";
        return super.load(sql,m_id);
    }

    @Override
    public void updateMoney(Money money) {
        String sql = "UPDATE moneyinfo SET m_id =?,m_action = ?,m_count = ?,m_date=?,m_userid=? WHERE m_id =?;";
        super.excuteUpdate(sql,money.getM_id(),money.getM_action(),money.getM_count(),money.getM_date(),money.getM_userid(),money.getM_id());
    }
}

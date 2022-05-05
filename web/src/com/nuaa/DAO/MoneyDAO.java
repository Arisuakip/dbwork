package com.nuaa.DAO;

import com.nuaa.obj.Equipment;
import com.nuaa.obj.Money;

import java.util.List;

public interface MoneyDAO {
    //获取人员信息表
    List<Money> getMoneyList(String keyword,int pageNo);
    //增加人员信息
    boolean addMoney(Money money);
    //删除人员信息
    boolean deleteMoney(int mid);
    //根据ID返回记录
    Money getMoneyById(int e_id);
    //查询记录条数
    int getMoneyCount(String keyword);
    //更新记录
    void updateMoney(Money money);
}

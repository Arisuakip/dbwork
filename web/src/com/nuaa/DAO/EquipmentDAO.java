package com.nuaa.DAO;

import com.nuaa.obj.Equipment;
import com.nuaa.obj.Member;

import java.util.List;

public interface EquipmentDAO {
    List<Equipment> getEquipmentList(String keyword,int pageNo);
    boolean addEquipment(Equipment equipment);
    boolean deleteEquipment(int eid);
    //更新记录
    void updateEquipment(Equipment equipment);
    //查询总记录条数
    int getEquipCount(String keyword);
    //根据ID返回记录
    Equipment getEquipmentById(int e_id);
}

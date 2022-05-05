package com.nuaa.DAO.impl;

import com.nuaa.DAO.EquipmentDAO;
import com.nuaa.DAO.impl.Base.BaseDAO;
import com.nuaa.obj.Equipment;

import java.util.List;

public class EquipmentDAOimpl extends BaseDAO<Equipment> implements EquipmentDAO {
    @Override
    public List<Equipment> getEquipmentList(String keyword,int pageNo) {
        String sql = "SELECT * FROM equipinfo WHERE (e_id LIKE ? OR e_name LIKE ?) LIMIT ?,7";
        return super.excuteQuery(sql,"%"+keyword+"%","%"+keyword+"%",(pageNo-1)*7);
    }
    @Override
    public boolean addEquipment(Equipment equipment) {
        String sql = "insert into equipinfo values(0,?,?,?)";
        return super.excuteUpdate(sql,equipment.getE_name(),equipment.getE_count(),equipment.getE_date());
    }
    @Override
    public boolean deleteEquipment(int eid) {
        String sql = "delete from equipinfo where e_id=?";
        return super.excuteUpdate(sql,eid);
    }

    @Override
    public void updateEquipment(Equipment equipment) {
        String sql = "UPDATE equipinfo SET e_id=?,e_name=?,e_count=?,e_date=? WHERE e_id=?;";
        super.excuteUpdate(sql,equipment.getE_id(),equipment.getE_name(),equipment.getE_count(),equipment.getE_date(),equipment.getE_id());
    }

    @Override
    public int getEquipCount(String keyword) {
        String sql = "SELECT COUNT(*) FROM equipinfo";
        return ((Long)super.excuteComplexQuery(sql)[0]).intValue();
    }

    @Override
    public Equipment getEquipmentById(int e_id) {
        String sql = "SELECT * FROM equipinfo WHERE e_id=?";
        return super.load(sql,e_id);
    }
}

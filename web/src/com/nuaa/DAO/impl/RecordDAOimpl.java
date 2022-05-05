package com.nuaa.DAO.impl;

import com.nuaa.DAO.RecordDAO;
import com.nuaa.DAO.impl.Base.BaseDAO;
import com.nuaa.obj.Record;

import java.util.List;

public class RecordDAOimpl extends BaseDAO<Record> implements RecordDAO {
    @Override
    public List<Record> getRecordList(String keyword,int pageNo) {
        String sql = "SELECT r.r_rid,r.r_eid,r.r_tid,r.r_date,r.r_remark,e.e_name r_ename,t.t_name r_tname FROM recordinfo r,memberinfo t,equipinfo e WHERE r.r_eid = e.e_id AND r.r_tid = t.t_id AND (r.r_eid LIKE ? OR r.r_tid LIKE ? OR e.e_name LIKE ? OR t.t_name LIKE ? OR r.r_remark LIKE ? OR r.r_rid LIKE ?)LIMIT ?,7";
        return super.excuteQuery(sql,"%"+keyword+"%","%"+keyword+"%","%"+keyword+"%","%"+keyword+"%","%"+keyword+"%","%"+keyword+"%",(pageNo-1)*7);
    }

    @Override
    public boolean addRecord(Record record) {
        String sql = "insert into recordinfo values (0,?,?,?,?)";
        return super.excuteUpdate(sql,record.getR_eid(),record.getR_tid(),record.getR_date(),record.getR_remark());
    }

    @Override
    public boolean deleteRecord(int rid) {
        String sql = "delete from recordinfo where r_rid=?";
        return super.excuteUpdate(sql,rid);
    }

    @Override
    public void updateRecord(Record record) {
        String sql = "UPDATE recordinfo SET r_rid = ?,r_eid= ?,r_tid=?,r_date=?,r_remark=? WHERE r_rid = ?;";
        excuteUpdate(sql,record.getR_rid(),record.getR_eid(),record.getR_tid(),record.getR_date(),record.getR_remark(),record.getR_rid());
    }
    @Override
    public Record getRecordById(int r_rid) {
        String sql = "SELECT r.r_rid,r.r_eid,r.r_tid,r.r_date,r.r_remark,e.e_name r_ename,t.t_name r_tname FROM recordinfo r,memberinfo t,equipinfo e WHERE r.r_rid = ? AND r.r_eid = e.e_id AND r.r_tid = t.t_id";
        return super.load(sql,r_rid);
    }

    @Override
    public int getRecordCount(String keyword) {
        String sql = "SELECT COUNT(*) FROM recordinfo";
        return ((Long)super.excuteComplexQuery(sql)[0]).intValue();
    }
}

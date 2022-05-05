package com.nuaa.DAO;

import com.nuaa.obj.Equipment;
import com.nuaa.obj.Record;

import java.util.List;

public interface RecordDAO {
    List<Record> getRecordList(String keyword,int pageNo);
    boolean addRecord(Record record);
    boolean deleteRecord(int rid);
    //更新记录
    void updateRecord(Record record);
    //查询总记录条数
    int getRecordCount(String keyword);
    //根据ID返回记录
    Record getRecordById(int r_rid);
}

package com.nuaa.DAO.impl;

import com.nuaa.DAO.MemberDAO;
import com.nuaa.DAO.impl.Base.BaseDAO;
import com.nuaa.obj.Member;

import java.util.List;

public class MemberDAOimpl extends BaseDAO<Member> implements MemberDAO {

    @Override
    public List<Member> getMemberList(String keyword,int pageNo){
        String sql = "SELECT stu.t_type,stu.t_id,stu.t_name,stu.t_sex,stu.t_phone,stu.t_teacherid,stu.t_level,tea.t_name AS t_teachername FROM memberinfo stu LEFT JOIN memberinfo tea ON stu.t_teacherid=tea.t_id WHERE stu.t_name LIKE ? OR stu.t_id LIKE ? OR stu.t_teacherid LIKE ? LIMIT ?,7";

        return super.excuteQuery(sql,"%"+keyword+"%","%"+keyword+"%","%"+keyword+"%",(pageNo-1)*7);
    }
    @Override
    public boolean addMember(Member member) {
        String sql = "insert into memberinfo values(?,?,?,?,?,?,?)";
        return super.excuteUpdate(sql,member.getT_type(),member.getT_id(),member.getT_name(),member.getT_sex(),member.getT_phone(),member.getT_teacherid(),member.getT_level());
    }

    @Override
    public boolean deleteMember(String tid) {
        String sql = "delete from memberinfo where t_id=?";
        return super.excuteUpdate(sql,tid);
    }

    @Override
    public Member getMemberById(String t_id) {
        String sql = "select * from memberinfo where t_id=?";
        return super.load(sql,t_id);
    }

    @Override
    public void updateMember(Member member) {
        String sql = "update memberinfo set t_type=?,t_id=?,t_name=?,t_sex=?,t_phone=?,t_teacherid=?,t_level=? where t_id=?";
        super.excuteUpdate(sql,member.getT_type(),member.getT_id(),member.getT_name(),member.getT_sex(),member.getT_phone(),member.getT_teacherid(),member.getT_level(),member.getT_id());
    }

    @Override
    public int getMemberCount(String keyword) {
        String sql = "select count(*) from memberinfo where t_name like ? or t_id like ? or t_teacherid like ?";
        return ((Long)super.excuteComplexQuery(sql,"%"+keyword+"%","%"+keyword+"%","%"+keyword+"%")[0]).intValue();
    }
}

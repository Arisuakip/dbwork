package com.nuaa.DAO;

import com.nuaa.obj.Member;

import java.util.List;

//memberDAO接口
public interface MemberDAO {
    //获取人员信息表
    List<Member> getMemberList(String keyword,int pageNo);
    //增加人员信息
    boolean addMember(Member member);
    //删除人员信息
    boolean deleteMember(String tid);
    //根据ID查询单个人员信息
    Member getMemberById(String t_id);
    //修改人员信息
    void updateMember(Member member);
    //查询总记录条数
    int getMemberCount(String keyword);
}

package com.nuaa;

import com.nuaa.DAO.MemberDAO;
import com.nuaa.DAO.impl.MemberDAOimpl;
import com.nuaa.obj.Member;

public class test {
    public static void main(String[] args) {
        MemberDAO memberDAO = new MemberDAOimpl();
        for (Member member : memberDAO.getMemberList("", 1)) {
            System.out.println(member);
        }
    }
}

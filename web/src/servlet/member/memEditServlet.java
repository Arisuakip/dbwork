package servlet.member;

import com.nuaa.DAO.MemberDAO;
import com.nuaa.DAO.impl.MemberDAOimpl;
import com.nuaa.obj.Member;
import myspringmvc.ViewBaseServlet;
import tools.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member.edit")
public class memEditServlet extends ViewBaseServlet {
    private MemberDAO memberDAO = new MemberDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tid= request.getParameter("t_id");
        Member member = memberDAO.getMemberById(tid);
        request.setAttribute("member",member);
        super.processTemplate("member/edit",request,response);
    }
}

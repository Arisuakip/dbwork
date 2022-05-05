package servlet.member;

import com.nuaa.DAO.MemberDAO;
import com.nuaa.DAO.impl.MemberDAOimpl;
import myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member.del")
public class memDelServlet extends ViewBaseServlet {
    private MemberDAO memberDAO = new MemberDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String t_id= request.getParameter("t_id");
        memberDAO.deleteMember(t_id);

        response.sendRedirect("member");
    }
}

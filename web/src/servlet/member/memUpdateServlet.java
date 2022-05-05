package servlet.member;

import com.nuaa.DAO.MemberDAO;
import com.nuaa.DAO.impl.MemberDAOimpl;
import com.nuaa.obj.Member;
import myspringmvc.ViewBaseServlet;
import tools.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/member.update")
public class memUpdateServlet extends ViewBaseServlet {
    private MemberDAO memberDAO = new MemberDAOimpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setCharacterEncoding("utf-8");
            String t_type = request.getParameter("t_type");
            String t_id = request.getParameter("t_id");
            String t_name = request.getParameter("t_name");
            String t_sex = request.getParameter("t_sex");
            String t_phone = request.getParameter("t_phone");
            String t_teacherid = request.getParameter("t_teacherid");
            String t_teachername;
            if(StringUtil.isNotEmpty(t_teacherid)){
                t_teachername= memberDAO.getMemberById(t_teacherid).getT_teachername();
            }else{
                t_teachername = null;
            }
            if(StringUtil.isEmpty(t_teacherid)){
                t_teacherid = null;
            }
            String t_level = request.getParameter("t_level");
            if(StringUtil.isEmpty(t_level) || t_type.equals("学生")){
                t_level = null;
            }
            //执行更新
            memberDAO.updateMember(new Member(t_type,t_id,t_name,t_sex,t_phone,t_teacherid,t_level,t_teachername));
            response.sendRedirect("member");
        }catch (Throwable e){
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
                out.print("<script language='javascript'>alert('参数不合法，请检查输入参数');window.location.href='member';</script>");
        }

    }
}

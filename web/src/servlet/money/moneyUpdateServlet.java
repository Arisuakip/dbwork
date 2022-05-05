package servlet.money;

import com.nuaa.DAO.EquipmentDAO;
import com.nuaa.DAO.MemberDAO;
import com.nuaa.DAO.MoneyDAO;
import com.nuaa.DAO.impl.EquipmentDAOimpl;
import com.nuaa.DAO.impl.MemberDAOimpl;
import com.nuaa.DAO.impl.MoneyDAOimpl;
import com.nuaa.obj.Equipment;
import com.nuaa.obj.Money;
import myspringmvc.ViewBaseServlet;
import tools.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;


@WebServlet("/money.update")
public class moneyUpdateServlet extends ViewBaseServlet {
    private MoneyDAO moneyDAO = new MoneyDAOimpl();
    private MemberDAO memberDAO = new MemberDAOimpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setCharacterEncoding("utf-8");
            String m_idstr = request.getParameter("m_id");
            int m_id = Integer.parseInt(m_idstr);
            String m_action = request.getParameter("m_action");
            String m_countstr = request.getParameter("m_count");
            double m_countdb = Double.parseDouble(m_countstr);
            BigDecimal m_count = BigDecimal.valueOf(m_countdb);
            Date m_date = Date.valueOf(request.getParameter("m_date")) ;
            String m_userid = request.getParameter("m_userid");
            String m_username = memberDAO.getMemberById(m_userid).getT_teachername();
            moneyDAO.updateMoney(new Money(m_id,m_action,m_count,m_date,m_userid,m_username));
            response.sendRedirect("money");
        }catch (Throwable e){
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.print("<script language='javascript'>alert('参数不合法，请检查输入参数');window.location.href='money/add.html';</script>");
        }

    }
}

package servlet.money;

import com.nuaa.DAO.EquipmentDAO;
import com.nuaa.DAO.MemberDAO;
import com.nuaa.DAO.MoneyDAO;
import com.nuaa.DAO.impl.EquipmentDAOimpl;
import com.nuaa.DAO.impl.MoneyDAOimpl;
import myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/money.del")
public class moneyDelServlet extends ViewBaseServlet {
    private MoneyDAO moneyDAO = new MoneyDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String m_idstr= request.getParameter("m_id");
        int m_id = Integer.parseInt(m_idstr);
        moneyDAO.deleteMoney(m_id);
        response.sendRedirect("money");
    }
}

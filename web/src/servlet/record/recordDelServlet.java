package servlet.record;

import com.nuaa.DAO.RecordDAO;
import com.nuaa.DAO.impl.RecordDAOimpl;
import myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/record.del")
public class recordDelServlet extends ViewBaseServlet {
    private RecordDAO recordDAO = new RecordDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String r_ridstr= request.getParameter("r_rid");
        int r_rid = Integer.parseInt(r_ridstr);
        recordDAO.deleteRecord(r_rid);
        response.sendRedirect("record");
    }
}

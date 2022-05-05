package servlet.record;

import com.nuaa.DAO.RecordDAO;
import com.nuaa.DAO.impl.RecordDAOimpl;
import com.nuaa.obj.Record;
import myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/record.edit")
public class recordEditServlet extends ViewBaseServlet {
    private RecordDAO recordDAO = new RecordDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String r_idstr= request.getParameter("r_rid");
        int r_rid = Integer.parseInt(r_idstr);
        Record record = recordDAO.getRecordById(r_rid);
        request.setAttribute("record",record);
        super.processTemplate("record/edit",request,response);
    }
}

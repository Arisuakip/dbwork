package servlet.record;

import com.nuaa.DAO.EquipmentDAO;
import com.nuaa.DAO.MemberDAO;
import com.nuaa.DAO.RecordDAO;
import com.nuaa.DAO.impl.EquipmentDAOimpl;
import com.nuaa.DAO.impl.MemberDAOimpl;
import com.nuaa.DAO.impl.RecordDAOimpl;
import com.nuaa.obj.Equipment;
import com.nuaa.obj.Record;
import myspringmvc.ViewBaseServlet;
import tools.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet("/record.add")
public class recordAddServlet extends ViewBaseServlet {
    private RecordDAO recordDAO = new RecordDAOimpl();
    private MemberDAO memberDAO = new MemberDAOimpl();
    private EquipmentDAO equipmentDAO = new EquipmentDAOimpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setCharacterEncoding("utf-8");
            //int r_rid = Integer.parseInt(request.getParameter("r_rid"));
            String r_eidstr =request.getParameter("r_eid");
            String r_tid = request.getParameter("r_tid");
            String r_datestr = request.getParameter("r_date");
            String r_remark = request.getParameter("r_remark");
            int r_eid = Integer.parseInt(request.getParameter("r_eid"));
            Date r_date = Date.valueOf(request.getParameter("r_date"));
            String r_ename = equipmentDAO.getEquipmentById(r_eid).getE_name();
            String r_tname = memberDAO.getMemberById(r_tid).getT_name();
            recordDAO.addRecord(new Record(0,r_eid,r_tid,r_date,r_remark,r_ename,r_tname));
            response.sendRedirect("record");
        }catch (Throwable e){
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out=response.getWriter();
                out.print("<script language='javascript'>alert('参数不合法，请检查输入参数');window.location.href='record/add.html';</script>");
        }

    }
}

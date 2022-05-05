package servlet.equipment;

import com.nuaa.DAO.EquipmentDAO;
import com.nuaa.DAO.MemberDAO;
import com.nuaa.DAO.impl.EquipmentDAOimpl;
import com.nuaa.DAO.impl.MemberDAOimpl;
import com.nuaa.obj.Equipment;
import com.nuaa.obj.Member;
import myspringmvc.ViewBaseServlet;
import tools.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;


@WebServlet("/equipment.update")
public class equipUpdateServlet extends ViewBaseServlet {
    private EquipmentDAO equipmentDAO = new EquipmentDAOimpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setCharacterEncoding("utf-8");
            int e_id=0;
            String e_idstr = request.getParameter("e_id");
            if(StringUtil.isNotEmpty(e_idstr)){
                e_id = Integer.parseInt(e_idstr);
            }
            String e_name = request.getParameter("e_name");
            String e_countstr = request.getParameter("e_count");
            int e_count = 0;
            if(StringUtil.isNotEmpty(e_countstr)){
                e_count = Integer.parseInt(e_countstr);
            }
            Date e_date = Date.valueOf(request.getParameter("e_date")) ;
            //执行更新
            equipmentDAO.updateEquipment(new Equipment(e_id,e_name,e_count,e_date));
            response.sendRedirect("equipment");
        }catch (Throwable e){
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.print("<script language='javascript'>alert('参数不合法，请检查输入参数');window.location.href='equipment';</script>");
        }

    }
}

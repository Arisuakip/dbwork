package servlet.equipment;

import com.nuaa.DAO.EquipmentDAO;
import com.nuaa.DAO.impl.EquipmentDAOimpl;
import com.nuaa.obj.Equipment;
import myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/equipment.edit")
public class equipEditServlet extends ViewBaseServlet {
    private EquipmentDAO equipmentDAO = new EquipmentDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String e_idstr= request.getParameter("e_id");
        int e_id = Integer.parseInt(e_idstr);
        Equipment equipment = equipmentDAO.getEquipmentById(e_id);
        request.setAttribute("equipment",equipment);
        super.processTemplate("equipment/edit",request,response);
    }
}

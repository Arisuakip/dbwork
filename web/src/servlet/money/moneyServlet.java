package servlet.money;

import com.nuaa.DAO.EquipmentDAO;
import com.nuaa.DAO.MoneyDAO;
import com.nuaa.DAO.impl.EquipmentDAOimpl;
import com.nuaa.DAO.impl.MoneyDAOimpl;
import com.nuaa.obj.Equipment;
import com.nuaa.obj.Money;
import myspringmvc.ViewBaseServlet;
import tools.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/money")
public class moneyServlet extends ViewBaseServlet {
    private MoneyDAO moneyDAO = new MoneyDAOimpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int pageNo = 1;
        HttpSession session = request.getSession();
        String pageNostr = request.getParameter("pageNo");
        if(StringUtil.isNotEmpty(pageNostr)){
            pageNo = Integer.parseInt(pageNostr);
        }
        String keyword = null;
        String oper = request.getParameter("oper");
        if(StringUtil.isNotEmpty(oper) && "search".equals(oper)){
            //通过查询得到的数据
            pageNo = 1;
            keyword = request.getParameter("keyword");
            if(StringUtil.isEmpty(keyword)){
                keyword="";
            }
            session.setAttribute("keyword",keyword);
        }else {
            //说明此处不是通过点击表单发送的请求
            if(StringUtil.isNotEmpty(pageNostr)){
                pageNo = Integer.parseInt(pageNostr);
            }
            Object keywordobj = session.getAttribute("keyword");
            if(keywordobj != null){
                keyword = (String)keywordobj;
            }else{
                keyword="";
            }
        }
        int equipCount = moneyDAO.getMoneyCount(keyword);
        int pagecount = (equipCount+7-1)/7;
        List<Money> list = new ArrayList<>();
        list = moneyDAO.getMoneyList(keyword,pageNo);
        session.setAttribute("pagecount",pagecount);
        session.setAttribute("keyword",keyword);
        session.setAttribute("pageNo",pageNo);
        session.setAttribute("moneylist",list);
        super.processTemplate("money",request,response);
    }
}

package servlets;

import Tool.Tools;
import dao.RepairDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet_repair", value = "/Repair")
public class Servlet_repair extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("param");
        request.setCharacterEncoding("utf-8");
        if (param != null) {
            switch (param) {
                case "1":
                    //修改请求
                    getRepair(request, response);
                    break;
                case "2":
                    //删除
                    deleteRepair(request, response);
                    break;
                case "3":
                    //修改确认
                    updateRepair(request, response);
                    break;
                case "4":
                    //添加报修
                    addRepair(request, response);
                    break;
                case "5":
                    addRepairUser(request, response);
                    break;

            }
        } else {
            getAllRepair(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void getAllRepair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<model.Repair> list = RepairDao.getAllRepair();
        request.getSession().setAttribute("repairs", list);
        response.sendRedirect("/admin/repair_manage.jsp");
    }

    public void addRepair(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String roomid = request.getParameter("roomid");
        String title = new String(request.getParameter("title").getBytes("iso-8859-1"), "utf-8");
        String type = request.getParameter("type");
        switch (type) {
            case "房间维修":
                type = "0";
                break;
            case "浴室维修":
                type = "1";
                break;
            case "阳台维修":
                type = "2";
                break;
            default:
                type = "3";
                break;
        }
        String pfee = request.getParameter("pfee");
        String mfee = request.getParameter("mfee");
        String content = new String(request.getParameter("content").getBytes("iso-8859-1"), "utf-8");
        String repairTime = Tools.getDate();
        String remark = new String(request.getParameter("remark").getBytes("iso-8859-1"), "utf-8");
        String total = String.valueOf(Double.parseDouble(pfee) + Double.parseDouble(mfee));
        RepairDao.addNewRepairAdmin(roomid, title, type, pfee, mfee, total, repairTime, content,
                remark,"admin");
        response.sendRedirect("/Repair");
    }
    public void addRepairUser(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
      //  System.out.println("test");
        String roomid = request.getParameter("roomid");
        String title = new String(request.getParameter("title").getBytes
                ("iso-8859-1"), "utf-8");
        String type = request.getParameter("type");
        switch (type) {
            case "房间维修":
                type="0";
                break;
            case "浴室维修":
                type="1";
                break;
            case "阳台维修":
                type="2";
                break;
            default:
                type="3";
                break;
        }
        String uid=(String) request.getSession().getAttribute("UID");
        RepairDao.addNewRepairUser(roomid, title, type,uid);
        response.sendRedirect("/Room?param=5");
    }


    public void getRepair(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String id = request.getParameter("rid");
        List<model.Repair> repairs = RepairDao.getRepair(id);
        model.Repair repair = repairs.get(0);
        request.getSession().setAttribute("repair", repair);
        response.sendRedirect("/admin/repair_room_admin_edit.jsp");
    }

    public void updateRepair(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String id = new String(request.getParameter("id").getBytes("iso-8859-1"), "utf-8");
        String roomid = request.getParameter("roomid");
        String title = new String(request.getParameter("title").getBytes("iso-8859-1"), "utf-8");
        String type = request.getParameter("type");
        switch (type) {
            case "房间维修":
                type = "0";
                break;
            case "浴室维修":
                type = "1";
                break;
            case "阳台维修":
                type = "2";
                break;
            default:
                type = "3";
                break;
        }
        String pfee = request.getParameter("pfee");
        String mfee = request.getParameter("mfee");
        String content = new String(request.getParameter("content").getBytes("iso-8859-1"), "utf-8");
        String remark = new String(request.getParameter("remark").getBytes("iso-8859-1"), "utf-8");
        String total = String.valueOf(Double.parseDouble(pfee) + Double.parseDouble(mfee));
        RepairDao.editNewRepairAdmin(roomid, title, type, pfee, mfee, total, content, remark, id);
        response.sendRedirect("/Repair");
    }

    public void deleteRepair(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String id = request.getParameter("rid");
        RepairDao.deleteRepair(id);
        response.sendRedirect("/Repair");
    }

}

package servlets;

import dao.StaffDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletStaff",value = "/SS")
public class ServletStaff extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        if("view".equals(request.getParameter("cz")))
        {
            search2(request, response);
        }
        else if("del".equals(request.getParameter("cz"))){
            delete(request, response);
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        StaffDao dao = new StaffDao();
        if("r".equals(request.getParameter("cz")))
        {
            int flag=dao.getStaffID(request.getParameter("id"));

            if(flag==1)
            {
                request.getSession().setAttribute("tip", "身份证重复");
                response.sendRedirect("add_staff.jsp");
                return;
            }
            String sex=request.getParameter("sex");

            dao.insert(request.getParameter("name"),sex,request.getParameter("id"),request.getParameter("phone"),request.getParameter("date"));
            request.getSession().setAttribute("tip", "添加成功");
            search2(request, response);
        }
        if("u".equals(request.getParameter("cz")))
        {
            String sex=request.getParameter("sex");
            dao.update(request.getParameter("name"),sex,request.getParameter("phone"),request.getParameter("date"),request.getParameter("id"));
            request.getSession().setAttribute("tip", "修改成功");
            //添加查询界面后，新增成功就直接进入查询页面
            search2(request, response);
        }
    }
    public void search2(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<model.Roomer> result;

        String Staffid = request.getParameter("roomerid");

        if (Staffid != null && !Staffid.equals("")) {
            result = StaffDao.getStaffByID(Staffid);
            System.out.println(result.size());
            request.getSession().setAttribute("staff", result);
            response.sendRedirect("/admin/edit_staff.jsp");
        } else {
            result = StaffDao.getAllStaff();
            System.out.print(result.size());
            request.getSession().setAttribute("staffs", result);
            response.sendRedirect("/admin/all_staffs.jsp");
        }

    }
    public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String roomer = request.getParameter("roomerid");
        StaffDao dao = new StaffDao();
        dao.delete(roomer);
        List<model.Roomer> result;
        search2(request, response);
    }
}

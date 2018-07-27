package servlets;

import dao.RoomDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet_AJax" ,value = "/Ajax")
public class Servlet_AJax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param=request.getParameter("param");
        response.setCharacterEncoding("utf-8");
        if(param.equals("1")){
            check(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }

    public void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value=request.getParameter("value");
       // System.out.println(value);
        if(value==null ||value.equals(""))
            return;
        List<model.Room> list=RoomDao.getRoomByID(value);
        if(RoomDao.getRoomByID(value).size()==0)
            response.getWriter().write("可用");
        else
            response.getWriter().write("已存在");
    }
}

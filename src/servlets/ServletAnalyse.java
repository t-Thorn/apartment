package servlets;

import dao.AccountDao;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletAnalyse",value = "/Analyse")
public class ServletAnalyse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("Orders",AccountDao.getOrder());
        request.getSession().setAttribute("newUsers",UserDao.getNewUser());
        request.getSession().setAttribute("Income",AccountDao.getIncome());
        request.getSession().setAttribute("out",AccountDao.getOut());
        response.sendRedirect("/admin/dashboard2.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

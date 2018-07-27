package servlets;

import Tool.Tools;
import dao.BookDao;
import dao.RoomDao;
import dao.UserDao;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Servlet_Booking", value = "/Booking")
public class Servlet_Booking extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String param = request.getParameter("param");
        request.setCharacterEncoding("utf-8");
        if (param != null) {
            switch (param) {
                case "1":
                    //修改请求
                    getBook(request, response);
                    break;
                case "2":
                    //删除
                    deleteBook(request, response);
                    break;
                case "3":
                    //修改确认
                    editBook(request, response);
                    break;
                case "4":
                    //选择房间
                    chooseRoom(request, response);
                    break;
            }
        } else if ("user".equals(request.getParameter("cz"))) {
            getBookByID(request, response);
        } else {
            getAllBook(request, response);
        }

    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }

    public void getBookByID(javax.servlet.http.HttpServletRequest request, javax.servlet.http
            .HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //根据房间号跳转到预定房间界面
        List<model.Book> list = BookDao.getUserBook((String) request.getSession().getAttribute
                ("ID"));
        request.getSession().setAttribute("books", list);
        response.sendRedirect("/admin/view_booking_user.jsp");
    }

    public void getAllBook(javax.servlet.http.HttpServletRequest request, javax.servlet.http
            .HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //根据房间号跳转到预定房间界面
        List<model.Book> list = BookDao.getAllBook();
        request.getSession().setAttribute("books", list);
        response.sendRedirect("/admin/view_booking.jsp");
    }

    public void getBookUser(javax.servlet.http.HttpServletRequest request, javax.servlet.http
            .HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //根据房间号跳转到预定房间界面
        String id = request.getParameter("bid");
        List<model.Book> list = BookDao.getBook(id);
        request.getSession().setAttribute("book", list.get(0));
        request.getSession().setAttribute("gender", BookDao.getGender(list.get(0).getBook_PersonID()));
        String type = RoomDao.getRoomType(request.getParameter("roomid"));
        request.getSession().setAttribute("gender", BookDao.getGender(list.get(0).getBook_PersonID
                ()));
        request.getSession().setAttribute("roomtype", type);
        response.sendRedirect("/admin/edit_booking_user.jsp");
    }

    public void getBook(javax.servlet.http.HttpServletRequest request, javax.servlet.http
            .HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //根据房间号跳转到预定房间界面
        if ("edit".equals(request.getParameter("cz"))) {
            getBookUser(request, response);
        } else {
            String id = request.getParameter("bid");
            List<model.Book> list = BookDao.getBook(id);
            request.getSession().setAttribute("book", list.get(0));
            System.out.println(list.get(0).getBook_PersonID());
            request.getSession().setAttribute("gender", BookDao.getGender(list.get(0).getBook_PersonID()));
            String type = RoomDao.getRoomType(request.getParameter("roomid"));
            // request.getSession().setAttribute("gender",Book.getGender(list.get(0).getBook_PersonID
            // ()));
            request.getSession().setAttribute("roomtype", type);
            response.sendRedirect("/admin/edit_booking.jsp");
        }
    }

    public void chooseRoom(javax.servlet.http.HttpServletRequest request, javax.servlet.http
            .HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //根据房间号跳转到预定房间界面
        if (validate(request, response, "/admin/new_booking.jsp") == -1) {
            return;
        }

        String name = new String(request.getParameter("name").getBytes
                ("iso-8859-1"), "utf-8");
        String gender = new String(request.getParameter("gender").getBytes
                ("iso-8859-1"), "utf-8");
        String phone = request.getParameter("phone");
        String id = request.getParameter("id");
        String begintime = request.getParameter("begintime");
        String finishtime = request.getParameter("finishtime");
        String type = new String(request.getParameter("type").getBytes
                ("iso-8859-1"), "utf-8");
        String remark = new String(request.getParameter("remark").getBytes
                ("iso-8859-1"), "utf-8");
        String msg = BookDao.chooseRoom(name, gender, phone, id, begintime, finishtime, type,
                remark);
        System.out.println(msg);
        if (msg.equals("该时段不存在符合条件的房间")) {
            request.getSession().setAttribute("tip", msg);
            response.getWriter().print("<script>eval(history.go(-1))</script>");
        } else {
            if (msg.equals(""))
                request.getSession().removeAttribute("tip");
            else
                request.getSession().setAttribute("tip", msg);
            if (UserDao.IsAdmin((String) request.getSession().getAttribute("Account")) == 0) {

                response.sendRedirect("/Booking?cz=user");
                return;
            }
            response.sendRedirect("/Booking");
            return;
        }
    }

    public int validate(javax.servlet.http.HttpServletRequest request, javax.servlet.http
            .HttpServletResponse response, String url) throws javax.servlet.ServletException,
            IOException {
        //根据房间号跳转到预定房间界面
        String begintime = request.getParameter("begintime");
        String finishtime = request.getParameter("finishtime");
        Date begin = Tools.getDate(begintime);
        Date finish = Tools.getDate(finishtime);
        if (begin.after(finish)) {
            request.getSession().setAttribute("tip", "结束时间不能小于开始时间");
            response.sendRedirect(url);
            return -1;
        }
        return 1;
    }

    public void editBook(javax.servlet.http.HttpServletRequest request, javax.servlet.http
            .HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        if (validate(request, response, "/admin/new_booking.jsp") == -1) {
            return;
        }
        String bid = new String(request.getParameter("bid").getBytes
                ("iso-8859-1"), "utf-8");
        String roomid = new String(request.getParameter("roomid").getBytes
                ("iso-8859-1"), "utf-8");
        String name = new String(request.getParameter("name").getBytes
                ("iso-8859-1"), "utf-8");
        String gender = new String(request.getParameter("gender").getBytes
                ("iso-8859-1"), "utf-8");
        String phone = request.getParameter("phone");
        String id = request.getParameter("id");
        String begintime = request.getParameter("begintime");
        String finishtime = request.getParameter("finishtime");
        String type = new String(request.getParameter("type").getBytes
                ("iso-8859-1"), "utf-8");
        String msg = BookDao.editRoom(bid, roomid, name, gender, phone, id, begintime, finishtime,
                type);
        System.out.println(msg);

        if (msg.equals("该时段不存在空房")) {
            request.getSession().setAttribute("tip", msg);
            response.getWriter().print("<script>eval(history.go(-1))</script>");
            //response.sendRedirect("/Booking");
        } else {
            if (msg.equals(""))
                request.getSession().removeAttribute("tip");
            else
                request.getSession().setAttribute("tip", msg);
            if (UserDao.IsAdmin((String) request.getSession().getAttribute("Account")) == 0) {
                response.sendRedirect("/Booking?cz=user");
                return;
            }
            response.sendRedirect("/Booking");
            return;
        }
    }

    public void deleteBook(javax.servlet.http.HttpServletRequest request, javax.servlet.http
            .HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //根据房间号跳转到预定房间界面
        String id = request.getParameter("bid");
        String roomid = request.getParameter("roomid");
        //String msg = Book.chooseRoom(name, gender, phone, id, begintime, finishtime, type,
        // remark);
        String msg = "";
        msg = BookDao.deletebook(id, roomid);
        if (msg.equals("该时段不存在空房")) {
            request.getSession().setAttribute("tip", msg);
        } else {
            if (msg.equals(""))
                request.getSession().removeAttribute("tip");
            else
                request.getSession().setAttribute("tip", msg);
        }

        if (UserDao.IsAdmin((String) request.getSession().getAttribute("Account")) == 0) {
            response.sendRedirect("/Booking?cz=user");
            return;
        }
        response.sendRedirect("/Booking");
        return;
    }

}

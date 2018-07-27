package servlets;

import dao.RoomDao;
import dao.RoomEXDao;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet_Room", value = "/Room")
public class Servlet_Room extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String param = request.getParameter("param");
        if (param != null) {
            switch (param) {
                case "1":
                    //修改
                    search(request, response);
                    break;
                case "2":
                    //退房
                    out(request,response);
                    break;
                case "3":
                    //修改提交到数据库
                    edit(request, response);
                    break;
                case "4":
                    //添加房间
                    add(request, response);
                    break;
                case "5":
                    user_search(request, response);
                    break;
                case "6":
                    detail(request, response);
                    break;
            }
        } else {
            search(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void search(javax.servlet.http.HttpServletRequest request, javax.servlet.http
            .HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //根据房间号跳转到预定房间界面

        String roomid = request.getParameter("roomid");
        if (roomid != null && !roomid.equals("")) {
            List<model.Room> result;
            result = RoomDao.getRoomByID(roomid);
            request.getSession().setAttribute("room", result);
            response.sendRedirect("/admin/edit_room.jsp");
        } else {
            List<model.RoomEX> result;
            result = RoomEXDao.getAllRoom();
            request.getSession().setAttribute("rooms", result);
            response.sendRedirect("/admin/all_rooms.jsp");
        }

    }

    public void user_search(javax.servlet.http.HttpServletRequest request, javax.servlet.http
            .HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //跳转到用户查看房间页面
        HttpSession hs = request.getSession();
        String user_id = (String)hs.getAttribute("User_ID");
        List<model.RoomEX> result;
        result=RoomEXDao.getRoomByID((String)request.getSession().getAttribute("ID"));
        int Balance=RoomEXDao.getBalance((String)request.getSession().getAttribute("ID"));
        System.out.println((String)request.getSession().getAttribute("ID"));
        if(Balance<0)
        {
            request.getSession().setAttribute("tip", "您已欠费"+Balance+"元");
        }
        request.getSession().setAttribute("rooms", result);
        response.sendRedirect("/admin/all_rooms_user.jsp");

    }

    public void edit(javax.servlet.http.HttpServletRequest request, javax.servlet.http
            .HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String roomid=request.getParameter("roomid");
        String type=request.getParameter("type")  ;
        String area=request.getParameter("area");
        String count=request.getParameter("count");
        String hiremoney=request.getParameter("hiremoney");
        String things=request.getParameter("things");
        String enregister=request.getParameter("enregister");
        String remark=request.getParameter("remark");
        RoomDao.updateRoom(type,area,count,hiremoney,things,enregister,remark,roomid);
        response.sendRedirect("/Room");
    }

    public void out(javax.servlet.http.HttpServletRequest request, javax.servlet.http
            .HttpServletResponse response) throws javax.servlet.ServletException, IOException{
        String id = request.getParameter("id");
        String msg=RoomDao.outRoom(id);
       if(!msg.equals(""))
            request.getSession().setAttribute("tip",msg);
        if (UserDao.IsAdmin((String)request.getSession().getAttribute("Account"))==1)
        {
            response.sendRedirect("/Room");
        }
        else
        {
            response.sendRedirect("/Room?param=5");
        }

    }

    public void add(javax.servlet.http.HttpServletRequest request, javax.servlet.http
            .HttpServletResponse response) throws javax.servlet.ServletException, IOException{
        String roomid=request.getParameter("roomid");
        String type=request.getParameter("type")  ;
        String area=request.getParameter("area");
        String count=request.getParameter("count");
        String hiremoney=request.getParameter("hiremoney");
        String things=request.getParameter("things");
        String enregister=request.getParameter("enregister");
        String enregisterTime=new String(request.getParameter("enregisterTime").getBytes
                ("iso-8859-1"), "utf-8");
        String remark=request.getParameter("remark");
        if(RoomDao.exist(roomid))
        {
            RoomDao.addRoom(roomid,type,area,count,hiremoney,things,enregister,enregisterTime,remark);
            response.sendRedirect("/Room");
        }else{
            request.getSession().setAttribute("tip","已存在该房间");
            response.getWriter().print("<script>eval(history.go(-1))</script>");
        }



    }

    public void detail(javax.servlet.http.HttpServletRequest request, javax.servlet.http
            .HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<model.Room> result;
        String Roomid=request.getParameter("roomid");
        result=RoomDao.getRoomDetail(Roomid);
        String path=(String)result.get(0).getRoom_Picture();
        String[]  strs=path.split(";");
        request.getSession().setAttribute("pic", strs);
        request.getSession().setAttribute("detail", result);
        response.sendRedirect("/admin/room_detail.jsp");
    }

}

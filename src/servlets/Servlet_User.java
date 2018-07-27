package servlets;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet_User", value = "/User")
public class Servlet_User extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("param");
        System.out.println("cz:" + request.getParameter("cz"));
        if (param != null) {
            switch (param) {
                case "0":
                    //System.out.println("logout");
                    logOut(request, response);
                    break;
                default:
                    break;
            }
        } else {
            if ("r".equals(request.getParameter("cz"))) {
                int flag = UserDao.getEmailByAccount(request.getParameter("email"));

                if (flag == 1) {
                    request.getSession().setAttribute("tip", "邮箱重复");
                    response.sendRedirect("/admin/add_user.jsp");
                    return;
                }

                int type = 2;
                if ("管理员".equals(request.getParameter("type"))) {
                    type = 1;
                }
                String sex = new String(request.getParameter("sex").getBytes("iso-8859-1"),
                        "utf-8");
                String name = new String(request.getParameter("firstname").getBytes("iso-8859-1"),
                        "utf-8") + new String(request.getParameter("lastname").getBytes("iso-8859-1"),
                        "utf-8");
                UserDao.insert(request.getParameter("email"), request.getParameter("pwd"), name
                        , "photo", sex, request.getParameter
                                ("id"), type, request.getParameter("phone"), request.getParameter("date")
                        , request.getParameter("Balance"));
                request.getSession().setAttribute("tip", "添加成功");
                //添加查询界面后，新增成功就直接进入查询页面
                search(request, response);
            }
            if ("u".equals(request.getParameter("cz"))) {

                int type = 2;
                if ("管理员".equals(request.getParameter("type"))) {
                    type = 1;
                }
                String sex = new String(request.getParameter("sex").getBytes
                        ("iso-8859-1"), "utf-8");
                String name = new String(request.getParameter("firstname").getBytes
                        ("iso-8859-1"), "utf-8");
                UserDao.update(request.getParameter("pwd"), name, sex, request.getParameter("id"),
                        type, request.getParameter("phone"), request.getParameter("Balance"), request.getParameter("account"));
                //System.out.println(request.getParameter("account"));
                request.getSession().setAttribute("tip", "修改成功");
                //添加查询界面后，新增成功就直接进入查询页面
                search(request, response);
            }
            if ("useru".equals(request.getParameter("cz"))) {
                String sex = new String(request.getParameter("sex").getBytes
                        ("iso-8859-1"), "utf-8");
                String name = new String(request.getParameter("firstname").getBytes
                        ("iso-8859-1"), "utf-8");
                UserDao.update_user(request.getParameter("pwd"), name, sex, request.getParameter
                        ("phone"), request.getParameter("account"));
                request.getSession().setAttribute("tip", "修改成功");
                //添加查询界面后，新增成功就直接进入查询页面
                response.sendRedirect("/Room?param=5");
            }
            if ("ur".equals(request.getParameter("cz"))) {
                int flag = UserDao.getEmailByAccount(request.getParameter("userName"));
                if (flag == 1) {
                    request.getSession().setAttribute("tip", "邮箱重复");
                    System.out.println("邮箱重复");
                    response.sendRedirect("/userlogin/userlogin.jsp");
                    return;
                }
                if (UserDao.getIDByAccount(request.getParameter("User_id")) == 1) {
                    System.out.println("进入");
                    request.getSession().setAttribute("tip", "身份证重复");
                    System.out.println("身份证重复");
                    response.sendRedirect("/userlogin/userlogin.jsp");
                    return;
                }
                UserDao.u_insert(request.getParameter("userName"), request.getParameter("password"), request.getParameter("User_id"));
                request.getSession().setAttribute("tip", "注册成功");
                //添加查询界面后，新增成功就直接进入查询页面
                response.sendRedirect("/userlogin/userlogin.jsp");
                return;
            }

            if ("dl".equals(request.getParameter("cz"))) {
              //  System.out.println("test" + UserDao.IsAdmin(request.getParameter("userName")));
                if (UserDao.IsAdmin(request.getParameter("userName")) == 1 || request.getSession().getAttribute("UID") != null) {
                    if (UserDao.selectPwd(request.getParameter("userName"), request.getParameter("password")) == 1) {
                        HttpSession hs = request.getSession();
                        hs.setAttribute("ID", UserDao.Select_UserID(request.getParameter("userName")));
                        hs.setAttribute("UID", UserDao.Select_UserID(request.getParameter
                                ("userName")));
                        hs.setAttribute("Account", request.getParameter("userName"));
                        hs.setAttribute("Name", UserDao.Select_UserName(request.getParameter("userName")));
                        hs.setAttribute("Tel", UserDao.Select_UserTel(request.getParameter("userName")));
                        hs.setAttribute("Sex", UserDao.Select_UserSex(request.getParameter("userName")));
                      //  System.out.println("acc");
                        response.sendRedirect("/Analyse");
                        return;
                    } else if (request.getSession().getAttribute("UID") != null) {
                        //已经登陆过了
                        response.sendRedirect("/Analyse");
                    }
                } else {
                    if (UserDao.selectPwd(request.getParameter("userName"), request.getParameter
                            ("password")) == 1 || request.getSession().getAttribute("UID") !=
                            null) {
                        HttpSession hs = request.getSession();
                        System.out.println("username:" + request.getParameter("userName"));
                        System.out.println("id:" + UserDao.Select_UserID(request.getParameter
                                ("userName")));
                        hs.setAttribute("UID", UserDao.Select_UserID(request.getParameter("userName")));
                        hs.setAttribute("ID", UserDao.Select_UserID(request.getParameter("userName")));
                        hs.setAttribute("Account", request.getParameter("userName"));
                        hs.setAttribute("Name", UserDao.Select_UserName(request.getParameter("userName")));
                        hs.setAttribute("Tel", UserDao.Select_UserTel(request.getParameter("userName")));
                        hs.setAttribute("Sex", UserDao.Select_UserSex(request.getParameter("userName")));
                        response.sendRedirect("/Room?param=5");
                        return;
                    } else if (request.getSession().getAttribute("UID") != null) {
                        //已经登陆过了
                        response.sendRedirect("/Room?param=5");
                    } else {
                        request.getSession().setAttribute("tip", "用户名或密码错误");
                        response.sendRedirect("/userlogin/userlogin.jsp");
                        return;
                    }
                }
            } else if ("xg".equals(request.getParameter("cz"))) {
                List<model.User> result;
                String id = (String) request.getSession().getAttribute("UID");
                result = UserDao.getUserByID(id);
                System.out.println(result.size());
                request.getSession().setAttribute("user", result);
                response.sendRedirect("/admin/edit_user_user.jsp");
            } else if ("view".equals(request.getParameter("cz"))) {
                search(request, response);
            } else if ("del".equals(request.getParameter("cz"))) {
                delete(request, response);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("logout");
        request.getSession().setAttribute("UID", null);
        request.getSession().removeAttribute("UID");
        if(request.getSession().getAttribute("UID")!=null)
            System.out.println("uid:"+request.getSession().getAttribute("UID"));
        else
            System.out.println("ok");
        request.getSession().invalidate();//用来清空会话，放在退出操作里
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);//这三句用来刷新缓存，放在需要验证登录的页面里

        response.sendRedirect("/mainpage/index.jsp");
    }

    public void search(javax.servlet.http.HttpServletRequest request, javax.servlet.http
            .HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<model.User> result;

        String userid = request.getParameter("userid");
        if (userid != null && !userid.equals("")) {
            result = UserDao.getUserByID(userid);
            System.out.println(result.size());
            request.getSession().setAttribute("user", result);
            response.sendRedirect("/admin/edit_user.jsp");
        } else {
            //System.out.println("test");
            result = UserDao.getAllUser();
            System.out.print(result.size());
            request.getSession().setAttribute("users", result);
            request.getSession().setAttribute("tip", "");
            response.sendRedirect("/admin/all_users.jsp");
        }
    }

    public void delete(javax.servlet.http.HttpServletRequest request, javax.servlet.http
            .HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String userid = request.getParameter("userid");
        UserDao dao = new UserDao();
        dao.delete(userid);
        List<model.User> result;
        result = UserDao.getAllUser();
        System.out.print(result.size());
        request.getSession().setAttribute("users", result);
        response.sendRedirect("/admin/all_users.jsp");
    }
}

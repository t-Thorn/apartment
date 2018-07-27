package dao;

import Tool.Tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static  int selectPwd(String account,String Pwd)
    {
        JDBCUtil util = new JDBCUtil();
        String sql = "SELECT User_Pwd FROM useristrator WHERE User_Account=?";

        ResultSet rs = util.getResultSet(sql, account);
        try {
            while(rs.next())
            {
                String pwd= rs.getString("User_Pwd");
                if(pwd.equals(Pwd))
                {
                    return 1;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }

    public static int IsAdmin(String account)
    {
        JDBCUtil util = new JDBCUtil();
        String sql = "SELECT User_Role FROM useristrator WHERE User_Account=?";
        ResultSet rs = util.getResultSet(sql, account);

        try {
            while(rs.next())
            {
                int type=rs.getInt("User_Role");
                System.out.println(type);
                if(type==1){
                    return 1;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }
    public static JDBCUtil jdbcUtil=new JDBCUtil();

    public static void updateUserBalance(String id,float money) {
        String sql="update useristrator set balance=? where User_ID=?";
        jdbcUtil.executeUpdate(sql,getUserBalance(id)-money,id);
    }
    public static void updateUserBalancein(String id,float money) {
        String sql="update useristrator set balance=? where User_ID=?";
        jdbcUtil.executeUpdate(sql,getUserBalance(id)+money,id);
    }
    public static double getUserBalance(String id) {
        String sql="select balance from useristrator  where User_ID=?";
        List<model.User> list=jdbcUtil.getQuery(sql,new model.User(),id);
        return  list.get(0).getBalance();
    }
    public static int exist(String user_ID){
        //-1代表不存在
        String sql="select * from useristrator where User_ID=?";
        List<model.User> list= jdbcUtil.getQuery(sql,new model.User(),user_ID);
        if( list.size()>0)
            return 1;
        else
            return -1;
    }

    public static void insert(Object...params){
        JDBCUtil util = new JDBCUtil();
        String sql = "INSERT INTO useristrator VALUES(null,?,?,?,?,?,?,?,?,?,?)";
        jdbcUtil.executeUpdate(sql,params);
    }
    public static int getEmailByAccount(String email)
    {
        model.User user=null;
        JDBCUtil util=new JDBCUtil();
        List<model.User> list=new ArrayList();
        String sql= "Select User_Account from useristrator where User_Account=?";
        list=util.getQuery(sql,new model.User(),email);
        System.out.println(list.size());
        if(list.size()>=1)
        {
            return 1;
        }
        else
            return 0;
    }


    public static int getIDByAccount(String email)
    {
        JDBCUtil util=new JDBCUtil();
        List<model.User> list=new ArrayList();
        String sql= "Select User_Id from useristrator where User_ID=?";
        list=util.getQuery(sql,new model.User(),email);
        System.out.println(list.size());
        if(list.size()>=1)
        {
            return 1;
        }
        else
            return 0;
    }
    public static List getUserByID(String userid)
    {
        JDBCUtil util=new JDBCUtil();
        List<model.User> list=new ArrayList();
        String sql= "Select *" +
                " from useristrator where User_ID=?";
        System.out.println("id:"+userid);
        list=util.getQuery(sql,new model.User(),userid);
        return list;
    }
    public static List getAllUser()
    {
        JDBCUtil util=new JDBCUtil();
        //List<User> list=new ArrayList();
        String sql= "Select * from useristrator";
        List<model.User> list=util.getQuery(sql,new model.User());
        return list;
    }


    public static void u_insert(Object...params){
        JDBCUtil util = new JDBCUtil();
        String sql = "INSERT INTO useristrator(User_account,User_Pwd,User_Role,User_ID) VALUES(?,?,2,?)";
        util.executeUpdate(sql,params);
    }

    public static  String Select_UserID(String Account)
    {
        JDBCUtil util = new JDBCUtil();
        String sql = "SELECT User_ID FROM useristrator WHERE User_Account=?";
        ResultSet rs = util.getResultSet(sql, Account);
        try {
            while(rs.next())
            {
                return rs.getString("user_id");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "";
    }

    public static  String Select_UserSex(String Account)
    {
        JDBCUtil util = new JDBCUtil();
        String sql = "SELECT User_sex FROM useristrator WHERE User_Account=?";
        ResultSet rs = util.getResultSet(sql, Account);
        try {
            while(rs.next())
            {
                return rs.getString("user_sex");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "";
    }

    public static  String Select_UserTel(String Account)
    {
        JDBCUtil util = new JDBCUtil();
        String sql = "SELECT User_Tel FROM useristrator WHERE User_Account=?";
        ResultSet rs = util.getResultSet(sql, Account);
        try {
            while(rs.next())
            {
                return rs.getString("user_tel");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "";
    }
    public static  String Select_UserName(String Account)
    {
        JDBCUtil util = new JDBCUtil();
        String sql = "SELECT User_Name FROM useristrator WHERE User_Account=?";
        ResultSet rs = util.getResultSet(sql, Account);
        try {
            while(rs.next())
            {
                return rs.getString("user_name");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "";
    }
    public static void delete(String userid){
        JDBCUtil util=new JDBCUtil();
        String sql= "delete from useristrator where User_ID=?";
        jdbcUtil.executeUpdate(sql,userid);

    }
    public static void update(Object...params)
    {
        JDBCUtil util = new JDBCUtil();
        String sql = "update useristrator set User_Pwd=?, User_Name=?, User_Sex=?, User_ID=?, User_Role=?, User_Tel=?, Balance=? where User_Account=?";
        jdbcUtil.executeUpdate(sql,params);
    }
    public static void update_user(Object...params)
    {
        String sql = "update useristrator set User_Pwd=?, User_Name=?, User_Sex=?,  User_Tel=? where User_Account=?";
        jdbcUtil.executeUpdate(sql,params);
    }

    public  static int getNewUser(){
        String sql=" select count(id) from useristrator where add_time>=? and " +
                "add_time<?";

        try(  ResultSet rs=jdbcUtil.getResultSet(sql,Tools.getNowMonth(),Tools.getNextMonth())) {
            if(rs.next())
            {
                return rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
}


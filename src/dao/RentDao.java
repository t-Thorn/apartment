package dao;

import Tool.Tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RentDao {
    static JDBCUtil jdbcUtil = new JDBCUtil();

    public static model.Rent getRent(String id) {
        String sql = "select * from rent where id=" + id;
        System.out.println(id);
        List< model.Rent> rents = jdbcUtil.getQuery(sql, new  model.Rent());
        System.out.println(rents.size());
        return rents.get(0);
    }

    public static boolean isFree(int roomid) {
        String cc = Tools.getDate();
        String sql = "select count(id) from rent where room_num=" + roomid + " and " +
                "Hire_Finaltime>'" + cc + "'";
        ResultSet rs = jdbcUtil.getResultSet(sql);
        try {
            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println(count);
                if (count == 0)
                    return true;
                else
                    return false;
            }
        } catch (SQLException e) {

        }
        return false;
    }

    public static void addRent(String major_Roomer,int room_Num,String mobilephone,String
            book_PersonID, String startime,String finishtime,String gender,float Hire_Money,
                               String Admin_Name ){
        String sql="insert into rent  (Major_Roomer,IDCard,gender,Room_num," +
                "Roomer_Mobile,Hire_StarTime,Hire_Finaltime,Hire_Money,Admin_Name,Register_Time) values(?,?,?," +
                "?,?,?,?,?,?,?)";
        jdbcUtil.executeUpdate(sql,major_Roomer,book_PersonID,gender,room_Num,mobilephone,startime,
                finishtime,Hire_Money,Admin_Name ,Tools.getDate());
    }

    public static void updateRent(String Major_Roomer,String IDCard,String
            Room_num,String Roomer_Mobile,String Hire_StarTime,String Hire_Finaltime,String id) {
           String sql="update rent set Major_Roomer=?,IDCard=?,Room_num=?,Roomer_Mobile=?," +
                   "Hire_StarTime=?,Hire_Finaltime=? where id=?";
           jdbcUtil.executeUpdate(sql,Major_Roomer,IDCard,Room_num,Roomer_Mobile,Hire_StarTime,
                   Hire_Finaltime,id);
    }
}

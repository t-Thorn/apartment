package dao;

import Tool.Tools;

import java.util.List;

public class RoomerDao {


    public static JDBCUtil jdbcUtil=new JDBCUtil();

    public static int getRoomerByID(String roomer_ID){
        //-1代表不存在
        String sql="select * from roomer where Roomer_ID=?";
        List<model.Roomer> list= jdbcUtil.getQuery(sql,new model.Roomer(),roomer_ID);
        if( list.size()>0)
            return 1;
        else
            return -1;
    }

    public static void addRoomer(String roomer_Name,String gender,String roomer_ID,String
            mobilephone){
       // System.out.println("addroomer");
        String sql="insert into roomer (Roomer_Name,Roomer_Sex,Roomer_ID,Mobilephone," +
                "Enregister_Time)values(?,?,?,?,?)";
        jdbcUtil.executeUpdate(sql,roomer_Name,gender,roomer_ID,mobilephone,Tools.getDate());
    }
}

package dao;


import Tool.Tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//在room表基础上加入所属房客
public class RoomEXDao {


    static JDBCUtil jdbcUtil = new JDBCUtil();

    public static List<model.RoomEX> getAllRoom() {
        String cc=Tools.getDate();
        String sql = "SELECT room.Room_Num,Room_PersCount,Room_Type,Room_Area,room" +
                ".Hire_Money, Room_Things,Room_Status,Room_Picture,Enregister_Pers,room" +
                ".Remark,Major_Roomer,rent.id FROM	rent RIGHT JOIN room ON (room" +
                ".Room_Num=rent.Room_num and Hire_Finaltime>'"+cc+"' and " +
                "Hire_StarTime<='"+cc+"') group by room.room_num";
        return jdbcUtil.getQuery(sql,new model.RoomEX());
    }

    private static List<model.RoomEX> getRoom(java.lang.String sql) {

        return jdbcUtil.getQuery(sql, new model.RoomEX());

    }


    public static int getBalance(String ID)
    {
        String sql="SELECT Balance FROM `useristrator` WHERE user_id=?";
        ResultSet rs =jdbcUtil.getResultSet(sql, ID);
        int b=0;

        try {
            while(rs.next()){
                b = rs.getInt("Balance");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return b;
    }

    public static List<model.RoomEX>  getRoomByID(String ID){

        String cc=Tools.getDate();
        String sql="SELECT room.Room_Num,Room_PersCount,Room_Type,Room_Area,room" +
                ".Hire_Money, Room_Things,Room_Status,Room_Picture,Enregister_Pers,room" +
                ".Remark,Major_Roomer,rent.id FROM\trent RIGHT JOIN room ON (room" +
                ".Room_Num=rent.Room_num and Hire_Finaltime>'"+cc+"' and " +
                "Hire_StarTime<='"+cc+"')  WHERE IDcard=? group by room.room_num";
        List<model.RoomEX> list=jdbcUtil.getQuery(sql,new model.RoomEX(),ID);

        return list;
    }

}

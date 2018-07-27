package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RepairDao {

    public static JDBCUtil jdbcUtil =new JDBCUtil();


    public static List<model.Repair> getAllRepair(){
       String sql="select * from repair order by repair_date desc";
       return jdbcUtil.getQuery(sql,new model.Repair());
    }

    public static List<model.Repair> getRepair(String id){
        String sql="select * from repair where Id="+id;
        return jdbcUtil.getQuery(sql,new model.Repair());
    }

     public static void addNewRepairAdmin(String...strings){
          String sql="insert into repair (Room_Num,Repair_Title,Repair_Type,Employee_Charge,Material_Charge," +
                  "Total_Charge,Repair_Date,Repair_Content,Remark,Register)" +
                  "values(?,?,?,?,?,?,?,?,?,?)";
          jdbcUtil.executeUpdate(sql,strings);
          AccountDao.outRepair(strings[5]);
     }

    public static void addNewRepairUser(String...strings){
        String sql="insert into repair (Room_Num,Repair_Title,Repair_Type,Register)" +
                "values(?,?,?,?)";
        jdbcUtil.executeUpdate(sql,strings);
    }

    public static void editNewRepairAdmin(String...strings){
        String sql="select total_charge,register from repair where id=?";
        List <model.Repair> list=jdbcUtil.getQuery(sql,new model.Repair(),strings[8]);
        float total=list.get(0).getTotal_Charge();
         sql="update  repair set Room_Num=?,Repair_Title=?,Repair_Type=?," +
                "Employee_Charge=?," +
                "Material_Charge=?,Total_Charge=?,Repair_Content=?,Remark=? where Id=?" ;
       /* for(String s:strings){
            System.out.print(s+" ");
        }8*/
        jdbcUtil.executeUpdate(sql,strings);
        System.out.println("Q:"+total);
        total=total-Float.parseFloat(strings[5]);
        System.out.println("H:"+total);
        if(total<0)
        {

            System.out.println("扣钱");
            if(!list.get(0).getRegister().equals("admin"))
                UserDao.updateUserBalance(list.get(0).getRegister(),Math.abs(total));
            else
            {
                dao.AccountDao.outRepair(String.valueOf(Math.abs(total)));
            }
        }
        else if(total>0)
        {

            System.out.println("加钱");
            //return "清收差价"+total;
            if(!list.get(0).getRegister().equals("admin"))
                UserDao.updateUserBalancein(list.get(0).getRegister(),total);
            else
                dao.AccountDao.in(String.valueOf(total));
        }
    }

    public static void deleteRepair(String id){
        String sql="select Total_Charge from repair where Id=?";
        ResultSet rs=jdbcUtil.getResultSet(sql,id);
        float money=0;
        try{
            if(rs.next())
                money=rs.getFloat(1);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        sql="delete  from repair where Id=?";
        jdbcUtil.executeUpdate(sql,id);
        AccountDao.in(String.valueOf(money));
    }
}

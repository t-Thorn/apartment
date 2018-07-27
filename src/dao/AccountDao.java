package dao;

import Tool.Tools;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {

    public static JDBCUtil jdbcUtil = new JDBCUtil();

    public static void out(String money) {//退回预定的钱
        String sql = "insert into account (type,money,time) values(?,?,?)";
        jdbcUtil.executeUpdate(sql, 1, money, Tools.getDate());
    }

    public static void in(String money) {
        String sql = "insert into account (type,money,time) values(?,?,?)";
        jdbcUtil.executeUpdate(sql, 0, money, Tools.getDate());
    }

    public static void outRepair(String money) {
        String sql = "insert into account (type,money,time) values(?,?,?)";
        jdbcUtil.executeUpdate(sql, 2, money, Tools.getDate());
    }


    public static int getOrder() {
        String sql = " select count(id) from book where Book_StartTime>=? and " +
                "Book_StartTime<?";
        try (ResultSet rs = jdbcUtil.getResultSet(sql, Tools.getNowMonth(), Tools.getNextMonth())) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static float getOut(){
        String sql = "SELECT sum(money) from account where time>? and time<? and type!=0";

        try (ResultSet rs = jdbcUtil.getResultSet(sql, Tools.getNowMonth(), Tools.getNextMonth())){
            if (rs.next()) {
                return rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
return 0;
    }
    public static float getIncome() {
        String sql = " SELECT sum(money) from account where time>? and time<? and type=0";
        float income = 0;
        float in=0;
        try ( ResultSet rs = jdbcUtil.getResultSet(sql, Tools.getNowMonth(), Tools.getNextMonth())){
            if (rs.next()) {
                 in = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        income=in-getOut();
        return income;
    }

}

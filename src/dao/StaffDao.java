package dao;

import java.util.List;

public class StaffDao {
	public static JDBCUtil jdbcUtil = new JDBCUtil();
public void insert(Object...params)
{
	String sql = "INSERT INTO roomer VALUES(null,?,?,?,?,?)";
	jdbcUtil.executeUpdate(sql,params);
	}

public static List<model.Roomer> getAllStaff()
{
	String sql= "Select * from roomer";
	List<model.Roomer> list=jdbcUtil.getQuery(sql,new model.Roomer());
	return list;
	}
public static List<model.Roomer> getStaffByID(String staffid)
{
	String sql= "Select * from roomer where roomer_id=?";
	List<model.Roomer> list=jdbcUtil.getQuery(sql,new model.Roomer(),staffid);
	return list;
	}
public static int getStaffID(String StaffId)
{
	String sql= "Select Roomer_ID from roomer where roomer_id=?";
	List<model.Roomer> list=jdbcUtil.getQuery(sql,new model.Roomer(),StaffId);
	if(list.size()>0)
	{
		return 1;
	}
	else
	{
		return 0;
	}
}

public void update(Object...params)
{
	String sql = "update roomer set Roomer_Name=?, Roomer_Sex=?, Mobilephone=?, Enregister_Time=? where Roomer_ID=?";
	jdbcUtil.executeUpdate(sql,params);
}
public void delete(String roomerid)
{
	String sql= "delete from roomer where Roomer_ID=?";
	jdbcUtil.executeUpdate(sql,roomerid);
	}
}

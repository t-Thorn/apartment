package model;

import java.util.Date;

public class User {
    private int Id;
    private String User_Account;
    private String User_Pwd;
    private String User_Name;
    private String User_Photo;
    private String User_Sex;
    private String User_ID;
    private int User_Role;
    private String User_Tel;
    private Date Add_Time;
    private float Balance;

    public int getId() {

        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUser_Account() {
        return User_Account;
    }

    public void setUser_Account(String user_Account) {
        User_Account = user_Account;
    }

    public String getUser_Pwd() {
        return User_Pwd;
    }

    public void setUser_Pwd(String user_Pwd) {
        User_Pwd = user_Pwd;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Photo() {
        return User_Photo;
    }

    public void setUser_Photo(String user_Photo) {
        User_Photo = user_Photo;
    }

    public String getUser_Sex() {
        return User_Sex;
    }

    public void setUser_Sex(String user_Sex) {
        User_Sex = user_Sex;
    }

    public String getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(String user_ID) {
        User_ID = user_ID;
    }

    public int getUser_Role() {
        return User_Role;
    }

    public void setUser_Role(int user_Role) {
        User_Role = user_Role;
    }

    public String getUser_Tel() {
        return User_Tel;
    }

    public void setUser_Tel(String user_Tel) {
        User_Tel = user_Tel;
    }

    public Date getAdd_Time() {
        return Add_Time;
    }

    public void setAdd_Time(Date add_Time) {
        Add_Time = add_Time;
    }

    public float getBalance() {
        return Balance;
    }

    public void setBalance(float balance) {
        Balance = balance;
    }
}

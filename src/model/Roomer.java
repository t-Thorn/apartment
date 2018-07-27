package model;

import java.util.Date;

public class Roomer {
    private int Id;
    private String Roomer_Name;
    private String Roomer_Sex;
    private String Roomer_Photo;
    private String Roomer_ID;
    private String Mobilephone;
    private String Remark;
    private int Roomer_Age;
    private Date Enregister_Time;
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getRoomer_Name() {
        return Roomer_Name;
    }
    public void setRoomer_Name(String roomer_Name) {
        Roomer_Name = roomer_Name;
    }
    public String getRoomer_Sex() {
        return Roomer_Sex;
    }
    public void setRoomer_Sex(String roomer_Sex) {
        Roomer_Sex = roomer_Sex;
    }
    public String getRoomer_Photo() {
        return Roomer_Photo;
    }
    public void setRoomer_Photo(String roomer_Photo) {
        Roomer_Photo = roomer_Photo;
    }
    public String getRoomer_ID() {
        return Roomer_ID;
    }
    public void setRoomer_ID(String roomer_ID) {
        Roomer_ID = roomer_ID;
    }
    public String getMobilephone() {
        return Mobilephone;
    }
    public void setMobilephone(String mobilephone) {
        Mobilephone = mobilephone;
    }
    public String getRemark() {
        return Remark;
    }
    public void setRemark(String remark) {
        Remark = remark;
    }
    public int getRoomer_Age() {
        return Roomer_Age;
    }
    public void setRoomer_Age(int roomer_Age) {
        Roomer_Age = roomer_Age;
    }
    public Date getEnregister_Time() {
        return Enregister_Time;
    }
    public void setEnregister_Time(Date enregister_Time) {
        Enregister_Time = enregister_Time;
    }
}

package model;

import java.util.Date;

public class RoomEX {
    private int id;//RENT的ID
    private int ID;
    private int Room_Num;
    private int Room_PersCount;
    private String Room_Type;
    private float Room_Area;
    private float Room_Deposit;
    private float Hire_Money;
    private String Room_Things;
    private int Room_Status;
    private String Room_Picture;
    private String Enregister_Pers;
    private Date Enregister_Time;
    private String Remark;
    private String Major_Roomer;
    private Date Hire_StarTime;
    private Date Hire_Finaltime;
    private String IDCard;

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getRoom_Num() {
        return Room_Num;
    }

    public void setRoom_Num(int room_Num) {
        Room_Num = room_Num;
    }

    public int getRoom_PersCount() {
        return Room_PersCount;
    }

    public void setRoom_PersCount(int room_PersCount) {
        Room_PersCount = room_PersCount;
    }

    public String getRoom_Type() {
        return Room_Type;
    }

    public void setRoom_Type(String room_Type) {
        Room_Type = room_Type;
    }

    public float getRoom_Area() {
        return Room_Area;
    }

    public void setRoom_Area(float room_Area) {
        Room_Area = room_Area;
    }

    public float getRoom_Deposit() {
        return Room_Deposit;
    }

    public void setRoom_Deposit(float room_Deposit) {
        Room_Deposit = room_Deposit;
    }

    public float getHire_Money() {
        return Hire_Money;
    }

    public void setHire_Money(float hire_Money) {
        Hire_Money = hire_Money;
    }

    public String getRoom_Things() {
        return Room_Things;
    }

    public void setRoom_Things(String room_Things) {
        Room_Things = room_Things;
    }

    public int getRoom_Status() {
        return Room_Status;
    }

    public void setRoom_Status(int room_Status) {
        Room_Status = room_Status;
    }

    public String getRoom_Picture() {
        return Room_Picture;
    }

    public void setRoom_Picture(String room_Picture) {
        Room_Picture = room_Picture;
    }

    public String getEnregister_Pers() {
        return Enregister_Pers;
    }

    public void setEnregister_Pers(String enregister_Pers) {
        Enregister_Pers = enregister_Pers;
    }

    public Date getEnregister_Time() {
        return Enregister_Time;
    }

    public void setEnregister_Time(Date enregister_Time) {
        Enregister_Time = enregister_Time;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getMajor_Roomer() {
        return Major_Roomer;
    }

    public void setMajor_Roomer(String major_Roomer) {
        Major_Roomer = major_Roomer;
    }

    public Date getHire_StarTime() {
        return Hire_StarTime;
    }

    public void setHire_StarTime(Date hire_StarTime) {
        Hire_StarTime = hire_StarTime;
    }

    public Date getHire_Finaltime() {
        return Hire_Finaltime;
    }

    public void setHire_Finaltime(Date hire_Finaltime) {
        Hire_Finaltime = hire_Finaltime;
    }
}

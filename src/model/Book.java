package model;

import java.util.Date;

public class Book {
    private int id;
    private String Room_Num;
    private String Book_Person;
    private String Book_PersonID;
    private String Mobilephone;
    private Date Book_StartTime;
    private Date Book_FinalTime;
    private float Book_Money;
    private String Admin_Name;
    private Date Register_Time;
    private String Remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_Num() {
        return Room_Num;
    }

    public void setRoom_Num(String room_Num) {
        Room_Num = room_Num;
    }

    public String getBook_Person() {
        return Book_Person;
    }

    public void setBook_Person(String book_Person) {
        Book_Person = book_Person;
    }

    public String getBook_PersonID() {
        return Book_PersonID;
    }

    public void setBook_PersonID(String book_PersonID) {
        Book_PersonID = book_PersonID;
    }

    public String getMobilephone() {
        return Mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        Mobilephone = mobilephone;
    }

    public Date getBook_StartTime() {
        return Book_StartTime;
    }

    public void setBook_StartTime(Date book_StartTime) {
        Book_StartTime = book_StartTime;
    }

    public Date getBook_FinalTime() {
        return Book_FinalTime;
    }

    public void setBook_FinalTime(Date book_FinalTime) {
        Book_FinalTime = book_FinalTime;
    }

    public float getBook_Money() {
        return Book_Money;
    }

    public void setBook_Money(float book_Money) {
        Book_Money = book_Money;
    }

    public String getAdmin_Name() {
        return Admin_Name;
    }

    public void setAdmin_Name(String admin_Name) {
        Admin_Name = admin_Name;
    }

    public Date getRegister_Time() {
        return Register_Time;
    }

    public void setRegister_Time(Date register_Time) {
        Register_Time = register_Time;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
}

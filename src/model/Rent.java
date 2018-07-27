package model;

import java.util.Date;

public class Rent {
    private int Id;
    private String Major_Roomer;
    private String IDCard;
    private int Room_Num;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String Roomer_Mobile;
    private Date Hire_StarTime;
    private Date Hire_Finaltime;
    private float Hire_Money;
    private float Room_Desposit;
    private float Fact_Charge;
    private String Admin_Name;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMajor_Roomer() {
        return Major_Roomer;
    }

    public void setMajor_Roomer(String major_Roomer) {
        Major_Roomer = major_Roomer;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public int getRoom_Num() {
        return Room_Num;
    }

    public void setRoom_Num(int room_num) {
        Room_Num = room_num;
    }


    public String getRoomer_Mobile() {
        return Roomer_Mobile;
    }

    public void setRoomer_Mobile(String roomer_Mobile) {
        Roomer_Mobile = roomer_Mobile;
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

    public float getHire_Money() {
        return Hire_Money;
    }

    public void setHire_Money(float hire_Money) {
        Hire_Money = hire_Money;
    }

    public float getRoom_Desposit() {
        return Room_Desposit;
    }

    public void setRoom_Desposit(float room_Desposit) {
        Room_Desposit = room_Desposit;
    }

    public float getFact_Charge() {
        return Fact_Charge;
    }

    public void setFact_Charge(float fact_Charge) {
        Fact_Charge = fact_Charge;
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

    private Date Register_Time;
}

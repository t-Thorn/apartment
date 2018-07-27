package model;

import java.util.Date;

public class Repair {
    private int Id;
    private int Room_Num;
    private String Repair_Title;
    private String Repair_Type;
    private float Employee_Charge;
    private float Material_Charge;
    private float Total_Charge;
    private Date Repair_Date;
    private String Repair_Content;
    private String Remark;
    private String Register;

    public String getRegister() {
        return Register;
    }

    public void setRegister(String register) {
        Register = register;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getRoom_Num() {
        return Room_Num;
    }

    public void setRoom_Num(int room_Num) {
        Room_Num = room_Num;
    }

    public String getRepair_Title() {
        return Repair_Title;
    }

    public void setRepair_Title(String repair_Title) {
        Repair_Title = repair_Title;
    }

    public String getRepair_Type() {
        return Repair_Type;
    }

    public void setRepair_Type(String repair_Type) {
        Repair_Type = repair_Type;
    }

    public float getEmployee_Charge() {
        return Employee_Charge;
    }

    public void setEmployee_Charge(float employee_Charge) {
        Employee_Charge = employee_Charge;
    }

    public float getMaterial_Charge() {
        return Material_Charge;
    }

    public void setMaterial_Charge(float material_Charge) {
        Material_Charge = material_Charge;
    }

    public float getTotal_Charge() {
        return Total_Charge;
    }

    public void setTotal_Charge(float total_Charge) {
        Total_Charge = total_Charge;
    }

    public Date getRepair_Date() {
        return Repair_Date;
    }

    public void setRepair_Date(Date repair_Date) {
        Repair_Date = repair_Date;
    }

    public String getRepair_Content() {
        return Repair_Content;
    }

    public void setRepair_Content(String repair_Content) {
        Repair_Content = repair_Content;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
}

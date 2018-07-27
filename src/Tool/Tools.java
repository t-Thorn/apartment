package Tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Tools {
    public static  String getDate(){
        Date d=new Date();
                /*//创建一个格式化对象
                SimpleDateFormat sdf=new SimpleDateFormat();
                System.out.println(sdf);*/
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        //格式化为日期/时间字符串
        java.lang.String cc=sdf.format(d);
        return cc;
    }
    public static  String getDateShort(){
        Date d=new Date();
                /*//创建一个格式化对象
                SimpleDateFormat sdf=new SimpleDateFormat();
                System.out.println(sdf);*/
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //格式化为日期/时间字符串
        java.lang.String cc=sdf.format(d);
        return cc;
    }

    public static Date getDate(String strDate){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            try {
                return  sdf.parse(strDate);
            }catch (ParseException e){
                e.printStackTrace();
            }
        return null;
    }
    public static String getLastday(){
        Date date=new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,-1);//取昨天
        date=calendar.getTime(); //取昨天
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        return dateString;
    }

    public static String getNowMonth(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH )+1;
        System.out.println(month);
        return year+"-"+month+"-"+"00";
    }
    public static String getNextMonth(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH )+1;
        if(month==12)
            year++;
        else
            month++;
        System.out.println(month);
        return year+"-"+month+"-"+"00";
    }
}

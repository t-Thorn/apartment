package task;

import dao.JDBCUtil;
import Tool.Tools;
import dao.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;

/**
 * 在 TimerManager 这个类里面，大家一定要注意 时间点的问题。如果你设定在凌晨2点执行任务。但你是在2点以后
 *发布的程序或是重启过服务，那这样的情况下，任务会立即执行，而不是等到第二天的凌晨2点执行。为了，避免这种情况
 *发生，只能判断一下，如果发布或重启服务的时间晚于定时执行任务的时间，就在此基础上加一天。
 * @author wls
 *
 */
public class NFDFlightDataTimerTask extends TimerTask {
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    JDBCUtil jdbcUtil=new JDBCUtil();
    @Override
    public void run() {
        try {

            //在这里写你要执行的内容
             String sql="select room_num from rent where Hire_Finaltime=?";
             List<model.Rent> endRoom=jdbcUtil.getQuery(sql,new model.Rent(),Tools.getLastday());
            for (model.Rent end:endRoom
                 ) {
                if(RentDao.isFree(end.getRoom_Num()))
                {
                    RoomDao.updateRoomStatus(end.getRoom_Num(),0);
                    System.out.println("房间号:"+end.getRoom_Num()+"  当前状态:空闲");
                }else {
                    RoomDao.updateRoomStatus(end.getRoom_Num(),1);
                    System.out.println("房间号:"+end.getRoom_Num()+"  当前状态:预定中");
                }
            }
            sql="select room_num,IDCard,Hire_Money from rent where Hire_StarTime=?";
            List<model.Rent> startRoom=jdbcUtil.getQuery(sql,new model.Rent(),Tools.getDate());
            for (model.Rent start:startRoom
                    ) {
                    RoomDao.updateRoomStatus(start.getRoom_Num(),2);
                    //扣钱
                    if(UserDao.exist(start.getIDCard())==1)

                    {
                        UserDao.updateUserBalance(start.getIDCard(),start.getHire_Money());
                        AccountDao.in(String.valueOf(start.getHire_Money()-100));
                        System.out.println("房间号:"+start.getRoom_Num()+"  用户ID:"+start.getIDCard()+"" +
                                "  扣除租金:"+(start.getHire_Money()-100));
                    }
            }
                //日常扣钱
            sql="select room_num,IDCard,Hire_Money from rent where Hire_StarTime<? and " +
                    "Hire_Finaltime>=?";
            List<model.Rent> normalRoom=jdbcUtil.getQuery(sql,new model.Rent(),Tools.getDate(),Tools.getDateShort());
            for (model.Rent normal:normalRoom
                    ) {
                //扣钱
                System.out.println("日常扣费");
                if(UserDao.exist(normal.getIDCard())==1)
                {
                    UserDao.updateUserBalance(normal.getIDCard(),normal.getHire_Money());
                    AccountDao.in(String.valueOf(normal.getHire_Money()));
                    System.out.println("房间号:"+normal.getRoom_Num()+"  用户ID:"+normal.getIDCard()+"" +
                            "  扣除租金:"+normal.getHire_Money());
                }
            }


            System.out.println("执行当前时间"+formatter.format(Calendar.getInstance().getTime()));
        } catch (Exception e) {
            System.out.println("-------------更新任务失败--------------");
        }
    }

}
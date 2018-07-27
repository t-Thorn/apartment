package dao;

import Tool.Tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RoomDao {

    static JDBCUtil jdbcUtil = new JDBCUtil();

    public static List<model.Room> getAllRoom() {
        return getRoom("select * from room");
    }

    private static List<model.Room> getRoom(String sql) {

        return jdbcUtil.getQuery(sql, new model.Room());

    }

    public static List<model.Room> getRoomByID(String ID) {
        String sql = "select * from room where Room_Num=" + ID;
        return getRoom(sql);
    }

    private static int getRoomID(List<model.Room> rooms, int ID) {
        int i = 0;
        while (((model.Room) rooms.get(i)).getRoom_Num() != ID) {
            i++;
        }
        return ((model.Room) rooms.get(i)).getRoom_Num();
    }

    public static void updateRoom(String... strings) {
        String sql = "update room set Room_Type=?,Room_Area=?,Room_PersCount=?,Hire_Money=?," +
                "Room_Things=?,Enregister_Pers=?,Remark=? where Room_Num=?";
        double area = Double.parseDouble(strings[1]);
        double hire_money = Double.parseDouble(strings[3]);
        jdbcUtil.executeUpdate(sql, strings[0], strings[1], strings[2], area, strings[4], strings[5],
                strings[6], strings[7]);
    }


    public static void addRoom(String... strings) {
        String pictures=RoomDao.setPicture(strings[0]);
        String sql = "insert into room (Room_Num,Room_Type,Room_Area,Room_PersCount," +
                "Hire_Money,Room_Things,Enregister_Pers,Enregister_Time,Remark,Room_Picture)" +
                "values (?,?,?,?," +
                "?,?,?,?,?,?)";
        //double area = Double.parseDouble(strings[2]);
        //double hire_money = Double.parseDouble(strings[4]);
        jdbcUtil.executeUpdate(sql,strings[0],strings[1],strings[2],strings[3],strings[4],
                strings[5],strings[6],strings[7],strings[8],pictures);
    }

    public static void updateRoomStatus(int roomid, int room_Status) {
        String sql = "update room set room_status=? where room_num=?";
        jdbcUtil.executeUpdate(sql, room_Status, roomid);
    }

    public static String outRoom(String id) {
        //Room表状态置为0
        model.Rent rent = RentDao.getRent(id);
        String sql = "update book set Book_FinalTime=? where room_num=? and Book_StartTime=?";
        jdbcUtil.executeUpdate(sql, Tools.getDateShort(), rent.getRoom_Num(), rent
                .getHire_StarTime());
        //rent表把结束时间设为当前时间
        sql = "update rent set Hire_Finaltime=? where Id=?";
        jdbcUtil.executeUpdate(sql, Tools.getDateShort(), id);


        //退房表加入纪录
        sql = "insert into quit (Room_Num,Room_User,Room_UserID,Quit_Date,Quit_Money)values(?,?,?,?,?)";

        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int days = (int) ((rent.getHire_Finaltime()
                .getTime() - Tools.getDate(Tools.getDate()).getTime()
        ) / (24 * 60 * 60 * 1000));
        String msg = "";
        float money = rent.getHire_Money() * days;
        if (UserDao.exist(rent.getIDCard()) == -1) {
            msg = "请退全额" + money;
            AccountDao.out(String.valueOf(money));
        } else {
            UserDao.updateUserBalancein(rent.getIDCard(), money);
            AccountDao.out(String.valueOf(money));
            msg = "用户已返回租金:" + money;
        }
        jdbcUtil.executeUpdate(sql, rent.getRoom_Num(), rent.getMajor_Roomer()
                , rent.getIDCard(), Tools.getDate(), money);
        if (RentDao.isFree(rent.getRoom_Num())) {
            RoomDao.updateRoomStatus(rent.getRoom_Num(), 0);//更改为空闲状态
        } else {
            RoomDao.updateRoomStatus(rent.getRoom_Num(), 1);//更改为预定状态
        }
        return msg;
    }

    public static List<model.RoomEX> getRoomtoRent(String room_Type) {
        String sql = "select * from room where room_status=0 and Room_Type=?";
        List<model.RoomEX> list = jdbcUtil.getQuery(sql, new model.RoomEX(), room_Type);
        return list;
    }

    public static List<model.RoomEX> getRoomtoRenting(String room_Type, String beginTime, String finishTime) {//添加已有订单的房间
        String sql = "select room_num,hire_money from room where " +
                "room_status=1 and Room_Type=?";
        List<model.RoomEX> bookList = jdbcUtil.getQuery(sql, new model.RoomEX(), room_Type);
        if (bookList.size() == 0)
            return null;

        List<model.RoomEX> resultList = new ArrayList();

        for (model.RoomEX roomEX : bookList) {
            //取到该时间段内是否存在订单,又则去除
            sql = "select room_num from rent where room_num=? and ((Hire_StarTime>=? and " +
                    "Hire_StarTime<=?) or (Hire_Finaltime>=? and Hire_Finaltime<=?))";
            System.out.println("候选:" + roomEX.getRoom_Num());
            List<model.RoomEX> list1 = jdbcUtil.getQuery(sql, new model.RoomEX(), roomEX.getRoom_Num(),
                    beginTime, finishTime, beginTime, finishTime);
            if (list1.size() == 0) {
                model.RoomEX roomEXTemp = new model.RoomEX();
                roomEXTemp.setRoom_Num(roomEX.getRoom_Num());
                roomEXTemp.setHire_Money(roomEX.getHire_Money());
                resultList.add(roomEXTemp);
                System.out.println("得到:" + roomEX.getRoom_Num());
            }
        }
        return resultList;
    }

    public static String getRoomType(String roomid) {
        String sql = "select Room_Type from room where room_num=?";
        List<model.Room> list = jdbcUtil.getQuery(sql, new model.Room(), roomid);
        return list.get(0).getRoom_Type();
    }

    public static boolean exist(String room_num) {
        String sql = "select * from room where room_num=?";
        List<model.Room> rooms = jdbcUtil.getQuery(sql, new model.Room(), room_num);
        if (rooms.size() > 0)
            return false;
        else
            return true;
    }

    public static String setPicture(String room_num) {
        final String pathSrc = "E:\\upload\\temp\\";
        String pathDes = "E:\\upload\\" + room_num + "\\";
        final String pathPro="/pic/"+room_num+"/";
        File myFolderPath = new File(pathDes);
        //System.out.println("目录:" + pathDes);
        //创建文件夹
        String pictures="";
        try {
            if (!myFolderPath.exists()) {
                myFolderPath.mkdir();
            }
        } catch (Exception e) {
            System.out.println("新建目录操作出错");
            e.printStackTrace();
        }

        //复制文件到房间号目录下
        File copyfolders = new File(pathSrc);
        File[] copyfoldersList = copyfolders.listFiles();
        for (int k = 0; k < copyfoldersList.length; k++) {
            System.out.println(copyfoldersList[k].getName());
            if (!copyfoldersList[k].isDirectory()) {
                try {
                    File oldFile = new File(pathSrc + copyfoldersList[k].getName());
                    File writeFile = new File(pathDes + copyfoldersList[k].getName());
                    if (!writeFile.exists()) {
                            writeFile.createNewFile();
                    }
                    File file = new File(pathDes + copyfoldersList[k].getName());
                    FileInputStream in = new FileInputStream(oldFile);
                    FileOutputStream out = new FileOutputStream(file);
                    byte[] buffer = new byte[2097152];

                    while ((in.read(buffer)) != -1) {
                        out.write(buffer);
                    }
                    pictures+=pathPro + copyfoldersList[k].getName()+";";
                     in.close();
                    out.close();
                } catch (Exception e) {
                    System.out.println("复制整个文件夹内容操作出错");
                    e.printStackTrace();
                }
            }

        }

        //删除临时文件
        File delfile = new File(pathSrc);
        File[] files = delfile.listFiles();
        for (int i = 0; i < files.length; i++)
        {
            //System.out.println(files[i].getAbsoluteFile().getName());
            if (files[i].isFile()) {
                File temp=new File(pathSrc+files[i].getName());
                //System.out.println(pathSrc+files[i].getName());
                temp.delete();
            }
        }
        System.out.println(pictures);
    return pictures;
    }

    public static List<model.Room> getRoomDetail(String roomid)
    {
        List<model.Room> list= new ArrayList();
        JDBCUtil util=new JDBCUtil();

        String sql="select * from room where room_num=?";
        list= util.getQuery(sql, new model.Room(),roomid);
        return list;
    }

}

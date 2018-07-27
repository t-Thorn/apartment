package dao;

import Tool.Tools;

import java.util.List;

public class BookDao {
    public static JDBCUtil jdbcUtil = new JDBCUtil();

    public static List<model.Book> getAllBook() {
        String sql = "select * from book where Book_StartTime>? ";
        return jdbcUtil.getQuery(sql, new model.Book(), Tools.getDate());
    }

    public static List<model.Book> getBook(String id) {
        String sql = "select * from book where Id=" + id;
        return jdbcUtil.getQuery(sql, new model.Book());
    }

    public static String chooseRoom(String name, String gender, String mobilephone, String
            book_PersonID, String startime, String finishtime, String type, String remark) {
        List<model.RoomEX> list;
        //(1)搜索合适的房间:
        //    ~1:在时间允许的范围内找到第一间房间,更改房间状态
        //	    1.1:房间状态=0;直接ok
        list = RoomDao.getRoomtoRent(type);
        //		1.2:房间状态!=0;搜索出租表,搜索在预定时间范围内是否没有出租纪录
        List<model.RoomEX> list1 = RoomDao.getRoomtoRenting(type, startime, finishtime);
        // list.addAll(list1);
        //	~2:不存在返回错误
        String msg = "";
        if (list.size() == 0 && list1.size() == 0)
            return "该时段不存在空房";
        else {
            List<model.RoomEX> listTemp;
            if (list.size() == 0)
            {
                System.out.println("没错,没有空闲房了");
                listTemp = list1;
            }

            else {
                listTemp = list;
                RoomDao.updateRoomStatus(listTemp.get(0).getRoom_Num(), 1);
            }

            //(2)判断房客表中是否已经存在,不存在则加入;以ID作为依据
            System.out.println("最后为:"+listTemp.get(0).getRoom_Num());
            if (RoomerDao.getRoomerByID(book_PersonID) == -1) {
                RoomerDao.addRoomer(name, gender, book_PersonID, mobilephone);
            }
            if (UserDao.exist(book_PersonID) == -1) {

                int days = (int) ((Tools.getDate(finishtime).getTime() - Tools.getDate(startime)
                        .getTime()) / (24 * 60 * 60 * 1000));
                days++;
                float money = days * listTemp.get(0).getHire_Money();
                msg = "请收全额" + money;
                AccountDao.in(String.valueOf(money));
            } else {
                UserDao.updateUserBalance(book_PersonID, listTemp.get(0).getHire_Money());
                AccountDao.in("100");
                msg = "用户已扣除100定金";
            }
            //(3)预定表中加入一条记录,(用户)房客扣除100定金,account+100
            addBook(name, String.valueOf(listTemp.get(0).getRoom_Num()), mobilephone, book_PersonID,
                    startime,
                    finishtime, type, remark);
            //(4)在出租表中加入一条纪录
            RentDao.addRent(name, listTemp.get(0).getRoom_Num(), mobilephone, book_PersonID, startime,
                    finishtime, gender, listTemp.get(0).getHire_Money(), "admin");
        }
        return msg;
    }

    public static void addBook(String name, String room_Num, String mobilephone, String
            book_PersonID, String startime, String finishtime, String type, String remark) {
        String sql = "insert into book  (Room_Num,Book_Person,Book_PersonID,Mobilephone,Book_StartTime," +
                "Book_FinalTime,Register_Time) values(?,?,?,?,?,?,?)";
        jdbcUtil.executeUpdate(sql, room_Num, name, book_PersonID, mobilephone, startime, finishtime,
                Tools.getDate());
    }

    public static String editRoom(String bid, String room_Num, String name, String gender, String
            mobilephone, String book_PersonID, String startime,
                                  String finishtime, String type) {
        //2.修改预定:
        //  (1)搜索合适的房间:
        //    ~1:在时间允许的范围内找到第一间房间,更改房间状态
        //	  1.1,优先在当前房间进行判断
        //		  1.1.2:搜索出租表的当前纪录,搜索在预定时间范围内该房是否没有出租纪录
        //取得原订单开始和结束时间
        String sql = "select  Book_StartTime,Book_FinalTime from book where id=?";
        List<model.Book> books = jdbcUtil.getQuery(sql, new model.Book(), bid);
        String bookStarttime = books.get(0).getBook_StartTime().toString();
        String bookEndtime = books.get(0).getBook_FinalTime().toString();

        //取得rentID
        sql = "select id from rent where Hire_StarTime=? and " +
                "Hire_Finaltime=? AND  Room_Num=?";
        System.out.println("BS"+bookStarttime+"BE"+bookEndtime);
        List<model.Rent> rents = jdbcUtil.getQuery(sql, new model.Rent(), bookStarttime,
                bookEndtime, room_Num);
        String rentid = String.valueOf(rents.get(0).getId());

        //判断当前房间是否满足条件
        sql = "select room_num from rent where room_num=? and ((Hire_StarTime>=? and " +
                "Hire_StarTime<=?) or (Hire_Finaltime>=? and Hire_Finaltime<=?)) and id!=?";
        List<model.Rent> list1 = jdbcUtil.getQuery(sql, new model.Rent(), room_Num, startime,
                finishtime,
                startime, finishtime, rentid);

        sql = "select Hire_StarTime,Hire_Finaltime from rent where id=?";
        List<model.Rent> time = jdbcUtil.getQuery(sql, new model.Rent(), rentid);

        //计算天数
        int days = (int) (((Tools.getDate(finishtime).getTime() - Tools.getDate(startime)
                .getTime()) - (time.get(0).getHire_Finaltime().getTime() - time.get(0)
                .getHire_StarTime().getTime())) / (24 * 60 * 60 * 1000));

        //初始化变量
        String msg = "";
        String realroom;
        if (list1.size() == 0 && type.equals(RoomDao.getRoomType(room_Num))) {
            //不改变房间类型,且当前房间有时间时执行
            realroom = room_Num;
            //取得当前房间押金,计算差价
            sql = "select hire_money from room where room_num=?";
            List<model.Room> hiremoney = jdbcUtil.getQuery(sql, new model.Room(), room_Num);
            float money = days * hiremoney.get(0).getHire_Money();
            System.out.println("days=" + days);

            if (UserDao.exist(book_PersonID) == -1) {

                if (money < 0) {
                    msg = "请退差额" + money;
                    AccountDao.out(String.valueOf(money));
                } else if (money > 0) {
                    msg = "请补差额" + money;
                    AccountDao.in(String.valueOf(money));
                }
            }
        } else {
            //	   1.2.1:房间状态=0;直接ok
            //	  1.2.2:房间状态!=0;搜索出租表,搜索在预定时间范围内是否没有出租纪录
            //	~2:不存在返回错误
            List<model.RoomEX> list;
            list = RoomDao.getRoomtoRent(type);
            List<model.RoomEX> list2 = RoomDao.getRoomtoRenting(type, startime, finishtime);
            if (list.size() == 0 && list1.size() == 0)
                return "该时段不存在空房";
            else {
                List<model.RoomEX> listTemp;
                if (list.size() == 0)
                    listTemp = list2;
                else {
                    listTemp = list;
                    RoomDao.updateRoomStatus(listTemp.get(0).getRoom_Num(), 1);
                }

                //	(3)判断房客表中是否已经存在,不存在则加入;以ID作为依据
                //	     退回差价
                realroom = String.valueOf(listTemp.get(0).getRoom_Num());

                float money = days * listTemp.get(0).getHire_Money();
                System.out.println("days=" + days);

                System.out.println(listTemp.get(0).getRoom_Num());
                if (RoomerDao.getRoomerByID(book_PersonID) == -1) {
                    RoomerDao.addRoomer(name, gender, book_PersonID, mobilephone);
                }
                if (UserDao.exist(book_PersonID) == -1) {
                    if (money < 0) {
                        msg = "请退差额" + money;
                        AccountDao.out(String.valueOf(money));
                    } else if (money > 0) {
                        msg = "请补差额" + money;
                        AccountDao.in(String.valueOf(money));
                    }
                }
            }

        }
        //(3)预定表更新,(用户)房客扣除100定金,account+100
        System.out.println(finishtime);
        updateBook(name, realroom, mobilephone, book_PersonID,
                startime, finishtime, bid);
        //(4)出租表中更新
        RentDao.updateRent(name,book_PersonID ,realroom ,mobilephone,
                startime, finishtime, rentid);
        return msg;
    }

    public static void updateBook(String name, String room_Num, String mobilephone, String
            book_PersonID, String startime, String finishtime, String id) {
        String sql = "update  book  set Book_Person=?,room_Num=?,Mobilephone=?,Book_PersonID=?," +
                "Book_StartTime=?,Book_FinalTime=? where id=?";
        System.out.println(finishtime);
        jdbcUtil.executeUpdate(sql, name, room_Num, mobilephone, book_PersonID, startime, finishtime,
                id);
    }

    public static String deletebook(String id, String room_Num) {
        String msg = "";
        //3.删除预定:
        //	(1)预定表中删除先前的记录,用预定表id确定纪录
        List<model.Book> list = getBook(id);
        String sql = "delete from book where Id=" + id;
        jdbcUtil.executeUpdate(sql);
        //	(2)在出租表中删除此前纪录,根据房号+出租时间范围确定
        sql = "delete from rent where room_num=? and Hire_StarTime=? and Hire_Finaltime=?";
        System.out.println(room_Num + ":" + list.get(0).getBook_StartTime() + "-" + list.get(0)
                .getBook_FinalTime());
        int i = jdbcUtil.executeUpdate(sql, room_Num, list.get(0).getBook_StartTime(), list.get(0)
                .getBook_FinalTime());
        System.out.println(i);
        List<model.Room> rooms = RoomDao.getRoomByID(room_Num);
        //	(2)更新余额,则返回房租(用户表+100),account-100/全额,
        if (UserDao.exist(list.get(0).getBook_PersonID()) == -1) {

            int days = (int) ((Tools.getDate(list.get(0).getBook_FinalTime().toString()).getTime() - Tools
                    .getDate(list.get(0).getBook_StartTime().toString())
                    .getTime()) / (24 * 60 * 60 * 1000));
            days++;
            float money = days * rooms.get(0).getHire_Money();
            msg = "请退全额" + money;
            AccountDao.out(String.valueOf(money));
        } else {
            UserDao.updateUserBalancein(list.get(0).getBook_PersonID(), rooms.get(0).getHire_Money());
            AccountDao.out(String.valueOf(rooms.get(0).getHire_Money()));
            msg = "用户已返回一天租金:" + rooms.get(0).getHire_Money();
        }
        //	(3)在出租表中搜索是否还有该房间未完成的订单,更新房间状态
        if (RentDao.isFree(rooms.get(0).getRoom_Num())) {
            RoomDao.updateRoomStatus(rooms.get(0).getRoom_Num(), 0);//更改为空闲状态
        } else {
            RoomDao.updateRoomStatus(rooms.get(0).getRoom_Num(), 1);//更改为预定状态
        }

        return msg;
    }

    public static String getGender(String id) {
        String sql = "select roomer_sex from roomer where roomer_id=?";
        List<model.Roomer> list = jdbcUtil.getQuery(sql, new model.Roomer(), id);
        System.out.println(list.get(0).getRoomer_Sex());
        return list.get(0).getRoomer_Sex();
    }

    public static List<model.Book> getUserBook(String ID) {
        String sql = "select * from book where Book_StartTime>? and Book_PersonID=? ";
        return jdbcUtil.getQuery(sql, new model.Book(), Tools.getDate(),ID);
    }
}

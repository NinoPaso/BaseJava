package cn.basejava.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) throws Exception{
        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(date);
        //测试时间对象和字符串之间的互相转换。
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        String str = df.format(new Date());
        System.out.println(str);

        Date d = df.parse("2018-04-20 23:21:34");
        System.out.println(d);
        //Canlendar测试

    }
}

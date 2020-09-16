package cn.basejava.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取上月最后一天+截单时间
        Calendar caleStart = Calendar.getInstance();
//        caleStart.add(Calendar.MONTH, 0);
        caleStart.set(Calendar.DAY_OF_MONTH, 1);
        caleStart.add(Calendar.DAY_OF_MONTH, -1);
        //获取当前前一天
        Calendar caleEnd = Calendar.getInstance();
        caleEnd.add(Calendar.MONTH, 0);
        caleEnd.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println(format.format(caleStart.getTime()));
    }
}

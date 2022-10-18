package basejava.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        String[] array = "2020-05-25".split("-");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //获取上月最后一天+截单时间
        Calendar caleStart = Calendar.getInstance();
        //设置年份
        caleStart.set(Calendar.YEAR, Integer.valueOf(array[0]));
        //设置月份
        caleStart.set(Calendar.MONTH, Integer.valueOf(array[1])-1);
        caleStart.set(Calendar.DATE, Integer.valueOf(array[2])+1);

        System.out.println(format.format(caleStart.getTime()));
        String a = (String)null;
        System.out.println(a);
        CalendarTest ct = new CalendarTest();
        ct.sout1();
    }

    public  void sout1() {
        CalendarTest.this.sout();
        System.out.println(123);
    }
    public void sout() {
        System.out.println(123);
    }
}

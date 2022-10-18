package basejava.test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SubTest {
    public static void main(String[] args) {
        // 获取当前时间
        Calendar caleStart = Calendar.getInstance();

        caleStart.add(Calendar.HOUR_OF_DAY,-12);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");
        System.out.println(format.format(caleStart.getTime()));
    }
}

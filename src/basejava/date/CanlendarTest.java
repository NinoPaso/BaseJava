package basejava.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
  可视化日历程序
  要求:输入任意日期 显示日历
 */
public class CanlendarTest {
    public static void main(String[] args) throws Exception {
        //定义测试日期
//        String str = "2015-12-10";
        //定义键盘获取
        System.out.print("请输入日期（格式：2019-01-01）：");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        //日期格式化类转换成日期
        DateFormat df  = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(str);
        //再根据日历类获取时间详细信息
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        //保存当前输入日期的信息：1.当月天数2.保存今天是几号
        int days = c.getActualMaximum(Calendar.DATE);
        int day = c.get(Calendar.DAY_OF_MONTH);

        //在控制台打印日历格式
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        c.set(Calendar.DAY_OF_MONTH,1);

        //根据时间循环 打印空格（在正式开始打印日期前）
        for (int i = 0;i<c.get(Calendar.DAY_OF_WEEK)-1;i++){
            System.out.print("\t");
        }

        //开始打印日期
        for(int i=0;i<days;i++){
            if(day == c.get(Calendar.DAY_OF_MONTH)){
                System.out.print(c.get(Calendar.DAY_OF_MONTH)+"*\t");
            }else{
                System.out.print(c.get(Calendar.DAY_OF_MONTH)+"\t");
            }

            //周六换行
            if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
                System.out.println();
            }

            c.add(Calendar.DAY_OF_MONTH,1);
        }

    }
}

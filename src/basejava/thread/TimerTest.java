package basejava.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName TimerTest
 * @Description TODO
 * @Author 86133
 * @Date 2020/3/1 18:28
 * @Version 1.0
 **/
public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(),1000,2000);
    }
}

class MyTask extends TimerTask{
    @Override
    public void run() {
        System.out.println("Hello World!");
        System.out.println("----end----");
    }
}

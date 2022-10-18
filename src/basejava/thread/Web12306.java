package basejava.thread;

/**
 * @ClassName Web12306
 * @Description TODO
 * @Author 86133
 * @Date 2020/2/21 17:04
 * @Version 1.0
 **/
public class Web12306 implements Runnable{
    private int ticketNum = 99;

    @Override
    public void run() {
        test();
    }
    public synchronized void test(){
        while(ticketNum>0){
            try {
                Thread.sleep(200);//并发数据问题
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--->"+ticketNum--);
        }
    }

    public static void main(String[] args) {
        Web12306 web = new Web12306();
        new Thread(web,"码农").start();
        new Thread(web,"码畜").start();
        new Thread(web,"蚂蟥").start();
    }
}

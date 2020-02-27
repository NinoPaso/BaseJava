package cn.basejava.thread;

/**
 * @ClassName YieldTest
 * @Description TODO yield方法，main线程进行礼让后，线程1和main线程同为就绪状态（非阻塞），等待CPU进行调度
 * @Author 86133
 * @Date 2020/2/24 18:11
 * @Version 1.0
 **/
public class YieldTest {
    public static void main(String[] args) {
        //线程1
        new Thread(()->{
            for(int i=0;i<100;i++){
                System.out.println("lambda...."+i);
            }
        }).start();
        //main线程的循环，并且进行礼让
        for (int i=0;i<100;i++){
            if(i%20 == 0){
                Thread.yield();
            }
            System.out.println("main...."+i);
        }
    }
}

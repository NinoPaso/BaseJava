package cn.basejava.thread;

/**
 * @ClassName LockTest
 * @Description TODO 可重入锁
 * @Author 86133
 * @Date 2020/3/3 22:53
 * @Version 1.0
 **/
public class LockTest {
    public void test(){
        synchronized (this){
            while(true){
                synchronized (this){
                    System.out.println("锁的可重入测试");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//while(true)以后的代码都不会执行，而且报错
        }
    }
    public static void main(String[] args) {
        new LockTest().test();
    }
}

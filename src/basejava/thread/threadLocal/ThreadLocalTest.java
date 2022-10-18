package basejava.thread.threadLocal;

/**
 * @ClassName ThreadLocalTest
 * @Description TODO
 * @Author 86133
 * @Date 2020/3/3 22:28
 * @Version 1.0
 **/
public class ThreadLocalTest {
    //定义私有ThreadLocal变量
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);
    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            new Thread(new MyRun()).start();
        }
    }
    public static class MyRun implements Runnable{
        @Override
        public void run() {
            Integer left = threadLocal.get();
            System.out.println(Thread.currentThread().getName()+"得到了"+left);
            threadLocal.set(left-1);
            System.out.println(Thread.currentThread().getName()+"剩下了"+threadLocal.get());
        }
    }
}


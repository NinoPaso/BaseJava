package basejava.thread;

/**
 * @ClassName AllState
 * @Description TODO
 * @Author 86133
 * @Date 2020/2/24 20:47
 * @Version 1.0
 **/
public class AllState {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            try {
                Thread.sleep(100);//TIMED WAITING
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("......");
        });
        //观察状态
        Thread.State s = t.getState();
        System.out.println(s);//NEW 新生状态
        t.start();
        System.out.println(t.getState());//RUNNABLE

        while(s!=Thread.State.TERMINATED){
            Thread.sleep(200);
            System.out.println(t.getState());
        }//TERMINATED
    }
}

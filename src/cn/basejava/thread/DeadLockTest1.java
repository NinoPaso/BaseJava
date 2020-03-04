package cn.basejava.thread;

/**
 * @ClassName DeadLockTest1
 * @Description TODO
 * @Author 86133
 * @Date 2020/2/28 22:12
 * @Version 1.0
 **/
public class DeadLockTest1 {
    public static void main(String[] args) {
        MakeUp g1 = new MakeUp(0,"小红");
        MakeUp g2 = new MakeUp(1,"小丽");
        new Thread(g1).start();
        new Thread(g2).start();
    }
}
//镜子资源
class Mirror{

}
//口红资源
class LipStick{

}
//化妆线程
class MakeUp implements Runnable{
    static LipStick lipStick = new LipStick();
    static Mirror mirror = new Mirror();
    int choice;
    String girlName;

    public MakeUp(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        //线程体 化妆
        makeUp();
    }
    private void makeUp(){
        if(choice == 0){
            synchronized (lipStick){
                System.out.println(this.girlName+"获得口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror){
                    System.out.println(this.girlName+"照镜子");
                }
            }
        }else{
            synchronized (mirror){
                System.out.println(this.girlName+"照镜子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipStick){
                    System.out.println(this.girlName+"获得口红");
                }
            }
        }
    }
}

package cn.basejava.thread;

/**
 * @ClassName Cooperation
 * @Description TODO
 * @Author 86133
 * @Date 2020/3/1 16:01
 * @Version 1.0
 **/
public class Cooperation {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Thread(new Productor(synContainer)).start();
        new Thread(new Consumer(synContainer)).start();
    }
}
//生产者
class Productor implements Runnable{
    SynContainer synContainer;

    public Productor(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("生产第-->"+i+"个馒头");
            synContainer.push(new SteamedBun(i));
        }
    }
}
//消费者
class Consumer implements Runnable{
    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("消费第-->"+i+"个馒头");
            synContainer.pop();
        }
    }
}
//缓冲区
class SynContainer{
    SteamedBun[] steamedBuns = new SteamedBun[10];
    //定义计数器
    int count = 0;
    //存储
    public synchronized void push(SteamedBun bun){
        //何时能生产？容器存在空间
        if(count == steamedBuns.length){
            try {
                this.wait();//线程阻塞，消费者通知进行解除
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在空间 可以生产
        steamedBuns[count] = bun;
        count++;
        this.notifyAll();
    }
    //消费
    public synchronized SteamedBun pop(){
        //何时可以消费？容器中存在数据
        //没有数据 只能等待
        if(count == 0){
            try {
                this.wait();//线程阻塞，等待生产者通知，解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在数据可以消费
        count--;
        SteamedBun bun = steamedBuns[count];
        this.notifyAll();
        return bun;
    }

}
//资源（举例：馒头）
class SteamedBun{
    int id;

    public SteamedBun(int id) {
        this.id = id;
    }
}

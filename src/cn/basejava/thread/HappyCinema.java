package cn.basejava.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HappyCinema
 * @Description TODO多线程应用，快乐电影院
 * 根据容器List进行改造
 * @Author 86133
 * @Date 2020/2/27 10:24
 * @Version 1.0
 **/
public class HappyCinema {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        list1.add(1);
        list1.add(2);
        list1.add(4);
        list2.add(2);
        list2.add(3);
        list2.add(1);
        list2.add(8);

        Cinema cinema = new Cinema(list,"青春旅途");
        Thread t1 = new Thread(new Customer(cinema,list1),"小李");
        t1.setPriority(1);
        Thread t2 = new Thread(new Customer(cinema,list2),"小王");
        t2.setPriority(10);

        t2.start();
        t1.start();
    }
}
//线程实现->顾客买票
class Customer implements Runnable{
    Cinema cinema;
    List<Integer> seats;

    public Customer(Cinema cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.bookTickets(seats);
            if (flag) {
                System.out.println("出票成功" + Thread.currentThread().getName() + "-<位置为" + seats);
            } else {
                System.out.println("出票失败" + Thread.currentThread().getName() + "位置不够");
            }
        }
    }
}

//线程资源->电影票
class Cinema{
    List<Integer> avaiable;//可用位置
    String name;//名称

    public Cinema(List<Integer> avaiable, String name) {
        this.avaiable = avaiable;
        this.name = name;
    }
    //购票方法
    public boolean bookTickets(List<Integer> seats){
        System.out.println("欢迎光临"+this.name+"可用位置为："+avaiable);
        List<Integer> copy = new ArrayList<>();
        copy.addAll(avaiable);
        copy.removeAll(seats);
        if(avaiable.size()-copy.size() != seats.size()){
            return false;
        }
        avaiable = copy;
        return true;
    }
}

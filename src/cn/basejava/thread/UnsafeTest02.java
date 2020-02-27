package cn.basejava.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UnsafeTest02
 * @Description 线程不安全容器
 * @Author 86133
 * @Date 2020/2/25 18:00
 * @Version 1.0
 **/
public class UnsafeTest02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        for(int i=0;i<10000;i++){
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size());
    }
}

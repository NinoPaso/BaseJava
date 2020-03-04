package cn.basejava.thread;

/**
 * @ClassName DoubleCheckedLocking
 * @Description TODO单例模式的实现（有很多种），此处使用doubleChecking,volatile实现(懒汉式基础实现单例，
 * 保证多线程并发，对外存在唯一对象)
 * 定义：多线程环境下，对外只能存在一个对象
 * 1.构造器私有化->不能通过new关键字进行创建
 * 2.提供私有的静态属性->存储对象的地址
 * 3.提供共有的静态方法->获取属性
 * @Author 86133
 * @Date 2020/3/2 19:59
 * @Version 1.0
 **/
public class DoubleCheckedLocking {
    //1.构造器私有
    private DoubleCheckedLocking(){
    }
    //2.提供私有的静态属性
    private static volatile DoubleCheckedLocking instance;
    //3.提供公共的静态方法->获取属性
    public static DoubleCheckedLocking getInstance(){
        //再次检测
        if(null != instance){//避免不必要的同步，已经存在对象了
            return instance;
        }
        synchronized (DoubleCheckedLocking.class){//锁定类
            if (null == instance){
                instance = new DoubleCheckedLocking();//1.开辟空间2.初始化对象的信息3.返回对象的地址给引用
                // （为避免happen——before）,给静态对象引用添加volatile关键字
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(DoubleCheckedLocking.getInstance());
        }).start();
        System.out.println(DoubleCheckedLocking.getInstance());
    }

}

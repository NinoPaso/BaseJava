package cn.basejava.thread;

/**
 * @ClassName StaticProxy
 * @Description TODO模拟静态代理模式
 * @Author 86133
 * @Date 2020/2/21 18:10
 * @Version 1.0
 **/
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();
    }
}
/*
结婚接口
 */
interface Marry{
    void happyMarry();
}
/*
真实角色
 */
class You implements Marry{
    @Override
    public void happyMarry() {
        System.out.println("今天终于结婚了");
    }
}
/*
代理角色
 */
class WeddingCompany implements Marry{
    //定义真实的角色
    private Marry target;
    //构造方法传入
    public WeddingCompany(Marry target) {
        this.target = target;
    }
    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }
    private void ready(){
        System.out.println("布置婚房------");
    }
    private void after(){
        System.out.println("闹洞房-----------");
    }
}

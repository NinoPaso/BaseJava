package cn.basejava.thread;

/**
 * @ClassName UnsafeTest01
 * @Description TODO 模拟线程不安全：取钱
 * @Author 86133
 * @Date 2020/2/25 14:02
 * @Version 1.0
 **/
public class UnsafeTest01 {
    public static void main(String[] args) {
        //定义账户
        Account account = new Account(100,"金库");
        Drawing you = new Drawing(account,80,"悲催的你");
        Drawing wife = new Drawing(account,90,"happy的她");
        you.start();
        wife.start();
    }
}

/*
账户类
 */
class Account{
    int money;
    String name;
    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
/*
模拟账户取钱
 */
class Drawing extends Thread{
    Account account;//模拟账户
    int drawingMoney;//取得钱数
    int drawingTotal;//单次取钱数
    int packetTotal;//取钱的总数

    public Drawing(Account account, int drawingMoney,String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        account.money -= drawingMoney;
        packetTotal += drawingMoney;
        System.out.println(this.getName()+"----->账户余额为："+account.money);
        System.out.println(this.getName()+"----->口袋总共有："+packetTotal);
    }
}

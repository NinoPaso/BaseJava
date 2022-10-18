package basejava.gof.adapter;

/**
 * @ClassName Client
 * @Description TODO
 * 模拟客户
 * @Author 86133
 * @Date 2020/4/4 22:03
 * @Version 1.0
 **/
public class Client {
    public static void test1(Target t){
        t.handleReq();
    }

    public static void main(String[] args) {
        Adaptee a = new Adaptee();
        Client.test1(new Adapter2(a));
    }
}

package basejava.gof.adapter;

/**
 * @ClassName Adapter
 * @Description TODO
 * 对象适配器的方式
 * @Author 86133
 * @Date 2020/4/4 22:06
 * @Version 1.0
 **/
public class Adapter2  implements Target{
    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleReq() {
        adaptee.request();
    }
}

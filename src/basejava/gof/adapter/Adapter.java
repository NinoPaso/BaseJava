package basejava.gof.adapter;

/**
 * @ClassName Adapter
 * @Description TODO
 * 1.类适配器的方式
 * @Author 86133
 * @Date 2020/4/4 22:06
 * @Version 1.0
 **/
public class Adapter extends Adaptee implements Target{

    @Override
    public void handleReq() {
        super.request();
    }
}

package basejava.gof.decorator;

/**
 * @ClassName DecorateCoffee
 * @Description TODO
 * @Author 86133
 * @Date 2020/2/9 19:37
 * @Version 1.0
 **/
public class DecorateCoffee {
    public static void main(String[] args) {
        Drink coffee = new Coffee();
        Drink suger = new Suger(coffee);
        System.out.println(suger.info()+"---->"+suger.cost());
        suger = new Milk(suger);
        System.out.println(suger.info()+"---->"+suger.cost());
    }

}
//抽象组件
interface Drink{
    double cost();//费用
    String info();//说明
}
//具体组件
class Coffee implements Drink{
    private String name = "原味咖啡";
    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}
//抽象装饰类
abstract class Decorate implements Drink{
    //引用抽象组件
    private Drink drink;

    Decorate(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}
//具体修饰类
class Milk extends Decorate{
    Milk(Drink drink) {
        super(drink);
    }
    @Override
    public double cost() {
        return super.cost()*4;
    }

    @Override
    public String info() {
        return super.info()+"加入了牛奶";
    }

}
class Suger extends Decorate{
    Suger(Drink drink) {
        super(drink);
    }
    @Override
    public double cost() {
        return super.cost()*2;
    }

    @Override
    public String info() {
        return super.info()+"加入了蔗糖";
    }

}
package basejava.gof.decorator;
//抽象构件
public interface ICar {
	void move();
}
//具体构件
class Car implements ICar{

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("地上跑。");
	}
	
}
//Decorator装饰角色
class SuperCar implements ICar{
	protected ICar car;
	
	public SuperCar(ICar car) {
		super();
		this.car = car;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		car.move();
	}
	
}
//ConcreteDecorator具体装饰角色
class FlyCar extends SuperCar{

	public FlyCar(ICar car) {
		super(car);
		// TODO Auto-generated constructor stub
	}
	public void fly() {
		System.out.println("天上飞。。。。。。");
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.move();
		fly();
	}
}


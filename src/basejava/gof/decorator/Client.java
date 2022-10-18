package basejava.gof.decorator;

public class Client {
	public static void main(String[] args) {
		ICar car = new Car();
		car.move();
		System.out.println("增加天上飞的功能-----------------------");
		FlyCar flyCar = new FlyCar(car);
		flyCar.move();
	}
}	

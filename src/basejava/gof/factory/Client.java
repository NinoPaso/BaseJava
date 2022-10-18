package basejava.gof.factory;

public class Client {
	public static void main(String[] args) {
		Car c1 = CarFactory.getCar("奥迪");
		Car c2 = CarFactory.getCar("比亚迪");
		
		c1.run();
		c2.run();
	}
}

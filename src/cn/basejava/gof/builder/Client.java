package cn.basejava.gof.builder;

public class Client {
	public static void main(String[] args) {
		AirShipDirector director = new WyjAirShipDirector(new WyjAirShipBuilder());
		AirShip a = director.directAirShip();
		System.out.println(a);
	}
}

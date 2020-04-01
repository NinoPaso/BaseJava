package cn.basejava.gof.factory;

public class CarFactory {
	public static Car getCar(String type) {
		if("奥迪".equals(type)) {
			return new Audi();
		}else if("比亚迪".equals(type)) {
			return new Byd();
		}else {
			return null;
		}
	}
}

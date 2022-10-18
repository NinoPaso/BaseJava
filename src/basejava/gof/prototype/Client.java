package basejava.gof.prototype;

import java.util.Date;

public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		Sheep s1 = new Sheep("羊1",new Date(9423048329041023L));
		//浅克隆
		Sheep s2 = (Sheep) s1.clone();
		System.out.println(s2.getName());
	}
}

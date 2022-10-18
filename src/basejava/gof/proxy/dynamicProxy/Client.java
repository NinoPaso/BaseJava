package basejava.gof.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		Star realStar = new RealStar();
		StarHandler handler = new StarHandler(realStar);
		
		Star star = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {Star.class}, handler);
		star.bookTicket();
		star.sing();
	}
}

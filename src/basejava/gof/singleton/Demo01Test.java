package basejava.gof.singleton;

public class Demo01Test {
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				System.out.println(Demo01.getInstance());
			};
		}.start();
		new Thread(()->System.out.println(Demo01.getInstance())).start();
	}
}

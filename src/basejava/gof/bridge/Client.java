package basejava.gof.bridge;

public class Client {
	public static void main(String[] args) {
		Computer2 c = new Desktop2(new Lenovo());
		c.sale();
	}
}

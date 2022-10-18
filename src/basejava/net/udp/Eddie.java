package basejava.net.udp;

public class Eddie {
	public static void main(String[] args) {
		new Thread(new TalkRecieve(6666)).start();
	}
}

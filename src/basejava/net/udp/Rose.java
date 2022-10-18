package basejava.net.udp;

public class Rose {
	public static void main(String[] args) {
		new Thread(new TalkSend(5555, "localhost", 6666)).start();
	}
}

package basejava.net;


import java.net.InetAddress;
import java.net.UnknownHostException;


public class IPTest {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress ia = InetAddress.getLocalHost();
		System.out.println(ia.getHostAddress());
		System.out.println(ia.getHostName());
	}

}

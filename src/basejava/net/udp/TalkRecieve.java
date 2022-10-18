package basejava.net.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/*
 * 接收端：使用面向对象封装
 */
public class TalkRecieve implements Runnable{
	private DatagramSocket server; 
	public TalkRecieve(int port) {
		try {
			server = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			//准备容器封装内容
			byte[] container = new byte[1024*60];
			DatagramPacket packet = new DatagramPacket(container,0,container.length);
			//阻塞式接收包裹
			try {
				server.receive(packet);
				byte[] datas = packet.getData();
				int length = packet.getLength();//这里获取packet的长度
				String data = new String(datas,0,length);
				System.out.println(data);
				if("bye".equals(data)) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		server.close();
	}

}

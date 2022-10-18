package basejava.net.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;


/*
 * 发送端：使用面向对象封装
 */
public class TalkSend implements Runnable{
	private DatagramSocket client; 
	private BufferedReader reader;
	private String toIP;
	private int toPort;
	public TalkSend(int port,String toIP,int toPort) {
		this.toIP = toIP;
		this.toPort = toPort;
		// TODO Auto-generated constructor stub
		try {
			client = new DatagramSocket(port);
			reader = new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				String data = reader.readLine();
				byte[] datas = data.getBytes();
				//封装成DatagramPacket包裹，并指定对应的接收端目的地地址以及端口
				DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress(toIP, toPort));
				client.send(packet);
				if(data.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		client.close();
	}
	
}

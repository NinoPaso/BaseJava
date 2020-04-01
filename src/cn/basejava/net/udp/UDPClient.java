package cn.basejava.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
/*
 * TODO:
 * 1.使用DatagramSocket 指定端口，创建发送端
 * 2.准备数据转换成字节数组
 * 3.封装成DatagramPacket包裹，指定目的地
 * 4.发送包裹send(DatagramPacket p)
 * 5.释放资源
 */

public class UDPClient {
	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中。。。。。。。。。。。");
		//1.使用DatagramSocket 指定端口，创建发送端
		DatagramSocket ds = new DatagramSocket(8888);
		//2.准备数据转换成字节数组
		byte[] datas = (new String("德邦王泱钧")).getBytes();
		//3.封装成DatagramPacket包裹，指定目的地
		DatagramPacket dp = new DatagramPacket(datas, 0,datas.length, new InetSocketAddress("localhost",9999));
		//4.发送包裹send(DatagramPacket p)
		ds.send(dp);
		//5.释放资源
		ds.close();
	}
}

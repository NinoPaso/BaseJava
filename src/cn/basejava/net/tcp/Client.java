package cn.basejava.net.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server
 * @Description TODO:
 * 熟悉流程：创建客户端
 * 1.建立连接：使用Socket创建客户端+加上服务端的地址端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 * @Author 86133
 * @Date 2020/3/12 22:49
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        //1.建立连接：使用Socket创建客户端+加上服务端的地址端口
        Socket client = new Socket("localhost",8888);
        // 2.操作：输入输出流操作
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        String data = "hello/";
        dos.writeUTF(data);
        dos.flush();
        // 3.释放资源
        dos.close();
        client.close();
    }
}
